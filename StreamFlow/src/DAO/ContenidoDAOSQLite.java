
package DAO;
import Model.Calidad;
import Model.Contenido;
import Model.Pelicula;
import Model.Serie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContenidoDAOSQLite implements IContenidoDAO {
    private final String URL = "jdbc:sqlite:streamflow.db";

    @Override
    public void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS contenidos (" +
                "id TEXT PRIMARY KEY, " +
                "titulo TEXT NOT NULL, " +
                "genero TEXT NOT NULL, " +
                "calidad TEXT NOT NULL, " +
                "tipo TEXT NOT NULL, " +
                "parametro_extra INTEGER NOT NULL);"; 
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error creando tabla: " + e.getMessage());
        }
    }

    @Override
    public void guardar(Contenido c) {
        String sql = "INSERT OR REPLACE INTO contenidos (id, titulo, genero, "
                + "calidad, tipo, parametro_extra) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, c.getId());
            pstmt.setString(2, c.getTitulo());
            pstmt.setString(3, c.getGenero());
            pstmt.setString(4, c.getCalidad().name());
            
            if (c instanceof Pelicula) {
                pstmt.setString(5, "Pelicula");
                pstmt.setInt(6, 120); 
            } else if (c instanceof Serie) {
                pstmt.setString(5, "Serie");
                pstmt.setInt(6, 5); 
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error guardando: " + e.getMessage());
        }
    }

    @Override
    public List<Contenido> obtenerTodos() {
        List<Contenido> lista = new ArrayList<>();
        String sql = "SELECT * FROM contenidos";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String id = rs.getString("id");
                String titulo = rs.getString("titulo");
                String genero = rs.getString("genero");
                Calidad calidad = Calidad.valueOf(rs.getString("calidad"));
                String tipo = rs.getString("tipo");
                int extra = rs.getInt("parametro_extra");

                if (tipo.equals("Pelicula")) {
                    lista.add(new Pelicula(id, titulo, genero, calidad, extra));
                } else {
                    lista.add(new Serie(id, titulo, genero, calidad, extra));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error leyendo: " + e.getMessage());
        }
        return lista;
    }
}
