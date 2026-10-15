package cuadernillo.ejercicio10;
import java.util.*;

public class Farola {

	private boolean prendida = false;
	private List<Farola> Neighbors = new LinkedList<>();
	
	public void pairWithNeighbor(Farola otraFarola) {
		this.Neighbors.add(otraFarola);
		otraFarola.Neighbors.add(this);
	}

	public List<Farola> getNeighbors(){
		return Neighbors;
	}
	
	public boolean isOn() {
		return this.prendida;
	}
	
	public boolean isOff() {
		return !this.prendida;
	}
	
	public void turnOn() {
		if (this.isOff()){
			this.prendida = true;
			for (Farola each: Neighbors) {
				each.turnOn();
			}
		}
	}
	
	public void turnOff() {
		if (this.isOn()) {
			this.prendida = false;
			for (Farola each: Neighbors) {
				each.turnOff();
			}
		}
	}
	 
	
}
