package model;

import strategy.MovimentoBarco;

public class Barco extends Veiculo {

    private final String tipoPropulsao;

    public Barco(
            String marca,
            String modelo,
            int ano,
            double peso,
            double velocidadeMaxima,
            Matricula matricula,
            String tipoPropulsao) {

        super(marca, modelo, ano, peso, velocidadeMaxima, matricula);

        if (tipoPropulsao == null || tipoPropulsao.isBlank()) {
            throw new IllegalArgumentException("O tipo de propulsão não pode estar vazio.");
        }

        this.tipoPropulsao = tipoPropulsao;
        setMovimentoStrategy(new MovimentoBarco());
    }

    public String getTipoPropulsao() {
        return tipoPropulsao;
    }

    @Override
    public void mover() {
        getMovimentoStrategy().mover(this);
    }
}
