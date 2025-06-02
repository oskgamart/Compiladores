package com.ok.semantica;

import com.ok.duckBaseListener;
import com.ok.duckParser;
import com.ok.generacion.Cuadruplo;
import com.ok.generacion.Memoria;
import com.ok.semantica.CuboSemantico;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class SemanticListener extends duckBaseListener {

    private final DirectorioFunciones directorio = new DirectorioFunciones();
    private final Memoria memoria = new Memoria();
    private final CuboSemantico cubo = new CuboSemantico();

    private final List<Cuadruplo> cuadruplos = new ArrayList<>();
    private final Stack<String> pilaOperadores = new Stack<>();
    private final Stack<Integer> pilaOperandos = new Stack<>();
    private final Stack<String> pilaTipos = new Stack<>();
    private final Stack<Integer> pilaSaltos = new Stack<>();
    private final Map<String, Integer> tablaConstantes = new HashMap<>();

    private String funcionActual = "global";
    private String nombrePrograma = null;

    @Override
    public void enterPrograma(duckParser.ProgramaContext ctx) {
        nombrePrograma = ctx.ID().getText(); 
        cuadruplos.add(new Cuadruplo("GOTO", -1, -1, -1));
        directorio.agregarFuncion("global", "void");
        funcionActual = "global";
        
    }  

    @Override
    public void enterBody(duckParser.BodyContext ctx) {
        // Si el padre es `programa` y estamos entrando a `main`
        if (ctx.getParent() instanceof duckParser.ProgramaContext) {
            // Este body es el de main → completamos el primer GOTO
            cuadruplos.get(0).resultado = cuadruplos.size();
        }
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
    public void enterFunc(duckParser.FuncContext ctx) {
        if (ctx.ID() == null) return;

        String nombreFuncion = ctx.ID().getText();
        
        
        if (directorio.existeFuncion(nombreFuncion)) {
            throw new RuntimeException("Función duplicada: '" + nombreFuncion + "'");
        }

        directorio.agregarFuncion(nombreFuncion, "void");
        funcionActual = nombreFuncion;

        Funcion f = directorio.obtenerFuncion(nombreFuncion);
        f.inicio = cuadruplos.size();

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
    public void exitFunc(duckParser.FuncContext ctx) {
        // ENDF y almacenamiento de memoria usados por la función
        
        Funcion f = directorio.obtenerFuncion(funcionActual);

        f.localInt = memoria.getContador("local", "int");
        f.localFloat = memoria.getContador("local", "float");
        f.tempInt = memoria.getContador("temp", "int");
        f.tempFloat = memoria.getContador("temp", "float");
        f.tempBool = memoria.getContador("temp", "bool");

        cuadruplos.add(new Cuadruplo("ENDF", -1, -1, funcionActual.hashCode()));
        memoria.resetearLocales();
        funcionActual = "global";
        
    }


    @Override
    public void exitF_call(duckParser.F_callContext ctx) {
        String nombreFuncion = ctx.ID().getText();

        if (!directorio.existeFuncion(nombreFuncion)) {
            throw new RuntimeException("Función no declarada: " + nombreFuncion);
        }

        Funcion f = directorio.obtenerFuncion(nombreFuncion);

        cuadruplos.add(new Cuadruplo("ERA", -1, -1, nombreFuncion.hashCode()));

        List<String> nombresParametros = new ArrayList<>(f.tablaVariables.keySet())
        .subList(0, f.parametros.size());

        for (int i = f.parametros.size() - 1; i >= 0; i--) {
            int valorDir = pilaOperandos.pop();
            String tipoArg = pilaTipos.pop();

            String tipoEsperado = f.parametros.get(i);
            if (!tipoEsperado.equals(tipoArg)) {
                throw new RuntimeException("Tipo de parámetro incorrecto para función " + nombreFuncion);
            }

            String nombreParam = nombresParametros.get(i);
            int dirDestino = f.tablaVariables.get(nombreParam).direccion;

            cuadruplos.add(new Cuadruplo("PARAM", valorDir, -1, dirDestino));
        }

        cuadruplos.add(new Cuadruplo("GOSUB", -1, -1, nombreFuncion.hashCode()));
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

        if (ctx.GT() != null || ctx.LT() != null || ctx.NE() != null) {
            generarCuadruploBinario();
        }
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
        // Procesar la primera expresión obligatoria
        procesarPrintExpresion(ctx.printExpresion());

        // Recorrer múltiples expresiones si existen
        duckParser.MultiplePrintContext multi = ctx.multiplePrint();
        while (multi != null && multi.printExpresion() != null) {
            procesarPrintExpresion(multi.printExpresion());
            multi = multi.multiplePrint();
        }
    }

    private void procesarPrintExpresion(duckParser.PrintExpresionContext expr) {
        if (expr.CTE_STRING() != null) {
            String valor = expr.CTE_STRING().getText();
            int dir = obtenerOAsignarConstante(valor, "string");
            cuadruplos.add(new Cuadruplo("print", dir, -1, -1));
        } else {
            int val = pilaOperandos.pop();
            cuadruplos.add(new Cuadruplo("print", val, -1, -1));
        }
    }

    @Override
    public void exitPrograma(duckParser.ProgramaContext ctx) {
        Funcion f = directorio.obtenerFuncion("global");

        f.localInt = memoria.getContador("global", "int");
        f.localFloat = memoria.getContador("global", "float");
        // No se asignan temporales a global


    }

    private int precedencia(String operador) {
        switch (operador) {
            case "*":
            case "/":
                return 3;
            case "+":
            case "-":
                return 2;
            case ">":
            case "<":
            case "!=":
                return 1;
            default:
                return 0; // operadores desconocidos o de control
        }
    }


    @Override
    public void enterCycle(duckParser.CycleContext ctx) {
        pilaSaltos.push(cuadruplos.size()); // marca el inicio del ciclo
    }

    @Override
    public void exitExpresion(duckParser.ExpresionContext ctx) {
        while (!pilaOperadores.isEmpty() && precedencia(pilaOperadores.peek()) >= 0) {
            generarCuadruploBinario();
        }

        ParseTree padre = ctx.getParent();

        if (padre instanceof duckParser.ConditionContext) {
            duckParser.ConditionContext condition = (duckParser.ConditionContext) padre;
            if (condition.expresion() == ctx) {
                if (pilaOperandos.isEmpty() || pilaTipos.isEmpty()) {
                    throw new RuntimeException("Expresión mal formada en condición.");
                }

                int resultadoCond = pilaOperandos.pop();
                String tipo = pilaTipos.pop();

                if (!tipo.equals("bool")) {
                    throw new RuntimeException("Condición debe ser booleana, no: " + tipo);
                }

                cuadruplos.add(new Cuadruplo("GOTOF", resultadoCond, -1, -1));
                pilaSaltos.push(cuadruplos.size() - 1);
            }
        }

        if (padre instanceof duckParser.CycleContext) {
            duckParser.CycleContext cycle = (duckParser.CycleContext) padre;
            if (cycle.expresion() == ctx) {
                if (pilaOperandos.isEmpty() || pilaTipos.isEmpty()) {
                    throw new RuntimeException("Expresión mal formada en ciclo.");
                }

                int resultadoCond = pilaOperandos.pop();
                String tipo = pilaTipos.pop();

                if (!tipo.equals("bool")) {
                    throw new RuntimeException("Condición debe ser booleana, no: " + tipo);
                }

                cuadruplos.add(new Cuadruplo("GOTOF", resultadoCond, -1, -1));
                pilaSaltos.push(cuadruplos.size() - 1);
            }
        }
    }



    @Override
    public void exitCycle(duckParser.CycleContext ctx) {
        int finCond = pilaSaltos.pop();        // salto falso (al final del ciclo)
        int inicioCond = pilaSaltos.pop();     // inicio del ciclo

        // GOTO al inicio
        cuadruplos.add(new Cuadruplo("GOTO", -1, -1, inicioCond));
        cuadruplos.get(finCond).resultado = cuadruplos.size(); // rellena GOTOF
    }

    @Override
    public void exitCondition(duckParser.ConditionContext ctx) {
        if (pilaSaltos.isEmpty()) {
            throw new RuntimeException("Falta GOTOF para condición.");
        }

        int gotofIndex = pilaSaltos.pop();

        // Si hay un else, no completamos aquí el salto todavía
        if (ctx.elsePart().ELSE() != null) {
            cuadruplos.add(new Cuadruplo("GOTO", -1, -1, -1));
            int gotoFinal = cuadruplos.size() - 1;

            cuadruplos.get(gotofIndex).resultado = cuadruplos.size(); // salta al else
            pilaSaltos.push(gotoFinal); // lo completamos en exitElsePart
        } else {
            cuadruplos.get(gotofIndex).resultado = cuadruplos.size();
        }
    }


    @Override
    public void exitElsePart(duckParser.ElsePartContext ctx) {
        if (ctx.ELSE() != null) {
            if (pilaSaltos.isEmpty()) {
                throw new RuntimeException("Falta GOTO final para else.");
            }
            int gotoFinal = pilaSaltos.pop();
            cuadruplos.get(gotoFinal).resultado = cuadruplos.size();
        }
    }

    @Override
    public void exitFactor(duckParser.FactorContext ctx) {
        if (ctx.sumaResta() != null && ctx.id_cte() != null) {
            String signo = ctx.sumaResta().getText().trim(); // puede ser "-", "+" o vacío

            // Si es negativo, genera un cuadruplo que multiplica por -1
            if (signo.equals("-")) {
                int operando = pilaOperandos.pop();
                String tipo = pilaTipos.pop();

                if (!tipo.equals("int") && !tipo.equals("float")) {
                    throw new RuntimeException("Solo se pueden negar constantes numéricas. Tipo: " + tipo);
                }

                // Obtener o asignar constante -1
                int dirMenosUno = obtenerOAsignarConstante("-1", tipo);
                int temp = memoria.nuevaDireccion("temp", tipo);
                cuadruplos.add(new Cuadruplo("*", dirMenosUno, operando, temp));

                pilaOperandos.push(temp);
                pilaTipos.push(tipo);
            }
            // Si es positivo o vacío, no hacemos nada extra (ya fue apilado en id_cte)
        }
    }


    // ---------------- GETTERS ----------------

    public DirectorioFunciones getDirectorio() {
        return directorio;
    }

    public List<Cuadruplo> getCuadruplos() {
        return cuadruplos;
    }


    public Map<Integer, Object> getTablaConstantes() {
        return convertirConstantesParaVM(tablaConstantes);
    }


    public Map<Integer, Object> convertirConstantesParaVM(Map<String, Integer> tablaConstantes) {
        Map<Integer, Object> memoriaConstantes = new HashMap<>();

        for (Map.Entry<String, Integer> entrada : tablaConstantes.entrySet()) {
            String valorOriginal = entrada.getKey();
            Integer direccion = entrada.getValue();

            Object valorConvertido;
            if (valorOriginal.startsWith("\"") && valorOriginal.endsWith("\"")) {
                valorConvertido = valorOriginal.substring(1, valorOriginal.length() - 1); // quitar comillas
            } else if (valorOriginal.contains(".")) {
                valorConvertido = Double.parseDouble(valorOriginal);
            } else if (valorOriginal.equals("true") || valorOriginal.equals("false")) {
                valorConvertido = Boolean.parseBoolean(valorOriginal);
            } else {
                try {
                    valorConvertido = Integer.parseInt(valorOriginal);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("No se pudo convertir constante: " + valorOriginal);
                }
            }

            memoriaConstantes.put(direccion, valorConvertido);
        }
        
        return memoriaConstantes;
    }

}