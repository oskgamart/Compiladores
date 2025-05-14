package com.ok.semantica;

public class Variable {
    public final String tipo;
    public final int direccion;

    public Variable(String tipo, int direccion) {
        this.tipo = tipo;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return tipo + "@" + direccion;
    }
}
