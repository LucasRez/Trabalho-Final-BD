package br.unb.cic.DiariasEPassagens.ui;

import java.util.List;
import java.util.Scanner;

import br.unb.cic.DiariasEPassagens.cadastro.Cadastro;
import br.unb.cic.DiariasEPassagens.entidades.AlbumMusical;
import br.unb.cic.DiariasEPassagens.entidades.Autor;
import br.unb.cic.DiariasEPassagens.negocio.Avaliacao;
import br.unb.cic.DiariasEPassagens.negocio.FaixaMusical;
import br.unb.cic.DiariasEPassagens.negocio.Filme;
import br.unb.cic.DiariasEPassagens.negocio.IMDBFacade;
import br.unb.cic.DiariasEPassagens.util.ContextoID;

public abstract class TelasDeInteracao {
	
	static void telaInicial(){
		int Resposta;
		boolean flag = true;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("___________________SEJA BEM-VINDO AO PROGRAMA IMDB_____________________");
		System.out.println("_______________Voc� possui cadastro em nosso programa?_________________");
		System.out.println("____Digite o n�mero correspondente � sua resposta e pressione Enter____");
		System.out.println("_______________________________________________________________________");
		System.out.println("______________________________1.SIM____________________________________");
		System.out.println("______________________________2.N�O____________________________________");		
		System.out.println("_______________________________________________________________________");
		
		Resposta = input.nextInt();
		
		do
		{
			if(Resposta == 1){
				telaDeLogin();
				flag = false;
			}else if(Resposta == 2){
				telaDesejaCadastro();
				flag = false;
			}else{
				System.out.println("_________________________Entrada Inv�lida______________________________");
				System.out.println("_______________________________________________________________________");
				System.out.println("_Por favor,digite o n�mero 1 se voc� tiver cadastro e 2 caso n�o tenha_");
				Resposta = input.nextInt();
				flag = true;
			}
		} while(flag == true);
	}
		
	//TO-DO Colocar as respostas  1 e 2
	static void telaDesejaCadastro(){
		int Resposta;
		boolean flag = true;
		
		Scanner input = new Scanner(System.in);
		System.out.println("_______________________________________________________________________");
		System.out.println("_______________________Deseja Cadastrar-se?____________________________");
		System.out.println("______________________________1.SIM____________________________________");
		System.out.println("_____________________2.N�O(Sair do Programa)___________________________");		
		System.out.println("_______________________________________________________________________");
		Resposta = input.nextInt();
		
		do
		{
			if(Resposta == 1){
				flag = false;
				telaCadastro();
			}else if(Resposta == 2){
				flag = false;
			}else{
				System.out.println("_______________________________________________________________________");
				System.out.println("_______________________________________________________________________");
				System.out.println("_________________________Entrada Inv�lida______________________________");
				System.out.println("_______________________________________________________________________");
				System.out.println("__Por favor,digite o n�mero 1 caso queira se cadastrar e 2 para sair___");
				Resposta = input.nextInt();
				flag = true;
			}
		} while(flag == true);	
	}
	//TO-DO Colocar cadastro
	static void telaCadastro(){
		String nomeCompleto;
		String dataDeNascimento;
		String login;
		String senhaDeAcesso;
		Scanner input = new Scanner(System.in);
		
		System.out.println("_______________________________________________________________________");
		System.out.println("_____________________Digite seu Nome Completo__________________________");
		nomeCompleto = input.nextLine();
		System.out.println("_______________________________________________________________________");
		System.out.println("__________________Digite sua Data de Nascimento________________________");
		dataDeNascimento = input.nextLine();
		System.out.println("_______________________________________________________________________");
		System.out.println("____Digite o login que deseja utilizar para acessar nosso programa_____");
		login = input.nextLine();
		System.out.println("_______________________________________________________________________");
		System.out.println("____Digite a senha que deseja utilizar para acessar nosso programa_____");
		senhaDeAcesso = input.nextLine();
		
		Cadastro cadastro = new Cadastro(nomeCompleto,dataDeNascimento,login,senhaDeAcesso);
		//TO-DO VALIDA��O
	}
	
	static void telaDeLogin(){
		String login;
		String senhaDeAcesso;
		Boolean Confirmacao = false;
		Scanner input = new Scanner(System.in);
		
		System.out.println("_______________________________________________________________________");
		System.out.println("_________________________Digite o seu usu�rio__________________________");
		login = input.nextLine();
		
		System.out.println("_______________________________________________________________________");
		System.out.println("__________________________Digite a sua senha___________________________");
		
		
		senhaDeAcesso = input.nextLine();
		
		ConfirmacaoLogin testeAutenticidade = new ConfirmacaoLogin();
		do{
			Confirmacao = testeAutenticidade.verificaLoginSenha(login,senhaDeAcesso);
			if(Confirmacao == false){
				System.out.println("_______________________________________________________________________");
				System.out.println("_______________________________________________________________________");
				System.out.println("_______________________________________________________________________");
				System.out.println("____________________Senha e Usu�rios incorretos________________________");
				System.out.println("__________________Digite o seu usu�rio novamente_______________________");
				login = input.nextLine();
				
				System.out.println("_______________________________________________________________________");
				System.out.println("___________________Digite a sua senha novamente________________________");
				senhaDeAcesso = input.nextLine();
			}else if(Confirmacao == true){
				telaPosLogin(login);
				Confirmacao = true;
			}
		}while(Confirmacao ==  false);
				
	}
	
	static void telaPosLogin(String login){
		int opcao;
		boolean flag = false;
		
		Scanner input = new Scanner(System.in);
		IMDBFacade facade = ContextoID.instance().facade();
		do{
			System.out.println("_______________________________________________________________________");
			System.out.println("_______________________________________________________________________");
			System.out.printf("@@@@@@@@@@@@@@@@@@Voc� est� conectado como %s @@@@@@@@@@@@@@@@@\n",login);
			System.out.println("_______________________________________________________________________");
			System.out.println("__________________________O que deseja fazer___________________________");
			System.out.println("_______________________________________________________________________");
			System.out.println("________________________1.Procurar um Filme____________________________");
			System.out.println("____________________2.Procurar um Album Musical________________________");
			System.out.println("______________________3.Procurar por um autor__________________________");
			System.out.println("_______________________________________________________________________");
			opcao = input.nextInt();
			input.nextLine();
		
			switch(opcao){
				case 1:
					telaProcurarFilme(login);
					flag = true;
					break;
				case 2:
					telaProcurarAlbumMusical(login);
					flag = true;
					break;
				case 3:
					String autor;
					System.out.println("_______________________________________________________________________");
					System.out.println("_____________________Digite o autor que voc� deseja____________________");
					System.out.println("_______________________________________________________________________");
					autor = input.nextLine();
					if(facade.recuperarAutorPorNome(autor)!=null){
						
						telaOperacaoAutor(facade.recuperarAutorPorNome(autor),login);
						flag = true;
					}else{
						System.out.println("_______________________________________________________________________");
						System.out.println("____________Autor n�o encontrado em nosso banco de dados_______________");
						System.out.println("__Tente realizar outra opera��o ou procurar por um autor diferente )___");
						System.out.println("_______________________________________________________________________");
						flag = false;
					}
				default:
					flag = false;
			}	
		}while(flag == false);
	}
	
	static void telaProcurarFilme(String login){
		int opcao;
		boolean flag = false;
		Filme filme;
		String nomeDoFilme;
		
		Scanner input = new Scanner(System.in);
		IMDBFacade facade = ContextoID.instance().facade();
		
		do{
			System.out.println("_______________________________________________________________________");
			System.out.println("_______________________________________________________________________");
			System.out.printf("@@@@@@@@@@@@@@@@@@Voc� est� conectado como %s @@@@@@@@@@@@@@@@@@@\n",login);
			System.out.println("_______________________________________________________________________");
			System.out.println("__________________________O que deseja fazer___________________________");
			System.out.println("_______________________________________________________________________");
			System.out.println("__________________1.Procurar um Filme pelo nome________________________");
			System.out.println("______________2.Procurar uma lista de filmes por g�nero________________");
			System.out.println("______________3.Procurar uma lista de filmes por autor_________________");
			System.out.println("_______________________________________________________________________");
			opcao = input.nextInt();
			input.nextLine();
			
			switch(opcao){
			case 1: //Done
				System.out.println("_______________________________________________________________________");
				System.out.println("____________Digite o nome do filme que voc� deseja procurar____________");
				System.out.println("_______________________________________________________________________");
				nomeDoFilme = input.nextLine();
				
				if(facade.recuperarFilmePorTitulo(nomeDoFilme)!= null){
					flag = true;
					telaOperacaoFilme(facade.recuperarFilmePorTitulo(nomeDoFilme),login);					
				}else{
				System.out.println("_______________________________________________________________________");
				System.out.println("___________Filme n�o encontrado em nosso banco de dados________________");
				System.out.println("___Tente realizar outra opera��o ou procurar por um nome diferente ____");
				System.out.println("_______________________________________________________________________");
				flag = false;
				}
				break;
			case 2:
				String genero;
				System.out.println("_______________________________________________________________________");
				System.out.println("____________________Digite o g�nero que voc� deseja____________________");
				System.out.println("_______________________________________________________________________");
				genero = input.nextLine();
				if(facade.recuperarPorTitulo(genero)!=null){
					flag = true;
					List<Filme> listaDeFilmes = facade.recuperarFilmePorGenero(genero);
					
					System.out.println("Os filmes com esse g�nero s�o os seguintes:\n");
					for(Filme object : listaDeFilmes){
						System.out.println("T�tulo: " + object.getTitulo());
					}
					telaPosLogin(login);
				}else{
					System.out.println("_______________________________________________________________________");
					System.out.println("___________G�nero n�o encontrado em nosso banco de dados_______________");
					System.out.println("__Tente realizar outra opera��o ou procurar por um g�nero diferente ___");
					System.out.println("_______________________________________________________________________");
					flag = false;
				}
				break;
			case 3:
				String autor;
				System.out.println("_______________________________________________________________________");
				System.out.println("_____________________Digite o autor que voc� deseja____________________");
				System.out.println("_______________________________________________________________________");
				autor = input.nextLine();
				if(facade.recuperarAutorPorNome(autor)!=null){
					flag = true;
					List<Filme> listaDeFilmes = facade.recuperarFilmePorAutor(autor);
					System.out.println("Esse autor j� produziu os seguintes filmes:");
					for(Filme object : listaDeFilmes){
						System.out.println("T�tulo: " + object.getTitulo());
					}
					telaPosLogin(login);
					
				}else{
					System.out.println("_______________________________________________________________________");
					System.out.println("____________Autor n�o encontrado em nosso banco de dados_______________");
					System.out.println("__Tente realizar outra opera��o ou procurar por um autor diferente )___");
					System.out.println("_______________________________________________________________________");
					flag = false;
				}
				break;
			default:
				flag = false;
			}	
		}while(flag == false);
	}
	
	//TO-DO ADICIONAR AVALIA��O E OP��O COMENTARIOS
	static void telaOperacaoFilme(Filme filme,String login){
		int opcao;
		boolean flag = false;
		
		Scanner input = new Scanner(System.in);
		IMDBFacade facade = ContextoID.instance().facade();
		do{
			System.out.println("_______________________________________________________________________");
			System.out.printf("@@@@@@@@@@@@@@@@@@Voc� est� conectado como %s @@@@@@@@@@@@@@@@@@@\n",login);
			System.out.println("_______________________________________________________________________");
			System.out.println("_______________________________________________________________________");
			System.out.printf("Voc� selecionou o filme %s \n",filme.getTitulo());
			System.out.printf("O filme � do ano %d \n",filme.getAno());
			System.out.printf("O nome do autor respons�vel pelo filme � %s \n",filme.getAutor().getNome());
			System.out.printf("A dura��o do filme � %d minutos  \n",filme.getDuracao());
			System.out.println("_______________________________________________________________________");
			System.out.println("__________________________O que deseja fazer___________________________");
			System.out.println("_______________________________________________________________________");
			System.out.println("__________________________1.Avaliar o filme____________________________");
			System.out.println("______________________2.Ver coment�rios do filme________________________");
			System.out.println("________________________3.Voltar � tela inicial________________________");
			System.out.println("___________________________4.Sair do programa__________________________");
			System.out.println("_______________________________________________________________________");
			System.out.println("_______________________________________________________________________");
			opcao = input.nextInt();
			input.nextLine();
		
			switch(opcao){
				case 1: 
					String comentario;
					int nota;
					Boolean flag1 = false;
					do{
						System.out.println("_______________________________________________________________________");
						System.out.println("___________Digite a sua nota de 1 a 5(n�meros inteiros)________________");
						System.out.println("_______________________________________________________________________");
						nota = input.nextInt();
						input.nextLine();
						if(nota!= 1 && nota!= 2 && nota!=3 && nota!=4&& nota!=5){
							flag1 = false;
							System.out.println("_________________Valor inv�lido! Tente novamente_______________________");
						}else{
							flag1 = true;
						}
					}while(flag1 == false);
					
						System.out.println("_______________________________________________________________________");
						System.out.println("_____________Digite um coment�rio a respeito do filme)_________________");
						System.out.println("_______________________________________________________________________");
						comentario = input.nextLine();
						
						Avaliacao avaliacao = new Avaliacao(nota,comentario);
						avaliacao.setFilme(filme);
						avaliacao.setUsuario(facade.recuperarUsuarioPorLogin(login));
						
						facade.adicionaAvaliacao(avaliacao);
						
						telaPosLogin(login);
					flag = true;
					break;
				case 2:
					List<Avaliacao> avaliacoes = facade.recuperarAvaliacoesPorFilme(filme.getTitulo());
					System.out.println("As avalia��es desse filme s�o as seguintes:");
					for(Avaliacao comentarios : avaliacoes){
						System.out.println("-" + comentarios.getComentario());
					}
					telaOperacaoFilme(filme,login);
					flag = true;
					break;
				case 3:
					telaPosLogin(login);
					flag = true;
					break;
				case 4:
					flag = true;
					break;
				default:
					flag = false;
			}	
		}while(flag == false);
	}
	
	static void telaProcurarAlbumMusical(String login){
		int opcao;
		boolean flag = false;
		AlbumMusical album;
		String nomeDoAlbum;
		
		Scanner input = new Scanner(System.in);
		IMDBFacade facade = ContextoID.instance().facade();
		
		do{
			System.out.println("_______________________________________________________________________");
			System.out.println("_______________________________________________________________________");
			System.out.printf("@@@@@@@@@@@@@@@@@@Voc� est� conectado como %s @@@@@@@@@@@@@@@@@@@\n",login);
			System.out.println("_______________________________________________________________________");
			System.out.println("__________________________O que deseja fazer___________________________");
			System.out.println("_______________________________________________________________________");
			System.out.println("________________1.Procurar um Album Musical pelo nome__________________");
			System.out.println("_________2.Procurar uma lista de albuns musicais por g�nero____________");
			System.out.println("_________3.Procurar uma lista de albuns musicais por autor_____________");
			System.out.println("_______________________________________________________________________");
			opcao = input.nextInt();
			input.nextLine();
			
			switch(opcao){
			case 1: //Done
				System.out.println("_______________________________________________________________________");
				System.out.println("________Digite o nome do Album Musical que voc� deseja procurar________");
				System.out.println("_______________________________________________________________________");
				nomeDoAlbum = input.nextLine();
				
				if(facade.recuperarAlbumMusicalPorTitulo(nomeDoAlbum)!= null){
					flag = true;
					telaOperacaoAlbum(facade.recuperarAlbumMusicalPorTitulo(nomeDoAlbum),login);					
				}else{
				System.out.println("_______________________________________________________________________");
				System.out.println("_________Album Musical n�o encontrado em nosso banco de dados__________");
				System.out.println("___Tente realizar outra opera��o ou procurar por um nome diferente ____");
				System.out.println("_______________________________________________________________________");
				flag = false;
				}
				break;
			case 2:
				String genero;
				System.out.println("_______________________________________________________________________");
				System.out.println("____________________Digite o g�nero que voc� deseja____________________");
				System.out.println("_______________________________________________________________________");
				genero = input.nextLine();
				if(facade.recuperarPorTitulo(genero)!=null){
					flag = true;
					List<AlbumMusical> listaDeAlbuns = facade.recuperarAlbunsMusicalPorGenero(genero);
					System.out.println("Albuns Musicais com o G�nero desejado:\n");
					for(AlbumMusical albuns : listaDeAlbuns){
						System.out.println("T�tulo: " + albuns.getTitulo());
					}
					telaPosLogin(login);
					
				}else{
					System.out.println("_______________________________________________________________________");
					System.out.println("___________G�nero n�o encontrado em nosso banco de dados_______________");
					System.out.println("__Tente realizar outra opera��o ou procurar por um g�nero diferente ___");
					System.out.println("_______________________________________________________________________");
					flag = false;
				}
				break;
			case 3:
				String autor;
				System.out.println("_______________________________________________________________________");
				System.out.println("_____________________Digite o autor que voc� deseja____________________");
				System.out.println("_______________________________________________________________________");
				autor = input.nextLine();
				if(facade.recuperarAutorPorNome(autor)!=null){
					List<AlbumMusical> listaDeAlbuns = facade.recuperarAlbunsMusicalPorGenero(autor);
					
					System.out.printf("Albuns musicais com o autor %s: \n", autor);
					for(AlbumMusical albuns : listaDeAlbuns){
						System.out.println("T�tulo: " + albuns.getTitulo());
					}
					
					flag = true;
					telaPosLogin(login);
				}else{
					System.out.println("_______________________________________________________________________");
					System.out.println("____________Autor n�o encontrado em nosso banco de dados_______________");
					System.out.println("__Tente realizar outra opera��o ou procurar por um autor diferente )___");
					System.out.println("_______________________________________________________________________");
					flag = false;
				}
				break;
			default:
				flag = false;
			}	
		}while(flag == false);
	}
	
	static void telaOperacaoAlbum(AlbumMusical album,String login){
		int opcao;
		boolean flag = false;
		float media =0;
		
		Scanner input = new Scanner(System.in);
		IMDBFacade facade = ContextoID.instance().facade();
		
		List<FaixaMusical> listaDeFaixas = album.getAlbumMusical();
		
		do{
			System.out.println("_______________________________________________________________________");
			System.out.printf("@@@@@@@@@@@@@@@@@@Voc� est� conectado como %s @@@@@@@@@@@@@@@@@@@\n",login);
			System.out.println("_______________________________________________________________________");
			System.out.println("_______________________________________________________________________");
			System.out.printf("Voc� selecionou o album musical %s \n",album.getTitulo());
			System.out.printf("O album musical � do ano %d \n",album.getAno());
			System.out.printf("O nome do autor respons�vel pelo album musical � %s \n",album.getAutor().getNome());
			System.out.printf("A lista de m�sicas presentes no album s�o:\n");
			for(FaixaMusical faixa : listaDeFaixas){
				System.out.println("T�tulo: " + faixa.getTitulo());
			}
			System.out.printf("A avalia��o do album �:");
			List<Avaliacao> notas = facade.recuperarAvaliacoesPorAlbum(album.getTitulo());
			
			for(Avaliacao avaliacoezinhas : notas){
				media += avaliacoezinhas.getAvaliacao();
			}
			media = media/notas.size();
			System.out.printf("%f estrelas \n",media);
			System.out.println("_______________________________________________________________________");
			System.out.println("__________________________O que deseja fazer___________________________");
			System.out.println("_______________________________________________________________________");
			System.out.println("______________________1.Avaliar o album musical________________________");
			System.out.println("__________________2.Ver coment�rios do album musical___________________");
			System.out.println("________________________3.Voltar � tela inicial________________________");
			System.out.println("___________________________4.Sair do programa__________________________");
			System.out.println("_______________________________________________________________________");
			System.out.println("_______________________________________________________________________");
			opcao = input.nextInt();
			input.nextLine();
		
			switch(opcao){
				case 1: 
					String comentario;
					int nota;
					Boolean flag1 = false;
					do{
						System.out.println("_______________________________________________________________________");
						System.out.println("___________Digite a sua nota de 1 a 5(n�meros inteiros)________________");
						System.out.println("_______________________________________________________________________");
						nota = input.nextInt();
						input.nextLine();
						if(nota!= 1 && nota!= 2 && nota!=3 && nota!=4 && nota!=5){
							flag1 = false;
							System.out.println("_________________Valor inv�lido! Tente novamente_______________________");
						}else{
							flag1 = true;
						}
					}while(flag1 == false);
					
						System.out.println("_______________________________________________________________________");
						System.out.println("________Digite um coment�rio a respeito do album musical)______________");
						System.out.println("_______________________________________________________________________");
						comentario = input.nextLine();

						Avaliacao avaliacao = new Avaliacao(nota,comentario);
						avaliacao.setAlbum(album);
						avaliacao.setUsuario(facade.recuperarUsuarioPorLogin(login));
						
						facade.adicionaAvaliacao(avaliacao);
						
						telaPosLogin(login);
						flag = true;
					break;
				case 2:
					List<Avaliacao> avaliacoes = facade.recuperarAvaliacoesPorAlbum(album.getTitulo());
					System.out.println("As avalia��es desse album s�o as seguintes:");
					for(Avaliacao comentarios : avaliacoes){
						System.out.println("-" + comentarios.getComentario());
					}
					
					telaOperacaoAlbum(album,login);
					flag = true;
					break;
				case 3:
					telaPosLogin(login);
					flag = true;
					break;
				case 4:
					flag = true;
					break;
				default:
					flag = false;
			}	
		}while(flag == false);
		
	}
	
	static void telaOperacaoAutor(Autor autor,String login){
		Scanner input = new Scanner(System.in);
		IMDBFacade facade = ContextoID.instance().facade();
		
		List<Filme> listaDeFilmes = facade.recuperarFilmePorAutor(autor.getNome());
		List<AlbumMusical> listaDeAlbuns = facade.recuperarAlbunsMusicalPorAutor(autor.getNome());
		
		System.out.println(listaDeFilmes.size());
		System.out.println("_______________________________________________________________________");
		System.out.printf("@@@@@@@@@@@@@@@@@@Voc� est� conectado como %s @@@@@@@@@@@@@@@@@@@\n",login);
		System.out.println("_______________________________________________________________________");
		System.out.println("_______________________________________________________________________");
		System.out.printf("Voc� selecionou o autor %s \n",autor.getNome());
		System.out.printf("Esse autor %s \n",autor.getDescricao());
		System.out.println("Esse autor j� produziu os seguintes filmes:");
		for(Filme filme : listaDeFilmes){
			System.out.println("T�tulo: " + filme.getTitulo());
		}
		System.out.println("Esse autor j� produziu os seguintes albums musicais:\n");
		for(AlbumMusical album : listaDeAlbuns){
			System.out.println("T�tulo: " +  album.getTitulo());
		}
		telaPosLogin(login);
				
	}
}


