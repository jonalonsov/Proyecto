package LN;

public class Preguntas extends Casilla{

	int num_Preg;
	String descp;
	
	public Preguntas(int num_Preg, String descp, int num_casilla, String color, int valor){
		super(num_casilla, color, valor);
		num_Preg = this.num_Preg;
		descp = this.descp;
	}

	public int getNum_Preg() {
		return num_Preg;
	}

	public void setNum_Preg(int num_Preg) {
		this.num_Preg = num_Preg;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}
	
}
