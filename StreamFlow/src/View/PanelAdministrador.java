
package View;
import Controller.StreamFlowController;
import Model.Calidad;
import Model.Pelicula;
import javax.swing.*;
import java.awt.*;

public class PanelAdministrador extends JPanel {
    
    public PanelAdministrador(StreamFlowController controlador, PanelCatalogo panelCatalogo) {

        setLayout(new GridLayout(11, 1, 5, 5));
        setBorder(BorderFactory.createTitledBorder("Admin - Agregar Película"));
        setPreferredSize(new Dimension(250, 0));

        JTextField txtId = new JTextField();
        JTextField txtTitulo = new JTextField();
        JTextField txtGenero = new JTextField();
        JComboBox<Calidad> cbCalidad = new JComboBox<>(Calidad.values());
        JTextField txtDuracion = new JTextField();

        add(new JLabel("ID:")); add(txtId);
        add(new JLabel("Título:")); add(txtTitulo);
        add(new JLabel("Género:")); add(txtGenero);
        add(new JLabel("Calidad:")); add(cbCalidad);
        add(new JLabel("Duración (min):")); add(txtDuracion);

        JButton btnGuardar = new JButton("Guardar Película");
        
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try {
                    int duracion = Integer.parseInt(txtDuracion.getText());
                    Pelicula p = new Pelicula(
                        txtId.getText(), 
                        txtTitulo.getText(), 
                        txtGenero.getText(), 
                        (Calidad) cbCalidad.getSelectedItem(), 
                        duracion
                    );

                    controlador.agregarContenido(p);
                    
                    JOptionPane.showMessageDialog(PanelAdministrador.this, "Película guardada en SQLite.");
      
                    panelCatalogo.cargarDatos(); 
                    
                    txtId.setText("");
                    txtTitulo.setText("");
                    txtGenero.setText("");
                    txtDuracion.setText("");
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(PanelAdministrador.this, "Error: Verifica que la duración sea un número.");
                }
            }
        });
        
        add(btnGuardar);
    }
}
