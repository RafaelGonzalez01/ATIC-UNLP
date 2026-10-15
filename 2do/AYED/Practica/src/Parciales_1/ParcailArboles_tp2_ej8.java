package Parciales_1;
import tp2.ejercicio1.*;

public class ParcailArboles_tp2_ej8 {
	
	public boolean esPrefijo (BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean ok = false;
		if (arbol2 != null && !arbol2.isEmpty()) {
			if (arbol2.getData().equals(arbol1.getData())) {
				ok = true;
				if (arbol1.hasLeftChild()) {
					ok = ok && esPrefijo(arbol1.getLeftChild(),arbol2.getLeftChild()); 
				}
				if (arbol1.hasRightChild()) {
					ok = ok && esPrefijo(arbol1.getRightChild(),arbol2.getRightChild());
				}
			}
		}
		return ok;	
	}
	
}
