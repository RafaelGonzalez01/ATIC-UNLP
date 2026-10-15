package tp5.ejercicio4;
import tp5.ejercicio1.*;
import java.util.*;

public class VisitaOslo {
	
	public List<String> paseoEnBici(Graph<String> lugares, String destino,  int maxTiempo, List<String> lugaresRestringidos){
		
		List<String> result = new LinkedList<>();
		
		Vertex<String> desde = lugares.search("Ayuntamiento");
		if (desde != null) {
			boolean[] visitados = new boolean[lugares.getSize()];
			List<Vertex<String>> vertices = lugares.getVertices();
			paseoEnBici(lugares,destino,maxTiempo,lugaresRestringidos,visitados,vertices,desde.getPosition(),new LinkedList<String>(),result,0);			
		}
		
		return result;
	}  
	
	private boolean paseoEnBici(Graph<String> lugares, String destino,  int maxTiempo, List<String> lugaresRestringidos, boolean[] visitados, List<Vertex<String>> vertices, int i, List<String> act, List<String> result, int tiempoAct){
		Vertex<String> v = lugares.getVertex(i);
		act.add(v.getData());
		visitados[i] = true;
		boolean encontro = false;
		
		if(!lugaresRestringidos.contains(v.getData())) {
			if (!v.getData().equals(destino)) {
				List<Edge<String>> aristas = lugares.getEdges(v);
				Iterator<Edge<String>> it = aristas.iterator();
				while (it.hasNext() && !encontro) {
					Edge<String> arista = it.next();
					if (tiempoAct + arista.getWeight() <= maxTiempo) {
						Vertex<String> destinoVer = arista.getTarget();
						int j = destinoVer.getPosition();
						if (!visitados[j]) {
							encontro = encontro || paseoEnBici(lugares,destino,maxTiempo,lugaresRestringidos,visitados,vertices,j,act,result,tiempoAct + arista.getWeight());
						}
					}
				}
				
			} else {
				encontro = true;
				result.addAll(act);
			}
		}
		
		visitados[i] = false;
		act.removeLast();
		
		return encontro;
	}
	
}
