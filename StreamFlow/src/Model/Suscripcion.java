
package Model;
import java.time.LocalDate;

public class Suscripcion {
    private String idSuscripcion;
    private LocalDate fechaInicio;
    private double costoMensual;
    private boolean activa;

    public Suscripcion(String idSuscripcion, LocalDate fechaInicio, double costoMensual, boolean activa) {
        this.idSuscripcion = idSuscripcion;
        this.fechaInicio = fechaInicio;
        this.costoMensual = costoMensual;
        this.activa = activa;
    }

    public String getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(String idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getCostoMensual() {
        return costoMensual;
    }

    public void setCostoMensual(double costoMensual) {
        this.costoMensual = costoMensual;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
}
