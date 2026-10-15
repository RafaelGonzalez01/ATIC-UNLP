package tp2.ejercicio5;
import tp2.ejercicio1.*;
import tp1.ejercicio8.*;

public class ProfundidadDeArbolBinario {
	
	private BinaryTree<Integer> arbol = new BinaryTree();
	
	public int sumaElementosProfundidad (int p) {
		Queue<BinaryTree<Integer>> cola = new Queue();
		BinaryTree<Integer> act;

		cola.enqueue(this.arbol);
		cola.enqueue(null);
		int profundidad = 0;
		int suma = 0;
		
		
		
		while (!cola.isEmpty()) {
			act = cola.dequeue();
			if (act != null) {
				if (p == profundidad) {
					suma += act.getData();
				}
				if (act.hasLeftChild()){
					cola.enqueue(act.getLeftChild());
				}
				if (act.hasRightChild()){
					cola.enqueue(act.getRightChild());
				}
			} else {
				profundidad ++;
				if (!cola.isEmpty()) {
					cola.enqueue(null);
				}

			}
		} 
		return suma;
	}
}
