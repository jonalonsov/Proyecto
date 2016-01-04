package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JList;
import javax.swing.JButton;

import LD.BasesDeDatos;
import LN.Instrucciones;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class instrucciones extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnVolver;
	private JTextPane area;
	Instrucciones inst;

	/**
	 * Create the frame.
	 */
	public instrucciones() {
		setTitle("INSTRUCCIONES");
		
		inst = new Instrucciones();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		area = new JTextPane();
		//list.setBounds(25, 28, 418, 289);
		//contentPane.add(list);
		//area.setColumns(10);
		area.setEditable(false);
		
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_JUSTIFIED);
		area.setParagraphAttributes(attribs,true);
		
		
		JScrollPane barra = new javax.swing.JScrollPane(area); 
		barra.setBounds(25, 28, 418, 289);
		contentPane.add(barra, BorderLayout.CENTER);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Stencil", Font.PLAIN, 14));
		btnVolver.setBounds(343, 328, 100, 40);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(this);
		
		this.AnadirInformacion();
	}
	
	public void AnadirInformacion(){
		
		
		Statement st = BasesDeDatos.getStatement();
		String s = "";
		inst.InsertarInstrucciones(BasesDeDatos.getStatement());
		
		try {
			s = "select descp from INSTRUCCIONES";
			
			ResultSet rs = st.executeQuery(s);
		
			while(rs.next())
				area.setText(rs.getString("descp"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnVolver)
			dispose();
		
	}
}
