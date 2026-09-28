package model;

public class Carro extends Veiculo {

    private final int numeroPortas;

    public Carro(
            String marca,
            String modelo,
            int ano,
            double peso,
            double velocidadeMaxima,
            Matricula matricula,
            int numeroPortas) {

        super(marca, modelo, ano, peso, velocidadeMaxima, matricula);

        if (numeroPortas < 0) {
            throw new IllegalArgumentException("O número de portas não pode ser negativo.");
        }

        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    @Override
    public void mover() {
        // Comportamento específico do carro.
    }
}
