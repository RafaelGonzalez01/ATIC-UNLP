package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		Queue<GeneralTree<T>> cola = new LinkedList<>();
		int altura = 0;
		GeneralTree<T> aux;
		
		cola.add(this);
		cola.add(null);
		
		while (!cola.isEmpty()) {
			aux = cola.poll();
		
			if (aux != null) {
				for (GeneralTree<T> each : aux.getChildren()) {
					cola.add(each);
				}
				aux = cola.poll();
			} else {
				if (!cola.isEmpty()) {
					altura ++;
					cola.add(null);
				}
			}
		}
		
		return altura;
	}
	
	public int nivel(T dato){
		Queue<GeneralTree<T>> cola = new LinkedList(); // que devuelve si no esta el dato?
		int altura = 0;
		GeneralTree<T> aux;
		boolean encontro = false;
		
		cola.add(this);
		cola.add(null);
		
		while (!cola.isEmpty() && !encontro) { //no es mejor usar un brake o un return antes que ejecute mas codigo en vez de comparar con un booleano?
			aux = cola.poll();
			if (aux != null) {
				if (aux.getData().equals(dato)) {
					encontro = true;
				} else {
					for (GeneralTree<T> each : aux.getChildren()) {
						cola.add(each);
					}
				} 
			} else {
				if (!cola.isEmpty()) {
					altura ++;
					cola.add(null);
				}
			}	
		}
		if (encontro) {
			return altura;
		} else {
			return -1;
		}
	  }

	public int ancho(){
		Queue<GeneralTree<T>> cola = new LinkedList<>();
		GeneralTree<T> aux;
		int nivel_act = 0;
		int nivel_max = 0;
		
		cola.add(this);
		cola.add(null);
		
		while (!cola.isEmpty()) {
			aux = cola.poll();
			if (aux != null) {
				nivel_act ++;
				for (GeneralTree<T> each : aux.getChildren()) {
					cola.add(each);
				}
			} else {
				if (nivel_act > nivel_max) {
					nivel_max = nivel_act;
				}
				if (!cola.isEmpty()) {
					cola.add(null);
					nivel_act = 0;
				}
			}
		}
		return nivel_max;
	}
	
	public boolean esAncestro(T a, T b) {
		
		boolean result = false;
		
		GeneralTree<T> padre = this.busqueda(a);
		
		if (padre != null) {
			if (padre.busqueda(b) != null) {
				result = true;
			}
		}
		
		return result;
	}
	
	private GeneralTree<T> busqueda (T a) {
		
		GeneralTree<T> result = null;
		
		if (this.getData().equals(a)) {
			result = this;
		} else {
			boolean encontro = false;
			Iterator<GeneralTree<T>> it = this.getChildren().iterator();
			while (it.hasNext() && !encontro) {
				GeneralTree<T> act = it.next().busqueda(a);
				if (act != null) {
					encontro = true;
					result = act;
				}
			}
		}
		
		return result;
	}
}