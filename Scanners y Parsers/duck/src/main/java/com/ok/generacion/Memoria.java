package com.ok.generacion;

import java.util.HashMap;
import java.util.Map;

public class Memoria {
    private final Map<String, Integer> contadores = new HashMap<>();

    public Memoria() {
        contadores.put("global_int", 1000);
        contadores.put("global_float", 3000);
        contadores.put("local_int", 5000);
        contadores.put("local_float", 7000);
        contadores.put("temp_int", 9000);
        contadores.put("temp_float", 11000);
        contadores.put("temp_bool", 13000);
        contadores.put("cte_int", 15000);
        contadores.put("cte_float", 17000);
        contadores.put("cte_string", 19000);
    }

    public int nuevaDireccion(String segmento, String tipo) {
        String clave = segmento + "_" + tipo;
        if (!contadores.containsKey(clave)) {
            throw new RuntimeException("Tipo de dirección desconocido: " + clave);
        }
        int dir = contadores.get(clave);
        contadores.put(clave, dir + 1);
        return dir;
    }
}
