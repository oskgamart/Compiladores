package com.ok.semantica;

import com.ok.duckBaseListener;
import com.ok.duckParser;
import org.antlr.v4.runtime.tree.TerminalNode;

public class SemanticListener extends duckBaseListener {

    private final DirectorioFunciones directorio = new DirectorioFunciones();
    private String funcionActual = "global";
    private String nombrePrograma = null;

    // Se crea el programa y se le asigna un nombre, este es guardado como una funcion en el directorio de funciones.
    @Override
    public void enterPrograma(duckParser.ProgramaContext ctx) {
        nombrePrograma = ctx.ID().getText(); // nombre de la funcion
        directorio.agregarFuncion("global", "void"); // usamos "global" como clave interna
        funcionActual = "global";
    }

    // Se agrega una variable a la funcion actual. Si ya existe marca error
    @Override
    public void enterVarDef(duckParser.VarDefContext ctx) {
        String tipo = ctx.type().getText(); // int o float
        Funcion f = directorio.obtenerFuncion(funcionActual);
        Funcion global = directorio.obtenerFuncion("global");

        // Obtener el primer ID
        String idPrincipal = ctx.ID().getText();
        validarVariable(idPrincipal, tipo, f, global);

        // Procesar IDs adicionales si existen
        duckParser.VarDefIDContext extras = ctx.varDefID();
        while (extras != null && extras.ID() != null) {
            String nombre = extras.ID().getText();
            validarVariable(nombre, tipo, f, global);
            extras = extras.varDefID();
        }
    }

    // Agrega funciones al directorio de funciones, si ya existe marca error
    @Override
    public void enterFuncs(duckParser.FuncsContext ctx) {
        if (ctx.ID() == null) return; // vacío

        String nombreFuncion = ctx.ID().getText();

        if (nombreFuncion.equals(nombrePrograma)) {
            throw new RuntimeException("No se puede declarar una función con el mismo nombre que el programa principal: '" + nombreFuncion + "'");
        }

        if (directorio.existeFuncion(nombreFuncion)) {
            throw new RuntimeException("Función duplicada: '" + nombreFuncion + "'");
        }

        directorio.agregarFuncion(nombreFuncion, "void");
        funcionActual = nombreFuncion;

        // Procesar argumentos si existen
        if (ctx.funcArguments() != null) {
            procesarArgumentos(ctx.funcArguments(), directorio.obtenerFuncion(nombreFuncion));
        }
    }

    // Agrega argumentos como variables, también valida contra colisiones globales
    private void procesarArgumentos(duckParser.FuncArgumentsContext ctx, Funcion f) {
        if (ctx == null || ctx.ID() == null) return;

        Funcion global = directorio.obtenerFuncion("global");

        String nombre = ctx.ID().getText();
        String tipo = ctx.type().getText();

        validarVariable(nombre, tipo, f, global);
        f.parametros.add(tipo);

        // Procesar argumentos múltiples
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

    // Validación de colisión con variables locales o globales
    private void validarVariable(String nombre, String tipo, Funcion funcionActual, Funcion funcionGlobal) {
        if (!this.funcionActual.equals("global") && funcionGlobal.tablaVariables.containsKey(nombre)) {
            throw new RuntimeException("Variable '" + nombre + "' ya fue declarada globalmente. No puede redeclararse en '" + this.funcionActual + "'");
        }

        funcionActual.agregarVariable(nombre, tipo, this.funcionActual);
    }

    // Cuando se termina la declaración de una función, regresar al contexto global
    @Override
    public void exitFuncs(duckParser.FuncsContext ctx) {
        funcionActual = "global";
    }

    // Obtener el directorio de funciones final
    public DirectorioFunciones getDirectorio() {
        return directorio;
    }
}
