package tp2.ejercicio7;
import tp2.ejercicio1.*;

public class ParcialArboles {

	private BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
	    this.arbol = arbol;
	}
	
	public boolean isLeftTree(int num) {
		
		BinaryTree<Integer> aux;
		
		aux = busqueda_num(num,this.arbol);
		
		boolean result;
		
		if (aux == null) {
			result = false;
		} else {
			
			int der;  // esto esta mal si no le doy valor en todos los caminos?
			int izq;
			
			if (aux.hasRightChild()) {
				der = contador_hijos_unicos(aux.getRightChild());
			} else {
				der = -1;
			}
			if (aux.hasLeftChild()) {
				izq = contador_hijos_unicos(aux.getLeftChild());
			} else {
				izq = -1;
			}
			result = izq > der;
		}
		
		return result;
		
	}
	
	private BinaryTree<Integer> busqueda_num(int num, BinaryTree<Integer> arbol){
		
		BinaryTree<Integer> result = null;
		
		if (arbol != null) {
			
			if (arbol.getData() == num) {
				result = arbol;
			} else {
				
				BinaryTree<Integer> der;
				BinaryTree<Integer> izq;
				
				izq = busqueda_num(num,arbol.getLeftChild());
				der = busqueda_num(num,arbol.getRightChild());
				
				if (izq != null) {
					result = izq;
				}
				
				if (der != null) {
					result = der;
				}
				
			}
			
		}  
		
		return result;  // hice el metodo con un solo return, la ia me dice que es poco eficiente y me da una recomendacion con 3 returns, es mejor?

	}
	
	
	private int contador_hijos_unicos(BinaryTree<Integer> arbol) {
		
		int total = 0;
		
		if (arbol != null) {
			
			if (arbol.hasLeftChild()){
				total += contador_hijos_unicos(arbol.getLeftChild());
			}
			if (arbol.hasRightChild()) {
				total += contador_hijos_unicos(arbol.getRightChild());
			}
			
			if (arbol.hasLeftChild() != arbol.hasRightChild()) {
				total += 1;
			}
		}

		return total;
	}
}
