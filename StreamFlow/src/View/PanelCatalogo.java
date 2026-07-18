
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

        String[] columnas = {"ID", "Título", "Género", "Calidad", "Costo Mensual ($)"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaContenidos = new JTable(modeloTabla);
        
        JScrollPane scrollPane = new JScrollPane(tablaContenidos);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnActualizar = new JButton("Actualizar Catálogo");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                cargarDatos();
            }
        });
        add(btnActualizar, BorderLayout.SOUTH);

        cargarDatos();
    }

    public void cargarDatos() {
        modeloTabla.setRowCount(0); 
        List<Contenido> catalogo = controlador.obtenerCatalogoCompleto();
        
        for (Contenido c : catalogo) {
            double costo = controlador.calcularCostoSuscripcion(c);
            Object[] fila = {
                c.getId(),
                c.getTitulo(),
                c.getGenero(),
                c.getCalidad().name(),
                String.format("%.2f", costo)
            };
            modeloTabla.addRow(fila);
        }
    }
}
