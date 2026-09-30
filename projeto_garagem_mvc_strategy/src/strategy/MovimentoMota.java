package strategy;

import model.Veiculo;

public class MovimentoMota implements MovimentoStrategy {

    @Override
    public void mover(Veiculo veiculo) {
        System.out.println("A mota " + veiculo.getModelo() + " move-se pela estrada.");
    }
}
