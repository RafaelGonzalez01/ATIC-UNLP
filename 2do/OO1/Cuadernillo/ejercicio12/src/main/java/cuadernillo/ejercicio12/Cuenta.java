package cuadernillo.ejercicio12;

public abstract class Cuenta {
	private double saldo;
	
	public Cuenta() {
		saldo = 0;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void depositar(double saldo) {
		this.saldo += saldo;
	}
	
	public boolean extraer(double monto) {
		boolean result = this.puedeExtraer(monto);
		if (result) {
			saldo -= monto;
		}
		return result;
	}
	
	public boolean transferirACuenta(double monto, Cuenta cuentaDestino) {
		boolean result = this.extraer(monto);
		if (result) {
			cuentaDestino.depositar(monto);
		};
		return result;
	}
	
	protected void extraerSinControlar(double monto) {
		this.saldo -= monto;
	}
	
	protected abstract boolean puedeExtraer(double monto);
	
}
