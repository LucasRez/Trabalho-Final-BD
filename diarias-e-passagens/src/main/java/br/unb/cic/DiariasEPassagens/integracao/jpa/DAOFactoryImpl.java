package br.unb.cic.DiariasEPassagens.integracao.jpa;

import br.unb.cic.DiariasEPassagens.integracao.DAOAcao;
import br.unb.cic.DiariasEPassagens.integracao.DAOFactory;
import br.unb.cic.DiariasEPassagens.integracao.DAOFavorecido;
import br.unb.cic.DiariasEPassagens.integracao.DAOFuncao;
import br.unb.cic.DiariasEPassagens.integracao.DAOOrgaoSubordinado;
import br.unb.cic.DiariasEPassagens.integracao.DAOOrgaoSuperior;
import br.unb.cic.DiariasEPassagens.integracao.DAOPagamento;
import br.unb.cic.DiariasEPassagens.integracao.DAOPrograma;
import br.unb.cic.DiariasEPassagens.integracao.DAOSubFuncao;
import br.unb.cic.DiariasEPassagens.integracao.DAOUnidadeGestora;


public class DAOFactoryImpl extends DAOFactory {

	@Override
	public DAOUnidadeGestora createDAOUnidadeGestora() {
		return new DAOUnidadeGestoraJPA();
	}

	@Override
	public DAOFuncao createDAOFuncao() {
		return new DAOFuncaoJPA();
	}

	@Override
	public DAOFavorecido createDAOFavorecido() {
		return new DAOFavorecidoJPA();
	}

	@Override
	public DAOPagamento createDAOPagamento() {
		return new DAOPagamentoJPA();
	}

	@Override
	public DAOSubFuncao createDAOSubFuncao() {
		return new DAOSubFuncaoJPA();
	}

	@Override
	public DAOAcao createDAOAcao() {
		return new DAOAcaoJPA();
	}

	@Override
	public DAOOrgaoSubordinado createDAOOrgaoSubordinado() {
		return new DAOOrgaoSubordinadoJPA();
	}

	@Override
	public DAOOrgaoSuperior createDAOOrgaoSuperior() {
		return new DAOOrgaoSuperiorJPA();
	}

	@Override
	public DAOPrograma createDAOPrograma() {
		return new DAOProgramaJPA();
	}
	
}