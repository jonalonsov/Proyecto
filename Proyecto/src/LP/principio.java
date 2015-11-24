package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

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
		
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setBounds(247, 119, 101, 23);
		contentPane.add(btnRegistrarse);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.equals(btnRegistrarse)){
			
			registrarse registrarse = new registrarse();
			registrarse.setVisible(true);
			
		}
		
		if (e.equals(btnLogIn)){
			

			logIn logIn = new logIn();
			logIn.setVisible(true);
			
		}
		
	}

}
