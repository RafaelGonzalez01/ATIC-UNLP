package cuadernillo.ejercicio7;
import java.util.*;

public class Balanza {
	
	private double precioTotal = 0;
	private double pesoTotal = 0;
	private LinkedList<Producto> productos = new LinkedList<>();
	
	public void ponerEnCero() {
		this.productos.clear();
		this.pesoTotal = 0;
		this.precioTotal = 0;
	}
	
	public void agregarProducto(Producto producto) {
		this.precioTotal += producto.getPrecio();
		this.pesoTotal += producto.getPeso();
		productos.add(producto);
	}
	
	public Ticket emitirTicket() {
		return new Ticket(productos,this.pesoTotal,this.precioTotal);
	}

	public Integer getCantidadDeProductos() {
		return productos.size();
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	
	public List<Producto> getProductos(){
		return productos;
	}

}
