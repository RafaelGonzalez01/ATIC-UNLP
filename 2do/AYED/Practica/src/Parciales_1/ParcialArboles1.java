/*
 * defina una case parcialarboles con una unica variable de istancia de tipo arbolgeneral de enteros y un metodo publico
 * con la siguiente fima public listagenerica <integer> nivel (int sum) el metodo debe devolver los nodos del nivel en
 * donde cada nodo tenga al menos la cantidad num de hijos, debe retornar el rimer nivel que encuentre que cumple con la condicion,
 * en caso de no encontrar ninguno retornar la lista vacia
 */


package Parciales_1;
import  tp3.ejercicio1.*;
import tp1.ejercicio8.Queue;
import java.util.*;

public class ParcialArboles1 {

	GeneralTree<Integer> arbol;
	
	public ArrayList<Integer> nivel (int num) {
		
		ArrayList<Integer> result = new ArrayList<>();
		
		if (arbol == null || arbol.isEmpty()) {
			return result;
		}
		
		GeneralTree<Integer> act;
		ArrayList<Integer> nivel_act = new ArrayList<>();
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		
		boolean ok = false;
		boolean cumple = true;
		
		while (!cola.isEmpty() && !ok) {

			act = cola.dequeue();
			
			if (act != null) {
				
				int cant = 0;
				for (GeneralTree<Integer> each : act.getChildren()) {
					cola.enqueue(each);
				}
				cumple = cumple && act.getChildren().size() >= num;
				if (cumple) {
					nivel_act.add(act.getData());
				}
		
			} else {
				
				if (cumple) {
					ok = true;
					result.addAll(nivel_act);
				} else {
					nivel_act.clear();
					cumple = true;
					if (!cola.isEmpty()) {
						cola.enqueue(null);
					}	
				}
			}	
		}
		
		return result;
	}
	
	
}
