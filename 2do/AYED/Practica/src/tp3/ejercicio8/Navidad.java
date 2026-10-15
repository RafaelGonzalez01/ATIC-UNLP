package tp3.ejercicio8;
import java.util.*;
import tp3.ejercicio1.*;

public class Navidad {

	GeneralTree<Integer> arbol;
	
	public String esAbetoNavidenio() {
		
		String result = "";
		
		if (arbol != null && !arbol.isEmpty()) {
			if (recorrer(arbol)) {
				result = "yes";
			} else {
				result = "no";
			}
		}
		
		return result;
	}
	
	private boolean recorrer(GeneralTree<Integer> arbol) {
		boolean ok = true;
		
		if (!arbol.isLeaf()) {
			
			Iterator<GeneralTree<Integer>> it = arbol.getChildren().iterator();
			int cant = 0;
			
			while (it.hasNext() && ok) {
				GeneralTree<Integer> act = it.next();
				if (act.isLeaf()) {
					cant++;
				} else {
					ok = recorrer(act);
				}
			}
			
			if (!ok || cant < 3) {
				ok = false;
			}
			
		}
		
		return ok;
		
	}
	
}
