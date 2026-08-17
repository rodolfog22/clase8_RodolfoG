package pa.gob.dntic.clase8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraDePrioridadTest {

    private CalculadoraDePrioridad calc;

    @BeforeEach
    void setUp(){
        calc= new CalculadoraDePrioridad();
    }


    @Test
    void error001() {
        int resultado=calc.prioridad("Incidente", 2, false);
        assertEquals(3,resultado );
    }

    @Test
    void error002() {
        assertEquals(2, calc.prioridad("Cambio", 4, false));
    }

    @Test
    void error003() {
        assertEquals(1, calc.prioridad("otro", 5, false));
    }

    @Test
    void error004() {
        int resp=calc.prioridad("Incidente", 5, false);
        assertEquals(3,resp );
    }

    @Test
    void error005() {
        int resp=calc.prioridad("Incidente", 6, false);
        assertEquals(4,resp );
    }

    @Test
    void error_yo_toque_eso() {
        assertThrows(IllegalArgumentException.class,()->calc.prioridad("Incidente",-1,false));
    }

    @Test
    void errorAlta() {
        int prioridad=calc.prioridad("Incidente", 6, false);
//        assertEquals(4,resp );
        assertEquals("Alta",calc.nivel(prioridad) );
    }

    @Test
    void errorMedia() {
        int prioridad=calc.prioridad("Incidente", 5, false);
        assertEquals("Media",calc.nivel(prioridad) );
    }

    @Test
    void errorBaja() {
        int prioridad=calc.prioridad("otro", 5, false);
        assertEquals("Baja",calc.nivel(prioridad) );
    }

    @Test
    void errorUrgente() {
        int prioridad=calc.prioridad("Incidente", 5, true);
        assertEquals("Urgente",calc.nivel(prioridad) );
    }








}
