package Parciales_1;
import tp2.ejercicio1.*;
import java.util.*;

public class ParcialArboles10 {
	
	 public List<Integer> resolver(BinaryTree<Integer> arbol){
		 List<Integer> result = new ArrayList<>();
		 if (arbol != null && )
		 
		 return result;
	 }
	
	 private int recorrer (List<Integer>lista,BinaryTree<Integer> nodo) {
		 int result = 0;
		 if (nodo != null) {
				 int descizq = recorrer(lista,nodo.getLeftChild());
				 int descder = recorrer(lista,nodo.getRightChild());
			 if (descizq == descder) {
				 lista.addFirst(nodo.getData());
			 }
			 result ++;
		 }
		 
		 return result;
	 }
	
	
}
