package LP;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import LD.BasesDeDatos;
import LN.GestorRanking;
import LN.Partida;
import LN.Usuario;

import java.awt.Font;
import java.util.ArrayList;

public class TablaRanking extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MiTablaModelo modelo;
	private JButton btnAtras;
	private String nombre;
	private GestorRanking gr;
	int arrayLuzera;
	static Partida[] arrayPartida;

	/**
	 * Create the frame.
	 */
	public TablaRanking(String nombre) {
		
		this.nombre = nombre;
		modelo = new MiTablaModelo(Usuario.nombresAtributos, Usuario.atributosEditables);
        
		gr = new GestorRanking();
		arrayLuzera = gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), nombre).size();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		 
		// Crear la tabla y el scrollpane
    	Ranking tabla = new Ranking( modelo );
        JScrollPane scrollPane = new JScrollPane( tabla );
        
		contentPane.add( scrollPane, "Center" );
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(this);
		btnAtras.setFont(new Font("Stencil", Font.PLAIN, 17));
		panel.add(btnAtras);
		
		this.RellenarTabla();
		
		this.pack();
	}


	public void RellenarTabla(){
		
//		try {
//			ResultSet rs = st.executeQuery("select * from PARTIDA where (nombreUsuario = '" + nombre + "')");
//			ArrayList<Usuario> datuak = new ArrayList<Usuario>;
		
		GestorRanking gr = new GestorRanking();
		int k = gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), nombre).size();
//			while(rs.next()){
		
		
				 for(int i=0; i<k; i++){
			    		
			    		//datuak[i] = rs.getObject(i+1);
					
				    	modelo.insertar( gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), nombre).get(i));
			    	}
				 
//				 for(int i=0; i<k; i++){
//			    		
//			    		//datuak[i] = rs.getObject(i+1);
//					
//				    	modelo.insertar( gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), nombre).get(i));
//			    	}
//	    	}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnAtras)
			dispose();
	}
	
	
	
//	
//	/** Ordena recursivamente (mergesort) un array de enteros
//	 * @param arrayList	Array de enteros a ordenar
//	 * @param ini	Posici�n inicial de la ordenaci�n
//	 * @param fin	Posici�n final de la ordenaci�n (inclusive)
//	 */
//	public static void mergeSort( ArrayList<Partida> arrayList, int ini, int fin ) {
//		System.out.println( "Entrando en merge: " + ini + "," + fin );
//		if (ini>=fin) {
//			return;  // Caso base, nada que ordenar
//		} else {
//			int med = (ini+fin)/2;
//			mergeSort(arrayList,ini,med);
//			mergeSort(arrayList,med+1,fin);
//			mezclaMergeSort(arrayList,ini,med,fin);
//		}
//	}
//		// Algoritmo de mezcla (no recursivo)
//		// Mezcla en nums las mitades ya ordenadas (ini1 a fin1) con (fin1+1 a fin2)
//		private static Partida[] mezclaMergeSort( ArrayList<Partida> arrayList, int ini1, int fin1, int fin2 ) {
//			int initotal = ini1; // Guardamos el inicio
//			int ini2 = fin1+1; // Inicio segunda mitad
//			// Mezclar las dos mitades. Primero llevarlas mezcladas a un array intermedio:
//			Partida[] destino = new Partida[fin1-ini1+fin2-ini2+2];
//			int posDest = 0;
//			int posEnCurso = -1;
//			while (ini1<=fin1 || ini2<=fin2) {  // Van subiendo ini1 e ini2 hasta acabar (fin1 y fin2)
//				// Hay que comparar ini1 con ini2
//				boolean menorEsIni1 = true;  // Suponemos en principio que es <= ini1 
//				if (ini1>fin1) // No hay ya elementos en la primera mitad
//					menorEsIni1 = false; // En este caso no lo es
//				else if (ini2<=fin2 && arrayList.get(ini1).getPunt()>arrayList.get(ini2).getPunt())
//					menorEsIni1 = false;  // En este caso tampoco
//				if (menorEsIni1) { // Si es menor el de la mitad 1 se lleva de 1
//					destino[posDest] = arrayList.get(ini1);
//					ini1++;
//				} else {  // Si es menor el de la mitad 2 se lleva de 2
//					destino[posDest] = arrayList.get(ini2);
//					ini2++;
//				}
//				posDest++;
//			}
//			// Copiar el array intermedio a la listaOriginal
//			arrayPartida = new Partida[100000];
//			posDest = 0;
//			for( int i=initotal; i<=fin2; i++ ) {
//				arrayPartida[i] = destino[posDest];
//				posDest++;
//			}
//			return arrayPartida;
//		}
//		
//	
//	
//	public void Ordenar() {
//		// Test de ordenaci�n por mezcla (array de enteros)
//		System.out.println( "Array sin ordenar:" );
//		for (int i=0; i<arrayLuzera; i++) 
//			System.out.print( gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), nombre).get(i).getPunt() + ", " );
//		
//		mergeSort( gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), nombre), 0, arrayLuzera-1);
//		System.out.println();
//		System.out.println( "Array ya ordenado:" );
//		for (int i=0; i<arrayLuzera; i++) 
//			System.out.print( arrayPartida[i].getPunt() + ", " );
//	}

}
