package cuadernillo.ejercicio8;

public class Circulo {

	private double radio;
	
	public Circulo (double radio) {
		this.radio = radio;
	}
	
	public double getDiametro() {
		return radio * 2;
	}
	
	public double getPerimetro(){
		return Math.PI * this.getDiametro();
	}
	
	public double getRadio() {
		return radio;
	}
	
	public double getArea() {
		return Math.PI * (this.radio*this.radio); 
	}
}
