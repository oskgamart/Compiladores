package com.ok.semantica;

import java.util.HashMap;
import java.util.Map;

public class CuboSemantico {
    private static final Map<String, Map<String, Map<String, String>>> cubo = new HashMap<>();

    static {
        String[] tipos = {"int", "float"};
        String[] ops = {"+", "-", "*", "/", "<", ">", "!=", "="};

        for (String op : ops) {
            cubo.put(op, new HashMap<>());
            for (String t1 : tipos) {
                cubo.get(op).put(t1, new HashMap<>());
                for (String t2 : tipos) {
                    if (op.equals("=")) {
                        cubo.get(op).get(t1).put(t2, t1.equals(t2) ? t1 : "error");
                    } else if (op.matches("[+\\-*/]")) {
                        cubo.get(op).get(t1).put(t2, (t1.equals("float") || t2.equals("float")) ? "float" : "int");
                    } else {
                        cubo.get(op).get(t1).put(t2, t1.equals(t2) ? "bool" : "error");
                    }
                }
            }
        }
    }

    public static String resultado(String operador, String tipo1, String tipo2) {
        return cubo.getOrDefault(operador, new HashMap<>())
                   .getOrDefault(tipo1, new HashMap<>())
                   .getOrDefault(tipo2, "error");
    }
}
