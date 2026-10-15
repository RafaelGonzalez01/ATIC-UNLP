package tp1.ejercicio4;

/*
 * a. Sin ejecutar el programa en su computadora, sólo analizándolo, indique qué imprime el 
siguiente código.
 
public class SwapValores { 

	public static void swap1 (int x, int y) { 
		if (x < y) { 
			int tmp = x ; 
			x = y ; 
			y = tmp; 
		} 
	} 
	public static void swap2 (Integer x, Integer y) { 
		if (x < y) { 
			int tmp = x ; 
			x = y ; 
			y = tmp; 
		} 
	} 
	public static void main(String[] args) { 
		int a = 1, b = 2; 
		Integer c = 3, d = 4; 
		swap1(a,b); 
		swap2(c,d); 
		System.out.println("a=" + a + " b=" + b) ; 
		System.out.println("c=" + c + " d=" + d) ; 
	} 
} 

El codigo imprime: a = 2 b = 1
				   c = 4 d = 3
				   
 * b. Ejecute el ejercicio en su computadora, y compare su resultado con lo esperado en el 
inciso anterior. 

a=1 b=2
c=3 d=4

el codigo no remplaza los valores, ya que siempre pasa los parametros por valor,
en el caso de los datos primitivos como int, para una copia del valor y de los objetos
como Integer pasa una copia de la referencia y tambien el objeto

 * c. Inserte un breakpoint en las líneas donde se indica: y = tmp y ejecute en modo debug 
¿los valores que adoptan las variables x, y coinciden con los valores impresos por 
consola?
 * 
 */

public class SwapValores {
	
	public static void swap1 (int x, int y) { 
		if (x < y) { 
			int tmp = x ; 
			x = y ; 
			y = tmp; 
		} 
	} 
	public static void swap2 (Integer x, Integer y) { 
		if (x < y) { 
			int tmp = x ; 
			x = y ; 
			y = tmp; 
		} 
	} 
	public static void main(String[] args) { 
		int a = 1, b = 2; 
		Integer c = 3, d = 4; 
		swap1(a,b); 
		swap2(c,d); 
		System.out.println("a=" + a + " b=" + b) ; 
		System.out.println("c=" + c + " d=" + d) ; 
	} 
}
