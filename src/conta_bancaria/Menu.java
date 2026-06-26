package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();
	

	public static void main(String[] args) {

		int opcao;
		criarContasTeste();

		while (true) {

			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);

			System.out.println("╔══════════════════════════════════════════════════════╗");
			System.out.println("║                                                      ║");
			System.out.println("║            💰 BANCO LAVAGEM DE DINHEIRO 💰           ║");
			System.out.println("║                                                      ║");
			System.out.println("╠══════════════════════════════════════════════════════╣");
			System.out.println("║  1  - Criar Conta                                    ║");
			System.out.println("║  2  - Listar todas as Contas                         ║");
			System.out.println("║  3  - Buscar Conta por Número                        ║");
			System.out.println("║  4  - Atualizar Dados da Conta                       ║");
			System.out.println("║  5  - Apagar Conta                                   ║");
			System.out.println("║  6  - Sacar                                          ║");
			System.out.println("║  7  - Depositar                                      ║");
			System.out.println("║  8  - Transferir entre Contas                        ║");
			System.out.println("║  9  - Consultar por Nome do Titular                  ║");
			System.out.println("║  0  - Sair                                           ║");
			System.out.println("╠══════════════════════════════════════════════════════╣");
			System.out.println("║ Digite a opção desejada:                             ║");
			System.out.println("╚══════════════════════════════════════════════════════╝");

			
			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("Digite um número inteiro entre 0 e 8");
				leia.nextLine();
			}
			if (opcao == 0) {
				System.out.println("\nBanco Lavagem de Dinheiro - O seu Dinheiro está seguro!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");
				cadastrarConta();
				keyPress();
				break;

			case 2:
				System.out.println("Listar todas as Contas\n\n");
				listarContas();
				keyPress();
				break;

			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");
				procurarContaPorNumero();
				keyPress();
				break;

			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				atualizarConta();
				keyPress();
				break;

			case 5:
				System.out.println("Apagar a Conta\n\n");
				deletarConta();
				keyPress();
				break;

			case 6:
				System.out.println("Saque\n\n");
				sacar();
				keyPress();
				break;

			case 7:
				System.out.println("Depósito\n\n");
				depositar();
				keyPress();
				break;

			case 8:
				System.out.println("Transferência entre Contas\n\n");
				transferir();
				keyPress();
				break;
			case 9:
				System.out.println("Consultar por nome do titular\n\n");
				buscarPorNome();
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
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

	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}

	public static void criarContasTeste() {
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(
				new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));

	}

	public static void cadastrarConta() {
		System.out.println("Digite o numero da Agencia: ");
		int agencia = leia.nextInt();

		System.out.println("Digite o nome do Titular da conta: ");
		leia.skip("\\R");
		String titular = leia.nextLine();

		System.out.println("Digite o tipo da Conta (1-CC | 2-CP: ");
		int tipo = leia.nextInt();

		System.out.println("Digite o saldo da conta: ");
		float saldo = leia.nextFloat();

		switch (tipo) {
		case 1 -> {
			System.out.println("Digite o limite da conta: ");
			float limite = leia.nextFloat();
			leia.nextLine();
			contaController
					.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.println("Digite o dia do aniversario da conta: ");
			int aniversario = leia.nextInt();
			leia.nextLine();
			contaController.cadastrar(
					new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de Conta Invalido!" + Cores.TEXT_RESET);
		}
	}

	public static void procurarContaPorNumero() {

		System.out.println("Digite o numero da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		contaController.procurarPorNumero(numero);
	}

	public static void deletarConta() {

		System.out.println("Digite o numero da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Optional<Conta> conta = contaController.buscarNaCollection(numero);

		if (conta.isPresent()) {
			// Confirmação da exclusão
			System.out.printf("\n Tem certeza que você deseja excluir a conta numero %d? (S/n)", numero);
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S"))
				contaController.deletar(numero);
			else
				System.out.println("operação cancelada");

		} else {
			System.out.printf("\n A conta número %d não foi encontrada!", numero);
		}
	}

	public static void atualizarConta() {

		System.out.println("Digite o numero da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Optional<Conta> conta = contaController.buscarNaCollection(numero);

		if (conta.isPresent()) {

			int agencia = conta.get().getAgencia();
			String titular = conta.get().getTitular();
			int tipo = conta.get().getTipo();
			float saldo = conta.get().getSaldo();

			System.out.printf(
					"Agencia atual: %d%nDigite o numero da nova agencia (Pressione ENTER para manter o valor atual)",
					agencia);
			String entrada = leia.nextLine();

			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);

			System.out.printf(
					"Titular atual: %s" + "%nDigite o nome do novo titular (Pressione ENTER para manter o valor atual)",
					titular);
			entrada = leia.nextLine();

			titular = entrada.isEmpty() ? titular : entrada;

			System.out.printf("Saldo atual: %.2f" + "%nDigite o novo saldo (Pressione ENTER para manter o valor atual)",
					saldo);
			entrada = leia.nextLine();

			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada.replace(",", "."));

			switch (tipo) {
			case 1 -> {
				ContaCorrente contaCorrente = (ContaCorrente) conta.get();
				float limite = contaCorrente.getLimite();

				System.out.println(
						"Limite atual: %.2f" + "%nDigite o novo limite (Pressione ENTER para manter o valor atual)");
				entrada = leia.nextLine();

				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada.replace(",", "."));

				contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
			}
			case 2 -> {
				ContaPoupanca contaPoupanca = (ContaPoupanca) conta.get();
				int aniversario = contaPoupanca.getAniversario();

				System.out.printf(
						"Dia do aniversario atual: %d"
								+ "%nDigite o novo dia do aniversario (Pressione ENTER para manter o valor atual)",
						aniversario);
				entrada = leia.nextLine();

				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada.replace(",", "."));

				contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, aniversario));

			}
			default -> {
				System.out.println(Cores.TEXT_RED + "Tipo da conta e invalido" + Cores.TEXT_RESET);
			}
			}
		} else {
			System.out.printf("\n A conta de numero %d não foi encontrada", numero);
		}

	}

	public static void sacar() {
		System.out.println("Digite o numero da conta: ");
		int numero = leia.nextInt();
		System.out.println("Digite o valor do saque: ");
		float valor = leia.nextFloat();
		
		contaController.sacar(numero, valor);

	}

	public static void depositar() {
		System.out.println("Digite o numero da conta: ");
		int numero = leia.nextInt();
		System.out.println("Digite o valor do deposito: ");
		float valor = leia.nextFloat();

		contaController.depositar(numero, valor);

	}

	public static void transferir() {
		System.out.println("Digite o numero da conta de origin: ");
		int numeroOrigin = leia.nextInt();
		System.out.println("Digite o numero da conta de destino: ");
		int numeroDestino = leia.nextInt();
		System.out.println("Digite o valor da transferencia: ");
		float valor = leia.nextFloat();

		contaController.transferir(numeroOrigin, numeroDestino, valor);

	}


	public static void buscarPorNome() {
		System.out.println("Digite o nome do titular: ");
		String nome = leia.next();

		contaController.listarPorTituar(nome);
	}
	
	public static void listarContas() {
		contaController.listarTodas();
	}
}