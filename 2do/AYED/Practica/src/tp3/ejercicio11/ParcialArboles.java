package tp3.ejercicio11;
import tp1.ejercicio8.Queue;
import tp3.ejercicio1.*;
import java.util.*;

public class ParcialArboles {

	public static boolean resolver(GeneralTree<Integer> arbol) {
		
		if (arbol == null || arbol.isEmpty()) {
			return false;
		}
		
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		GeneralTree<Integer> act;
		
		cola.enqueue(arbol);
		cola.enqueue(null);
		int nivel_ant = 0;
		int nivel_act = 0;
		boolean ok = true;
		
		while (!cola.isEmpty() && ok) {
			
			act = cola.dequeue();
			
			if (act != null) {
				
				nivel_act ++;
				
				for (GeneralTree<Integer> each : act.getChildren()) {
					cola.enqueue(each);
				}
				
			} else {
				
				ok = nivel_act == (nivel_ant + 1);
				
				if (!cola.isEmpty()) {
					
					cola.enqueue(null);
					nivel_ant = nivel_act;
					nivel_act = 0;
					
				}
			}
			
		}
		
		return ok;
		
	}
	
	
}
