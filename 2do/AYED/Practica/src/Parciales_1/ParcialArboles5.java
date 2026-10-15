package Parciales_1;
import tp3.ejercicio1.*;
import java.util.*;

/*
 * Dado un árbol general, encontrar todos los caminos desde la raíz a una hoja, tales que la cantidad de
nodos en el camino sea un número par. Escribir el siguiente método dentro de la clase Parcial public ??
caminosPares(ArbolGeneral<Character> arbol)
 */

public class ParcialArboles5 {
	
	public List<List<Character>> caminosPares(GeneralTree<Character> arbol){
		
		List<List<Character>> result = new ArrayList<>();
		if (arbol != null && !arbol.isEmpty()) {
			List<Character> camino = new ArrayList<>();
			recorrer(arbol,camino,result);
		}
		
		return result;
	}
	
	private void recorrer (GeneralTree<Character> nodo, List<Character> camino, List<List<Character>> result) {
		camino.add(nodo.getData());
		if (nodo.hasChildren()) {
			for (GeneralTree<Character> each : nodo.getChildren()) {
				recorrer (each,camino,result);
			}
		} else {
			if (camino.size() % 2 == 0) {
				result.add(new ArrayList<>(camino));
			}
		}
		
		camino.removeLast();
		
	}
	
}
