package tp1.ejercicio3;
import java.util.*;

/*
 * Cree una clase llamada Profesor con los atributos especificados abajo y sus 
correspondientes métodos getters y setters (haga uso de las facilidades que brinda 
eclipse) 
● nombre 
● apellido 
● email 
● catedra 
● facultad

c. Agregue un método de instancia llamado tusDatos() en la clase Estudiante y en la 
clase Profesor, que retorne un String con los datos de los atributos de las mismas. 
Para acceder a los valores de los atributos utilice los getters previamente 
definidos.
 */

public class Profesor {

	private String nombre;
	private String apellido;
	private String email;
	private String catedra;
	private String facultad;
	
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	private void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	private void setEmail(String email) {
		this.email = email;
	}
	public String getCatedra() {
		return catedra;
	}
	private void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return facultad;
	}
	private void setFacultad(String facultad) {
		this.facultad = facultad;
	}	
	
	public void tusDatos() {
		System.out.println("Nombre: " + this.getNombre() + ", Apellido: " + this.apellido + ", Email:" + this.getEmail() + ", Catedra: " + 
	this.getCatedra() + ", Facultad: " + this.getFacultad() );
	}
	
	public void generar(String nombre, String apellido, String email, String catedra, String facultad) {
		this.setApellido(apellido);
		this.setCatedra(catedra);
		this.setEmail(email);
		this.setFacultad(facultad);
		this.setNombre(nombre);
	}
	
}
