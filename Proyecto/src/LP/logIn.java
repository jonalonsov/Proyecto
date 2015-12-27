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

import java.awt.Font;

public class logIn extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblContrasea;
	private JButton btnAceptar;
	private JButton cancelarbtn;

	public logIn() {
		setTitle("LOG IN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(135, 70, 184, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passwordField.setBounds(135, 154, 184, 33);
		contentPane.add(passwordField);
		
		lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNewLabel.setBounds(170, 33, 111, 26);
		contentPane.add(lblNewLabel);
		
		lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblContrasea.setBounds(141, 118, 167, 25);
		contentPane.add(lblContrasea);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setFont(new Font("Stencil", Font.PLAIN, 18));
		btnAceptar.setBounds(26, 244, 400, 44);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(this);
		
		cancelarbtn = new JButton("CANCELAR");
		cancelarbtn.setFont(new Font("Stencil", Font.PLAIN, 18));
		cancelarbtn.setBounds(26, 299, 400, 44);
		contentPane.add(cancelarbtn);
		cancelarbtn.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		char[] contrasenya = passwordField.getPassword();
			
		if (e.getSource() == btnAceptar){
		
//        if (isPasswordCorrect(contrasenya)) {
//            JOptionPane.showMessageDialog(btnAceptar, "Bien! Tu contrasenya es correcta.");
//        } else {
//            JOptionPane.showMessageDialog(btnAceptar, "Contrasenya incorrecta, prueba otra vez","Mensaje de error",JOptionPane.ERROR_MESSAGE);
//        }
		//konprobatu base de datosen daon usuario ta kontrasenyak bat datozen
		//queri (ejemploBD)nn
		
		Menu frameMenu = new Menu();
		frameMenu.setVisible(true);

			dispose();
			
		}
		
		if (e.getSource() == cancelarbtn){
			
			dispose();
			principio frame = new principio();
			frame.setVisible(true);
		}
			
		
	}
}

