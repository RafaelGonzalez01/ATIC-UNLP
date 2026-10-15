package tp1.ejercicio7;
import java.util.*;

public class EjercicioSucesion {
	
	public void sucesionRecursiva(int numero,ArrayList<Integer> numeros) {
		numeros.add(numero);
		if (numero != 1) {
			if (numero % 2 == 0) {
				numero = numero / 2;
				this.sucesionRecursiva(numero, numeros);
			} else {
				numero = numero * 3 + 1;
				this.sucesionRecursiva(numero, numeros);
			}
		}
	}
	
/*
 * h. Implemente un método recursivo que invierta el orden de los elementos en un 
ArrayList. 	
 */
	
	public void invertirArrayList(ArrayList<Integer> lista){
		if (lista.size() > 1) {
			Integer temp = lista.get(0);
			lista.remove(0);
			invertirArrayList(lista);
			lista.add(temp);
		}
	}
	
/*
 * . 
i. Implemente un método recursivo que calcule la suma de los elementos en un 
LinkedList.	
 */
	public int sumaRecursiva(LinkedList<Integer> lista, int indice) {
		if ((lista.size()-1) == indice) {
			return lista.get(indice);
		} else {
			return indice + sumaRecursiva(lista,indice+1);
		}
	}
	
	public int sumarLinkedList(LinkedList<Integer> lista) {
		return sumaRecursiva(lista,0);
	}
	
/*
j.  Implemente el método “combinarOrdenado” que reciba 2 listas de números ordenados 
y devuelva una nueva lista también ordenada conteniendo los elementos de las 2 listas.  
*/
	
	public ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		ArrayList<Integer> ordenada = new ArrayList();
		int indice1 = 0,indice2 = 0;
		while ((lista1.size() > indice1) && (lista2.size() > indice2)){			
			if (lista1.get(indice1) < lista2.get(indice2)) {
				ordenada.add(lista1.get(indice1));
				indice1++;
			} else {
				ordenada.add(lista2.get(indice2));
				indice2++;
			}
		}
		while (indice1 < lista1.size()) {
			ordenada.add(lista1.get(indice1));
		    indice1++;
		}
		while (indice2 < lista2.size()) {
			ordenada.add(lista2.get(indice2));
			indice2++;
		}
		return ordenada;
	} 
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("ingrese un numero para hacer  la sucecion: ");
		int numero = scan.nextInt();
		scan.close();
		
		ArrayList<Integer> sucesion = new ArrayList();
		EjercicioSucesion ejer = new EjercicioSucesion();
		
		ejer.sucesionRecursiva(numero, sucesion);
		
		for (Integer each : sucesion) {
			System.out.println(each);
		}
		
	}
	
	
}
