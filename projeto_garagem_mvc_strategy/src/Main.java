import control.GestorGaragem;
import model.Barco;
import model.Carro;
import model.Garagem;
import model.Matricula;
import model.Mota;
import model.Veiculo;
import view.GaragemView;

public class Main {

    public static void main(String[] args) {

        Garagem garagem = new Garagem(5);
        GestorGaragem gestor = new GestorGaragem(garagem);
        GaragemView view = new GaragemView();

        Matricula matriculaCarro = Matricula.terrestre(
                "AA-11-AA", "Branco", "Portugal", 2024,
                "Normal", "AA-00-AA", "Carro"
        );

        Matricula matriculaBarco = Matricula.maritima(
                "Oceano - 12345 - Classe A PT", "Azul", "Portugal", 2023,
                "Normal", "Nome do Barco - Número de Registo - Classe e PT", "Barco"
        );

        Matricula matriculaMota = Matricula.terrestre(
                "BB-22-BB", "Preto", "Portugal", 2024,
                "Normal", "AA-00-AA", "Mota"
        );

        Carro carro = new Carro("Toyota", "Corolla", 2024, 1400, 200, matriculaCarro, 5);
        Barco barco = new Barco("Yamaha", "242X", 2023, 1700, 70, matriculaBarco, "Motor");
        Mota mota = new Mota("Honda", "CB500", 2024, 190, 180, matriculaMota, 500);

        view.mostrarResultado(gestor.adicionarVeiculo(carro), "Entrada do carro");
        view.mostrarResultado(gestor.adicionarVeiculo(barco), "Entrada do barco");
        view.mostrarResultado(gestor.adicionarVeiculo(mota), "Entrada da mota");

        view.mostrarGaragem(garagem);

        System.out.println("\n===== STRATEGY PATTERN =====");
        for (Veiculo veiculo : garagem.getVeiculos()) {
            veiculo.mover();
        }
    }
}
