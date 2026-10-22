package cuadernillo.ejercicio16;

public class Cilindro extends Pieza{
	
	private double altura;
	private double radio;
	
	private double getRadio() {
		return this.radio;
	}
	
	private double getAltura() {
		return this.altura;
	}
	
	public Cilindro (double altura, double radio, String color, String material) {
		super(color,material);
		this.altura = altura;
		this.radio = radio;
	}
	
	public double getVolumen() {
		return Math.PI * Math.pow(this.getRadio(),2) * this.getAltura();
	}
	
	public double getSuperficie() {
		return 2 * Math.PI * this.getRadio() * this.getAltura() + 2 * Math.PI * Math.pow(this.getRadio(), 2);
	}
}
