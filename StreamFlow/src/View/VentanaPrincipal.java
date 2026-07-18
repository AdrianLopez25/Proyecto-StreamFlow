
package View;
import Controller.StreamFlowController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
    private StreamFlowController controlador;
    private PanelCatalogo panelCatalogo;

    public VentanaPrincipal(StreamFlowController controlador) {
        this.controlador = controlador;
        setTitle("StreamFlow - Sistema de Gestión");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem menuSalir = new JMenuItem("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.exit(0);
            }
        });
        menuArchivo.add(menuSalir);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

        panelCatalogo = new PanelCatalogo(controlador);
        add(panelCatalogo, BorderLayout.CENTER);
        
        PanelAdministrador panelAdmin = new PanelAdministrador(controlador, panelCatalogo);
        add(panelAdmin, BorderLayout.EAST);
    }
}
