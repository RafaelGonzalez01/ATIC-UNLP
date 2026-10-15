package cuadernillo.ejercicio7;
import java.time.LocalDate;
import java.util.*;

public class Ticket {
	
	private LocalDate fecha;
	private LinkedList<Producto> productos = new LinkedList<>();
	private double pesoTotal;
	private double precioTotal;
	
	public Ticket(LinkedList<Producto> produtcos, double pesoTotal, double precioTotal) {
		this.fecha = LocalDate.now();
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal + this.impuesto();
		this.productos.addAll(produtcos);
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantidadDeProductos() {
		return productos.size();
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public double impuesto() {
		return this.getPrecioTotal() * 0.21;
	}
	
	public List<Producto> getProductos(){
		return productos;
	}
	
}
