package tp2.ejercicio3;
import tp2.ejercicio1.*;
import tp1.ejercicio8.*;
import tp1.ejercicio8.Queue;
import java.util.*;

public class ContadorArbol {
	
	BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public void numerosParesInOrden(BinaryTree<Integer> arbol, LinkedList<Integer> lista) {
		if ( arbol.getData() % 2 == 0 ) {
			lista.add(arbol.getData());
		}
		if (arbol.hasLeftChild()) {
			numerosParesInOrden(arbol.getLeftChild(),lista);
		}
		if (arbol.hasRightChild()) {
			numerosParesInOrden(arbol.getRightChild(),lista);
		}
	}
	
	public void numerosParesPostOrden(BinaryTree<Integer> arbol, LinkedList<Integer> lista) {
		if (arbol.hasLeftChild()) {
			numerosParesInOrden(arbol.getLeftChild(),lista);
		}
		if (arbol.hasRightChild()) {
			numerosParesInOrden(arbol.getRightChild(),lista);
		}
		if ( arbol.getData() % 2 == 0 ) {
			lista.add(arbol.getData());
		}
	}
	
	
	public LinkedList<Integer> numerosPares() {
		LinkedList<Integer> lista = new LinkedList();
		if (arbol != null) {
			System.out.println("InOrden: ");
			numerosParesInOrden(this.arbol,lista);
			System.out.println("PostOrden: ");
			numerosParesPostOrden(this.arbol,lista);
		}
		return lista;
	}	
}
