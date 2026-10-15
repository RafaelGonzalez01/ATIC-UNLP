package tp1.ejercicio9;
import tp1.ejercicio8.*;

/*
9. Considere un string de caracteres S, el cual comprende únicamente los caracteres: (,),[,],{,}. 
Decimos que S está balanceado si tiene alguna de las siguientes formas: 
S = ""   S es el string de longitud cero. 
S = "(T)" 
S = "[T]" 
S = "{T}" 
S = "TU" 
 Donde ambos T y U son strings balanceados. Por ejemplo, "{( ) [ ( ) ] }" está balanceado, pero  
"( [ ) ]" no lo está. 

a. Indique qué estructura de datos utilizará para resolver este problema y cómo la 
utilizará.
 
b. Implemente una clase llamada tp1.ejercicio9.TestBalanceo, cuyo objetivo es 
determinar si un String dado está balanceado. El String a verificar es un parámetro de 
entrada (no es un dato predefinido). 
*/

public class TestBalanceo {

	public boolean estaBalanceado(String data) {
		int i = 0;
		char act;
		DoubleEndedQueue cola = new DoubleEndedQueue();
		if (data != null && data.length() > 0) {
			while (data.length() > i) {
				if (data.charAt(i) == '(' || data.charAt(i) == '[' || data.charAt(i) == '{') {
					cola.enqueueFirst(data.charAt(i));
				} else {
					if (data.charAt(i) == ')' || data.charAt(i) == ']' || data.charAt(i) == '}'){
						if (cola.isEmpty()) {
							return false;
						} else {
							act = (char) cola.dequeue();
							if (data.charAt(i) == ')' && act != '(' ||
							   data.charAt(i) == ']' && act != '[' ||
							   data.charAt(i) == '}' && act != '{') {
								return false;
							}
						}
					} 
				}
				i++;
			}
		}
		if (cola.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
