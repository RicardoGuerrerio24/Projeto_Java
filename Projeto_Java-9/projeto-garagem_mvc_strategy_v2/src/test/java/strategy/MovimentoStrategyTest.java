package strategy;

import model.Carro;
import model.Matricula;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MovimentoStrategyTest {

    @Test
    void carroDeveTerUmaEstrategiaDeMovimento() {
        Carro carro = new Carro(
                "Toyota",
                "Corolla",
                2024,
                1400,
                200,
                Matricula.terrestre(
                        "AA-11-AA",
                        "Branco",
                        "Portugal",
                        2024,
                        "Normal",
                        "AA-00-AA",
                        "Carro"
                ),
                5
        );

        assertDoesNotThrow(carro::mover);
    }
}
