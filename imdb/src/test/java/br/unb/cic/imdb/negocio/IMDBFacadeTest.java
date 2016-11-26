package br.unb.cic.imdb.negocio;

import br.unb.cic.imdb.util.ContextoID;
import junit.framework.TestCase;

public class IMDBFacadeTest extends TestCase {

	public void testeAdicionaGenero() {
		try {
			IMDBFacade facade = ContextoID.instance().facade();
		
			Genero novoGenero = new Genero("Rap", "M�sica das ruas"); 
		
			int quantidadeGeneros = facade.recuperarGeneros().size();
		
			facade.adicionaGenero(novoGenero);
		
			Genero resultadoConsulta = facade.recuperarPorTitulo("Rap");
		
			assertEquals(quantidadeGeneros+1, facade.recuperarGeneros().size());
			assertNotNull(resultadoConsulta);		
		}
		catch(Throwable t) {
			t.printStackTrace();
			fail();
		}
	}
}
