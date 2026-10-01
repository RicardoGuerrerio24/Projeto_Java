package strategy;
import model.Veiculo;
public class MovimentoBarco implements MovimentoStrategy {
    public void mover(Veiculo veiculo){System.out.println("O barco "+veiculo.getModelo()+" move-se na água.");}
}
