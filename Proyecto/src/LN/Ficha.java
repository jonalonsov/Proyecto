package LN;

public class Ficha {
	
	protected double posX;  // Posición en X (horizontal)
	protected double posY;  // Posición en Y (vertical)
	
		
	// Constructores
	
	public Ficha() {
		
		posX = 100;
		posY = 100;
	}
	
		
		public double getPosX() {
		return posX;
	}
		public double getPosY() {
		return posY;
	}
		public void setPosicion( double posX, double posY ) {
		setPosX( posX );
		setPosY( posY );
	}
	
	public void setPosX( double posX ) {
		this.posX = posX; 
	}
	
	public void setPosY( double posY ) {
		this.posY = posY; 
	}
	
	
}