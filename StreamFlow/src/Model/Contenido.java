
package Model;

public abstract class Contenido implements Recomendable {
    protected String id;
    protected String titulo;
    protected String genero;
    protected Calidad calidad;
    
    public Contenido(String id, String titulo, String genero, Calidad calidad) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.calidad = calidad;
    }
    public abstract void reproducir();  
    public abstract String obtenerDetalles();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Calidad getCalidad() {
        return calidad;
    }

    public void setCalidad(Calidad calidad) {
        this.calidad = calidad;
    }
    
}
