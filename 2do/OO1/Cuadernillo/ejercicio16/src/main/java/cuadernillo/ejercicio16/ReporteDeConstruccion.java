package cuadernillo.ejercicio16;
import java.util.*;

public class ReporteDeConstruccion {
	
	LinkedList<Pieza> piezas = new LinkedList<> ();
	
	public double volumenDeMaterial(String material) {
		double total = piezas.stream()
				.filter(pieza -> pieza.getMaterial().equals(material))
				.mapToDouble(pieza -> pieza.getVolumen())
				.sum();
		return total;
	}
	
	public double superficieDeColor(String color) {
		double total = piezas.stream()
				.filter(pieza -> pieza.getColor().equals(color))
				.mapToDouble(pieza -> pieza.getSuperficie())
				.sum();
		return total;
	}
	
	public void agregarPieza(Pieza pieza) {
		piezas.add(pieza);
	}
	
}
