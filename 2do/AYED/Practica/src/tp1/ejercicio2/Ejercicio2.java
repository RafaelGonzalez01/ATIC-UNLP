package tp1.ejercicio2;
import java.util.*;

/*
Escriba un método de clase que dado un número n devuelva un nuevo arreglo de tamaño n 
con los n primeros múltiplos enteros de n mayores o iguales que 1. 
Ejemplo: f(5) = [5; 10; 15; 20; 25]; f(k) = {n*k donde k : 1..k} 
Agregue al programa la posibilidad de probar con distintos valores de n ingresandolos por teclado, mediante el uso de System.in. 
La clase Scanner permite leer de forma sencilla valores de entrada. 
 */

public class Ejercicio2 {

public static int[] ejer () {
	System.out.println("Ingrese un numero.");
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	int[] numeros;
	numeros = new int[n];
	for (int i = 0; i < n; i++) {
		numeros[i] = n * (i + 1);
	}
	return numeros;
}

public static void main(String[] args) {
	int [] arreglo = ejer();
	for (int i = 0; i < arreglo.length ; i++) {
		System.out.println(arreglo[i]);
	}
}




}
