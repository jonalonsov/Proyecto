package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class logIn extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblContrasea;
	private JButton btnAceptar;

	public logIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(178, 86, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 155, 86, 20);
		contentPane.add(passwordField);
		
		lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(195, 61, 60, 14);
		contentPane.add(lblNewLabel);
		
		lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setBounds(188, 130, 86, 14);
		contentPane.add(lblContrasea);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(175, 200, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		char[] contrasenya = passwordField.getPassword();
		
//        if (isPasswordCorrect(contrasenya)) {
//            JOptionPane.showMessageDialog(btnAceptar, "Bien! Tu contraseña es correcta.");
//        } else {
//            JOptionPane.showMessageDialog(btnAceptar, "Contraseña incorrecta, prueba otra vez","Mensaje de error",JOptionPane.ERROR_MESSAGE);
//        }
		//konprobatu base de datosen daon usuario ta kontraseñak bat datozen
		//queri (ejemploBD)nn

			dispose();
	}
}
