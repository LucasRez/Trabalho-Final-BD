package br.unb.cic.DiariasEPassagens.negocio;

import br.unb.cic.DiariasEPassagens.entidades.Autor;
import br.unb.cic.DiariasEPassagens.negocio.Filme;
import br.unb.cic.DiariasEPassagens.negocio.Genero;
import br.unb.cic.DiariasEPassagens.negocio.IMDBFacade;
import br.unb.cic.DiariasEPassagens.util.ContextoID;
import junit.framework.TestCase;

public class IMDBFacadeTest3 extends TestCase {

	public void testeAdicionaFilme() {
		try {
			IMDBFacade facade = ContextoID.instance().facade();
			Genero novoGenero = new Genero("Fantasia","Voc� vai se encantar");
			Autor novoAutor = new Autor("Marc Forster","� um diretor de cinema  su��o-alem�o");
			
			   Filme novoFilme = new Filme("Mais estranho que a fic��o",2007,novoGenero,novoAutor,105);
			
			   int quantidadeFilmes = facade.recuperarFilme().size();
			   
			   facade.adicionaGenero(novoGenero);
			   facade.adicionaAutor(novoAutor);
			   facade.adicionaFilme(novoFilme);
			   Filme resultadoConsulta = facade.recuperarFilmePorTitulo("Mais estranho que a fic��o");
			   assertEquals(quantidadeFilmes+1, facade.recuperarFilme().size());
			   assertNotNull(resultadoConsulta);	
		}
		catch(Throwable t) {
			t.printStackTrace();
			fail();
		}
	}
}



