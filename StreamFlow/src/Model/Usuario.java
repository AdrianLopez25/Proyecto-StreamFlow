
package Model;

public class Usuario {
    private String idUsuario;
    private String nombre;
    private String email;
    private Suscripcion suscripcionActiva;

    public Usuario(String idUsuario, String nombre, String email) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Suscripcion getSuscripcionActiva() {
        return suscripcionActiva;
    }

    public void setSuscripcionActiva(Suscripcion suscripcionActiva) {
        this.suscripcionActiva = suscripcionActiva;
    }
    
}
