package tp3.ejercicio4;
import tp3.ejercicio1.*;
import java.util.*;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol) {
		
		double prom_act = 0;
		double cant = 0;
		double prom_max = -1;
		
		Queue<GeneralTree<AreaEmpresa>> cola = new LinkedList<>();
		GeneralTree<AreaEmpresa> aux;
		
		cola.add(arbol);
		cola.add(null);
		
		while (!cola.isEmpty()) {
			aux = cola.poll();
			if (aux != null) {
				cant ++;
				prom_act += aux.getData().tardanza;
				for (GeneralTree<AreaEmpresa> each: aux.getChildren()) {
					cola.add(each);
				}
			} else {
				prom_act = prom_act / cant;
				if (prom_act > prom_max) {
					prom_max = prom_act;
				}
				if (!cola.isEmpty()) {
					prom_act = 0;
					cant = 0;
					cola.add(null);
				}
			}
		}
		return prom_max;
	}
}
