package model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BarcoTest {

    private Barco criarBarco() {
        Matricula matricula = Matricula.maritima(
                "Oceano - 12345 - Classe A PT",
                "Azul",
                "Portugal",
                2023,
                "Normal",
                "Nome do Barco - Número de Registo - Classe e PT",
                "Barco"
        );

        return new Barco(
                "Yamaha",
                "242X",
                2023,
                1700,
                70,
                matricula,
                "Motor"
        );
    }

    @Test
    void deveCriarBarco() {
        Barco barco = criarBarco();

        assertEquals("Yamaha", barco.getMarca());
        assertEquals("242X", barco.getModelo());
        assertEquals(2023, barco.getAno());
        assertEquals(1700, barco.getPeso());
        assertEquals(70, barco.getVelocidadeMaxima());
        assertEquals("Motor", barco.getTipoPropulsao());
    }

    @Test
    void deveTerMatriculaMaritimaCorreta() {
        Barco barco = criarBarco();

        assertEquals(
                "Oceano - 12345 - Classe A PT",
                barco.getMatricula().getMatricula()
        );
    }

    @Test
    void deveMover() {
        Barco barco = criarBarco();

        assertDoesNotThrow(barco::mover);
    }
}
