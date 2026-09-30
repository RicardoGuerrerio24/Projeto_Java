package model;

public class Mota extends Veiculo {

    private final int cilindrada;

    public Mota(
            String marca,
            String modelo,
            int ano,
            double peso,
            double velocidadeMaxima,
            Matricula matricula,
            int cilindrada) {

        super(marca, modelo, ano, peso, velocidadeMaxima, matricula);

        if (cilindrada < 0) {
            throw new IllegalArgumentException("A cilindrada não pode ser negativa.");
        }

        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public void mover() {
        // Comportamento específico da mota.
    }
}
