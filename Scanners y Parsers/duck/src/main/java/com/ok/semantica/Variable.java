package com.ok.semantica;

public class Variable {
    public final String tipo;

    public Variable(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Variable{" + "tipo='" + tipo + '\'' + '}';
    }
}