package model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MotaTest {

    private Mota criarMota() {
        Matricula matricula = Matricula.terrestre(
                "BB-22-BB",
                "Preto",
                "Portugal",
                2024,
                "Normal",
                "AA-00-AA",
                "Mota"
        );

        return new Mota(
                "Honda",
                "CB500",
                2024,
                190,
                180,
                matricula,
                500
        );
    }

    @Test
    void deveCriarMota() {
        Mota mota = criarMota();

        assertEquals("Honda", mota.getMarca());
        assertEquals("CB500", mota.getModelo());
        assertEquals(2024, mota.getAno());
        assertEquals(190, mota.getPeso());
        assertEquals(180, mota.getVelocidadeMaxima());
        assertEquals(500, mota.getCilindrada());
    }

    @Test
    void deveTerMatriculaCorreta() {
        Mota mota = criarMota();

        assertEquals("BB-22-BB", mota.getMatricula().getMatricula());
    }

    @Test
    void deveMover() {
        Mota mota = criarMota();

        assertDoesNotThrow(mota::mover);
    }
}
