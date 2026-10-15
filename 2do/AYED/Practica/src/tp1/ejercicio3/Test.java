package tp1.ejercicio3;

/*
d. Escriba una clase llamada Test con el método main, el cual cree un arreglo con 2 
objetos Estudiante, otro arreglo con 3 objetos Profesor, y luego recorra ambos 
arreglos imprimiendo los valores obtenidos mediante el método tusDatos(). Recuerde 
asignar los valores de los atributos de los objetos Estudiante y Profesor invocando los 
respectivos métodos setters. 
*/

public class Test {

	Estudiante[] estudiantes = new Estudiante[2];
	Profesor[] profesores = new Profesor[3];
	
	public static void main(String[] args) {
		Test t = new Test();
		
		t.estudiantes[0] = new Estudiante();
		t.estudiantes[1] = new Estudiante();
		
		t.profesores[0] = new Profesor();
		t.profesores[1] = new Profesor();
		t.profesores[2] = new Profesor();
			
		t.estudiantes[0].generar("Gomez", "Juan", 2 , "1 y 2", "gomjuan@gmail.com");
		t.estudiantes[1].generar("Sanchez", "Alexis", 3, "20 y 2", "chile@gmail.com");
		
		t.profesores[0].generar("Messi", "lionel", "liopesi@gmail.com", "Matematica", "la vida");
		t.profesores[1].generar("Ronaldo", "Cristiano", "elbicho@gmail.com", "Astronomia", "champions");
		t.profesores[2].generar("Maradona", "Diego", "eldiego@gmail.com", "Fisica", "fiorito");
		
		for (Estudiante estudiante: t.estudiantes) {
			estudiante.tusDatos();
		}
		
		for (Profesor profesor : t.profesores) {
			profesor.tusDatos();
		}
		
	}
	
}
