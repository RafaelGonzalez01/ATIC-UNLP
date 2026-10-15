package tp2.ejercicio8;
import tp2.ejercicio1.*;

public class ParcialArboles {

	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		
		boolean result = false;
		
		if (arbol1 != null && arbol2 != null) {
			
			result = arbol1.getData() == arbol2.getData();
			
			if (result) {
				
				if (arbol1.hasLeftChild() && !arbol2.hasLeftChild()) {
					result = false;
				} else {
					if (arbol1.hasLeftChild() && arbol2.hasLeftChild()) {
						result = result && esPrefijo(arbol1.getLeftChild(),arbol2.getLeftChild());
					}					
				}
				
				if (arbol1.hasRightChild() && !arbol2.hasRightChild()) {
					result = false;
				} else {
					if (arbol1.hasRightChild() && arbol2.hasRightChild()) {
						result = result && esPrefijo(arbol1.getRightChild(),arbol2.getRightChild());
					}
				}
			}
		}
	
		return result;
		
	}
	
	
}
