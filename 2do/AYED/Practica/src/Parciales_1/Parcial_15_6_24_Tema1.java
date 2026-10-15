package Parciales_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Defina una clase ParcialArboles con: (i) una única variable de instancia de tipo ArbolGeneral
de enteros, y (ii) un método público con la siguiente firma: public ListaGenerica <Integer> camino (int
num). El método debe devolver un camino desde la raíz hasta una hojaen donde cada nodo (no hoja) tenga al menos la
cantidad num de hijos.Debe retornar el primer camino que encuentre que cumple la condición. En caso de no encontrar
ninguno retornar la lista vacia.
 */

import tp3.ejercicio1.GeneralTree;

public class Parcial_15_6_24_Tema1 {
	
	GeneralTree<Integer> arbol;
	
	public List<Integer> camino (int num) {
		
		ArrayList<Integer> camino = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		
		if (arbol != null && !arbol.isEmpty()) {
			recorrer(num,arbol,camino,result);
		}
			
		return result;
		
	}
	
	public boolean recorrer (int num, GeneralTree<Integer> arbol,ArrayList<Integer> camino,ArrayList<Integer> result) {
		
		boolean ok = false;
		
		camino.add(arbol.getData());
		
		if (arbol.hasChildren()) {
			List<GeneralTree<Integer>> hijos = arbol.getChildren();
			if (hijos.size() >= num) {
				Iterator<GeneralTree<Integer>> it = hijos.iterator();
				while (it.hasNext() && !ok) {
					ok = recorrer(num,it.next(),camino,result);
				}
			} 
		} else {
			ok = true;
			result.addAll(camino);
		}
		
		camino.removeLast();
	
		return ok;
	}
}
