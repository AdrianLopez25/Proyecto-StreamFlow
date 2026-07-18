
package Service;
import Model.Contenido;

public class SuscripcionService {
    private static final double TARIFA_BASE = 5.99;

    public double calcularCostoMensual(Contenido contenido) {
        return TARIFA_BASE * contenido.getCalidad().getMultiplicador();
    }
}
