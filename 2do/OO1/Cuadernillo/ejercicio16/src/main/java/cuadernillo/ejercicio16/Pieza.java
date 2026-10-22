package cuadernillo.ejercicio16;

public abstract class Pieza {

	protected String material;
	protected String color;
	
	public String getMaterial() {
		return this.material;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public Pieza (String color, String material) {
		this.color = color;
		this.material = material;
	}
	
	public abstract double getSuperficie();
	public abstract double getVolumen();
	
}
