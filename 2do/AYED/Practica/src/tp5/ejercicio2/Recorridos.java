package tp5.ejercicio2;
import tp5.ejercicio1.*;
import tp1.ejercicio8.Queue;
import java.util.*;

public class Recorridos<T> {

	public List<T> dfs(Graph<T> grafo){
		List<T> result = new LinkedList<T>();
		boolean[] visitados = new boolean[grafo.getSize()];
		List<Vertex<T>> vertices = grafo.getVertices();
		
		for ( int i = 0; i < grafo.getSize(); i++) {
			if (!visitados[i]) {
				dfs(i, grafo, vertices, visitados, result);
			}
		}
		return result;
	}
	
	private void dfs(int i, Graph<T> grafo, List<Vertex<T>> vertices, boolean[] visitados, List<T> result){
		visitados[i] = true;
		Vertex<T> v = vertices.get(i);
		result.add(v.getData());
		
		List<Edge<T>> aristas = grafo.getEdges(v);
		for (Edge<T> arista: aristas) {
			Vertex<T> destino = arista.getTarget();
			int j = destino.getPosition();
			if (!visitados[j]) {
				dfs(j,grafo,vertices,visitados,result);
			}
		}
	}
	
	public List<T> bfs(Graph<T> grafo){
		List<T> result = new LinkedList<T>();
		boolean[] visitados = new boolean[grafo.getSize()];
		List<Vertex<T>> vertices = grafo.getVertices();
		
		for (int i = 0; i < grafo.getSize(); i++) {
			if (!visitados[i]) {
				bfs(i,grafo,vertices,visitados,result);
			}
		}
		
		return result;
	} 
	
	private void bfs(int i, Graph<T> grafo, List<Vertex<T>> vertices, boolean[] visitados, List<T> result){
		Vertex<T> v = vertices.get(i);
		visitados[i] = true;
		
		Queue<Vertex<T>> cola = new Queue<Vertex<T>>();
		cola.enqueue(v);
		while (!cola.isEmpty()) {
			v = cola.dequeue();
			result.add(v.getData());
			
			List<Edge<T>> aristas = grafo.getEdges(v);
			for (Edge<T> arista : aristas) {
				Vertex<T> destino = arista.getTarget();
				int j = destino.getPosition();
				
				if (!visitados[j]) {
					visitados[j] = true;
					cola.enqueue(destino);
				}
			}	
		}
	}
}
