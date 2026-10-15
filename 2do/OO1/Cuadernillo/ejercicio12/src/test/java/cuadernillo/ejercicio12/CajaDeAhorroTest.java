package cuadernillo.ejercicio12;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CajaDeAhorroTest {
	private CajaDeAhorro cajaUno;
	private CajaDeAhorro cajaDos;

	@BeforeEach
	void setUp() throws Exception {
		cajaUno = new CajaDeAhorro();
		cajaDos = new CajaDeAhorro();
	}
	
}
