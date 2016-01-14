package LP;

import java.awt.Dimension;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JTable;

import LN.Usuario;


public class Ranking extends JTable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	// Modelo de datos propio
		private  MiTablaModelo datos;
		

		// [02] Renderers para alinear distinto que a la izquierda
		private static DefaultTableCellRenderer rendererCentrado = new DefaultTableCellRenderer();
		static{
			rendererCentrado.setHorizontalAlignment( JLabel.CENTER );
		}
		
		public Ranking( MiTablaModelo modelo ) {
			super(modelo);
			
	    	// Fijar tama�o preferido de la tabla
	        setPreferredScrollableViewportSize(new Dimension(500, 200));
	        // [02] Asignar renderers de alineación horizontal
	        getColumn("Nombre_de_Usuario").setCellRenderer( rendererCentrado );
	        getColumn("Puntuacion").setCellRenderer( rendererCentrado );
	        getColumn("Fecha").setCellRenderer( rendererCentrado );
	        
	        datos = new MiTablaModelo( Usuario.nombresAtributos, Usuario.atributosEditables );
	        
		}
		
		public void setModel( TableModel t ) {
			if (t instanceof MiTablaModelo)
				super.setModel( t );
			else
				throw new IncompatibleClassChangeError( "No se puede asignar cualquier modelo de datos a una JTable" );
		}
		
		public MiTablaModelo getMiTableModel() {
			return (MiTablaModelo) getModel();
		}
		

}