package br.unb.cic.imdb.negocio;

import br.unb.cic.imdb.util.ContextoID;
import junit.framework.TestCase;

public class IMDBFacadeTest3 extends TestCase {

	public void testeAdicionaFilme() {
		try {
			IMDBFacade facade = ContextoID.instance().facade();
			Genero novoGenero = new Genero("Fantasia","Você vai se encantar");
			Autor novoAutor = new Autor("Marc Forster","é um diretor de cinema  suíço-alemão");
			
			   Filme novoFilme = new Filme("Mais estranho que a ficção",2007,novoGenero,novoAutor,105);
			
			   int quantidadeFilmes = facade.recuperarFilme().size();
			   
			   facade.adicionaGenero(novoGenero);
			   facade.adicionaAutor(novoAutor);
			   facade.adicionaFilme(novoFilme);
			   Filme resultadoConsulta = facade.recuperarFilmePorTitulo("Mais estranho que a ficção");
			   assertEquals(quantidadeFilmes+1, facade.recuperarFilme().size());
			   assertNotNull(resultadoConsulta);	
		}
		catch(Throwable t) {
			t.printStackTrace();
			fail();
		}
	}
}



