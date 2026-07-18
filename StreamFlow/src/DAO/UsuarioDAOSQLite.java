
package DAO;
import Model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOSQLite implements IUsuarioDAO {
    private final String URL = "jdbc:sqlite:streamflow.db";

    @Override
    public void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                     "idUsuario TEXT PRIMARY KEY, " +
                     "nombre TEXT NOT NULL, " +
                     "email TEXT NOT NULL UNIQUE);";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error creando tabla usuarios: " + e.getMessage());
        }
    }

    @Override
    public void guardar(Usuario usuario) {
        String sql = "INSERT OR REPLACE INTO usuarios (idUsuario, nombre, email) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getIdUsuario());
            pstmt.setString(2, usuario.getNombre());
            pstmt.setString(3, usuario.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error guardando usuario: " + e.getMessage());
        }
    }

    @Override
    public Usuario buscarPorId(String idUsuario) {
        String sql = "SELECT * FROM usuarios WHERE idUsuario = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getString("idUsuario"),
                    rs.getString("nombre"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error buscando usuario: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getString("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("email")));
            }
        } catch (SQLException e) {
            System.err.println("Error obteniendo usuarios: " + e.getMessage());
        }
        return usuarios;
    }
}
