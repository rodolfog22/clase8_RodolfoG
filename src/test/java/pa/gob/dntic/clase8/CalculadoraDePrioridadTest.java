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
    void errorParaIncidente() {
        int resultado=calc.prioridad("Incidente", 2, false);
        assertEquals(3,resultado );
    }

    @Test
    void errorParaCambio() {
        assertEquals(2, calc.prioridad("Cambio", 4, false));
    }

    @Test
    void errorParaOtros() {
        assertEquals(1, calc.prioridad("otro", 5, false));
    }

    @Test
    void errorCasoBorde5() {
        int resp=calc.prioridad("Incidente", 5, false);
        assertEquals(3,resp );
    }

    @Test
    void errorCasoBorde6() {
        int resp=calc.prioridad("Incidente", 6, false);
        assertEquals(4,resp );
    }

    //prueba criticidad
    @Test
    void errorCasoCriticidad() {
        int resp=calc.prioridad("Incidente", 6, true);
        assertEquals(5,resp );
    }

    @Test
    void errorCasoCriticidad2() {
        int resp=calc.prioridad("Cambio", 2, true);
        assertEquals(5,resp );
    }

    @Test
    void errorCasoCriticidad3() {
        int resp=calc.prioridad("otro", 3, true);
        assertEquals(5,resp );
    }



    @Test
    void errorCasoNegativo() {
        assertThrows(IllegalArgumentException.class,()->calc.prioridad("Incidente",-1,false));
    }

    //pruebas de nivel
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
