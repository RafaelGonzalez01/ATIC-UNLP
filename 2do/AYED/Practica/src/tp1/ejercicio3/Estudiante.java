package tp1.ejercicio3;
import java.util.*;

/*
Cree una clase llamada Estudiante con los atributos especificados abajo y sus 
correspondientes métodos getters y setters (haga uso de las facilidades que brinda 
eclipse) 
● nombre 
● apellido 
● comision 
● email 
● direccion

c. Agregue un método de instancia llamado tusDatos() en la clase Estudiante y en la 
clase Profesor, que retorne un String con los datos de los atributos de las mismas. 
Para acceder a los valores de los atributos utilice los getters previamente 
definidos.
 */

public class Estudiante {
	private String nombre;
	private String apellido;
	private Integer comision;
	private String email;
	private String direccion;
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	private void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	private void setDirccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Integer getComision() {
		return this.comision;
	}
	
	private void setComision (Integer comision) {
		this.comision = comision;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	private void setEmail(String email) {
		this.email = email;
	}
	
	public void tusDatos() {
		System.out.println("Nombre: " + this.getNombre() + ", Apellido: " + this.getApellido() + ", Comision: " + this.getComision() + ", Email: " 
				+ this.getEmail() + ", Direccion: " + this.getDireccion());
	}
	
	public void generar(String nombre, String apellido, Integer comision, String direccion, String email) {
		this.setApellido(apellido);
		this.setComision(comision);
		this.setDirccion(direccion);
		this.setEmail(email);
		this.setNombre(nombre);
	}
	public Estudiante(String nombre, String apellido, Integer comision, String direccion, String email) {
		this.setApellido(apellido);
		this.setComision(comision);
		this.setDirccion(direccion);
		this.setEmail(email);
		this.setNombre(nombre);
	}
}
