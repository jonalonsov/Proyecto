package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class registrarse extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNombreDeUsuario;
	private JLabel lblContrasea;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public registrarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(65, 56, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(65, 113, 86, 20);
		contentPane.add(passwordField);
		
		lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setBounds(65, 31, 112, 14);
		contentPane.add(lblNombreDeUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(65, 87, 86, 14);
		contentPane.add(lblContrasea);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(65, 203, 89, 23);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(270, 203, 89, 23);
		contentPane.add(btnCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.equals(btnAceptar)){
			
			//HashMap baten bildu base de datoseko datuk eta hashcodekin konprobatu usuarioa ez dala errepikatzen
			//usuarion hashcode in behar deu ez errepikatzeko
			//berdina baldin bada JoptionPane batean azaldu beste izen bat aukeratzeko
			
			//ondo sartu bada datu basean gorde
			
		}
		
		if (e.equals(btnCancelar)){
			
			dispose();
		}
		
	}

}
