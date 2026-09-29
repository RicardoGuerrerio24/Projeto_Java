package strategy;

import model.Veiculo;

public class MovimentoBarco implements MovimentoStrategy {

    @Override
    public void mover(Veiculo veiculo) {
        System.out.println("O barco " + veiculo.getModelo() + " move-se na água.");
    }
}
