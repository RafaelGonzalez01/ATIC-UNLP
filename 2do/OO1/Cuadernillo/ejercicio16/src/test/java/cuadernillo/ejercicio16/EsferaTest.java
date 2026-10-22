package cuadernillo.ejercicio16;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EsferaTest {
	
	Esfera esfera;
	
	@BeforeEach
	void setUp() throws Exception {
		esfera = new Esfera(5,"Rojo","Metal");
	}
	
	@Test
	void getSuperficieTest() {
		assertEquals(314.16,esfera.getSuperficie(),0.01);
	}
	
	@Test
	void getVolumenTest() {
		assertEquals(523.60,esfera.getVolumen(),0.01);
	}
	
	

}
