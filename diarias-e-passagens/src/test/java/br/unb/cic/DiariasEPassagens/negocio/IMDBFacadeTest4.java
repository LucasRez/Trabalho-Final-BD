package br.unb.cic.DiariasEPassagens.negocio;

import br.unb.cic.DiariasEPassagens.entidades.Autor;
import br.unb.cic.DiariasEPassagens.negocio.Genero;
import br.unb.cic.DiariasEPassagens.negocio.IMDBFacade;
import br.unb.cic.DiariasEPassagens.negocio.TrabalhoArtistico;
import br.unb.cic.DiariasEPassagens.util.ContextoID;
import junit.framework.TestCase;

public class IMDBFacadeTest4 extends TestCase {
	public void testeAdicionaTrabalhoArtistico(){
		try{
			
			IMDBFacade facade = ContextoID.instance().facade();
			
			
			Genero novoGenero = new Genero("Romance","Hist�rias de amor que v�o tocar seu cora��o");
			Autor novoAutor = new Autor("Robert Zemeckis","� um cineasta, produtor e roteirista estadunidense");
			TrabalhoArtistico trabalho = new TrabalhoArtistico("Forrest Gump: O Contador de Hist�rias",1996, novoGenero, novoAutor);
			  
			int quantidadeTrabalhos = facade.recuperarTrabalhosArtisticos().size();
			
			facade.adicionaAutor(novoAutor);
			facade.adicionaGenero(novoGenero);
			facade.adicionaTrabalhoArtistico(trabalho);
			TrabalhoArtistico resultadoConsulta = facade.recuperarTrabalhoArtisticoPorTitulo("Forrest Gump: O Contador de Hist�rias");
			assertEquals(quantidadeTrabalhos+1, facade.recuperarTrabalhosArtisticos().size());
			assertNotNull(resultadoConsulta);
			
		}catch(Throwable t){
			t.printStackTrace();
			fail();
		}
	}
}

