package cuadernillo.ejercicio12;

public class CajaDeAhorro extends Cuenta {
	
	private double saldo = 0;

	public boolean puedeExtraer(double monto) {
		return this.saldo >= monto;
	}
	
	public boolean extraer(double monto) {
		double nuevoMonto = monto + monto * 0.02;
		boolean result = this.puedeExtraer(nuevoMonto);
		if (result) {
			saldo -= nuevoMonto;
		}
		return result;
	}
	
	public void depositar(double monto) {
		double nuevoMonto = monto + monto * 0.02;
		this.saldo += nuevoMonto;
	}
}
