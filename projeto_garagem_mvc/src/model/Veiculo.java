package model;

public abstract class Veiculo {

    private final String marca;
    private final String modelo;
    private final int ano;
    private final double peso;
    private final double velocidadeMaxima;
    private double velocidadeAtual;
    private final Matricula matricula;

    protected Veiculo(
            String marca,
            String modelo,
            int ano,
            double peso,
            double velocidadeMaxima,
            Matricula matricula) {

        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("A marca não pode estar vazia.");
        }

        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("O modelo não pode estar vazio.");
        }

        if (ano < 0) {
            throw new IllegalArgumentException("O ano não pode ser negativo.");
        }

        if (peso < 0) {
            throw new IllegalArgumentException("O peso não pode ser negativo.");
        }

        if (velocidadeMaxima < 0) {
            throw new IllegalArgumentException("A velocidade máxima não pode ser negativa.");
        }

        if (matricula == null) {
            throw new IllegalArgumentException("O veículo tem de ter uma matrícula.");
        }

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
            throw new IllegalArgumentException("A aceleração não pode ser negativa.");
        }

        velocidadeAtual = Math.min(
                velocidadeAtual + quantidade,
                velocidadeMaxima
        );
    }

    public void travar(double quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A travagem não pode ser negativa.");
        }

        velocidadeAtual = Math.max(
                velocidadeAtual - quantidade,
                0
        );
    }

    public abstract void mover();

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " - " + marca + " " + modelo
                + " | Matrícula: " + matricula;
    }
}
