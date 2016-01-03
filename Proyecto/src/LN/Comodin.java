package LN;

public class Comodin extends Casilla{

	int num_comodin;
	
	public Comodin( int pos_x, int pos_y, String color, int valor, int num_comodin){
		super(pos_x, pos_y, color, valor);
		num_comodin = this.num_comodin;
	}

	public int getNum_comodin() {
		return num_comodin;
	}

	public void setNum_comodin(int num_comodin) {
		this.num_comodin = num_comodin;
	}
	
}
