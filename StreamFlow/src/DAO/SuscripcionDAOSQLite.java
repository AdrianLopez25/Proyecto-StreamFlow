
package DAO;
import Model.Suscripcion;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SuscripcionDAOSQLite implements ISuscripcionDAO {
    private final String URL = "jdbc:sqlite:streamflow.db";

    @Override
    public void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS suscripciones (" +
                     "idSuscripcion TEXT PRIMARY KEY, " +
                     "fechaInicio TEXT NOT NULL, " +
                     "costoMensual REAL NOT NULL, " +
                     "activa INTEGER NOT NULL);"; 
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error creando tabla suscripciones: " + e.getMessage());
        }
    }

    @Override
    public void guardar(Suscripcion suscripcion) {
        String sql = "INSERT OR REPLACE INTO suscripciones (idSuscripcion, fechaInicio, costoMensual, activa) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, suscripcion.getIdSuscripcion());
            pstmt.setString(2, suscripcion.getFechaInicio().toString());
            pstmt.setDouble(3, suscripcion.getCostoMensual());
            pstmt.setInt(4, suscripcion.isActiva() ? 1 : 0);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error guardando suscripción: " + e.getMessage());
        }
    }

    @Override
    public Suscripcion buscarPorId(String idSuscripcion) {
        String sql = "SELECT * FROM suscripciones WHERE idSuscripcion = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, idSuscripcion);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Suscripcion(
                    rs.getString("idSuscripcion"),
                    LocalDate.parse(rs.getString("fechaInicio")),
                    rs.getDouble("costoMensual"),
                    rs.getInt("activa") == 1
                );
            }
        } catch (SQLException e) {
            System.err.println("Error buscando suscripción: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Suscripcion> obtenerTodas() {
        List<Suscripcion> lista = new ArrayList<>();
        String sql = "SELECT * FROM suscripciones";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                lista.add(new Suscripcion(
                    rs.getString("idSuscripcion"),
                    LocalDate.parse(rs.getString("fechaInicio")),
                    rs.getDouble("costoMensual"),
                    rs.getInt("activa") == 1
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error obteniendo suscripciones: " + e.getMessage());
        }
        return lista;
    }
}