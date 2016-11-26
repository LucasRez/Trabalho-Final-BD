package br.unb.cic.DiariasEPassagens.negocio;



import br.unb.cic.DiariasEPassagens.negocio.Autor;
import br.unb.cic.DiariasEPassagens.negocio.Avaliacao;
import br.unb.cic.DiariasEPassagens.negocio.Filme;
import br.unb.cic.DiariasEPassagens.negocio.Genero;
import br.unb.cic.DiariasEPassagens.negocio.IMDBFacade;
import br.unb.cic.DiariasEPassagens.negocio.Usuario;
import br.unb.cic.DiariasEPassagens.util.ContextoID;
import junit.framework.TestCase;



public class IMDBFacadeTest7 extends TestCase {

	public void testeAdicionaAvaliacao(){

		try{

			IMDBFacade facade = ContextoID.instance().facade();

			

			Autor novoAutor = new Autor("Arnold Schwarzenegger", "Excelente autor e ator de Filmes de Ação");

			Genero novoGenero = new Genero("História","Filmes que vão despertar seu interesse no passado");

			Filme novoFilme = new Filme("Discovery a new World", 2015, novoGenero, novoAutor, 200);

			

			Usuario novoUser = new Usuario("Bruno", "Usuario", "Senha", "06/12/2015");

			

			Avaliacao aval = new Avaliacao(5, "Filme simplismente sensacional!Mas trilha sonora fraca");

			aval.setUsuario(novoUser);

			aval.setFilme(novoFilme);

			

			

			facade.adicionaAutor(novoAutor);

			facade.adicionaGenero(novoGenero);

			facade.adicionaUsuario(novoUser);

			facade.adicionaFilme(novoFilme);

			facade.adicionaAvaliacao(aval);

			

			

			Avaliacao resultadoConsulta = facade.recuperarAvaliacaoPorUsuario(novoUser);

			assertNotNull(resultadoConsulta);

		}catch(Throwable t){

			t.printStackTrace();

			fail();

		}

	}

}