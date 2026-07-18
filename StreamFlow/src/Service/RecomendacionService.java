package Service;
import Model.Contenido;
import java.util.ArrayList;
import java.util.List;

public class RecomendacionService {
    public List<Contenido> sugerirPorGenero(List<Contenido> catalogo, String generoFavorito) {
        List<Contenido> recomendaciones = new ArrayList<>();
        for (Contenido c : catalogo) {
            if (c.getGenero().equalsIgnoreCase(generoFavorito)) {
                recomendaciones.add(c);
            }
        }
        return recomendaciones;
    }
}

