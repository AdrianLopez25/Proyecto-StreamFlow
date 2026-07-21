
package View;
import Controller.StreamFlowController;
import Model.Contenido;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelCatalogo extends JPanel {
    private StreamFlowController controlador;
    private JTable tablaContenidos;
    private DefaultTableModel modeloTabla;

    public PanelCatalogo(StreamFlowController controlador) {
        this.controlador = controlador;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Catálogo Disponible"));

        String[] columnas = {"ID", "Título", "Género", "Calidad"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaContenidos = new JTable(modeloTabla);
        
        JScrollPane scrollPane = new JScrollPane(tablaContenidos);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnActualizar = new JButton("Actualizar Catálogo");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                cargarDatos();
            }
        });
        add(btnActualizar, BorderLayout.SOUTH);

        cargarDatos();
    }

    public void cargarDatos() {
        modeloTabla.setRowCount(0); 
        
        List<Contenido> catalogo = controlador.obtenerCatalogoFiltrado();
        
        for (int i = 0; i < catalogo.size(); i++) {
            Contenido c = catalogo.get(i);
            
            Object[] fila = {
                c.getId(),
                c.getTitulo(),
                c.getGenero(),
                c.getCalidad().name()
            };
            modeloTabla.addRow(fila);
        }
    }
}