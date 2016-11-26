package br.unb.cic.DiariasEPassagens.integracao.jpa;

import br.unb.cic.DiariasEPassagens.integracao.DAOAlbumMusical;
import br.unb.cic.DiariasEPassagens.integracao.DAOAutor;
import br.unb.cic.DiariasEPassagens.integracao.DAOAvaliacao;
import br.unb.cic.DiariasEPassagens.integracao.DAOFactory;
import br.unb.cic.DiariasEPassagens.integracao.DAOFaixaMusical;
import br.unb.cic.DiariasEPassagens.integracao.DAOFavorecido;
import br.unb.cic.DiariasEPassagens.integracao.DAOGenero;
import br.unb.cic.DiariasEPassagens.integracao.DAOTrabalhoArtistico;
import br.unb.cic.DiariasEPassagens.integracao.DAOUsuario;

/**
 * Implementacao da classe abstrata DAOFactory 
 * com persistencia via JPA. 
 * 
 * @author rbonifacio
 */
public class DAOFactoryImpl extends DAOFactory {
	@Override
	public DAOGenero createDAOGenero() {
		return new DAOGeneroJPA();
	}

	@Override
	public DAOTrabalhoArtistico createDAOTrabalhoArtistico() {
		return new DAOTrabalhoArtisticoJPA();
	}

	@Override
	public DAOFavorecido createDAOFilme() {
		return new DAOFilmeJPA();
	}

	@Override
	public DAOFaixaMusical createDAOFaixaMusical() {
		return new DAOFaixaMusicalJPA();
	}

	@Override
	public DAOAutor createDAOAutor() {
		return new DAOAutorJPA();
	}

	@Override
	public DAOAlbumMusical createDAOAlbumMusical() {
		return new DAOAlbumMusicalJPA();
	}

	@Override
	public DAOUsuario createDAOUsuario() {
		return new DAOUsuarioJPA();
	}
	
	@Override
	public DAOAvaliacao createDAOAvaliacao(){
		return new DAOAvaliacaoJPA();
	}
}