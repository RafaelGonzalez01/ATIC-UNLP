package cuadernillo.ejercicio6;
import java.time.LocalDate;
import java.util.*;

public class Presupuesto {

	LocalDate fecha = LocalDate.now();
	String cliente;
	LinkedList<Item> items = new LinkedList<>();
	
	public void agregarItem(Item item) {
		items.add(item);
	}
	
	public double calcularTotal() {
		double total = 0;
		for (Item each: items) {
			total += each.costo();
		}
		return total;
	}
	
	public Presupuesto(String cliente) {
		this.cliente = cliente;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
}

/*
b_ lo que esta en el uml,
	inicializo la fecha,
	
c_ 

*/