package br.unb.cic.DiariasEPassagens.negocio;

import br.unb.cic.DiariasEPassagens.entidades.Autor;
import br.unb.cic.DiariasEPassagens.negocio.IMDBFacade;
import br.unb.cic.DiariasEPassagens.util.ContextoID;
import junit.framework.TestCase;

public class IMDBFacadeTest2 extends TestCase {
	public void testeAdicionaAutor(){
		try{
			IMDBFacade facade = ContextoID.instance().facade();
			Autor novoAutor = new Autor("Kasabian", " ");
			int quantidadeAutores = facade.recuperarAutor().size();
			facade.adicionaAutor(novoAutor);
			Autor resultadoConsulta = facade.recuperarAutorPorNome("Kasabian");
			assertEquals(quantidadeAutores+1, facade.recuperarAutor().size());
			assertNotNull(resultadoConsulta);
		}catch(Throwable t){
			t.printStackTrace();
			fail();
		}
	}
}
