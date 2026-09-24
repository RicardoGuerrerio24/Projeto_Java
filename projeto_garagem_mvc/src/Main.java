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

        Matricula matriculaCarro = new Matricula(
                "AA-11-AA",
                "Branco",
                "Portugal",
                2024,
                "520x110"
        );

        Matricula matriculaBarco = new Matricula(
                "BB-22-BB",
                "Azul",
                "Portugal",
                2023,
                "500x100"
                );

        Matricula matriculaMota = new Matricula(
                "CC-33-CC",
                "Preto",
                "Portugal",
                2015,
                "300x100"
                );

        Carro carro = new Carro(
                "Mustang",
                "Eleanor",
                2023,
                1530,
                200,
                matriculaCarro,
                2
        );

        Barco barco = new Barco(
                "Spirit of Australia",
                "242X",
                1978,
                1100,
                511,
                matriculaBarco,
                "Jato de Aviação Militar"
        );

        Mota mota = new Mota(
                "Kawasaki",
                "Ninja H2r",
                2015,
                216,
                400,
                matriculaMota,
                998
        );

        view.mostrarResultado(
                gestor.adicionarVeiculo(carro),
                "Entrada do carro"
        );

        view.mostrarResultado(
                gestor.adicionarVeiculo(barco),
                "Entrada do barco"
        );

        view.mostrarResultado(
                gestor.adicionarVeiculo(mota),
                "Entrada da mota"
        );

        view.mostrarGaragem(garagem);

        System.out.println("\n===== POLIMORFISMO =====");

        for (Veiculo veiculo : garagem.getVeiculos()) {
            veiculo.mover();
        }
    }
}
