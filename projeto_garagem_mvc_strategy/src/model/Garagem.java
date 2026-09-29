package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garagem {

    public static final int CAPACIDADE_MINIMA = 0;
    public static final int CAPACIDADE_MAXIMA = 5;

    private final int capacidade;
    private final List<Veiculo> veiculos;

    public Garagem(int capacidade) {
        if (capacidade < CAPACIDADE_MINIMA
                || capacidade > CAPACIDADE_MAXIMA) {
            throw new IllegalArgumentException(
                    "A capacidade da garagem deve estar entre 0 e 5."
            );
        }

        this.capacidade = capacidade;
        this.veiculos = new ArrayList<>();
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getNumeroVeiculos() {
        return veiculos.size();
    }

    public boolean estaVazia() {
        return veiculos.isEmpty();
    }

    public boolean estaCheia() {
        return veiculos.size() >= capacidade;
    }

    public List<Veiculo> getVeiculos() {
        return Collections.unmodifiableList(veiculos);
    }

    public boolean podeEntrar(Veiculo veiculo) {
        if (veiculo == null || estaCheia()) {
            return false;
        }

        return ordemValida(veiculo);
    }

    public boolean entrar(Veiculo veiculo) {
        if (!podeEntrar(veiculo)) {
            return false;
        }

        veiculos.add(veiculo);
        return true;
    }

    public boolean sair(Veiculo veiculo) {
        return veiculos.remove(veiculo);
    }

    private boolean ordemValida(Veiculo veiculo) {
        int posicao = veiculos.size();

        if (posicao == 0) {
            return veiculo instanceof Carro;
        }

        if (posicao == 1) {
            return veiculo instanceof Barco;
        }

        if (posicao == 2) {
            return veiculo instanceof Mota;
        }

        return true;
    }
}
