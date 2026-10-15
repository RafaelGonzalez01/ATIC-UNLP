package Parciales_1;
import java.util.*;
import tp3.ejercicio1.*;

/*
 * Defina una clase ParcialArboles que contenga el siguiente método:
public static List<Integer> caminoSignoAlternante(GeneralTree<Integer> arbol)
que recibe un arbol general de valores enteros y devuelve una lista con los valores de los nodos del camino de mayor
costo (suma total de los valores) desde la raíz hasta una hoja, tal que los valores de los nodos alternen entre positivos y
negativos en cada paso. Esto significa que cada nodo del camino debe tener signo opuesto al de su padre (por ejemplo,
si un nodo tiene valor positivo, su hijo inmediato debe tener valor negativo y viceversa).
Si existen varios caminos con el mismo costo máximo que cumplen con la alternancia de signos, se debe devolver el
primer camino encontrado en un recorrido de izquierda a derecha.
En caso de no existir ningún camino desde la raíz hasta una hoja que cumpla con esta condición, el método debe
devolver una lista vacía.
 */

public class Parcial_10_5_25 {

	public static List<Integer> caminoSignoAlternante(GeneralTree<Integer> arbol){
		ArrayList<Integer> result = new ArrayList<>();
		
		if (arbol != null && !arbol.isEmpty()) {
			ArrayList<Integer> camino = new ArrayList<>();
			int[] max = {Integer.MIN_VALUE};
			
			recorrer(camino,result,arbol,0,max);
		}
		return result;
	}
	
	private static void recorrer (ArrayList<Integer> camino, ArrayList<Integer> result, GeneralTree<Integer> nodo, int act, int[]max) {
		
		boolean signo = nodo.getData() > 0;
		camino.add(nodo.getData());
		act += nodo.getData();
		
		if (nodo.hasChildren()) {
			for (GeneralTree<Integer> each : nodo.getChildren()) {
				if (signo != each.getData() > 0) {
					recorrer(camino,result,each,act,max);
				} 
			}
		} else {
			if (act > max[0]) {
				max[0] = act;
				result.clear();
				result.addAll(camino);
			}
		}
		
		camino.removeLast();
		
	}
	
	
}
