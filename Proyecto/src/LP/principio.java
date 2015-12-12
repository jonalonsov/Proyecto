package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import LD.BasesDeDatos;

public class principio extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnLogIn;
	private JButton btnRegistrarse;

	public principio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLogIn = new JButton("LOG IN");
		btnLogIn.setBounds(92, 119, 89, 23);
		contentPane.add(btnLogIn);
		btnLogIn.addActionListener(this);
		
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setBounds(247, 119, 130, 23);
		contentPane.add(btnRegistrarse);
		btnRegistrarse.addActionListener(this);
		
		
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				BasesDeDatos.close();
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnRegistrarse){
			
			registrarse registrarse = new registrarse();
			registrarse.setVisible(true);
			
		}
		
		if (e.getSource() == btnLogIn){
			

			logIn logIn = new logIn();
			logIn.setVisible(true);
			
		}
		
	}
	
	

}
