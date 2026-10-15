package cuadernillo2026.ejercicio2;

public class Balanza {
	
	private Integer cantidadDeProductos = 0;
	private double precioTotal = 0;
	private double pesoTotal = 0;
	
	public void ponerEnCero() {
		this.cantidadDeProductos = 0;
		this.pesoTotal = 0;
		this.precioTotal = 0;
	}
	
	public void agregarProducto(Producto producto) {
		this.precioTotal += producto.getPrecio();
		this.pesoTotal += producto.getPeso();
		this.cantidadDeProductos ++;
	}
	
	public Ticket emitirTicket() {
		return new Ticket(this.cantidadDeProductos,this.pesoTotal,this.precioTotal);
	}

	public Integer getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public void setCantidadDeProductos(Integer cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
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

}
