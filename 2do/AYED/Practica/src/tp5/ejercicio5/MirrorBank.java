package tp5.ejercicio5;
import java.util.*;
import tp5.ejercicio1.*;
import tp1.ejercicio8.*;
import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

public class MirrorBank {
	
	public List<Persona> quedateEnCasa(Graph<Persona> personas, int gradoSeparacion, Persona emplado){
		List<Persona> result = new LinkedList<>();
		boolean[] visitados = new boolean[personas.getSize()];
		
		
		Vertex<Persona> desde = personas.search(emplado);

		if (desde != null) {
			Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
			cola.enqueue(desde);
			int nivel = 0;
			cola.enqueue(null);
			while (!cola.isEmpty() && nivel < gradoSeparacion && result.size() < 40) {
				
				Vertex<Persona> aux = cola.dequeue();
				
				if (aux != null) {
					if (!visitados[aux.getPosition()]) {
						visitados[aux.getPosition()] = true;
						Persona perAct = aux.getData();
						if (perAct.getRol().equals("jubilado") && !perAct.getCobro()) {
							result.add(aux.getData());
						}
						List<Edge<Persona>> aristas = personas.getEdges(aux);
						for (Edge<Persona> arista : aristas) {
							int j = arista.getTarget().getPosition();
							if (!visitados[j]) {
								cola.enqueue(arista.getTarget());
							}
						}
					}
				} else {
					
					if (!cola.isEmpty()) {
						cola.enqueue(null);
						nivel ++;
					}
					
				}
				
			}
		}
		
		return result;
	}

	
}
