package br.unb.cic.imdb.negocio;



import br.unb.cic.imdb.util.ContextoID;

import junit.framework.TestCase;



public class IMDBPopulandoBDTeste extends TestCase {



	public void testePopulaBD() {

		try {

			IMDBFacade facade = ContextoID.instance().facade();

		

			Genero novoGenero1 = new Genero("Rock", "|m|");

			Genero novoGenero2 = new Genero("Punk", "|m|");

			Genero novoGenero3 = new Genero("Grunge", "|m|");

			Genero novoGenero4 = new Genero("Metal", "Rock mais pesado");

			Genero novoGenero5 = new Genero("MPB", "Musica Popular Brasileira");

			Genero novoGenero6 = new Genero("Jazz", "Manifestação musical originaria de Nova Orleans EUA");

			Genero novoGenero7 = new Genero("Blues", "Forma musical marcada");

			Genero novoGenero8 = new Genero("Soul", "Genero musical que nasceu do blues e do rythm");

			Genero novoGenero9 = new Genero("Acao", "Adrenalina do começo ao fim!");

			Genero novoGenero10 = new Genero("Aventura", "Historias de tirar o folego!");

			Genero novoGenero11 = new Genero("Terror", "Voce vai se assustar");

			Genero novoGenero12 = new Genero("Comedia", "Boas risadas garantidas!");

			Genero novoGenero13 = new Genero("Ficcao Cientifica", "Temas futuristicos e que fazem voce pensar!");

			

			

			Autor novoAutor1 = new Autor("Oasis", "Uma das maiores bandas dos anos 90 e do mundo!");

			Autor novoAutor2 = new Autor("Queens of the Stone Age", "Josh Homme revolucionou a forma na qual o rock é feito");

			Autor novoAutor3 = new Autor("Nirvana", "Uma das bandas mais influentes no meio Grunge");

			Autor novoAutor4 = new Autor("Pearl Jam", "Fez e ainda faz muito sucesso pela voz de Eddie Vedder");

			Autor novoAutor5 = new Autor("Radiohead", "Comandado por Thom Yorke");

			Autor novoAutor6 = new Autor("Stereophonics", "Banda bastante famosa na Grã-Bretanha, comandado por Kelly Jones");

			Autor novoAutor7 = new Autor("The Libertines", "Uma das poucas bandas atuais que fizeram sucesso na Inglaterra");

			Autor novoAutor8 = new Autor("Alfred Hithcock", "Um dos melhores diretores de terror");

			Autor novoAutor9 = new Autor("Chris Columbus", "Melhor diretor dos filmes de Harry Potter");

			Autor novoAutor10 = new Autor("Adam Sandler", "Sempre pronto para fazer você rir");

			Autor novoAutor11 = new Autor("George Lucas", "Lenda do cinema!");

			Autor novoAutor12 = new Autor("Peter Jackson", "Sagrou-se um dos maiores diretores após Senhor dos Aneis");

			Autor novoAutor13 = new Autor("Irmãos Wachowski", "Matrix foi a obra-prima desses diretores");

			

			

			Filme novoFilme = new Filme("Psicose", 1960, novoGenero11, novoAutor8, 109);

			Filme novoFilme2 = new Filme("Harry Potter e a Pedra Filosofal", 2001, novoGenero10, novoAutor9, 153);

			Filme novoFilme3 = new Filme("Zohan", 2008, novoGenero12, novoAutor10, 86);

			Filme novoFilme4 = new Filme("Star Wars IV : Uma Nova Esperanca", 1977, novoGenero13, novoAutor11,130);

			Filme novoFilme5 = new Filme("Star Wars V: O Império Contra-Ataca", 1980, novoGenero13,

					novoAutor11, 129);

			Filme novoFilme6 = new Filme("Star Wars VI : O Retorno dos Jedi", 1983, novoGenero13,novoAutor11,129);

			Filme novoFilme7 = new Filme("King Kong", 2005, novoGenero13, novoAutor12, 187);

			Filme novoFilme8 = new Filme("O Senhor dos Aneis : A Sociedade do Anel", 2001, novoGenero10, novoAutor12, 178);

			Filme novoFilme9 = new Filme("O Senhor dos Aneis : As Duas Torres", 2002, novoGenero10, novoAutor12, 179);

			Filme novoFilme10 = new Filme("O Senhor dos Aneis : O Retorno do Rei", 2003, novoGenero10, novoAutor12, 201);

			Filme novoFilme11 = new Filme("Matrix", 1999, novoGenero13,novoAutor13,136);

			Filme novoFilme12 = new Filme("Matrix Reloaded", 2003, novoGenero13,novoAutor13,138);

			Filme novoFilme13 = new Filme("Matrix Revolutions", 2003, novoGenero13,novoAutor13,129);

			

			

			AlbumMusical novoAlbum1 = new AlbumMusical("(What's the Story) Morning Glory", 

					1994, novoGenero1, novoAutor1);

			AlbumMusical novoAlbum2 = new AlbumMusical("Queens of the Stone Age", 1999, 

					novoGenero1, novoAutor1);

			AlbumMusical novoAlbum3 = new AlbumMusical("Nevermind", 1991, novoGenero3, novoAutor3);

			AlbumMusical novoAlbum4 = new AlbumMusical("Performance and Cocktails", 1998, novoGenero1, novoAutor6);

			

			FaixaMusical faixa1 = new FaixaMusical("Hello", 3, novoAlbum1);

			FaixaMusical faixa2 = new FaixaMusical("Roll With It", 4, novoAlbum1);

			FaixaMusical faixa3 = new FaixaMusical("Wonderwall", 4, novoAlbum1);

			FaixaMusical faixa4 = new FaixaMusical("Don't Look Back in Anger", 3, novoAlbum1);

			

			FaixaMusical faixa5 = new FaixaMusical("Regular John", 4, novoAlbum2);

			FaixaMusical faixa6 = new FaixaMusical("Avon", 3, novoAlbum2);

			FaixaMusical faixa7 = new FaixaMusical("If Only", 3, novoAlbum2);

			

			FaixaMusical faixa8 = new FaixaMusical("Smells Like Teen Spirit", 5, novoAlbum3);

			FaixaMusical faixa9 = new FaixaMusical("Something in the Way", 5, novoAlbum3);

			FaixaMusical faixa10 = new FaixaMusical("Polly", 3, novoAlbum3);

			

			FaixaMusical faixa11 = new FaixaMusical("She Takes Her Clothes Off", 4, novoAlbum4);

			FaixaMusical faixa12 = new FaixaMusical("Same Size Feet", 3, novoAlbum4);

			FaixaMusical faixa13 = new FaixaMusical("Roll Up and Shine", 3, novoAlbum4);

		

			//Usuario user = new Usuario("Padrao", "padrao", "123132", "21/12/2012");

			//Avaliacao aval = new Avaliacao(5, "Um dos melhores albuns da historia!");

			//Avaliacao aval2 = new Avaliacao(5, "Um dos melhores filmes baseados em livro!");

			//Avaliacao aval3 = new Avaliacao(5, "Melhor filme de suspense!");

			//Avaliacao aval4 = new Avaliacao(3, "Filme muito bobo");

			//Avaliacao aval5 = new Avaliacao(5, "Melhor filme de ficçao cientifica! Porem as sequencias deixam a desejar");

			

			//aval.setAlbum(novoAlbum1);

			//aval.setUsuario(user);

			

			//aval2.setFilme(novoFilme10);

			//aval2.setUsuario(user);

			

			//aval3.setFilme(novoFilme);

			//aval3.setUsuario(user);

			

			//aval4.setFilme(novoFilme3);

			//aval4.setUsuario(user);

			

			//aval5.setFilme(novoFilme11);

			//aval5.setUsuario(user);

			

			

			novoAlbum1.adicionaFaixaMusical(faixa1);

			novoAlbum1.adicionaFaixaMusical(faixa2);

			novoAlbum1.adicionaFaixaMusical(faixa3);

			novoAlbum1.adicionaFaixaMusical(faixa4);

			novoAlbum2.adicionaFaixaMusical(faixa5);

			novoAlbum2.adicionaFaixaMusical(faixa6);

			novoAlbum2.adicionaFaixaMusical(faixa7);

			novoAlbum3.adicionaFaixaMusical(faixa8);

			novoAlbum3.adicionaFaixaMusical(faixa9);

			novoAlbum3.adicionaFaixaMusical(faixa10);

			novoAlbum4.adicionaFaixaMusical(faixa11);

			novoAlbum4.adicionaFaixaMusical(faixa12);

			novoAlbum4.adicionaFaixaMusical(faixa13);

			

		

			facade.adicionaGenero(novoGenero1);

			facade.adicionaGenero(novoGenero2);

			facade.adicionaGenero(novoGenero3);

			facade.adicionaGenero(novoGenero4);

			facade.adicionaGenero(novoGenero5);

			facade.adicionaGenero(novoGenero6);

			facade.adicionaGenero(novoGenero7);

			facade.adicionaGenero(novoGenero8);

			facade.adicionaGenero(novoGenero9);

			facade.adicionaGenero(novoGenero10);

			facade.adicionaGenero(novoGenero11);

			facade.adicionaGenero(novoGenero12);

			facade.adicionaGenero(novoGenero13);

			

			facade.adicionaAutor(novoAutor1);

			facade.adicionaAutor(novoAutor2);

			facade.adicionaAutor(novoAutor3);

			facade.adicionaAutor(novoAutor4);

			facade.adicionaAutor(novoAutor5);

			facade.adicionaAutor(novoAutor6);

			facade.adicionaAutor(novoAutor7);

			facade.adicionaAutor(novoAutor8);

			facade.adicionaAutor(novoAutor9);

			facade.adicionaAutor(novoAutor10);

			facade.adicionaAutor(novoAutor11);
			facade.adicionaAutor(novoAutor12);
			facade.adicionaAutor(novoAutor13);

			

			facade.adicionaFilme(novoFilme);

			facade.adicionaFilme(novoFilme2);

			facade.adicionaFilme(novoFilme3);

			facade.adicionaFilme(novoFilme4);

			facade.adicionaFilme(novoFilme5);

			facade.adicionaFilme(novoFilme6);

			facade.adicionaFilme(novoFilme7);

			facade.adicionaFilme(novoFilme8);

			facade.adicionaFilme(novoFilme9);

			facade.adicionaFilme(novoFilme10);

			facade.adicionaFilme(novoFilme11);

			facade.adicionaFilme(novoFilme12);

			facade.adicionaFilme(novoFilme13);

			

			facade.adicionaAlbumMusical(novoAlbum1);

			facade.adicionaAlbumMusical(novoAlbum2);

			facade.adicionaAlbumMusical(novoAlbum3);

			facade.adicionaAlbumMusical(novoAlbum4);

			

			facade.adicionaFaixaMusical(faixa1);

			facade.adicionaFaixaMusical(faixa2);

			facade.adicionaFaixaMusical(faixa3);

			facade.adicionaFaixaMusical(faixa4);

			facade.adicionaFaixaMusical(faixa5);

			//facade.adicionaFaixaMusical(faixa6);

			//facade.adicionaFaixaMusical(faixa7);

			//facade.adicionaFaixaMusical(faixa8);

			//facade.adicionaFaixaMusical(faixa9);

			//facade.adicionaFaixaMusical(faixa10);

			//facade.adicionaFaixaMusical(faixa11);

			//facade.adicionaFaixaMusical(faixa12);

			//facade.adicionaFaixaMusical(faixa13);

			

			//facade.adicionaUsuario(user);

			

		//	facade.adicionaAvaliacao(aval);

		//	facade.adicionaAvaliacao(aval2);

		//	facade.adicionaAvaliacao(aval3);

		//	facade.adicionaAvaliacao(aval4);

		//	facade.adicionaAvaliacao(aval5);

			

		

		}

		catch(Throwable t) {

			t.printStackTrace();

			fail();

		}

	}

}