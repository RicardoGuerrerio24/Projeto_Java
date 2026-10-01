package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class MatriculaTest {

    @Test
    void deveCriarMatriculaTerrestre() {
        Matricula matricula = Matricula.terrestre(
                "AA-11-AA",
                "Branco",
                "Portugal",
                2024,
                "Normal",
                "AA-00-AA",
                "Carro"
        );

        assertEquals("AA-11-AA", matricula.getMatriculaTerrestre());
        assertEquals("AA-11-AA", matricula.getMatricula());
        assertNull(matricula.getMatriculaMaritima());
    }

    @Test
    void deveCriarMatriculaMaritima() {
        Matricula matricula = Matricula.maritima(
                "Oceano - 12345 - Classe A PT",
                "Azul",
                "Portugal",
                2023,
                "Normal",
                "Nome do Barco - Número de Registo - Classe e PT",
                "Barco"
        );

        assertEquals(
                "Oceano - 12345 - Classe A PT",
                matricula.getMatriculaMaritima()
        );
        assertEquals(
                "Oceano - 12345 - Classe A PT",
                matricula.getMatricula()
        );
        assertNull(matricula.getMatriculaTerrestre());
    }
}
