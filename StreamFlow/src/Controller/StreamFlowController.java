
package Controller;
import DAO.IContenidoDAO;
import Model.Contenido;
import Service.SuscripcionService;
import Service.RecomendacionService;
import java.util.List;

public class StreamFlowController {
    private final IContenidoDAO dao;
    private final SuscripcionService suscripcionService;
    private final RecomendacionService recomendacionService;

    public StreamFlowController(IContenidoDAO dao) {
        this.dao = dao;
        this.suscripcionService = new SuscripcionService();
        this.recomendacionService = new RecomendacionService();
        this.dao.crearTabla(); 
    }

    public void agregarContenido(Contenido c) {
        dao.guardar(c);
    }

    public List<Contenido> obtenerCatalogoCompleto() {
        return dao.obtenerTodos();
    }
    
    public double calcularCostoSuscripcion(Contenido c) {
        return suscripcionService.calcularCostoMensual(c);
    }
    
    public List<Contenido> obtenerRecomendaciones(String genero) {
        return recomendacionService.sugerirPorGenero(obtenerCatalogoCompleto(), genero);
    }
}

