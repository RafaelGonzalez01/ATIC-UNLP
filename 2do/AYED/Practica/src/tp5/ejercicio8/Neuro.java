package tp5.ejercicio8;
import tp5.ejercicio1.*;
import tp5.ejercicio5.Persona;
import tp1.ejercicio8.*;
import tp1.ejercicio8.Queue;

import java.util.*;

public class Neuro {
	
	public int neuronasActivadas(Graph<String> grafo, String inicio, int impulso){
		
		int result = 0;
		
		if (grafo != null) {
			Vertex<String> desde = grafo.search(inicio);
			
			if (desde != null) {
				boolean[] visitados = new boolean[grafo.getSize()];
				visitados[desde.getPosition()] = true;
				
				Queue<Vertex<String>> cola = new Queue<Vertex<String>>();
				
				List<Edge<String>> aristas = grafo.getEdges(desde);
				for (Edge<String> arista : aristas) {
					if (impulso <= arista.getWeight()) {
						cola.enqueue(arista.getTarget());
					}	
				}
				cola.enqueue(null);
				
				double impulsoAct = impulso;
				
				while (!cola.isEmpty()) {
					Vertex<String> aux = cola.dequeue();
					
					if (aux != null) {
						
						if (!visitados[aux.getPosition()]) {
							visitados[aux.getPosition()] = true;
							result ++;
							aristas = grafo.getEdges(aux);
							for (Edge<String> arista : aristas) {
								if (impulsoAct <= arista.getWeight()) {
									if (!visitados[arista.getTarget().getPosition()]) {
										cola.enqueue(arista.getTarget());
									}
								}
							}
						}
					} else {
						if (!cola.isEmpty()) {
							impulsoAct = impulsoAct - (impulsoAct * 0.10);
							cola.enqueue(null);
						}
					}
				}
			}
		}	
		return result;
	}
}
