package com.example;

import java.util.ArrayList;

public class Garagem {

    private static final int CAPACIDADE_MAXIMA = 5;

    private int capacidade;
    private ArrayList<Veiculo> veiculos;

    public Garagem(int capacidade) {

        if (capacidade < 0 || capacidade > CAPACIDADE_MAXIMA) {
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

    public boolean estaCheia() {
        return veiculos.size() >= capacidade;
    }

    public boolean estaVazia() {
        return veiculos.isEmpty();
    }

    public void entrar(Veiculo veiculo) {

        if (veiculo == null) {
            System.out.println("Não é possível adicionar um veículo nulo.");
            return;
        }

        if (estaCheia()) {
            System.out.println("A garagem está cheia.");
            return;
        }

        if (!ordemValida(veiculo)) {
            System.out.println(
                    "O " + veiculo.getClass().getSimpleName()
                            + " não pode entrar agora."
            );
            return;
        }

        veiculos.add(veiculo);

        System.out.println(
                veiculo.getClass().getSimpleName()
                        + " entrou na garagem."
        );
    }

    private boolean ordemValida(Veiculo veiculo) {

        if (veiculos.isEmpty()) {
            return veiculo instanceof Carro;
        }

        if (veiculos.size() == 1) {
            return veiculo instanceof Barco;
        }

        if (veiculos.size() == 2) {
            return veiculo instanceof Mota;
        }

        return true;
    }

    public void sair(Veiculo veiculo) {

        if (veiculos.remove(veiculo)) {
            System.out.println(
                    veiculo.getClass().getSimpleName()
                            + " saiu da garagem."
            );
        } else {
            System.out.println(
                    "O veículo não se encontra na garagem."
            );
        }
    }

    public void mostrarVeiculos() {

        System.out.println("\n===== GARAGEM =====");

        if (veiculos.isEmpty()) {
            System.out.println("A garagem está vazia.");
            return;
        }

        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + veiculos.get(i)
            );
        }

        System.out.println(
                "Ocupação: "
                        + veiculos.size()
                        + "/"
                        + capacidade
        );
    }

    public void moverVeiculos() {

        System.out.println("\n===== MOVIMENTO =====");

        for (Veiculo veiculo : veiculos) {
            veiculo.mover();
        }
    }
}