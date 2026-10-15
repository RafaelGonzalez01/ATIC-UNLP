package cuadernillo.ejercicio6;

public class Item {

	String detalle;
	Integer cantidad;
	double costoUnitario;
	
	public double costo() {
		return costoUnitario * cantidad;
	}
	
	public Item(String detalle, Integer cantidad, double costoUnitario) {
		this.cantidad = cantidad;
		this.detalle = detalle;
		this.costoUnitario = costoUnitario;
	}
	
	public double getCostoUnitario() {
		return costoUnitario;
	}
	
}
