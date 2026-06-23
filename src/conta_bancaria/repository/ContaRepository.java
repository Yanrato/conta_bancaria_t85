package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository {

	//CRUD
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void procurarPorNumero(int numero);
	public void deletar(int numero);
	
	//Metodos Bancários
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigin, int numeroDestino, float valor);
	
	//
}
