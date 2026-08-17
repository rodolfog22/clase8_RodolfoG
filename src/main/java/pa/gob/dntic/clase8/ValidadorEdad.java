package pa.gob.dntic.clase8;

/*
 * DRILL "atrapa el bug": esta clase tiene un error escondido.
 * Regla correcta: una persona es mayor de edad si tiene 18 años O MÁS.
 * Tu trabajo NO es leer el código buscando el error: es escribir la prueba
 * que lo delata. Piensa en el BORDE (¿qué pasa exactamente a los 18?).
 */
public class ValidadorEdad {

    public boolean esMayorDeEdad(int edad) {
        return edad >= 18;   // <-- ¿seguro? la regla dice "18 o más"...
    }
}
