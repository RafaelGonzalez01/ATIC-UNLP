package Parciales_1;
import java.util.*;
import tp2.ejercicio1.*;

public class ParcialArboles4 {
	
	public List<Character> descifrarCodigo (BinaryTree<Character> arbol, List<String> listaDeSecuencias){
		
		List<Character> result = new ArrayList<>();
		
		if (arbol != null && !arbol.isEmpty()) {	
			for (String each : listaDeSecuencias) {
				String secuencia = each;
				Character letra = recorrido(arbol,secuencia,0);
				result.add(letra);
			}
		}
		
		return result;
		
	}
	
	private Character recorrido (BinaryTree<Character> nodo,String secuencia,int act) {
		char result;
		
		if (nodo.isLeaf()) {
			result = nodo.getData();
		} else {
			if (secuencia.charAt(act) == '1') {
				result = recorrido(nodo.getRightChild(),secuencia,act++);
			} else {
				result = recorrido(nodo.getLeftChild(),secuencia,act++);
			}
		}
		
		return result;
	}
	
}
