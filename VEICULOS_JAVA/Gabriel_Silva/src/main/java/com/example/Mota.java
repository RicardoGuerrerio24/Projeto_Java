package com.example;

public class Mota extends Veiculo {

    private int cilindrada;

    public Mota(
            String marca,
            String modelo,
            int ano,
            double peso,
            double velocidadeMaxima,
            Matricula matricula,
            int cilindrada) {

        super(
                marca,
                modelo,
                ano,
                peso,
                velocidadeMaxima,
                matricula
        );

        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public void mover() {
        System.out.println(
                "A mota " + getMarca() + " "
                        + getModelo() + " está a circular."
        );
    }
}