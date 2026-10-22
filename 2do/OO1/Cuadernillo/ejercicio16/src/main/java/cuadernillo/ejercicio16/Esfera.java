package cuadernillo.ejercicio16;

public class Esfera extends Pieza{
	
	private double radio;
	
	public Esfera (double radio, String color, String material) {
		super(color,material);
		this.radio = radio;
	}
	
	private double getRadio() {
		return this.radio;
	}
	
	public double getVolumen() {
		return (4.0/3.0) * Math.PI * Math.pow(this.getRadio(), 3);
	}
	
	public double getSuperficie() {
		return 4 * Math.PI * Math.pow(this.getRadio(), 2);
	}
	
}
