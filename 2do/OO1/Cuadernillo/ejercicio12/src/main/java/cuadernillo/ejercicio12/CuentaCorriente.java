package cuadernillo.ejercicio12;

public class CuentaCorriente extends Cuenta{

	private double limiteDescubierto = 0;
	
	public boolean puedeExtraer(double monto) {
		boolean result = (this.getSaldo() + this.limiteDescubierto) >= monto;
		return result;
	}
}
