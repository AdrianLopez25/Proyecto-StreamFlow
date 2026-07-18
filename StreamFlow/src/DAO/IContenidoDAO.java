
package DAO;
import Model.Contenido;
import java.util.List;

public interface IContenidoDAO {
    void crearTabla();
    void guardar(Contenido contenido);
    List<Contenido> obtenerTodos();
}
