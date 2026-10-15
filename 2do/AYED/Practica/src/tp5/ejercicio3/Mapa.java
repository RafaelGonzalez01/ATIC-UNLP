package tp5.ejercicio3;
import tp5.ejercicio1.*;
import java.util.*;

public class Mapa {
	
	private Graph<String> mapaCiudades;
	
	public List<String> devolverCamino(String ciudad1, String ciudad2){
		List<String> result = new LinkedList<>();
		boolean[] visitados = new boolean[mapaCiudades.getSize()];
		List<Vertex<String>> vertices = mapaCiudades.getVertices();
		
		Vertex<String> desde = mapaCiudades.search(ciudad1);
		
		if (desde != null) {
			devolverCamino(desde.getPosition(),visitados,mapaCiudades,vertices,result,ciudad2);
			if (!result.getLast().equals(ciudad2)) {
				result = new LinkedList<>();
			}
		}
		return result;
	}
	
	private List<String> devolverCamino(int i,boolean[] visitados,Graph<String> mapaCiudades,List<Vertex<String>> vertices,List<String> result,String ciudad2){
		visitados[i] = true;
		Vertex<String> v = vertices.get(i);
		result.add(v.getData());
		if (v.getData().equals(ciudad2)) {
			return result;
		} else {
			List<Edge<String>> aristas = mapaCiudades.getEdges(v);
			for (Edge<String> arista : aristas) {
				if (!result.getLast().equals(ciudad2)) {
					Vertex<String> destino = arista.getTarget();
					int j = destino.getPosition();
					if (!visitados[j]) {
						devolverCamino(j,visitados,mapaCiudades,vertices,result,ciudad2);
						if (!result.getLast().equals(ciudad2)) {
							result.removeLast();
						}
					}	
				}
			}
		}
		return result;
	}
	
	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
		List<String> result = new LinkedList<>();
		boolean[] visitados = new boolean[mapaCiudades.getSize()];
		List<Vertex<String>> vertices = mapaCiudades.getVertices();
		
		Vertex<String> desde = mapaCiudades.search(ciudad1);
		
		if (desde != null) {
			devolverCaminoExceptuando(ciudad2,ciudades,visitados,result,vertices,desde.getPosition());
			if (!result.getLast().equals(ciudad2)) {
				result = new LinkedList<>();
			}
		}
	
		return result;
	}
	
	private List<String> devolverCaminoExceptuando (String ciudad2, List<String> ciudades,
			boolean[] visitados, List<String> result, List<Vertex<String>> vertices,int i){
		Vertex<String> v = mapaCiudades.getVertex(i);
		visitados[i] = true;
		result.add(v.getData());
		
		if (!v.getData().equals(ciudad2)) {
			List<Edge<String>> aristas = mapaCiudades.getEdges(v);
			
			for (Edge<String> arista : aristas) {
				if (!result.getLast().equals(ciudad2)) {
					Vertex<String> destino = arista.getTarget();
					if (!ciudades.contains(destino.getData()) && !visitados[destino.getPosition()]) {
						devolverCaminoExceptuando (ciudad2,ciudades,visitados,result,vertices,destino.getPosition());
						if (!result.getLast().equals(ciudad2)) {
							result.removeLast();
						}
					}
				}
			}
		}
		return result;
	}
	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> result = new LinkedList<>();
		boolean[] visitados = new boolean[mapaCiudades.getSize()];
		List<Vertex<String>> vertices = mapaCiudades.getVertices();
		
		Vertex<String> desde = mapaCiudades.search(ciudad1);
		List<String> act = new LinkedList<>();
		if (desde != null) {
			caminoMasCorto(desde.getPosition(),ciudad2,result,visitados,vertices,act,Integer.MAX_VALUE,0);
		}

		return result;
	}
	
	private int caminoMasCorto(int i,String ciudad2,List<String> result,boolean[] visitados, List<Vertex<String>> vertices, List<String> act, int pesoact,int pesomin) {
		boolean encontro = false;
		Vertex<String> v = mapaCiudades.getVertex(i);
		act.add(v.getData());
		
		
		encontro = act.getLast().equals(ciudad2);
		if (encontro) {
			if (pesoact < pesomin) {
				result.clear();
				result.addAll(act);
				pesomin = pesoact;
			}
		} else {
			visitados[i] = true;
			List<Edge<String>> aristas = mapaCiudades.getEdges(v);
			for (Edge<String> arista:aristas) {
				Vertex<String> destino = arista.getTarget();
				if (!visitados[destino.getPosition()]) {
					pesomin = caminoMasCorto(destino.getPosition(),ciudad2,result,visitados,vertices,act,pesomin,pesoact+arista.getWeight());
				}
			}
			visitados[i] = false;
		}
		act.removeLast();
		return pesomin;
	}
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		List<String> result = new LinkedList<>();
		boolean[] visitados = new boolean[mapaCiudades.getSize()];
		List<Vertex<String>> vertices = mapaCiudades.getVertices();
		
		Vertex<String> desde = mapaCiudades.search(ciudad1);
		
		if (desde != null) {
			List<String> caminoAct = new LinkedList<>();
			result = caminoSinCargarCombustible(ciudad2,tanqueAuto,visitados,vertices,desde.getPosition(),0,caminoAct);
		}
		
		return result;
	}
	
	private List<String> caminoSinCargarCombustible(String ciudad2, int tanqueAuto, boolean[] visitados, List<Vertex<String>> vertices, int i, int tanqueAct,List<String> caminoAct) {
		Vertex<String> v = mapaCiudades.getVertex(i);
		caminoAct.add(v.getData());
		boolean encontro = v.getData().equals(ciudad2);
		List<String> result = new LinkedList<>();
		
		if (!encontro) {
			visitados[i] = true;
			List<Edge<String>> aristas = mapaCiudades.getEdges(v);
			
			Iterator<Edge<String>> it = aristas.iterator();
			while (result.isEmpty() && it.hasNext()) {
				Edge<String> arista = it.next();
				Vertex<String> destino = arista.getTarget();
				if (!visitados[destino.getPosition()]) {
					result = caminoSinCargarCombustible(ciudad2,tanqueAuto,visitados,vertices,destino.getPosition(),tanqueAct + arista.getWeight(),caminoAct);
				}
			}
			
			visitados[i] = false;
			caminoAct.removeLast();
		} else {
			encontro = tanqueAct <= tanqueAuto;
			if (encontro) {
				result.addAll(caminoAct);
			}
		}
		
		return result;
	}
	
	public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
		List<String> result = new LinkedList<>();
		
		Vertex<String> desde = mapaCiudades.search(ciudad1);
		
		if (desde != null) {
			boolean[] visitados = new boolean[mapaCiudades.getSize()];
			List<Vertex<String>> vertices = mapaCiudades.getVertices();
			List<String> caminoAct = new LinkedList<>();
			
			caminoConMenorCargaDeCombustible(ciudad2, tanqueAuto, 0, 0, Integer.MAX_VALUE, result, visitados, vertices, caminoAct, desde.getPosition());
		}
		
		return result;
	} 
	
	private int caminoConMenorCargaDeCombustible(String ciudad2, int tanqueAuto, int tanqueAct, int cantCargas, int cargaMin, List<String> result, boolean[] visitados, List<Vertex<String>> vertices, List<String> caminoAct, int i) {
		
		Vertex<String> v = mapaCiudades.getVertex(i);
		caminoAct.add(v.getData());
		boolean encontro = (v.getData().equals(ciudad2));
		
		if (!encontro) {
			List<Edge<String>> aristas = mapaCiudades.getEdges(v);
			Iterator<Edge<String>> it = aristas.iterator();
			visitados[i] = true;
			
			while (it.hasNext()) {
				Edge<String> arista = it.next();
				Vertex<String> destino = arista.getTarget();
				if (!visitados[destino.getPosition()] && arista.getWeight() <= tanqueAuto) {
					int act;
					if (tanqueAct < arista.getWeight()) {
						cantCargas++;
						act = caminoConMenorCargaDeCombustible(ciudad2,tanqueAuto, tanqueAuto - arista.getWeight() , cantCargas, cargaMin, result, visitados, vertices, caminoAct, destino.getPosition());
						cantCargas--;
					} else {
						act = caminoConMenorCargaDeCombustible(ciudad2,tanqueAuto, tanqueAct - arista.getWeight() , cantCargas, cargaMin, result, visitados, vertices, caminoAct, destino.getPosition());
					}
					if (act < cargaMin) {
						cargaMin = act;
					}
				}
			}
		} else {
			if (cantCargas < cargaMin) {
				result.clear();
				result.addAll(caminoAct);
				cargaMin = cantCargas;
			}			
		}
		
		visitados[i] = false;
		caminoAct.removeLast();
		
		return cargaMin;
	}
	
	
}
