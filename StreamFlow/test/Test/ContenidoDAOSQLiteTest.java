
package Test;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import DAO.ContenidoDAOSQLite;
import Model.Calidad;
import Model.Pelicula;
import Model.Contenido;
import java.util.List;

public class ContenidoDAOSQLiteTest {
    private ContenidoDAOSQLite dao;

    @Before
    public void setUp() {
        dao = new ContenidoDAOSQLite();
        dao.crearTabla();
    }

    @Test
    public void testGuardarYObtenerContenido() {
        
        String testId = "TEST-999";
        Pelicula p = new Pelicula(testId, "Prueba JUnit", "Comedia", Calidad.SD, 90);

        dao.guardar(p);
        List<Contenido> resultados = dao.obtenerTodos();
        
        boolean encontrado = false;
        for (Contenido c : resultados) {
            if (c.getId().equals(testId)) {
                encontrado = true;
                assertEquals("Prueba JUnit", c.getTitulo());
                assertEquals(Calidad.SD, c.getCalidad());
                break;
            }
        }
        assertTrue("El contenido guardado debe poder recuperarse de SQLite", encontrado);
    }
}

