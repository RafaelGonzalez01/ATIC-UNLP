package cuadernillo.ejercicio16;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrismaRectangularTest {
	
	PrismaRectangular prisma;
	
	@BeforeEach
	void setUp() throws Exception {
		prisma = new PrismaRectangular(9,5,12,"Violeta","Papel");
	}
	
	@Test
	void getVolumenTest() {
		assertEquals(540,prisma.getVolumen(),0.01);
	}
	
	@Test
	void getSuperficieTest() {
		assertEquals(426,prisma.getSuperficie(),0.1);
	}
	
	

}
