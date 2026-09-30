package strategy;

import model.Veiculo;

public class MovimentoCarro implements MovimentoStrategy {

    @Override
    public void mover(Veiculo veiculo) {
        System.out.println("O carro " + veiculo.getModelo() + " move-se pela estrada.");
    }
}
