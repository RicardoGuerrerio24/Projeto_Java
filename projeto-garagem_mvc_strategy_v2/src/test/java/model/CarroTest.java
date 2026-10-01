package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CarroTest {

    private Carro criarCarro() {
        Matricula matricula = Matricula.terrestre(
                "AA-11-AA",
                "Branco",
                "Portugal",
                2024,
                "Normal",
                "AA-00-AA",
                "Carro"
        );

        return new Carro(
                "Toyota",
                "Corolla",
                2024,
                1400,
                200,
                matricula,
                5
        );
    }

    @Test
    void deveCriarCarro() {
        Carro carro = criarCarro();

        assertEquals("Toyota", carro.getMarca());
        assertEquals("Corolla", carro.getModelo());
        assertEquals(2024, carro.getAno());
        assertEquals(1400, carro.getPeso());
        assertEquals(200, carro.getVelocidadeMaxima());
        assertEquals(5, carro.getNumeroPortas());
    }

    @Test
    void deveTerMatriculaCorreta() {
        Carro carro = criarCarro();

        assertEquals("AA-11-AA", carro.getMatricula().getMatricula());
    }

    @Test
    void deveAcelerarSemUltrapassarVelocidadeMaxima() {
        Carro carro = criarCarro();

        carro.acelerar(250);

        assertEquals(200, carro.getVelocidadeAtual());
    }

    @Test
    void deveTravarSemFicarComVelocidadeNegativa() {
        Carro carro = criarCarro();

        carro.acelerar(100);
        carro.travar(150);

        assertEquals(0, carro.getVelocidadeAtual());
    }
}
