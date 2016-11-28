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
			
			switch(opcao){
				case 1: 
					//FACADE
					//System.out.println("O servidor que gastou mais foi: " + favorecido.getNome());
				break;
				case 2: break;
				case 3: break;
				case 4: break;
				case 5: break;
				case 6: break;
				case 7: break;
				case 8: break;
				case 9: break;
				case 10: break;
				case 11: break;
				case 12: System.out.println("Saindo do programa"); break;
				default: System.out.println("Opcao invalida!"); break;
			}
		
		}while(opcao != 12);
		
	}

}
