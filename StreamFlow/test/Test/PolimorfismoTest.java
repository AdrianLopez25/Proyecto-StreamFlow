
package Test;
import org.junit.Test;
import static org.junit.Assert.*;
import Model.Calidad;
import Model.Contenido;
import Model.Pelicula;
import Model.Serie;
import java.util.ArrayList;
import java.util.List;

public class PolimorfismoTest {
    @Test
    public void testComportamientoPolimorfico() {
        // Arrange
        List<Contenido> catalogo = new ArrayList<>();
        catalogo.add(new Pelicula("1", "Gladiador", "Acción", Calidad.HD, 155));
        catalogo.add(new Serie("2", "Dark", "Ciencia Ficción", Calidad.UHD_4K, 3));

        Contenido item1 = catalogo.get(0);
        assertTrue(item1.obtenerDetalles().contains("[Película]"));
        assertTrue(item1.obtenerReglaRecomendacion().contains("te recomendamos más del género"));

        Contenido item2 = catalogo.get(1);
        assertTrue(item2.obtenerDetalles().contains("[Serie]"));
        assertTrue(item2.obtenerReglaRecomendacion().contains("mira estos títulos sugeridos"));
    }
}
