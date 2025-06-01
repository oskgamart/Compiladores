package com.ok.generacion;

import java.util.HashMap;
import java.util.Map;

public class Memoria {
    private final Map<String, Integer> contadores = new HashMap<>();
    private Map<String, Integer> original = new HashMap<>();

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
        original = new HashMap<>(contadores);
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

    public int getContador(String segmento, String tipo){
        int contador = 0;
        String clave = segmento + "_" + tipo;
        int dir = contadores.get(clave);
        int direccionOriginal = original.get(clave);
        contador = dir-direccionOriginal;
        return contador;
    }

    public void resetearLocales(){
        contadores.put("local_int", original.get("local_int"));
        contadores.put("local_float", original.get("local_float"));
        contadores.put("temp_int", original.get("temp_int"));
        contadores.put("temp_float", original.get("temp_float"));
        contadores.put("temp_bool", original.get("temp_bool"));
    }
}
