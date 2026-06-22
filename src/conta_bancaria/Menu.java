package conta_bancaria;

import java.util.ArrayList; 
import java.util.Scanner;
import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {

	static String nomeOperacao = "";

	static Scanner leia = new Scanner(System.in);

	static ArrayList<Conta> contas = new ArrayList<>();

	public static void main(String[] args) {

		boolean sair = false;

		while (sair == false) {

			System.out.println("*** Banco Lavagem de dinheiro S2 Vorcaro ***");
			System.out.println("Onde seu dinheiro esta sempre protegido, no meu bolso!!");
			System.out.println("       BLDV - Evite sacar S2   ");
			System.out.println("*****************************************");
			System.out.println("          1 - Criar Conta");
			System.out.println("          2 - Listar Todas as Contas");
			System.out.println("          3 - Consultar Dados da Conta");
			System.out.println("          4 - Atualizar Dados da Conta");
			System.out.println("          5 - Apagar a Conta");
			System.out.println("          6 - Saque");
			System.out.println("          7 - Deposito");
			System.out.println("          8 - Transferência entre Contas");
			System.out.println("          9 - Sair");
			System.out.println("*****************************************");

			System.out.print("Entre com a opção desejada: ");
			int operacao = leia.nextInt();

			switch (operacao) {
			case 1:
				nomeOperacao = "Criar Conta";
				System.out.printf("\nNome da operacao: %s", nomeOperacao);
				novaconta();
				break;

			case 2:
				nomeOperacao = "Listar Todas as Contas";
				System.out.printf("\nNome da operacao: %s", nomeOperacao);

				listarcontas();
				voltarMenu();
				break;
			case 3:
				nomeOperacao = "Consultar Conta";
				System.out.printf("\nNome da operacao: %s", nomeOperacao);

				consultarconta();
				voltarMenu();

				break;
			case 4:
				nomeOperacao = "Atualizar Dados da Conta";
				System.out.printf("Nome da operacao: %s", nomeOperacao);
				atualizarconta();
				voltarMenu();

				break;
			case 5:
				nomeOperacao = "Apagar a Conta";
				System.out.printf("Nome da operacao: %s", nomeOperacao);
				System.out.printf("");
				break;

			case 6:
				nomeOperacao = "Saque";
				System.out.printf("Nome da operacao: %s", nomeOperacao);

				break;
			case 7:
				nomeOperacao = "Deposito";
				System.out.printf("Nome da operacao: %s", nomeOperacao);

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

	public static void novaconta() {
		boolean confirma = false;

		while (!confirma) {

			System.out.printf("\nDigite seu nome: ");
			String novoNome = leia.next();

			System.out.printf("\nDigite sua Agência: ");
			int novaAgencia = leia.nextInt();

			System.out.println("\nDigite o numero da conta: ");
			int numeroConta = leia.nextInt();
			
			System.out.println("\nDigite o tipo da conta: ");
			int novoTipo = leia.nextInt();

			System.out.println("\nDigite o saldo da conta: ");
			float novoSaldo = leia.nextFloat();

			System.out.println("\nConfirme os Dados ");
			System.out.println("\nNome: " + novoNome);
			System.out.println("Agência: " + novaAgencia);
			System.out.println("Número da Conta: " + numeroConta);
			System.out.println("Saldo: " + novoSaldo);

			System.out.println("\nOs dados estão corretos: (S/N)");
			String sn = leia.next();

			if (sn.equalsIgnoreCase("S")) {
				Conta novaConta = new Conta(novoNome, novaAgencia, numeroConta, novoSaldo, novoTipo);

				contas.add(novaConta);

				System.out.println("Conta criada com sucesso!!\n");
				confirma = true;
			}
		}
		voltarMenu();

	}

	public static void listarcontas() {

		if (contas.isEmpty()) {
			System.out.println("\nNão existem contas");
		} else {
			for (var c : contas) {
				System.out.println("\n" + c.getNome());

			}
		}

	}

	public static void consultarconta() {
		listarcontas();

		System.out.println("Digite o nome da Conta que deseja consultar: ");
		String nomeC = leia.next();

		boolean contaEncontrada = false;

		for (Conta c : contas) {
			if (c.getNome().equalsIgnoreCase(nomeC)) {
				System.out.println("\n=== CONTA ENCONTRADA ===");
				System.out.println("Nome: " + c.getNome());
				System.out.println("Agência: " + c.getAgencia());
				System.out.println("Número: " + c.getNumeroConta());
				System.out.println("Saldo: " + c.getSaldo());
				contaEncontrada = true;
			}
			if (!contaEncontrada) {
				System.out.println("Conta não encontrada!");
			}

		}

	}

	public static void atualizarconta() {
		listarcontas();

		System.out.println("Digite o nome da Conta que deseja atualizarr: ");
		String nomeC = leia.next();

		boolean contaEncontrada = false;

		for (Conta c : contas) {
			if (c.getNome().equalsIgnoreCase(nomeC)) {
				System.out.println("Nome: " + c.getNome());
				System.out.println("Agência: " + c.getAgencia());
				System.out.println("Número: " + c.getNumeroConta());
				System.out.println("Saldo: " + c.getSaldo());

				boolean confirmaDados = false;
				while (!confirmaDados) {
					System.out.println("Digite o novo nome: ");
					String novoNome = leia.next();

					System.out.println("Digite a nova agencia: ");
					int novaAgencia = leia.nextInt();

					System.out.println("Digite o novo numero da conta: ");
					int novaConta = leia.nextInt();

					System.out.println("Confirme os dados");
					System.out.println("novo nome: " + novoNome);
					System.out.println("nova agencia: " + novaAgencia);
					System.out.println("novo numero da conta: " + novaConta);
					System.out.println("Os novo dados estão certos? (S/N)");
					String sn = leia.next();

					if (sn.equalsIgnoreCase("S")) {
						c.setNome(novoNome);
						c.setAgencia(novaAgencia);
						c.setNumeroConta(novaConta);
						System.out.println("Conta Atualizada");
						confirmaDados = true;

					}

				}

				contaEncontrada = true;
			}
			if (!contaEncontrada) {
				System.out.println("Conta não encontrada!");
			}

		}

	}

	public static void voltarMenu() {
		boolean voltarMenu = false;
		while (!voltarMenu) {
			System.out.println("Deseja voltar ao menu? (S/N)");
			String sn = leia.next();

			if (sn.equalsIgnoreCase("S")) {
				voltarMenu = true;
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
