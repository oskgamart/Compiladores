package com.ok.vm;

import com.ok.generacion.Cuadruplo;
import com.ok.semantica.DirectorioFunciones;
import com.ok.semantica.Funcion;

import java.util.*;

public class VirtualMachine {
    private final List<Cuadruplo> cuadruplos;
    private final Map<Integer, Object> memoriaGlobal = new HashMap<>();
    private final Map<Integer, Object> memoriaConstantes;
    private final DirectorioFunciones directorio;
    private final Map<String, Integer> inicioFunciones = new HashMap<>();

    private final Stack<Map<Integer, Object>> pilaMemoriaLocal = new Stack<>();
    private final Stack<Map<Integer, Object>> pilaMemoriaTemporal = new Stack<>();
    private final Stack<Integer> pilaRetorno = new Stack<>();

    private Map<Integer, Object> memoriaLocalActual = new HashMap<>();
    private Map<Integer, Object> memoriaTempActual = new HashMap<>();

    private int ip = 0;
    private final Map<Integer, String> hashToNombreFuncion = new HashMap<>();

    public VirtualMachine(List<Cuadruplo> cuadruplos, DirectorioFunciones directorio, Map<Integer, Object> memoriaConstantes) {
        this.cuadruplos = cuadruplos;
        this.memoriaConstantes = memoriaConstantes;
        this.directorio = directorio;

        for (String nombre : directorio.todas().keySet()) {
            hashToNombreFuncion.put(nombre.hashCode(), nombre);
        }

        Funcion global = directorio.obtenerFuncion("global");
        crearMemoria(memoriaGlobal, "global", global.localInt, global.localFloat);


    }

    public void run() {
        while (ip < cuadruplos.size()) {
            Cuadruplo q = cuadruplos.get(ip);
            String op = q.operador;

            switch (op) {
                case "+": case "-": case "*": case "/":
                    operarAritmetica(q);
                    break;
                case "<": case ">": case "!=":
                    evaluarCondicion(q);
                    break;
                case "=":
                    guardarValor(q.resultado, obtenerValor(q.operando1));
                    ip++;
                    break;
                case "print":
                    System.out.println(obtenerValor(q.operando1));
                    ip++;
                    break;
                case "GOTO":
                    ip = q.resultado;
                    break;
                case "GOTOF": {
                    Boolean cond = (Boolean) obtenerValor(q.operando1);
                    ip = cond ? ip + 1 : q.resultado;
                    break;
                }
                case "GOTOV": {
                    Boolean cond = (Boolean) obtenerValor(q.operando1);
                    ip = cond ? q.resultado : ip + 1;
                    break;
                }
                case "ERA": {
                    String nombre = hashToNombreFuncion.get(q.resultado);
                    Funcion f = directorio.obtenerFuncion(nombre);

                    memoriaLocalActual = new HashMap<>();
                    memoriaTempActual = new HashMap<>();
                    crearMemoria(memoriaLocalActual, "local", f.localInt, f.localFloat);
                    crearMemoria(memoriaTempActual, "temp", f.tempInt, f.tempFloat);
                    crearMemoria(memoriaTempActual, "temp_bool", f.tempBool, 0);

                    ip++;
                    break;
                }
                case "PARAM":
                    Object val = obtenerValor(q.operando1);
                    memoriaLocalActual.put(q.resultado, val);
                    ip++;
                    break;
                case "GOSUB":
                    pilaRetorno.push(ip + 1);
                    pilaMemoriaLocal.push(memoriaLocalActual);
                    pilaMemoriaTemporal.push(memoriaTempActual);
                    

                    Funcion f = directorio.obtenerFuncion(hashToNombreFuncion.get(q.resultado));
                    
                    ip = f.inicio;
                    
                    break;
                case "ENDF":
                    memoriaLocalActual = pilaMemoriaLocal.pop();
                    memoriaTempActual = pilaMemoriaTemporal.pop();
                    ip = pilaRetorno.pop();
                    break;
                default:
                    throw new RuntimeException("Operador no soportado: " + op);
            }
        }
    }

    private void operarAritmetica(Cuadruplo q) {
        Number izq = (Number) obtenerValor(q.operando1);
        Number der = (Number) obtenerValor(q.operando2);

        Object resultado;
        switch (q.operador) {
            case "+": 
                resultado = izq.doubleValue() + der.doubleValue(); 
                break;
            case "-": resultado = izq.doubleValue() - der.doubleValue(); break;
            case "*": resultado = izq.doubleValue() * der.doubleValue(); break;
            case "/": resultado = izq.doubleValue() / der.doubleValue(); break;
            default: throw new RuntimeException("Operación aritmética inválida: " + q.operador);
        }
        guardarValor(q.resultado, resultado);
        ip++;
    }

    private void evaluarCondicion(Cuadruplo q) {
        Number izq = (Number) obtenerValor(q.operando1);
        Number der = (Number) obtenerValor(q.operando2);

        boolean resultado;
        switch (q.operador) {
            case "<": resultado = izq.doubleValue() < der.doubleValue(); break;
            case ">": resultado = izq.doubleValue() > der.doubleValue(); break;
            case "!=": resultado = !izq.equals(der); break;
            default: throw new RuntimeException("Condición inválida: " + q.operador);
        }
        guardarValor(q.resultado, resultado);
        ip++;
    }

    private Object obtenerValor(int dir) {
        if (dir >= 1000 && dir < 5000) return memoriaGlobal.get(dir);
        if (dir >= 5000 && dir < 9000) return memoriaLocalActual.get(dir);
        if (dir >= 9000 && dir < 15000) return memoriaTempActual.get(dir);
        if (dir >= 15000) return memoriaConstantes.get(dir);
        throw new RuntimeException("Dirección inválida: " + dir);
    }

    private void guardarValor(int dir, Object val) {
        if (dir >= 1000 && dir < 5000) memoriaGlobal.put(dir, val);
        else if (dir >= 5000 && dir < 9000) memoriaLocalActual.put(dir, val);
        else if (dir >= 9000 && dir < 15000) memoriaTempActual.put(dir, val);
        else throw new RuntimeException("Dirección inválida para asignación: " + dir);
    }

    private void crearMemoria(Map<Integer, Object> memoria, String tipo, int ints, int floats) {
        int inicio;
        switch (tipo) {
            case "global":
                inicio = 1000;
                for (int i = 0; i < ints; i++) memoria.put(inicio + i, 0);
                for (int i = 0; i < floats; i++) memoria.put(inicio + 2000 + i, 0.0);
            break;
            case "local":
                inicio = 5000;
                for (int i = 0; i < ints; i++) memoria.put(inicio + i, 0);
                for (int i = 0; i < floats; i++) memoria.put(inicio + 2000 + i, 0.0);
                break;
            case "temp":
                inicio = 9000;
                for (int i = 0; i < ints; i++) memoria.put(inicio + i, 0);
                for (int i = 0; i < floats; i++) memoria.put(inicio + 2000 + i, 0.0);
                break;
            case "temp_bool":
                inicio = 13000;
                for (int i = 0; i < ints; i++) memoria.put(inicio + i, false);
                break;
            default:
                throw new RuntimeException("Tipo de memoria no soportado: " + tipo);
        }
        

        
        
    }

}
