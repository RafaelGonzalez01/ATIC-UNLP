package tp1.ejercicio7;
import java.util.*;
import tp1.ejercicio3.*;

public class TestArrayList {
	
/*
 * a. Escriba una clase llamada TestArrayList cuyo método main recibe una secuencia de 
números, los agrega a una lista de tipo ArrayList, y luego de haber agregado todos los 
números a la lista, imprime el contenido de la misma iterando sobre cada elemento.  

f. Escriba un método que devuelva verdadero o falso si la secuencia almacenada en la 
lista es o no capicúa
 */
	
	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList();
		Scanner scan  = new Scanner(System.in);
		TestArrayList t = new TestArrayList();
		
		System.out.println("Ingrese numeros, finalize con -1");
		int temp = scan.nextInt();
		while (temp  != -1) {
			numeros.add(temp);
			temp = scan.nextInt();
		}
		
		System.out.println("La  lista contiene los nuemros: ");
		for (Integer each : numeros) {
			System.out.print(each+",");
		}
		
		scan.close();
		
		t.ejerD();
	}	
	
	public boolean esCapicua(ArrayList<Integer> numeros) {
		int minI = 0;
		int maxI = numeros.size() -1;
		boolean ok = true;
		while (minI < maxI) {
			if (numeros.get(minI).equals(numeros.get(maxI))) {
				minI += 1;
				maxI -= 1;
			}
			else {
				return false;
			}
		}
		return ok;
	}
	
/*
 * b. Si en lugar de usar un ArrayList en el inciso anterior hubiera usado un LinkedList ¿Qué 
diferencia encuentra respecto de la implementación? Justifique

 No habria difenrencia en codigo, pero seria menos eficiente
 
 c. ¿Existen otras alternativas para recorrer los elementos de la lista del punto 7a.? 
 
 podria usar un for clasico, con un indice, un iterator o streams
 
 d. Escriba un método que realice las siguientes acciones: 
■ cree una lista que contenga 3 estudiantes 
■ genere una nueva lista que sea una copia de la lista del inciso i 
■ imprima el contenido de la lista original y el contenido de la nueva lista 
■ modifique algún dato de los estudiantes 
■ vuelva a imprimir el contenido de la lista original y el contenido de la nueva lista. 
¿Qué conclusiones obtiene a partir de lo realizado? 

	La lista copiada tiene la referencia copida, por lo cual apuntan a la misma direccion de memoria
	
■ ¿Cuántas formas de copiar una lista existen? ¿Qué diferencias existen entre 
ellas?

 existe el metodo clone() o addall(), copia las referencias  no los objetos similar a =, 
 
 */
	
	public void ejerD() {
		ArrayList<Estudiante> estudiantes = new ArrayList();
		Estudiante e1 = new Estudiante("Gomez", "Gomenzon", 2, " 1 y 70", "gg@gmail.com");
		estudiantes.add(e1);
		Estudiante e2 = new Estudiante("Pepito", "Clavo", 2, "1", "unclav@gmail.com");
		estudiantes.add(e2);
		Estudiante e3 = new Estudiante("Patricio", "Estrella", 1, "1y2y3", "bob@gmail.com");
		estudiantes.add(e3);
		
		ArrayList<Estudiante> estudiantesCopia = new ArrayList();
		estudiantesCopia = estudiantes;
		
		System.out.println("La lista original contiene los siguientes estudiantes: ");
		for (Estudiante each : estudiantes) {
			each.tusDatos();
			System.out.println(", ");
		}
		
		System.out.println("La lista copia contiene los siguientes estudiantes: ");
		for (Estudiante each : estudiantesCopia) {
			each.tusDatos();
			System.out.println(", ");
		}
		
		estudiantes.get(0).setNombre("Alfredito");
		
		System.out.println("La lista original contiene los siguientes estudiantes: ");
		for (Estudiante each : estudiantes) {
			each.tusDatos();
			System.out.println(", ");
		}
		
		System.out.println("La lista copia contiene los siguientes estudiantes: ");
		for (Estudiante each : estudiantesCopia) {
			each.tusDatos();
			System.out.println(", ");
		}
	}
	
}

