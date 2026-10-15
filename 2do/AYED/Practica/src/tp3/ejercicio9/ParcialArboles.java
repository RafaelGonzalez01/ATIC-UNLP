package tp3.ejercicio9;
import tp3.ejercicio1.*;
import java.util.*;

import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {

	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		if (!arbol.isEmpty()) {
			return recorrer (arbol);
		} else {
			return false;
		}
	}
	
	private static boolean recorrer (GeneralTree<Integer> arbol) {
		boolean ok = true;
		
		if (!arbol.isLeaf()) {
			int min = Integer.MAX_VALUE;
			List<GeneralTree<Integer>> hijos = arbol.getChildren();
			Iterator<GeneralTree<Integer>> it = hijos.iterator();
			
			while (it.hasNext() && ok) {
				GeneralTree<Integer> act = it.next();
				if (act.getData() < min) {
					min = act.getData();
				}
				ok = recorrer(act);
			}
			ok = ok && arbol.getData() == min;
		}
		
		return ok;
	}
}
