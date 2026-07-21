
package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class VentanaSuscripcion extends JFrame {
    
    public JTextField txtCorreo;
    public JPasswordField txtPassword;
    
    public JTextField txtNombreTarjeta;
    public JTextField txtNumeroTarjeta;
    public JTextField txtFechaVencimiento;
    public JTextField txtCVV;
    
    public JButton btnPlanSD;
    public JButton btnPlanHD;
    public JButton btnPlan4K;

    public VentanaSuscripcion() {
        setTitle("Registro y Pago - StreamFlow");
        setSize(550, 400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 15));
        panelPrincipal.setBorder(new EmptyBorder(15, 20, 15, 20));

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(7, 2, 10, 15));

        panelFormulario.add(new JLabel("Correo Electrónico:"));
        txtCorreo = new JTextField();
        panelFormulario.add(txtCorreo);

        panelFormulario.add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField(); 
        panelFormulario.add(txtPassword);

        panelFormulario.add(new JLabel("Nombre en la Tarjeta:"));
        txtNombreTarjeta = new JTextField();
        panelFormulario.add(txtNombreTarjeta);

        panelFormulario.add(new JLabel("Número de Tarjeta (16 dígitos):"));
        txtNumeroTarjeta = new JTextField();
        panelFormulario.add(txtNumeroTarjeta);

        panelFormulario.add(new JLabel("Fecha de Vencimiento (MM/AA):"));
        txtFechaVencimiento = new JTextField();
        panelFormulario.add(txtFechaVencimiento);

        panelFormulario.add(new JLabel("Código de Seguridad (CVV):"));
        txtCVV = new JTextField();
        panelFormulario.add(txtCVV);


        panelFormulario.add(new JLabel("")); 
        panelFormulario.add(new JLabel("Seleccione un plan para finalizar:"));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 3, 10, 0));
        
        btnPlanSD = new JButton("Plan SD - $5.99");
        btnPlanHD = new JButton("Plan HD - $9.99");
        btnPlan4K = new JButton("Plan 4K - $14.99");
        
        panelBotones.add(btnPlanSD);
        panelBotones.add(btnPlanHD);
        panelBotones.add(btnPlan4K);

        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);
    }
}