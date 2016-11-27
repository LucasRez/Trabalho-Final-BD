package br.unb.cic.DiariasEPassagens.integracao.jpa;

import br.unb.cic.DiariasEPassagens.integracao.DAOAcao;
import br.unb.cic.DiariasEPassagens.integracao.DAOSubFuncao;
import br.unb.cic.DiariasEPassagens.integracao.DAOAvaliacao;
import br.unb.cic.DiariasEPassagens.integracao.DAOFactory;
import br.unb.cic.DiariasEPassagens.integracao.DAOFaixaMusical;
import br.unb.cic.DiariasEPassagens.integracao.DAOFavorecido;
import br.unb.cic.DiariasEPassagens.integracao.DAOUnidadeGestora;
import br.unb.cic.DiariasEPassagens.integracao.DAOFuncao;
import br.unb.cic.DiariasEPassagens.integracao.DAOUsuario;

/**
 * Implementacao da classe abstrata DAOFactory 
 * com persistencia via JPA. 
 * 
 * @author rbonifacio
 */
public class DAOFactoryImpl extends DAOFactory {
	@Override
	public DAOUnidadeGestora createDAOGenero() {
		return new DAOGeneroJPA();
	}

	@Override
	public DAOFuncao createDAOTrabalhoArtistico() {
		return new DAOFuncaoJPA();
	}

	@Override
	public DAOFavorecido createDAOFilme() {
		return new DAOFilmeJPA();
	}

	@Override
	public DAOFaixaMusical createDAOFaixaMusical() {
		return new DAOOrgaoSubordinadoJPA();
	}

	@Override
	public DAOSubFuncao createDAOAutor() {
		return new DAOSubFuncaoJPA();
	}

	@Override
	public DAOAcao createDAOAlbumMusical() {
		return new DAOAcaoJPA();
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