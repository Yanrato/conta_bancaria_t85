package conta_bancaria.model;

public class ContaPoupanca extends Conta{
	
	private int dia;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int dia) {
		super(numero, agencia, tipo, titular, saldo);
		this.dia = dia;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}
	

	
}
