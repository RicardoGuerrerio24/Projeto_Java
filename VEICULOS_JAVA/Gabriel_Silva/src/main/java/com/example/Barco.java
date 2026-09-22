package com.example;

public class Barco extends Veiculo {

    private String tipoPropulsao;

    public Barco(
            String marca,
            String modelo,
            int ano,
            double peso,
            double velocidadeMaxima,
            Matricula matricula,
            String tipoPropulsao) {

        super(
                marca,
                modelo,
                ano,
                peso,
                velocidadeMaxima,
                matricula
        );

        this.tipoPropulsao = tipoPropulsao;
    }

    public String getTipoPropulsao() {
        return tipoPropulsao;
    }

    @Override
    public void mover() {
        System.out.println(
                "O barco " + getMarca() + " "
                        + getModelo() + " está a navegar."
        );
    }
}