
package Controller;
import DAO.IUsuarioDAO;
import Model.Usuario;
import java.util.List;

public class UsuarioController {
    private final IUsuarioDAO usuarioDAO;

    public UsuarioController(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
        this.usuarioDAO.crearTabla(); // Se asegura que la tabla exista
    }

    public void registrarUsuario(String id, String nombre, String email) {
        Usuario nuevoUsuario = new Usuario(id, nombre, email);
        usuarioDAO.guardar(nuevoUsuario);
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioDAO.obtenerTodos();
    }
    
}
