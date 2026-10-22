package cuadernillo.ejercicio12;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {
	
	private CuentaCorriente cuentaUno;
	private CuentaCorriente cuentaDos;

	@BeforeEach
	void setUp() throws Exception {
		cuentaUno = new CuentaCorriente();
		cuentaDos = new CuentaCorriente();
	}
	
	@Test
	void depositarTest() {
		cuentaUno.depositar(100);
		assertEquals(100,cuentaUno.getSaldo());
	}
	
	@Test
	void extraerTest() {
		cuentaUno.setDescubierto(500);
		assertTrue(cuentaUno.extraer(300));
		assertEquals(-300,cuentaUno.getSaldo());
		cuentaDos.setDescubierto(500);
		assertFalse(cuentaDos.extraer(600));
		assertEquals(0,cuentaDos.getSaldo());
	}
	
	@Test
	void extraerACuentaTest() {
		cuentaUno.setDescubierto(200);
		assertFalse(cuentaUno.transferirACuenta(300, cuentaDos));
		assertEquals(0,cuentaUno.getSaldo());
		assertEquals(0,cuentaDos.getSaldo());
		assertTrue(cuentaUno.transferirACuenta(100, cuentaDos));
		assertEquals(-100,cuentaUno.getSaldo());
		assertEquals(100,cuentaDos.getSaldo());
	}
	
	@Test
	void transferirDeCuentaCorrienteACajaTest() {
		CajaDeAhorro caja = new CajaDeAhorro();
		cuentaUno.setDescubierto(100);
		assertFalse(cuentaUno.transferirACuenta(200, caja));
		assertEquals(0,cuentaUno.getSaldo());
		assertEquals(0,caja.getSaldo());
		assertTrue(cuentaUno.transferirACuenta(100, caja));
		assertEquals(-100,cuentaUno.getSaldo());
		assertEquals(98,caja.getSaldo());
	}
	
	
}
