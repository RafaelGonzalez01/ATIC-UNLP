package cuadernillo.ejercicio16;

public class PrismaRectangular extends Pieza{
	
	private double ladoMayor;
	private double ladoMenor;
	private double altura;
	
	public PrismaRectangular(double ladoMayor, double ladoMenor, double altura, String color, String material) {
		super(color,material);
		this.altura = altura;
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
	}
	
	public double getVolumen() {
		return ladoMayor * ladoMenor * altura;
	} 
	
	public double getSuperficie() {
		return 2 * (ladoMayor * ladoMenor + ladoMayor * altura + ladoMenor * altura);
	}

}
