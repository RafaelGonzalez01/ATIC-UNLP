package tp1.ejercicio8;
import java.util.*;

public class Queue<T> extends Sequence {
	protected List<T> data;
	
	public Queue() {
		data = new ArrayList();
	}
	
	public void enqueue(T data) {
		this.data.add(data);
	}
	
	public T dequeue() {
		T temp = data.getFirst();
		data.removeFirst();
		return temp;
	}
	
	public T head() {
		return this.data.getFirst();
	}
	
	public String toString() {
		String temp = "";
		for (T each  : data) {
			temp += (String) each + " ";
		}
		return temp;
	}
}
