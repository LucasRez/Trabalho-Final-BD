package br.unb.cic.DiariasEPassagens.negocio;

import br.unb.cic.DiariasEPassagens.integracao.DAOFactory;
import br.unb.cic.DiariasEPassagens.integracao.DAOFactory.DataBase;
import br.unb.cic.DiariasEPassagens.integracao.DAOQuery;

public class Facade {

	private DAOQuery daoQuery;
	
	public Facade() {
		daoQuery = DAOFactory.instance(DataBase.SQLDB).createDAOQuery();
	}
	
	public void recuperaQualServidorGastouMais() {
		daoQuery.recuperaQualServidorGastouMais();
	}
	
	public void recuperaListaGastoTotaisDecres() {
		daoQuery.recuperaListaGastoTotaisCresc();
	}
	
	public void recuperaListaGastoTotaisCresc() {
		daoQuery.recuperaListaGastoTotaisDecres();
	}
	
	public void recuperaQualOrgSupGastouMais() {
		daoQuery.recuperaQualOrgSupGastouMais();
	}
	
	public void recuperaQualAcaoGastouMais() {
		daoQuery.recuperaQualAcaoGastouMais();
	}
	
	public void recuperaQualProgramaGastouMais() {
		daoQuery.recuperaQualProgramaGastouMais();
	}
	
	public void recuperaGastoPorCpf(String CPF) {
		daoQuery.recuperaGastoPorCpf(CPF);
	}
	
	public void recuperaGastoPorNome(String nome) {
		daoQuery.recuperaGastoPorNome(nome);
	}
	
	public void recuperaCodPagamGastouMais() {
		daoQuery.recuperaCodPagamGastouMais();
	}
	
	public void recuperaGastoTotal() {
		daoQuery.recuperaGastoTotal();
	}
	
	public void recuperaProgramadeAcaoGastouMais(String acaoNome) {
		daoQuery.recuperaProgramadeAcaoGastouMais(acaoNome);
	}
}