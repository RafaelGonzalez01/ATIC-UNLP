package cuadernillo.ejercicio7;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public double getPrecio() {
		return this.precioPorKilo * this.peso;
	}
	
	public double getPeso() {
		return this.peso;
	}

	public double getPrecioPorKilo() {
		return precioPorKilo;
	}

	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Producto(String descripcion, double peso, double precioPorKilo) {
		this.peso = peso;
		this.precioPorKilo = precioPorKilo;
		this.descripcion = descripcion;
	}
	
	
	
	
}
