package Parciales_3;
import tp5.ejercicio1.*;
import java.util.*;

public class Tema2_15_06_2024 {

/*
EJERCICIO 1: Puntaje 5 puntos
Implemente la clase Parcial, y el método:
public ??? resolver(Graph <??? > sitios, int tiempo)
Una familia se encuentra planificando su visita al Bioparque Temaikèn en las vacaciones de
invierno. Quieren visitar la máxima cantidad de recintos posibles dentro del tiempo que disponen.
Se quiere saber la cantidad máxima de recintos que se puede visitar en un tiempo determinado
partiendo desde la "Entrada"
Cada vértice contiene el nombre del sitio (o recinto de animal) y el tiempo que se tarda en
recorrerlo, y en las aristas se cuenta con el tiempo que toma ir de un sitio a otro.
Por ejemplo para este grafo, si el tiempo disponible es 100 minutos, el método debería devolver 5,
ya que con un total de 98 minutos se pueden recorrer los siguientes sitios: 15' (Entrada) + 15' + 10'
(Tigres) + 8' + 10' (Cebras) + 5' + 10' (Tortugas) + 15' + 10' (Pumas) = 98'
Si el tiempo inicial fuera 30 minutos solo podría recorrer la "Entrada". Debería devolver 1 vértice.
 */
	
	public class Recinto{
		String nombre;
		int tiempo;
		
		public String getNombre() {
			return this.nombre;
		}
		
		public int getTiempo() {
			return this.tiempo;
		}
	}
	
	public int resolver (Graph<Recinto> sitios, int tiempo){
		int result = 0;
		boolean[] visitados = new boolean[sitios.getSize()];
		
		List<Vertex<Recinto>> vertices = sitios.getVertices();
		
		Iterator<Vertex<Recinto>> it = vertices.iterator();
		int desde = -1;
		
		while (it.hasNext() && desde == -1) {
			Vertex<Recinto> v = it.next();
			if (v.getData().getNombre().equals("Entrada")) {
				desde = v.getPosition();
			}
		}
		
		result = resolver(sitios, tiempo, 0, desde, visitados, 0, 0);
		
		return result;
	}
	
	private int resolver(Graph<Recinto> sitios, int tiempo, int act, int i, boolean[] visitados, int max, int cantAct) {
		
		Vertex<Recinto> vertice = sitios.getVertex(i);
		visitados[i] = true;
		
		if (vertice.getData().getTiempo() + act <= tiempo) {
			cantAct ++;
			act += vertice.getData().getTiempo();
			
			List<Edge<Recinto>> aristas = sitios.getEdges(vertice);
			
			for (Edge<Recinto> arista : aristas) {
				Vertex<Recinto> v = arista.getTarget();
				int j = v.getPosition();
				if (!visitados[j]) {
					if (arista.getWeight() + act <= tiempo) {
						max = resolver(sitios,tiempo,act,j,visitados,max,cantAct);
					}
				}
			}
		}
		
		
		if (cantAct > max) {
			max = cantAct;
		}
		
		visitados[i] = false;
		return max;
	}
	
	
	
}
