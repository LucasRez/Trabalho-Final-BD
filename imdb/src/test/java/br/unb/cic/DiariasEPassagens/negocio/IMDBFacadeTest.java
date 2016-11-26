package br.unb.cic.DiariasEPassagens.negocio;

import br.unb.cic.DiariasEPassagens.negocio.Genero;
import br.unb.cic.DiariasEPassagens.negocio.IMDBFacade;
import br.unb.cic.DiariasEPassagens.util.ContextoID;
import junit.framework.TestCase;

public class IMDBFacadeTest extends TestCase {

	public void testeAdicionaGenero() {
		try {
			IMDBFacade facade = ContextoID.instance().facade();
		
			Genero novoGenero = new Genero("Rap", "Música das ruas"); 
		
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
