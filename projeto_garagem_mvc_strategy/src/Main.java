import control.GestorGaragem;
import model.Barco;
import model.Carro;
import model.Garagem;
import model.Matricula;
import model.Mota;
import view.GaragemView;

public class Main {
        public static void main(String[] args) {

        Garagem garagem = new Garagem(5);
        GestorGaragem gestor = new GestorGaragem(garagem);
        GaragemView view = new GaragemView();

        Matricula matriculaCarro = Matricula.terrestre(
                "AA-11-AA",
                "Branco",
                "Portugal",
                2024,
                "Normal",
                "AA-00-AA",
                "Carro"
        );

        Matricula matriculaBarco = Matricula.maritima(
                "OXEAN - 50503 - AVZAAPT",
                "Azul",
                "Portugal",
                2023,
                "Normal",
                "Nome do Barco - Número de Registo - Classe e PT",
                "Barco"
        );

        Matricula matriculaMota = Matricula.terrestre(
                "RI-CA-DO",
                "Preta e Verde",
                "Portugal",
                2024,
                "Normal",
                "AA-00-AA",
                "Mota"
        );

        Carro carro = new Carro(
                "Toyota",
                "Corolla",
                2024,
                1400,
                200,
                matriculaCarro,
                5
        );

        Barco barco = new Barco(
                "BYD",
                "XYNEZE",
                2022,
                5000,
                300,
                matriculaBarco,
                "Motor"
        );

        Mota mota = new Mota(
                "Kawasaki",
                "H2R",
                2024,
                190,
                400,
                matriculaMota,
                900
        );

        gestor.adicionarVeiculo(carro);
        gestor.adicionarVeiculo(barco);
        gestor.adicionarVeiculo(mota);

        // AGORA VAI BUSCAR OS DADOS À BASE DE DADOS
        view.mostrarVeiculos(
                gestor.consultarVeiculos()
        );
        }
}

