package br.unb.cic.DiariasEPassagens.integracao.memoria;

import br.unb.cic.DiariasEPassagens.integracao.DAOAlbumMusical;
import br.unb.cic.DiariasEPassagens.integracao.DAOSubFuncao;
import br.unb.cic.DiariasEPassagens.integracao.DAOFactory;
import br.unb.cic.DiariasEPassagens.integracao.DAOFaixaMusical;
import br.unb.cic.DiariasEPassagens.integracao.DAOFavorecido;
import br.unb.cic.DiariasEPassagens.integracao.DAOUnidadeGestora;
import br.unb.cic.DiariasEPassagens.integracao.DAOFuncao;
import br.unb.cic.DiariasEPassagens.integracao.DAOUsuario;
import br.unb.cic.DiariasEPassagens.integracao.jpa.DAOAlbumMusicalJPA;
import br.unb.cic.DiariasEPassagens.integracao.jpa.DAOSubFuncaoJPA;
import br.unb.cic.DiariasEPassagens.integracao.jpa.DAOOrgaoSubordinadoJPA;
import br.unb.cic.DiariasEPassagens.integracao.jpa.DAOFuncaoJPA;
import br.unb.cic.DiariasEPassagens.integracao.jpa.DAOUsuarioJPA;

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
	
	public DAOUnidadeGestora createDAOGenero() {
		return new DAOGeneroMemoria();
	}
	
}
