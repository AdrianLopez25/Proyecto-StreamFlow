
package Main;
import Controller.StreamFlowController;
import DAO.ContenidoDAOSQLite;
import View.VentanaPrincipal;

public class MainApp {

    public static void main(String[] args) {
  
        ContenidoDAOSQLite dao = new ContenidoDAOSQLite();

        StreamFlowController controlador = new StreamFlowController(dao);
        
        VentanaPrincipal ventana = new VentanaPrincipal(controlador);
        ventana.setVisible(true);
    }
}
    
