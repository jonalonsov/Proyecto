package LP;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import LN.Partida;


public class MiTablaModelo extends AbstractTableModel {

	
	   // Lista principal de datos del modelo:
    private ArrayList<Partida> datos = new ArrayList<Partida>();
    private String[] nombresColumnas;  // Nombres de columnas
    private boolean[] columnasEditables;  // Columnas editables o no
	private static final long serialVersionUID = 7026825539532562011L;

    /** Constructor de modelo de tabla
     * @param nombresColumnas	Nombres de las columnas
     * @param colsEditables	Array de valores lógicos si las columnas son editables (true) o no (false)
     */
    public MiTablaModelo( String[] nombresColumnas, boolean[] colsEditables ) {
    	this.nombresColumnas = nombresColumnas;
    	this.columnasEditables = colsEditables;
    }
    
    /** Añade un dato al final del modelo
     * @param dato	Dato a añadir
     */
    public void insertar(Partida dato ) {
    	datos.add( dato );
    }

    /* [01] MODELO: Devuelve el numero de columnas
     */
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    /* [01] MODELO: Devuelve el numero de filas
     */
    public int getRowCount() {
        return datos.size();
    }

    /* [01] MODELO: Devuelve el nombre de la columna
     */
    public String getColumnName(int col) {
        return nombresColumnas[col];
    }

    /* [01] MODELO: Devuelve el valor de la celda indicada
     */
    public Object getValueAt(int row, int col) {
        return datos.get(row).getValor(col);
    }


}
