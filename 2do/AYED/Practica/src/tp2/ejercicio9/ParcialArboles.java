package tp2.ejercicio9;
import tp2.ejercicio1.*;
import java.util.*;

public class ParcialArboles {
	
	
	
	public BinaryTree<List<Integer>> sumAndDif(BinaryTree<Integer> arbol){
		
		BinaryTree<List<Integer>> result = new BinaryTree();
		
		if (arbol != null) {
			result = recorrido(arbol,0,0);
		}
		
		return result;
		
	}
	
	public BinaryTree<List<Integer>> recorrido (BinaryTree<Integer> arbol, int sumPadre, int numPadre) {
		
		List<Integer> result = new ArrayList();
		
		result.add(sumPadre + arbol.getData());
		result.add(arbol.getData()-numPadre);
		
		BinaryTree<List<Integer>> nue = new BinaryTree();
		
		nue.setData(result);
		
		if (arbol.hasLeftChild()) {
			nue.addLeftChild(recorrido (arbol.getLeftChild(),result.get(0),arbol.getData()));
		}
		
		if (arbol.hasRightChild()) {
			nue.addRightChild(recorrido (arbol.getRightChild(),result.get(0),arbol.getData()));
		}
		
		return nue;
		
	}

}
