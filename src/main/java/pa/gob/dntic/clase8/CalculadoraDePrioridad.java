package pa.gob.dntic.clase8;

/*
 * Lógica de negocio pura (la del Bloque 1). No depende de Spring:
 * por eso se puede probar de forma UNITARIA, aislada y rápida.
 */
public class CalculadoraDePrioridad {

    public int prioridad(String tipo, int diasEspera, boolean critica) {
        if (diasEspera < 0) {
            throw new IllegalArgumentException("diasEspera no puede ser negativo");
        }
        if (critica) {
            return 5;
        }
        int base = switch (tipo) {
            case "Incidente" -> 3;
            case "Cambio"    -> 2;
            default          -> 1;
        };
        return diasEspera > 5 ? base + 1 : base;
    }

    public String nivel(int prioridad) {
        return switch (prioridad) {
            case 5 -> "Urgente";
            case 4 -> "Alta";
            case 3 -> "Media";
            default -> "Baja";
        };
    }
}
