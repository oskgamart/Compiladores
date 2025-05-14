package com.ok.semantica;

import com.ok.duckBaseListener;
import com.ok.duckParser;
import com.ok.generacion.Cuadruplo;
import com.ok.generacion.Memoria;
import com.ok.semantica.CuboSemantico;

import java.util.*;

public class SemanticListener extends duckBaseListener {

    private final DirectorioFunciones directorio = new DirectorioFunciones();
    private final Memoria memoria = new Memoria();
    private final CuboSemantico cubo = new CuboSemantico();

    private final List<Cuadruplo> cuadruplos = new ArrayList<>();
    private final Stack<String> pilaOperadores = new Stack<>();
    private final Stack<Integer> pilaOperandos = new Stack<>();
    private final Stack<String> pilaTipos = new Stack<>();
    private final Map<String, Integer> tablaConstantes = new HashMap<>();

    private String funcionActual = "global";
    private String nombrePrograma = null;

    @Override
    public void enterPrograma(duckParser.ProgramaContext ctx) {
        nombrePrograma = ctx.ID().getText();
        directorio.agregarFuncion("global", "void");
        funcionActual = "global";
    }

    @Override
    public void enterVarDef(duckParser.VarDefContext ctx) {
        String tipo = ctx.type().getText();
        Funcion f = directorio.obtenerFuncion(funcionActual);
        Funcion global = directorio.obtenerFuncion("global");

        String idPrincipal = ctx.ID().getText();
        validarVariable(idPrincipal, tipo, f, global);

        duckParser.VarDefIDContext extras = ctx.varDefID();
        while (extras != null && extras.ID() != null) {
            String nombre = extras.ID().getText();
            validarVariable(nombre, tipo, f, global);
            extras = extras.varDefID();
        }
    }

    @Override
    public void enterFuncs(duckParser.FuncsContext ctx) {
        if (ctx.ID() == null) return;

        String nombreFuncion = ctx.ID().getText();


        if (directorio.existeFuncion(nombreFuncion)) {
            throw new RuntimeException("Función duplicada: '" + nombreFuncion + "'");
        }

        directorio.agregarFuncion(nombreFuncion, "void");
        funcionActual = nombreFuncion;

        if (ctx.funcArguments() != null) {
            procesarArgumentos(ctx.funcArguments(), directorio.obtenerFuncion(nombreFuncion));
        }
    }

    private void procesarArgumentos(duckParser.FuncArgumentsContext ctx, Funcion f) {
        if (ctx == null || ctx.ID() == null) return;

        Funcion global = directorio.obtenerFuncion("global");

        String nombre = ctx.ID().getText();
        String tipo = ctx.type().getText();
        validarVariable(nombre, tipo, f, global);
        f.parametros.add(tipo);

        duckParser.MultipleFuncArgumentsContext multi = ctx.multipleFuncArguments();
        while (multi != null && multi.funcArguments() != null) {
            duckParser.FuncArgumentsContext arg = multi.funcArguments();
            nombre = arg.ID().getText();
            tipo = arg.type().getText();
            validarVariable(nombre, tipo, f, global);
            f.parametros.add(tipo);
            multi = multi.funcArguments().multipleFuncArguments();
        }
    }

    private void validarVariable(String nombre, String tipo, Funcion funcionActual, Funcion funcionGlobal) {

        String scope = (this.funcionActual.equals("global")) ? "global" : "local";
        int direccion = memoria.nuevaDireccion(scope, tipo);
        funcionActual.agregarVariable(nombre, tipo, direccion, this.funcionActual);
    }

    @Override
    public void exitFuncs(duckParser.FuncsContext ctx) {
        funcionActual = "global";
    }

    // --------------------- PILAS Y CUÁDRUPLOS ---------------------

    @Override
    public void enterExpFinal(duckParser.ExpFinalContext ctx) {
        if (ctx.PLUS() != null) pilaOperadores.push("+");
        if (ctx.MINUS() != null) pilaOperadores.push("-");
    }

    @Override
    public void enterTerminoFinal(duckParser.TerminoFinalContext ctx) {
        if (ctx.MULT() != null) pilaOperadores.push("*");
        if (ctx.DIV() != null) pilaOperadores.push("/");
    }

    @Override
    public void enterExpresionFinal(duckParser.ExpresionFinalContext ctx) {
        if (ctx.GT() != null) pilaOperadores.push(">");
        if (ctx.LT() != null) pilaOperadores.push("<");
        if (ctx.NE() != null) pilaOperadores.push("!=");
    }

    @Override
    public void enterId_cte(duckParser.Id_cteContext ctx) {
        if (ctx.ID() != null) {
            String nombre = ctx.ID().getText();
            Variable var = directorio.obtenerFuncion(funcionActual).tablaVariables.get(nombre);
            if (var == null) {
                var = directorio.obtenerFuncion("global").tablaVariables.get(nombre);
                if (var == null) throw new RuntimeException("Variable no declarada: " + nombre);
            }
            pilaOperandos.push(var.direccion);
            pilaTipos.push(var.tipo);
        } else if (ctx.CTE_INT() != null) {
            String valor = ctx.CTE_INT().getText();
            int dir = obtenerOAsignarConstante(valor, "int");
            pilaOperandos.push(dir);
            pilaTipos.push("int");
        } else if (ctx.CTE_FLOAT() != null) {
            String valor = ctx.CTE_FLOAT().getText();
            int dir = obtenerOAsignarConstante(valor, "float");
            pilaOperandos.push(dir);
            pilaTipos.push("float");
        }
    }

    private int obtenerOAsignarConstante(String valor, String tipo) {
        if (!tablaConstantes.containsKey(valor)) {
            int dir = memoria.nuevaDireccion("cte", tipo);
            tablaConstantes.put(valor, dir);
        }
        return tablaConstantes.get(valor);
    }

    @Override
    public void exitExpFinal(duckParser.ExpFinalContext ctx) {
        if (ctx.PLUS() != null || ctx.MINUS() != null) generarCuadruploBinario();
    }

    @Override
    public void exitTerminoFinal(duckParser.TerminoFinalContext ctx) {
        if (ctx.MULT() != null || ctx.DIV() != null) generarCuadruploBinario();
    }

    @Override
    public void exitExpresionFinal(duckParser.ExpresionFinalContext ctx) {
        if (ctx.GT() != null || ctx.LT() != null || ctx.NE() != null) generarCuadruploBinario();
    }

    private void generarCuadruploBinario() {
        if (pilaOperadores.isEmpty()) return;

        String operador = pilaOperadores.pop();
        int der = pilaOperandos.pop();
        String tipoDer = pilaTipos.pop();
        int izq = pilaOperandos.pop();
        String tipoIzq = pilaTipos.pop();

        String tipoRes = CuboSemantico.resultado(operador, tipoIzq, tipoDer);
        if (tipoRes.equals("error")) {
            throw new RuntimeException("Operación inválida: " + tipoIzq + " " + operador + " " + tipoDer);
        }

        int dirTemp = memoria.nuevaDireccion("temp", tipoRes);
        cuadruplos.add(new Cuadruplo(operador, izq, der, dirTemp));
        pilaOperandos.push(dirTemp);
        pilaTipos.push(tipoRes);
    }

    @Override
    public void exitAssign(duckParser.AssignContext ctx) {
        String nombreVar = ctx.ID().getText();
        Variable var = directorio.obtenerFuncion(funcionActual).tablaVariables.get(nombreVar);
        if (var == null) var = directorio.obtenerFuncion("global").tablaVariables.get(nombreVar);
        if (var == null) throw new RuntimeException("Variable no declarada: " + nombreVar);

        int res = pilaOperandos.pop();
        String tipoRes = pilaTipos.pop();
        String tipoVar = var.tipo;

        String tipoValidado = CuboSemantico.resultado("=", tipoVar, tipoRes);
        if (tipoValidado.equals("error")) {
            throw new RuntimeException("Tipos incompatibles: " + tipoVar + " = " + tipoRes);
        }

        cuadruplos.add(new Cuadruplo("=", res, -1, var.direccion));
    }

    @Override
    public void exitPrint(duckParser.PrintContext ctx) {
        int valor = pilaOperandos.pop();
        cuadruplos.add(new Cuadruplo("print", valor, -1, -1));
    }

    // ---------------- GETTERS ----------------

    public DirectorioFunciones getDirectorio() {
        return directorio;
    }

    public List<Cuadruplo> getCuadruplos() {
        return cuadruplos;
    }
}
