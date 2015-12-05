package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

public class tablero extends JFrame {

	private JPanel contentPane;

					
				

	public tablero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
	}
	
	protected void paintComponent(Graphics g) {
	    super.paintComponents(g); // paint the background image and scale it to fill the entire space
	    Image background = Toolkit.getDefaultToolkit().createImage("tablero.png");
	    g.drawImage(null, 0, 0, null);
	}

}
