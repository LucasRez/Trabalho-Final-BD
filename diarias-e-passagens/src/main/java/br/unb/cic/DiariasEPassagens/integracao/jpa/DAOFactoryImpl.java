package br.unb.cic.DiariasEPassagens.integracao.jpa;

import br.unb.cic.DiariasEPassagens.integracao.DAOFactory;
import br.unb.cic.DiariasEPassagens.integracao.DAOQuery;


public class DAOFactoryImpl extends DAOFactory {

	@Override
	public DAOQuery createDAOQuery() {
		return new DAOQueryJPA();
	}
	
}