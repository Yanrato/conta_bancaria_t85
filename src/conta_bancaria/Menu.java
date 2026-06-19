package conta_bancaria;

import java.util.ArrayList;
import java.util.Scanner;
import conta_bancaria.util.Cores;

public class Menu {
	
	static ArrayList<String> nomes = new ArrayList<String>();
	static ArrayList<Integer> agencias = new ArrayList<Integer>();
	static ArrayList<Integer> contas = new ArrayList<Integer>();
	static Scanner leia = new Scanner(System.in);
	static String nomeOperacao = "";

	public static void main(String[] args) {
		
		float saldo = 0.0f;

		boolean sair = false;

		while (sair == false) {
			System.out.println("*** Banco Lavagem de dinheiro S2 Vorcaro ***");
			System.out.println("Bem-vindo ao Banco Lavagem de dinheiro S2 Vorcaro");
			System.out.println("Onde seu dinheiro esta sempre protegido, no meu bolso!!");

			System.out.println("\n*****************************************");
			System.out.println("       BLDV - Evite sacar S2   ");
			System.out.print("*****************************************\n");

			System.out.println("          1 - Criar Conta");
			System.out.println("          2 - Listar Todas as Contas");
			System.out.println("          3 - Consultar Dados da Conta");
			System.out.println("          4 - Atualizar Dados da Conta");
			System.out.println("          5 - Apagar a Conta");
			System.out.println("          6 - Saque");
			System.out.println("          7 - Deposito");
			System.out.println("          8 - Transferência entre Contas");
			System.out.println("          9 - Sair");

			System.out.println("\n*****************************************");

			System.out.print("Entre com a opção desejada: ");
			int operacao = leia.nextInt();


			switch (operacao) {
			case 1:
				novaconta();
				break;
				
			case 2:
				nomeOperacao = "Listar Todas as Contas";
				System.out.printf("Nome da operacao: %s", nomeOperacao);
				System.out.printf("");
				break;
			case 3:
				nomeOperacao = "Consultar Dados da Conta";
				System.out.printf("Nome da operacao: %s", nomeOperacao);
				System.out.printf("");
				break;
			case 4:
				nomeOperacao = "Atualizar Dados da Conta";
				System.out.printf("Nome da operacao: %s", nomeOperacao);
				System.out.printf("");
				break;
			case 5:
				nomeOperacao = "Apagar a Conta";
				System.out.printf("Nome da operacao: %s", nomeOperacao);
				System.out.printf("");
				break;

			case 6:
				nomeOperacao = "Saque";
				System.out.printf("Nome da operacao: %s", nomeOperacao);
				System.out.println("\nDigite o valor do saque: ");
				float saque = leia.nextFloat();
				if (saque > saldo) {
					System.out.println("Saldo insuficiente");
				} else {
					saldo = saldo - saque;
					System.out.printf("Saque Efetuado! \nSaldo Atual R$%.2f", saldo);
				}
				break;
			case 7:
				nomeOperacao = "Deposito";
				System.out.printf("Nome da operacao: %s", nomeOperacao);
				System.out.printf("\nDigite valor a ser depositado: ");
				float deposito = leia.nextFloat();
				saldo = saldo + deposito;
				System.out.printf("Saldo atual: R$%.2f", saldo);
				break;
			case 8:
				nomeOperacao = "Transferência entre Contas";
				System.out.printf("Nome da operacao: %s", nomeOperacao);
				System.out.printf("");
				break;

			case 9:
				nomeOperacao = "Sair";
				System.out.printf("Nome da operacao: %s", nomeOperacao);
				System.out.printf("");
				sair = true;
				break;

			default:
				System.out.print("operacao invalida!");

			}
		}

	}
	
	public static void novaconta(){
		nomeOperacao = "Criar Conta";
		boolean confirma = false;
		while(confirma == false) {
		System.out.printf("Nome da operacao: %s", nomeOperacao);
		System.out.printf("\nDigite seu nome: ");
		String novoNome = leia.next();
		
		System.out.printf("\nDigite sua Agência: ");
		int novaAgencia = leia.nextInt();
		
		System.out.println("\nDigite o numero da conta: ");
		int numeroConta = leia.nextInt();
		
		System.out.println("Confirme os Dados ");
		System.out.println("\nNome: " + novoNome);
		System.out.println("Agência: " + novaAgencia);
		System.out.println("Número da Conta: " + numeroConta);
		
		System.out.println("\nOs dados estão corretos: (S/N)");
		String sn = leia.next();
		
		if (sn.equalsIgnoreCase("S")) {
			nomes.add(novoNome);
			agencias.add(novaAgencia);
			contas.add(numeroConta);
			System.out.println("Conta criada com sucesso!!\n");
			confirma = true;
		} else {
			confirma = false;
		}
		}
		
		
		
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Yan");
		System.out.println("Yan Ferreira - yanferreira985@gmail.com");
		System.out.println("https://github.com/Yanrato");
		System.out.println("*********************************************************");
	}

}
