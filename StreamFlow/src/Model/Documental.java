
package Model;

public class Documental extends Contenido {
    private String temaInvestigacion;

    public Documental(String id, String titulo, String genero, Calidad calidad, 
            String temaInvestigacion) {
        super(id, titulo, genero, calidad);
        this.temaInvestigacion = temaInvestigacion;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo Documental investigativo: " + titulo);
    }

    @Override
    public String obtenerDetalles() {
        return "[Documental] " + titulo + " | Tema: " + temaInvestigacion;
    }

    @Override
    public String obtenerReglaRecomendacion() {
        return "Porque te interesa el tema '" + temaInvestigacion + "', mira estos documentales.";
    }
}
