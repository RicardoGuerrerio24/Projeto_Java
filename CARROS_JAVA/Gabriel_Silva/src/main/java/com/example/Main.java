public class Main {

    public static void main(String[] args) {

        // ==========================================
        // CRIAR O CARRO
        // ==========================================

        Carro carro = new Carro(
                "Toyota",
                "Corolla",
                2024,
                1400,
                4.63,
                1.78,
                1.44,
                200
        );


        // ==========================================
        // CRIAR O CONDUTOR
        // ==========================================

        Condutor condutor = new Condutor("João");


        // ==========================================
        // SIMULAÇÃO
        // ==========================================

        System.out.println("===== INÍCIO =====");

        System.out.println(
                "Carro: "
                        + carro.getMarca()
                        + " "
                        + carro.getModelo()
        );

        System.out.println(
                "Ano: " + carro.getAno()
        );


        // O condutor liga o carro
        condutor.ligarCarro(carro);


        // O condutor acelera
        condutor.acelerar(carro, 50);


        // O carro trata dos seus sistemas automaticamente
        carro.atualizar();


        // O condutor acelera novamente
        condutor.acelerar(carro, 30);


        // O carro atualiza novamente os sistemas
        carro.atualizar();


        // O condutor trava
        condutor.travar(carro, 40);


        // O carro atualiza os sistemas
        carro.atualizar();


        // O condutor buzina
        condutor.buzinar(carro);


        // Mostrar velocidade
        System.out.println(
                "Velocidade final: "
                        + carro.getVelocidadeAtual()
                        + " km/h"
        );


        // O condutor trava completamente
        condutor.travar(carro, 100);


        // O condutor desliga o carro
        condutor.desligarCarro(carro);


        System.out.println("===== FIM =====");
    }
}