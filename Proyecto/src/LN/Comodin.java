package LN;

public class Comodin extends Casilla{

	int num_comodin;
	
	public Comodin(int num_casilla, String color, int valor, int num_comodin){
		super(num_casilla, color, valor);
		num_comodin = this.num_comodin;
	}

	public int getNum_comodin() {
		return num_comodin;
	}

	public void setNum_comodin(int num_comodin) {
		this.num_comodin = num_comodin;
	}
	
}
