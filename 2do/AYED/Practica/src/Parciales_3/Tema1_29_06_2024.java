package Parciales_3;
import java.util.*;
import tp5.ejercicio1.*;
import tp1.ejercicio8.*;
import tp1.ejercicio8.Queue;

public class Tema1_29_06_2024 {
	
/*
	EJERCICIO 1: Puntaje 5 puntos
	implemente la clase Parcial, y el método:

	T

	publiç List <???> invitacionMasterClass (Graph <??? > red, String usuario, int distancia, int limite)
	En una red social, cada usuario está conectado con otros mediante relaciones de amistad. Estas
	relaciones pueden ser representadas como un grafo no dirigido, donde cada nodo representa un
	usuario y cada arista representa una amistad entre dos usuarios
	Un usuario quiere invitar a una masterclass a todos sus contactos que se encuentran hasta cierta
	distancia de él, pero hay un límite en la cantidad total de personas que puede invitar. El nombre
	del usuario, la distancia y el límite son parámetros del método. Los nombres de usuarios no se
	repiten en el grafo.
	Encuentre todos los usuarios que cumplen con este criterio, priorizando a aquellos que están
	más cerca del usuario. Una vez que se llegue al límite de usuarios se debe cortar la ejecución.
	La lista a retornar debe contener en cada elemento: nombre de usuario y la distancia.
	Nota: Al recorrer la red social, asegúrate de visitar todos los amigos a una distancia menor antes de
	considerar los amigos a la distancia siguiente.
	
*/
	public class Usuario {
		private String usuario;
		private int distancia;
		
		public Usuario(String user, int dist) {
			this.usuario = user;
			this.distancia = dist;
		}
	}
	
	public List<Usuario> invitacionMasterClass (Graph <String> red, String usuario, int distancia, int limite){
		List<Usuario> result = new LinkedList<>();
		
		if (red != null) {
			Vertex<String> desde = red.search(usuario);
			
			if (desde != null) {
				boolean [] visitados = new boolean[red.getSize()];
				visitados[desde.getPosition()] = true;
				List<Edge<String>> aristas = red.getEdges(desde);
				Queue<Vertex<String>> cola = new Queue<Vertex<String>>();
				
				for (Edge<String> arista : aristas) {
					Vertex<String> vertice = arista.getTarget();
					cola.enqueue(vertice);
				}
				
				cola.enqueue(null);
				int nivel = 1;
				
				int cant = 0;
				
				while (!cola.isEmpty() && cant < limite && nivel <= distancia) {
					Vertex<String> aux = cola.dequeue();
					
					if (aux != null) {
						if (!visitados[aux.getPosition()]) {
							result.add(new Usuario(aux.getData(),nivel));
							visitados[aux.getPosition()] = true;
							cant++;
							
							aristas = red.getEdges(aux);
							
							for (Edge<String> arista : aristas) {
								Vertex<String> v = arista.getTarget();
								if (!visitados[v.getPosition()] && nivel < distancia && cant < limite) {
									cola.enqueue(v);
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
		}
		return result;
	}
	
	
}
