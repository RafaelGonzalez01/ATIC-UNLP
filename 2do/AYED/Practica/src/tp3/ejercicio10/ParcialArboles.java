package tp3.ejercicio10;
import java.util.*;
import tp3.ejercicio1.*;

public class ParcialArboles {

	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> camino = new ArrayList();
		List<Integer> recorrido = new ArrayList();
		int[] suma_max = { -1 };
		recorrer(arbol,camino,recorrido,0,0,suma_max);
		return camino;
	}
	
	private static void recorrer(GeneralTree<Integer> nodo, List<Integer> camino, List<Integer> recorrido, int nivel, int suma, int[] suma_max) {
		
		boolean agrego = nodo.getData().equals(1);
		
		if (agrego) {
			recorrido.add(1);
		}
	
		suma += nodo.getData() * nivel;
		
		if (nodo.hasChildren()) {
			for (GeneralTree<Integer> each : nodo.getChildren()) {
				recorrer(each,camino,recorrido,nivel+1,suma,suma_max);
			} 
		} else {
			if (suma > suma_max[0]) {
				camino.clear();
				camino.addAll(recorrido);
				suma_max[0] = suma;
			}
		}
		
		if (agrego) {
			recorrido.removeLast();
		}
			
	}
	
}
