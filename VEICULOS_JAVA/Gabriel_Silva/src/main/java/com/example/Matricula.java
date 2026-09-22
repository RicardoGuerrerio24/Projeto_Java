package com.example;

public class Matricula {

    private String codigo;

    public Matricula(String codigo) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException(
                    "A matrícula não pode estar vazia."
            );
        }

        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return codigo;
    }
}