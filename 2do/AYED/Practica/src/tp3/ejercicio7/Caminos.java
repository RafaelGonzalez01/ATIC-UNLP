package tp3.ejercicio7;
import tp3.ejercicio1.*;
import java.util.*;

public class Caminos {
	
	private GeneralTree<Integer> arbol;
	
	public List<Integer> caminoAHojaMasLejana(){
		List<Integer> camino = new LinkedList<>();
		List<Integer> max = new LinkedList<>();
		if (!arbol.isEmpty()) {
			recorrerArbol(arbol,camino,max);
		} else {
			return null;
		}
		return max;
	}
	
	private void recorrerArbol(GeneralTree<Integer>nodo, List<Integer> camino, List<Integer> max) {
		camino.add(nodo.getData());
		
		if (nodo.hasChildren()) {
			for (GeneralTree<Integer> each : nodo.getChildren()) {
				recorrerArbol(each,camino,max);
			}
		} else {
			if (camino.size() > max.size()) {
				max.clear();
				max.addAll(camino);
			}
		}
		
		camino.removeLast();
	}
	
}
