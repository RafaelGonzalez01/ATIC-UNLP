package tp1.ejercicio5;
import java.util.*;
import tp1.ejercicio5.*;
/*
 * 5. Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio 
	en un único método. Escriba tres métodos de clase, donde respectivamente: 
	
 * a. Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return"). 
 * 
 * b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de 
	tipo arreglo). 
	
 * c. Devuelva lo pedido sin usar parámetros ni la sentencia "return". 
 */

public class Ejercicio5 {

	private int[] enteros = new int[5];
	
	private double[] resultado = new double[3];
	
	public void generarEnteros() {
		
		Random random = new Random();
		
		for (int i = 0; i < this.enteros.length; i++) {
			this.enteros[i] = random.nextInt(100);
		}
	}
	
	public double[] devolverReturn() {
		double[] resultado = new double[3];
		int max = -1;
		int min = 200;
		int cantTotal = 0;
		for (int each: enteros) {
			if (max < each) {
				max = each;
			}
			if (min > each) {
				min = each;
			}
			cantTotal += each;
		}
		resultado[0] = max;
		resultado[1] = min;
		resultado[2] = (double) cantTotal / enteros.length;
		
		return resultado;
	}
	
	public void devolverParametro(Resultado resultado) {
		int max = -1;
		int min = 200;
		int cantTotal = 0;
		for (int each: enteros) {
			if (max < each) {
				max = each;
			}
			if (min > each) {
				min = each;
			}
			cantTotal += each;
		}
		
		resultado.max = max;
		resultado.min = min;
		resultado.promedio = (double) cantTotal / enteros.length;
		
	}
	
	public void devolverSin() {
		int max = -1;
		int min = 200;
		int cantTotal = 0;
		for (int each: enteros) {
			if (max < each) {
				max = each;
			}
			if (min > each) {
				min = each;
			}
			cantTotal += each;
		}
		
		this.resultado[0] = max;
		this.resultado[1] = min;
		this.resultado[2] = (double) cantTotal / enteros.length;
		
	}

}
