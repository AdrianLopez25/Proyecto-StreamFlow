
package Main;
import Controller.StreamFlowController;
import DAO.ContenidoDAOSQLite;
import View.VentanaPrincipal;
import View.VentanaSuscripcion;

public class MainApp {

    public static void main(String[] args) {
        
        ContenidoDAOSQLite dao = new ContenidoDAOSQLite();
        
        VentanaSuscripcion ventSuscripcion = new VentanaSuscripcion();
        VentanaPrincipal ventPrincipal = new VentanaPrincipal();
        
        StreamFlowController controlador = new StreamFlowController(dao, ventSuscripcion, ventPrincipal);
        
        ventPrincipal.setControlador(controlador);
        
        controlador.iniciarApp();
    }
}