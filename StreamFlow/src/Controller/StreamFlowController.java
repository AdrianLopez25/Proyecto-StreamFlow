
package Controller;
import DAO.IContenidoDAO;
import Model.Contenido;
import Service.SuscripcionService;
import Service.RecomendacionService;
import View.VentanaPrincipal;
import View.VentanaSuscripcion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.LinkedList;
import javax.swing.JOptionPane; 

public class StreamFlowController implements ActionListener {
    
    private final IContenidoDAO dao;
    private final SuscripcionService suscripcionService;
    private final RecomendacionService recomendacionService;
    
    private VentanaSuscripcion ventSuscripcion;
    private VentanaPrincipal ventPrincipal;
    private String planSeleccionado;

    public StreamFlowController(IContenidoDAO dao, VentanaSuscripcion ventSuscripcion, VentanaPrincipal ventPrincipal) {
        this.dao = dao;
        this.suscripcionService = new SuscripcionService();
        this.recomendacionService = new RecomendacionService();
        this.dao.crearTabla(); 
        
        this.ventSuscripcion = ventSuscripcion;
        this.ventPrincipal = ventPrincipal;
        this.planSeleccionado = "";
        
        this.ventSuscripcion.btnPlanSD.addActionListener(this);
        this.ventSuscripcion.btnPlanHD.addActionListener(this);
        this.ventSuscripcion.btnPlan4K.addActionListener(this);
        this.ventPrincipal.btnCancelarSuscripcion.addActionListener(this);
        this.ventPrincipal.btnCerrar.addActionListener(this);
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
    
    public List<Contenido> obtenerCatalogoFiltrado() {
        List<Contenido> todasLasPeliculas = dao.obtenerTodos();
        List<Contenido> peliculasFiltradas = new LinkedList<Contenido>();
        
        for (int i = 0; i < todasLasPeliculas.size(); i++) {
            Contenido peli = todasLasPeliculas.get(i);
            String calidadDeLaPeli = String.valueOf(peli.getCalidad());
            
            if (calidadDeLaPeli.equals(planSeleccionado)) {
                peliculasFiltradas.add(peli);
            }
        }
        
        return peliculasFiltradas;
    }

    public void iniciarApp() {
        ventPrincipal.setVisible(false);
        ventSuscripcion.setVisible(true);
    }

    public boolean validarCampos() {
        if (ventSuscripcion.txtCorreo.getText().equals("")) { return false; }
        if (ventSuscripcion.txtPassword.getText().equals("")) { return false; }
        if (ventSuscripcion.txtNombreTarjeta.getText().equals("")) { return false; }
        if (ventSuscripcion.txtNumeroTarjeta.getText().equals("")) { return false; }
        if (ventSuscripcion.txtFechaVencimiento.getText().equals("")) { return false; }
        if (ventSuscripcion.txtCVV.getText().equals("")) { return false; }
        
        return true; 
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == ventSuscripcion.btnPlanSD || 
            e.getSource() == ventSuscripcion.btnPlanHD || 
            e.getSource() == ventSuscripcion.btnPlan4K) {
            
            // Comprobamos si hay algún campo vacío
            if (validarCampos() == false) {
                // Mostramos un mensaje de error en pantalla
                JOptionPane.showMessageDialog(null, "Por favor, llene todos los datos antes de elegir un plan.");
            } else {
                if (e.getSource() == ventSuscripcion.btnPlanSD) {
                    planSeleccionado = "SD";
                }
                if (e.getSource() == ventSuscripcion.btnPlanHD) {
                    planSeleccionado = "HD";
                }
                if (e.getSource() == ventSuscripcion.btnPlan4K) {
                    planSeleccionado = "UHD_4K";
                }
                abrirCatalogo();
            }
        }
        
        if (e.getSource() == ventPrincipal.btnCancelarSuscripcion) {
            ventPrincipal.setVisible(false);
            ventSuscripcion.setVisible(true);
            planSeleccionado = ""; 
            
            ventSuscripcion.txtCorreo.setText("");
            ventSuscripcion.txtPassword.setText("");
            ventSuscripcion.txtNombreTarjeta.setText("");
            ventSuscripcion.txtNumeroTarjeta.setText("");
            ventSuscripcion.txtFechaVencimiento.setText("");
            ventSuscripcion.txtCVV.setText("");
        }
        
        if (e.getSource() == ventPrincipal.btnCerrar) {
            System.exit(0);
        }
    }

    public void abrirCatalogo() {
        ventSuscripcion.setVisible(false);
        ventPrincipal.setVisible(true);
        ventPrincipal.panelCatalogo.cargarDatos();
    }
}