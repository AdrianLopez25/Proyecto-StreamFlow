
package DAO;
import Model.Suscripcion;
import java.util.List;

public interface ISuscripcionDAO {
    void crearTabla();
    void guardar(Suscripcion suscripcion);
    Suscripcion buscarPorId(String idSuscripcion);
    List<Suscripcion> obtenerTodas();
}
