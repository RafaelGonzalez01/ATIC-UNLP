package tp3.ejercicio6;

import tp3.ejercicio1.*;
import java.util.*;

public class RedDeAguaPotable {
	
	private GeneralTree<Character> red;

	public double minimoCaudal(double caudal) {
		return recorrerRed(red,caudal);
	}
	
	private double recorrerRed(GeneralTree<Character> nodo, double caudal) {
		double min = caudal;
		double act = 0;
		if (nodo.hasChildren()) {
			for (GeneralTree<Character> each : nodo.getChildren()) {
				act = recorrerRed(each,(caudal / nodo.getChildren().size()));
				if (act < min) {
					min = act;
				} 
			}
		}
		return min;
	}
	
	
}
