package com.example;

public class Main {

    public static void main(String[] args) {

        // Criação da garagem
        Garagem garagem = new Garagem(5);

        // Criação das matrículas
        Matricula matriculaCarro = new Matricula("AA-11-AA");
        Matricula matriculaBarco = new Matricula("BB-22-BB");
        Matricula matriculaMota = new Matricula("CC-33-CC");

        // Criação dos veículos
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
                "Yamaha",
                "242X",
                2023,
                1700,
                70,
                matriculaBarco,
                "Motor"
        );

        Mota mota = new Mota(
                "Honda",
                "CB500",
                2024,
                190,
                180,
                matriculaMota,
                500
        );

        System.out.println("===== ENTRADA NA GARAGEM =====");

        // A ordem correta é Carro -> Barco -> Mota
        garagem.entrar(carro);
        garagem.entrar(barco);
        garagem.entrar(mota);

        garagem.mostrarVeiculos();

        // Demonstração de polimorfismo
        garagem.moverVeiculos();

        System.out.println("\n===== TESTE DE MOVIMENTO =====");

        carro.acelerar(80);
        barco.acelerar(30);
        mota.acelerar(100);

        System.out.println(
                "Velocidade do carro: "
                        + carro.getVelocidadeAtual()
                        + " km/h"
        );

        System.out.println(
                "Velocidade do barco: "
                        + barco.getVelocidadeAtual()
                        + " km/h"
        );

        System.out.println(
                "Velocidade da mota: "
                        + mota.getVelocidadeAtual()
                        + " km/h"
        );

        System.out.println("\n===== SAÍDA =====");

        garagem.sair(barco);

        garagem.mostrarVeiculos();
    }
}