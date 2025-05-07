package com.ok.semantica;

import java.util.HashMap;
import java.util.Map;

public class DirectorioFunciones {
    private final Map<String, Funcion> funciones = new HashMap<>();

    public void agregarFuncion(String nombre, String tipoRetorno) {
        if (funciones.containsKey(nombre)) {
            throw new RuntimeException("Función duplicada: " + nombre);
        }
        funciones.put(nombre, new Funcion(tipoRetorno));
    }
    
    public Funcion obtenerFuncion(String nombre) {
        return funciones.get(nombre);
    }

    public boolean existeFuncion(String nombre) {
        return funciones.containsKey(nombre);
    }

    public Map<String, Funcion> todas() {
        return funciones;
    }

    @Override
    public String toString() {
        return "DirectorioFunciones{\n" + funciones + "\n}";
    }
}
