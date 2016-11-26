package br.unb.cic.imdb.integracao.memoria;

import br.unb.cic.imdb.integracao.DAOAlbumMusical;
import br.unb.cic.imdb.integracao.DAOAutor;
import br.unb.cic.imdb.integracao.DAOFactory;
import br.unb.cic.imdb.integracao.DAOFaixaMusical;
import br.unb.cic.imdb.integracao.DAOFilme;
import br.unb.cic.imdb.integracao.DAOGenero;
import br.unb.cic.imdb.integracao.DAOTrabalhoArtistico;
import br.unb.cic.imdb.integracao.DAOUsuario;
import br.unb.cic.imdb.integracao.jpa.DAOAlbumMusicalJPA;
import br.unb.cic.imdb.integracao.jpa.DAOAutorJPA;
import br.unb.cic.imdb.integracao.jpa.DAOFaixaMusicalJPA;
import br.unb.cic.imdb.integracao.jpa.DAOTrabalhoArtisticoJPA;
import br.unb.cic.imdb.integracao.jpa.DAOUsuarioJPA;

/**
 * Implementacao da classe abstrata DAOFactory 
 * com persistencia em memoria. 
 * 
 * @author rbonifacio
 */
//O erro aqui � por que n�o completei a classe com a implementa��o de mem�ria, visto que n�o foi pedido.
//O erro n�o gera problemas na compila��o do programa principal.
public class DAOFactoryImpl extends DAOFactory {

	public DAOFactoryImpl() {
		super();
	} 
	
	public DAOGenero createDAOGenero() {
		return new DAOGeneroMemoria();
	}
	
}
