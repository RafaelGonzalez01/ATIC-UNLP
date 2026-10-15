package Parciales_1;
import tp2.ejercicio1.*;
import java.util.*;
import tp1.ejercicio8.Queue;

public class ParcialArboles2 {
	
	BinaryTree<String> arbol;
	
	private boolean esPrincesa(String nombre) {
		return nombre.equals("Princesa");
	}
	
	private boolean  esDragon(String nombre) {
		return nombre.equals("Dragon");
	}
	
	
	public List<BinaryTree<String>> accesible(){
		
		List<BinaryTree<String>> result = new ArrayList<>();
		
		
		
	} 
	
	private boolean encontrar (BinaryTree<String> nodo,List<BinaryTree<String>> camino,List<BinaryTree<String>> result,boolean encontro) {
		boolean ok = false;
		
		if (!encontro) {
			if (esPrincesa(nodo.getData())) {
				camino.add(nodo);
				result.addAll(camino);
				ok = true;
			} else {
				if (!esDragon(nodo.getData())) {
					camino.add(nodo);
					if (!encontro && nodo.hasLeftChild()) {
						ok = encontrar(nodo.getLeftChild(),camino,result,ok);
					}
					if (!encontro && nodo.hasRightChild()) {
						ok = encontrar(nodo.getRightChild(),camino,result,ok);
					}
					
				}
			}
		}
		
		camino.removeLast();
		
		return ok;
	}
	
}
