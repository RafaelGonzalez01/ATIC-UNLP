package tp2.ejercicio6;
import tp2.ejercicio1.*;

public class Transformacion {

	private BinaryTree<Integer> arbol;
	
	public BinaryTree<Integer> suma() {
		return armar(this.arbol);
	}
	
	private BinaryTree<Integer> armar (BinaryTree<Integer> arbol) {
		BinaryTree<Integer> nuevo = new BinaryTree();
		nuevo.setData(suma_interior(arbol.getLeftChild()) + suma_interior(arbol.getRightChild()));
		if (arbol.hasLeftChild()) {
			nuevo.addLeftChild(armar(arbol.getLeftChild()));
		}
		if (arbol.hasRightChild()) {
			nuevo.addRightChild(armar(arbol.getRightChild()));
		}
		return nuevo;
	}
	
	private int suma_interior(BinaryTree<Integer> arbol) {
		if (arbol != null) {
			return arbol.getData() + suma_interior(arbol.getLeftChild()) + suma_interior(arbol.getRightChild());
		} else {
			return 0;
		}
	}
	
	public BinaryTree<Integer> suma_unico(){
		
		BinaryTree<Integer> nue = new BinaryTree();
		
		nue.setData(suma_unico(arbol,nue));
		
		return nue;
		
	}
	
	private int suma_unico(BinaryTree<Integer> arbol, BinaryTree<Integer> nue) {
		
		if (arbol == null) {  
		    return 0;
		}
		
		int izq = 0;
		int der = 0;
		
		if (arbol.hasLeftChild()) {
			nue.addLeftChild(new BinaryTree());
			izq = suma_unico(arbol.getLeftChild(),nue.getLeftChild());
		}
		if (arbol.hasRightChild()) {
			nue.addRightChild(new BinaryTree());
			der = suma_unico(arbol.getRightChild(),nue.getRightChild());
		}
		nue.setData(izq + der);
		return arbol.getData() + izq + der;
	}
}
