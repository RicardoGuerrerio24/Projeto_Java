package com.example;

public abstract class Veiculo {

    private String marca;
    private String modelo;
    private int ano;
    private double peso;
    private double velocidadeMaxima;
    private double velocidadeAtual;
    private Matricula matricula;

    public Veiculo(
            String marca,
            String modelo,
            int ano,
            double peso,
            double velocidadeMaxima,
            Matricula matricula) {

        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.peso = peso;
        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidadeAtual = 0;
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getPeso() {
        return peso;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void acelerar(double quantidade) {

        if (quantidade < 0) {
            return;
        }

        velocidadeAtual += quantidade;

        if (velocidadeAtual > velocidadeMaxima) {
            velocidadeAtual = velocidadeMaxima;
        }
    }

    public void travar(double quantidade) {

        if (quantidade < 0) {
            return;
        }

        velocidadeAtual -= quantidade;

        if (velocidadeAtual < 0) {
            velocidadeAtual = 0;
        }
    }

    // Método abstrato usado para demonstrar polimorfismo.
    public abstract void mover();

    @Override
    public String toString() {
        return marca + " " + modelo
                + " | Ano: " + ano
                + " | Matrícula: " + matricula;
    }
}