
package Model;

public class Serie extends Contenido {
    private int temporadas;

    public Serie(String id, String titulo, String genero, Calidad calidad, int temporadas) {
        super(id, titulo, genero, calidad);
        this.temporadas = temporadas;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo Serie: " + titulo
                + " (Temporada 1, Ep 1) en " + calidad);
    }

    @Override
    public String obtenerDetalles() {
        return "[Serie] " + titulo + " | Género: " + genero + " | Temporadas: "
                + temporadas;
    }

    @Override
    public String obtenerReglaRecomendacion() {
        return "Si te gustó esta serie de " + genero + 
                ", mira estos títulos sugeridos.";
    }
}
