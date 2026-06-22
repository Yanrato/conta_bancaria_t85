package conta_bancaria.model;

public class Conta {

	private String nome;
	private int agencia;
	private int numeroConta;
	private float saldo;
	private int tipo;

	public Conta(String nome, int agencia, int numeroConta, float saldo, int tipo) {
		this.nome = nome;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.tipo = tipo;
	}
	
	public Conta() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public void visualizar() {
		
		String tipo = "";
		switch(this.tipo) {
			
		case 1: 
			tipo = "Conta Corrente";
			break;
		case 2:
			tipo = "Conta Poupança";
			break;
		}
		
		System.out.println("******************************************");
		System.out.println("             DADOS DA CONTA");
		System.out.println("******************************************");
		System.out.printf("Número da conta: %d%n", this.numeroConta);
		System.out.printf("Número da agencia: %d%n", this.agencia);
		System.out.printf("Tipo conta: %s%n", tipo);
		System.out.printf("Nome do titular: %s%n", this.nome);
		System.out.printf("Saldo da conta: %.2f%n", this.saldo);
		
	}
}

