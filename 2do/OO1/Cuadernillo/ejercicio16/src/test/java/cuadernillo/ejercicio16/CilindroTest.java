package cuadernillo.ejercicio16;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CilindroTest {
	
	Cilindro cilindro;
	
	@BeforeEach
	void setUp()throws Exception{
		 cilindro = new Cilindro(10,5,"Verde","Madera");
	}

	@Test
	void getVolumenTest() {
		assertEquals(785.40,cilindro.getVolumen(),0.01);
	}
	
	@Test
	void getSuperficieTest() {
		assertEquals(471.24,cilindro.getSuperficie(),0.01);
	}
	
}
