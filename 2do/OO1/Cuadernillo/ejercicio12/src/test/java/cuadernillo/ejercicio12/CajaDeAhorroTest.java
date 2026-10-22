package cuadernillo.ejercicio12;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CajaDeAhorroTest {
	private CajaDeAhorro cajaUno;
	private CajaDeAhorro cajaDos;

	@BeforeEach
	void setUp() throws Exception {
		cajaUno = new CajaDeAhorro();
		cajaDos = new CajaDeAhorro();
	}
	
	@Test
	void testDepositar() {
		cajaUno.depositar(100);
		assertEquals(98, cajaUno.getSaldo());
	}
	
	@Test
	void testExtraer() {
		cajaUno.depositar(100);
		assertFalse(cajaUno.extraer(98));
		assertEquals(98,cajaUno.getSaldo());
		assertTrue(cajaUno.extraer(50));
		assertEquals(47,cajaUno.getSaldo());
	}
	
	@Test
	void transferirACuentaTest() {
		cajaUno.depositar(100);
		assertEquals(98,cajaUno.getSaldo());
		assertFalse(cajaUno.transferirACuenta(98, cajaDos));
		assertEquals(98,cajaUno.getSaldo());
		assertEquals(0,cajaDos.getSaldo());
		assertTrue(cajaUno.transferirACuenta(50, cajaDos));
		assertEquals(49,cajaDos.getSaldo());
		assertEquals(47,cajaUno.getSaldo());
	}
	
	@Test
	void transferirDeCajaACuentaCorrienteTest() {
		cajaUno.depositar(100);
		CuentaCorriente cuenta = new CuentaCorriente();
		assertTrue(cajaUno.transferirACuenta(50, cuenta));
		assertEquals(47,cajaUno.getSaldo());
		assertEquals(50,cuenta.getSaldo());
		assertFalse(cajaUno.transferirACuenta(47, cuenta));
		assertEquals(47,cajaUno.getSaldo());
		assertEquals(50,cuenta.getSaldo());		
	}
	
	
	
}
