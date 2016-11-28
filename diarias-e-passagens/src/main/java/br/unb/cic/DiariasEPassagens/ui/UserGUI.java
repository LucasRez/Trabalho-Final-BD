package br.unb.cic.DiariasEPassagens.ui;

import java.util.Scanner;

public class UserGUI {

	private Scanner scanner;

	public void interfaceUsuario(){

		int opcao = 0;
		String nomeServidor, servidorCPF, nomeAcao, codPagamento;
		//Facade cria facade


		do{
			System.out.println("------DIARIAS E PASSSAGENS------");
			System.out.println("Opcoes de queries:");
			System.out.println();
			System.out.println("1. Qual servidor gastou mais.");
			System.out.println("2. A lista decrescente dos gastos totais de cada servidor.");
			System.out.println("3. A lista crescente de gastos totais de cada servidor.");
			System.out.println("4. Qual orgao superior que mais gastou recursos e quanto foi.");
			System.out.println("5. Qual programa gastou mais.");
			System.out.println("6. Qual acao gastou mais.");
			System.out.println("7. Gasto total dos 6 meses.");
			System.out.println("8. Retornar gastos dos servidores pelo nome.");
			System.out.println("9. Retornar gastos dos servidores pelo CPF.");
			System.out.println("10. Qual programa da acao gastou mais.");
			System.out.println("11. Dado o codigo de pagamento, qual teve o maior gasto.");
			System.out.println("12. Sair");
			System.out.println();
			System.out.print("Digite a opcao escolhida: ");
			scanner = new Scanner(System.in);

			opcao = scanner.nextInt();
			scanner.nextLine();

			switch(opcao){
			case 1: 
				//FACADE
				//System.out.println("O servidor que gastou mais foi: " + favorecido.getNome());
				System.out.println("Aperte Enter para continuar.");
				scanner.nextLine();
				break;
			case 2: 
				//facade
				//List<Favorecido> listaFavorecidos = facade.;
				//for(Favorecido object : listaFavorecidos){
				//System.out.println("Nome do Servidor: " + object.getNome() + "Gastos do servidor: " + object)
				//}
				System.out.println("Aperte Enter para continuar.");
				scanner.nextLine();
				break;
			case 3: 
				System.out.println("Aperte Enter para continuar.");
				scanner.nextLine();
				break;
			case 4: 
				//facade
				//System.out.println("O orgao superior que mais gastou foi: " + orgaoSuperior.getNome());
				System.out.println("Aperte Enter para continuar.");
				scanner.nextLine();
				break;
			case 5: 
				//facade
				//System.out.println("O programa que mais gastou foi: " + programa.getNome());
				System.out.println("Aperte Enter para continuar.");
				scanner.nextLine();
				break;
			case 6: 
				//facade
				//System.out.println("A acao que mais gastou foi: " + acao.getNome());
				System.out.println("Aperte Enter para continuar.");
				scanner.nextLine();
				break;
			case 7: 
				//facade
				//System.out.println("O gasto total de Janeiro a Junha do ano de 2013 foi: " + pagamento.getValor());
				System.out.println("Aperte Enter para continuar.");
				scanner.nextLine();
				break;
			case 8: 
				System.out.println("Digite o nome do servidor: ");
				nomeServidor = scanner.nextLine();
				//facade
				//if(/*facade.*//**/ != NULL){
				//	System.out.println("Servidor: " + favorecido.getNome() + "Gastos do servidor: " + favorecido.getValorTotal());
				//}else{
				//	System.out.println("Servidor nao encontrado no Banco de Dados!");
				//}
				System.out.println("Aperte Enter para continuar.");
				scanner.nextLine();
				break;
			case 9: 
				System.out.println("Digite o CPF do servidor: ");
				servidorCPF = scanner.nextLine();
				//facade
				//if(/*facade.*//**/ != NULL){
				//	System.out.println("Servidor: " + favorecido.getCpf() + "Gastos do servidor: " + favorecido.getValorTotal());
				//}else{
				//	System.out.println("Servidor nao encontrado no Banco de Dados!");
				//}
				System.out.println("Aperte Enter para continuar.");
				scanner.nextLine();
				break;
			case 10: 
				System.out.println("Digite a acao que deseja procurar: ");
				nomeAcao = scanner.nextLine();
				//facade
				//if(/*facade.*//**/ != NULL){
				//	System.out.println("Programa: " + programa.getNome() + "Gastos do programa: " + programa.getValorTotal());
				//}else{
				//	System.out.println("Acao nao encontrado no Banco de Dados!");
				//}
				System.out.println("Aperte Enter para continuar.");
				scanner.nextLine();
				break;
			case 11: 
				System.out.println("Digite o codigo de pagamento que deseja procurar: ");
				codPagamento = scanner.nextLine();
				//facade
				//if(/*facade.*//**/ != NULL){
				//	System.out.println("Codigo do Pagamento: " + Pagamento.getCodigo() + "Gastos atrelados ao codigo: " + pagamento.getValor());
				//}else{
				//	System.out.println("Codigo de pagamento nao encontrado no Banco de Dados!");
				//}
				System.out.println("Aperte Enter para continuar.");
				scanner.nextLine();
				break;
			case 12: System.out.println("Saindo do programa"); break;
			default: System.out.println("Opcao invalida!");
			System.out.println("Aperte Enter para continuar.");
			scanner.nextLine();
			break;
			}

		}while(opcao != 12);

	}

}
