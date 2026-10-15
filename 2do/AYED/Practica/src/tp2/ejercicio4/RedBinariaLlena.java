package tp2.ejercicio4;
import tp2.ejercicio1.*;

public class RedBinariaLlena {

	BinaryTree<Integer> red = new BinaryTree();
	
	public RedBinariaLlena(BinaryTree<Integer> red) {
		this.red = red;
	}
	
	private int retardoReenvio(BinaryTree<Integer> red) {
		if (!red.hasLeftChild() && !red.hasRightChild()) {
			return red.getData();
		}
		
		int izq = 0;
		int der = 0;
		
		if (red.hasRightChild()) {
			der = retardoReenvio(red.getRightChild());
		}
		if (red.hasLeftChild()) {
			izq = retardoReenvio(red.getLeftChild());
		}
		
		return red.getData() + Math.max(izq, der);
	}
	
	public int retardoReenvio() {
		return retardoReenvio(this.red);
	}
	
}
