package com.ok.generacion;

public class Cuadruplo {
    public final String operador;
    public final int operando1;
    public final int operando2;
    public final int resultado;

    public Cuadruplo(String operador, int operando1, int operando2, int resultado) {
        this.operador = operador;
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "(" + operador + ", " + operando1 + ", " + operando2 + ", " + resultado + ")";
    }
}
