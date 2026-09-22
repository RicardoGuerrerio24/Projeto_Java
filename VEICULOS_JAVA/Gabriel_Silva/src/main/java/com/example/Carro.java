package com.example;

public class Carro extends Veiculo {

    private int numeroPortas;

    public Carro(
            String marca,
            String modelo,
            int ano,
            double peso,
            double velocidadeMaxima,
            Matricula matricula,
            int numeroPortas) {

        super(
                marca,
                modelo,
                ano,
                peso,
                velocidadeMaxima,
                matricula
        );

        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    @Override
    public void mover() {
        System.out.println(
                "O carro " + getMarca() + " "
                        + getModelo() + " está a circular."
        );
    }
}