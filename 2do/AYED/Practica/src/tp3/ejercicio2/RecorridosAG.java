package tp3.ejercicio2;
import java.util.*;
import tp1.ejercicio8.Queue;
import tp3.ejercicio1.*;

public class RecorridosAG {

	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n) {
		
		List<Integer> result = new ArrayList(); //la ia me pide operador diamond en el new, es correcto?
		
		if (a != null && !a.isEmpty()) {
			Integer aux = a.getData();
			if (aux % 2 != 0 && aux > n) {
				result.add(aux);
			}
			
			for (GeneralTree<Integer> each : a.getChildren()) {
				result.addAll(numerosImparesMayoresQuePreOrden(each,n));
			} 
		}
		return result;
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n) {
		
		List<Integer> result = new ArrayList<>();
		
		if (a != null && !a.isEmpty()) {
			
			List<GeneralTree<Integer>> children = a.getChildren();
			Iterator<GeneralTree<Integer>> it = children.iterator(); // se puede hacer sin iterator?
			
			if (it.hasNext()) {
				result.addAll(numerosImparesMayoresQueInOrden(it.next(),n));
			}
			
			Integer aux = a.getData();
			if (aux % 2 != 0 && aux > n) {
				result.add(aux);
			}
			
			while (it.hasNext()) {
				result.addAll(numerosImparesMayoresQueInOrden(it.next(),n));
			}	
			
		}
		return result;
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n) {
		
		List<Integer> result = new ArrayList<>();
		
		if (a != null && !a.isEmpty()) {
			
			for (GeneralTree<Integer> each : a.getChildren()) {
				result.addAll(numerosImparesMayoresQuePreOrden(each,n));
			} 
			
			Integer aux = a.getData();
			if (aux % 2 != 0 && aux > n) {
				result.add(aux);
			}
				
		}
		
		return result;
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n) {
		
		List<Integer> result = new ArrayList<>();
		GeneralTree <Integer> aux;
		
		if (a != null && !a.isEmpty()) {
			
			Queue<GeneralTree<Integer>> cola = new Queue();
			cola.enqueue(a);
			while (!cola.isEmpty()) {
				aux = cola.dequeue();
				if (aux.getData() % 2 != 0 && aux.getData() > n) {
					result.add(aux.getData());
				}
				for (GeneralTree<Integer> each : aux.getChildren()) {
					cola.enqueue(each);
				}
			}
		}
		
		return result;
	}
	
	/*
		b) Si ahora tuviera que implementar estos métodos en la clase GeneralTree<T>, ¿qué modificaciones
		haría tanto en la firma como en la implementación de los mismos?
	*/
}
