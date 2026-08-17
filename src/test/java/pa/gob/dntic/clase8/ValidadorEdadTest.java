package pa.gob.dntic.clase8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidadorEdadTest {

    private ValidadorEdad VEdad;

    @BeforeEach
    void setUp(){
        VEdad= new ValidadorEdad();
    }

    @Test
    void errorValidarEdad() {
        boolean resultado=VEdad.esMayorDeEdad(18);
        assertEquals(true,resultado );
    }

}
