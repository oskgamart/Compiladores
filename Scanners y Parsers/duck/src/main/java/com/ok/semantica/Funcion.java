package com.ok.semantica;

import java.util.*;

public class Funcion {
    public final String tipoRetorno; // siempre es void
    public final Map<String, Variable> tablaVariables;
    public final List<String> parametros;
    public final List<String> espacio;
    public int localInt = 0;
    public int localFloat = 0;
    public int tempInt = 0;
    public int tempFloat = 0;
    public int tempBool = 0;
    public int inicio = 0;

    public Funcion(String tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
        this.tablaVariables = new HashMap<>();
        this.parametros = new ArrayList<>();
        this.espacio = new ArrayList<>();
        
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "tipoRetorno='" + tipoRetorno + '\'' +
                ", parametros=" + parametros +
                ", tablaVariables=" + tablaVariables +
                '}';
    }

    public void agregarVariable(String nombre, String tipo, int direccion, String contexto) {
        if (tablaVariables.containsKey(nombre)) {
            throw new RuntimeException("Variable '" + nombre + "' ya fue declarada en " + contexto);
        }
        tablaVariables.put(nombre, new Variable(tipo, direccion));
    }
}
