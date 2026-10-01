import control.GestorGaragem;
import model.Garagem;
import model.Veiculo;
import view.GaragemView;

public class Main {
    public static void main(String[] args) {
        Garagem garagem = new Garagem(5);
        GestorGaragem gestor = new GestorGaragem(garagem);
        GaragemView view = new GaragemView();

        gestor.carregarGaragemDaBaseDeDados();
        view.mostrarGaragem(garagem);

        System.out.println("\n===== STRATEGY PATTERN =====");
        for (Veiculo veiculo : garagem.getVeiculos()) {
            veiculo.mover();
        }
    }
}
