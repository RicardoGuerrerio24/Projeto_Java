package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GaragemTest {

    private Carro criarCarro() {
        return new Carro(
                "Toyota", "Corolla", 2024, 1400, 200,
                Matricula.terrestre(
                        "AA-11-AA", "Branco", "Portugal", 2024,
                        "Normal", "AA-00-AA", "Carro"
                ),
                5
        );
    }

    private Barco criarBarco() {
        return new Barco(
                "Yamaha", "242X", 2023, 1700, 70,
                Matricula.maritima(
                        "Oceano - 12345 - Classe A PT", "Azul", "Portugal", 2023,
                        "Normal", "Nome do Barco - Número de Registo - Classe e PT", "Barco"
                ),
                "Motor"
        );
    }

    private Mota criarMota() {
        return new Mota(
                "Honda", "CB500", 2024, 190, 180,
                Matricula.terrestre(
                        "BB-22-BB", "Preto", "Portugal", 2024,
                        "Normal", "AA-00-AA", "Mota"
                ),
                500
        );
    }

    @Test
    void deveCriarGaragemComCapacidadeValida() {
        Garagem garagem = new Garagem(5);

        assertEquals(5, garagem.getCapacidade());
        assertTrue(garagem.estaVazia());
        assertEquals(0, garagem.getNumeroVeiculos());
    }

    @Test
    void naoDeveAceitarCapacidadeMaiorQueCinco() {
        assertThrows(IllegalArgumentException.class, () -> new Garagem(6));
    }

    @Test
    void naoDeveAceitarCapacidadeNegativa() {
        assertThrows(IllegalArgumentException.class, () -> new Garagem(-1));
    }

    @Test
    void deveRespeitarOrdemDeEntrada() {
        Garagem garagem = new Garagem(5);

        assertTrue(garagem.entrar(criarCarro()));
        assertTrue(garagem.entrar(criarBarco()));
        assertTrue(garagem.entrar(criarMota()));

        assertEquals(3, garagem.getNumeroVeiculos());
    }

    @Test
    void naoDeveAceitarVeiculoForaDaOrdemInicial() {
        Garagem garagem = new Garagem(5);

        assertFalse(garagem.entrar(criarBarco()));
    }

    @Test
    void deveRespeitarCapacidade() {
        Garagem garagem = new Garagem(0);

        assertTrue(garagem.estaCheia());
        assertFalse(garagem.entrar(criarCarro()));
    }

    @Test
    void deveRemoverVeiculo() {
        Garagem garagem = new Garagem(5);
        Carro carro = criarCarro();

        garagem.entrar(carro);

        assertTrue(garagem.sair(carro));
        assertTrue(garagem.estaVazia());
    }
}
