package com.ok.semantica;

import java.util.*;

public class Funcion {
    public final String tipoRetorno; // siempre es void
    public final Map<String, Variable> tablaVariables;
    public final List<String> parametros;

    public Funcion(String tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
        this.tablaVariables = new HashMap<>();
        this.parametros = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "tipoRetorno='" + tipoRetorno + '\'' +
                ", parametros=" + parametros +
                ", tablaVariables=" + tablaVariables +
                '}';
    }

    public void agregarVariable(String nombre, String tipo, String contexto) {
        if (tablaVariables.containsKey(nombre)) {
            throw new RuntimeException("Variable '" + nombre + "' ya fue declarada en " + contexto);
        }
        tablaVariables.put(nombre, new Variable(tipo));
    }
}
