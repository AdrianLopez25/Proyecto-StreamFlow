
package DAO;
import Model.Usuario;
import java.util.List;

public interface IUsuarioDAO {
    void crearTabla();
    void guardar(Usuario usuario);
    Usuario buscarPorId(String idUsuario);
    List<Usuario> obtenerTodos();
}
