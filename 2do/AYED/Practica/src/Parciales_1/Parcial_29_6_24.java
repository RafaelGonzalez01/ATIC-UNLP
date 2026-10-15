package Parciales_1;
import java.util.*;
import tp2.ejercicio1.*;

/*
 * Ejercicio 1 (5 puntos). Defina una clase ParcialArboles con: (i) una única variable de instancia de tipo
BinaryTree<Integer>. y (il) un método público con la siguiente firma:
public BinaryTree<Integer> nuevoTree()
El método debe devolver un nuevo árbol, construido de la siguiente forma:
Si el árbol dado tiene hijo izquierdo, el nuevo árbol tendrá hijo izquierdo cuyo valor será la suma del valor del
hijo izquierdo y el valor del padre del árbol dado.
Si el àrbol dado no tiene hijo izquierdo, tampoco lo tendrá el nuevo
Los hijos derechos del nuevo árbol son iguales que los del árboi dado
Las hojas del árbol dado serán hojas en el nuevo.
 */


public class Parcial_29_6_24 {

	BinaryTree<Integer> arbol;
	
	public BinaryTree<Integer> nuevoTree() {
		BinaryTree<Integer> result = new BinaryTree<>();
		if (arbol != null && !arbol.isEmpty()) {
			result = recorrido(arbol,0);
		}
		return result;
	}
	
	public BinaryTree<Integer> recorrido (BinaryTree<Integer> nodo, Integer agregado) {
		BinaryTree<Integer> result = new BinaryTree<>();
		result.setData(nodo.getData() + agregado);
		if (nodo.hasLeftChild()) {
			result.addLeftChild(recorrido(nodo.getLeftChild(),nodo.getData()));
		}
		if (nodo.hasRightChild()) {
			result.addRightChild(recorrido(nodo.getRightChild(),0));
		}
		return result;
	}
	
}
