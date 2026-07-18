
package Test;
import org.junit.Test;
import static org.junit.Assert.*;

import Model.Calidad;
import Model.Pelicula;
import Service.SuscripcionService;

public class StreamFlowTest {
    
    @Test
    public void testCalcularCostoMensual4K() {
        
        Pelicula pelicula = new Pelicula("1", "Dune", "Sci-Fi", Calidad.UHD_4K, 155);
        SuscripcionService service = new SuscripcionService();

        double costo = service.calcularCostoMensual(pelicula);
        
        assertEquals("El cálculo para 4K falló", 11.98, costo, 0.01);
    }

    @Test
    public void testCalcularCostoMensualSD() {
        Pelicula pelicula = new Pelicula("2", "Shrek", "Animación", Calidad.SD, 90);
        SuscripcionService service = new SuscripcionService();
        assertEquals(5.99, service.calcularCostoMensual(pelicula), 0.01);
    }
}

