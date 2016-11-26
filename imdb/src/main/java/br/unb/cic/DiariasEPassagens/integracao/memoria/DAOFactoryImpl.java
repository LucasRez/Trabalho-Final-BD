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
//O erro aqui é por que não completei a classe com a implementação de memória, visto que não foi pedido.
//O erro não gera problemas na compilação do programa principal.
public class DAOFactoryImpl extends DAOFactory {

	public DAOFactoryImpl() {
		super();
	} 
	
	public DAOGenero createDAOGenero() {
		return new DAOGeneroMemoria();
	}
	
}
