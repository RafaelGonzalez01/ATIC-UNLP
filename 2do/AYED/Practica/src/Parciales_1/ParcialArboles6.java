package Parciales_1;
import tp2.ejercicio1.*;
import tp1.ejercicio8.Queue;
import java.util.*;

public class ParcialArboles6 {

	BinaryTree<Integer> arbol;
	
	public BinaryTree<Integer> minEnNivelAB(int n){
		BinaryTree<Integer> result = null;
		
		Queue<BinaryTree<Integer>> cola = new Queue<>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		int nivel = 0;
		boolean ok = false;
		int min = Integer.MAX_VALUE;
		
		while (!cola.isEmpty() && !ok) {
			BinaryTree<Integer> act = cola.dequeue();
			
			if (act != null) {
				if (nivel == n) {
					if (act.isLeaf() && act.getData() < min) {
						result = act;
						min = act.getData();
					}
				}
				if (act.hasLeftChild()) {
					cola.enqueue(act.getLeftChild());
				}
				if (act.hasRightChild()) {
					cola.enqueue(act.getRightChild());
				}
			} else {
				if (!cola.isEmpty()) {
					cola.enqueue(null);
					nivel++;
				}
			}
			ok = nivel > n;
			
		}
		
		return result;
	}
}
