package br.unb.cic.DiariasEPassagens.negocio;

import br.unb.cic.DiariasEPassagens.negocio.AlbumMusical;
import br.unb.cic.DiariasEPassagens.negocio.Autor;
import br.unb.cic.DiariasEPassagens.negocio.FaixaMusical;
import br.unb.cic.DiariasEPassagens.negocio.Genero;
import br.unb.cic.DiariasEPassagens.negocio.IMDBFacade;
import br.unb.cic.DiariasEPassagens.util.ContextoID;
import junit.framework.TestCase;

public class IMDBFacadeTest6 extends TestCase {

 public void testeAdicionaAlbum() {
	 try {
   
		 IMDBFacade facade = ContextoID.instance().facade();
   
		 Autor autor = new Autor("Arctic Monkeys", "é simplismente sensacional.");
		 Genero genero = new Genero("Alternative", " ");
		 
		 AlbumMusical album = new AlbumMusical("AM",2013, genero, autor);
		 FaixaMusical faixa1 = new FaixaMusical();
		 faixa1.setAlbumMusical(album);
		 faixa1.setTitulo("Are you  mine?");
		 
		 FaixaMusical faixa2 = new FaixaMusical();
		 faixa2.setAlbumMusical(album);
		 faixa2.setTitulo("Why do you only call me when you're high?");
		 
		 album.adicionaFaixaMusical(faixa1);
		 album.adicionaFaixaMusical(faixa2);
   
		 int quantidadeAlbum = facade.recuperarAlbumMusical().size();
   
		 facade.adicionaAutor(autor);
		 facade.adicionaGenero(genero);
		 facade.adicionaAlbumMusical(album);
		 facade.adicionaFaixaMusical(faixa1);
		 facade.adicionaFaixaMusical(faixa2);
   
		 AlbumMusical resultadoConsulta = facade.recuperarAlbumMusicalPorTitulo("AM");
		 FaixaMusical resultadoConsulta2 = facade.recuperarFaixaMusicalPorTitulo("Are you  mine?");
   
		 assertEquals(quantidadeAlbum + 1, facade.recuperarAlbumMusical().size());
		 assertNotNull(resultadoConsulta);
		 assertNotNull(resultadoConsulta2);  
	 }
	catch(Throwable t) {
		t.printStackTrace();
		fail();
	}
 }
}