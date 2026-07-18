
package Model;

public class Pelicula extends Contenido {
    private int duracionMinutos;

    public Pelicula(String id, String titulo, String genero, Calidad calidad, 
            int duracion) {
        super(id, titulo, genero, calidad);
        this.duracionMinutos = duracion;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo Película: " + titulo + " en " + calidad);
    }

    @Override
    public String obtenerDetalles() {
        return "[Película] " + titulo + " | Género: " + genero + " | Duración: "
                + duracionMinutos + " min";
    }

    @Override
    public String obtenerReglaRecomendacion() {
        return "Basado en " + titulo + ", te recomendamos más del género " + genero;
    }
}
