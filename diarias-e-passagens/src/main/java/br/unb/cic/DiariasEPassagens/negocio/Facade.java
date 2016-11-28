package br.unb.cic.DiariasEPassagens.negocio;

import java.util.List;

import br.unb.cic.DiariasEPassagens.entidades.Acao;
import br.unb.cic.DiariasEPassagens.entidades.Favorecido;
import br.unb.cic.DiariasEPassagens.entidades.Funcao;
import br.unb.cic.DiariasEPassagens.entidades.OrgaoSubordinado;
import br.unb.cic.DiariasEPassagens.entidades.OrgaoSuperior;
import br.unb.cic.DiariasEPassagens.entidades.Pagamento;
import br.unb.cic.DiariasEPassagens.entidades.Programa;
import br.unb.cic.DiariasEPassagens.entidades.SubFuncao;
import br.unb.cic.DiariasEPassagens.entidades.UnidadeGestora;
import br.unb.cic.DiariasEPassagens.integracao.DAOAcao;
import br.unb.cic.DiariasEPassagens.integracao.DAOFactory;
import br.unb.cic.DiariasEPassagens.integracao.DAOFactory.DataBase;
import br.unb.cic.DiariasEPassagens.integracao.DAOFavorecido;
import br.unb.cic.DiariasEPassagens.integracao.DAOFuncao;
import br.unb.cic.DiariasEPassagens.integracao.DAOOrgaoSubordinado;
import br.unb.cic.DiariasEPassagens.integracao.DAOOrgaoSuperior;
import br.unb.cic.DiariasEPassagens.integracao.DAOPagamento;
import br.unb.cic.DiariasEPassagens.integracao.DAOPrograma;
import br.unb.cic.DiariasEPassagens.integracao.DAOSubFuncao;
import br.unb.cic.DiariasEPassagens.integracao.DAOUnidadeGestora;

public class Facade {

	private DAOAcao daoAcao;
	private DAOFavorecido daoFavorecido;
	private DAOFuncao daoFuncao;
	private DAOOrgaoSubordinado daoOrgaoSubordinado;
	private DAOOrgaoSuperior daoOrgaoSuperior;
	private DAOPagamento daoPagamento;
	private DAOPrograma daoPrograma;
	private DAOSubFuncao daoSubFuncao;
	private DAOUnidadeGestora daoUnidadeGestora;
	
	public Facade() {
		daoAcao = DAOFactory.instance(DataBase.SQLDB).createDAOAcao();
		daoFavorecido = DAOFactory.instance(DataBase.SQLDB).createDAOFavorecido();
		daoFuncao = DAOFactory.instance(DataBase.SQLDB).createDAOFuncao();
		daoOrgaoSubordinado = DAOFactory.instance(DataBase.SQLDB).createDAOOrgaoSubordinado();
		daoOrgaoSuperior = DAOFactory.instance(DataBase.SQLDB).createDAOOrgaoSuperior();
		daoPagamento = DAOFactory.instance(DataBase.SQLDB).createDAOPagamento();
		daoPrograma = DAOFactory.instance(DataBase.SQLDB).createDAOPrograma();
		daoSubFuncao = DAOFactory.instance(DataBase.SQLDB).createDAOSubFuncao();
		daoUnidadeGestora = DAOFactory.instance(DataBase.SQLDB).createDAOUnidadeGestora();
	}
	
	List<Acao> recuperaTodasAcoes() {
		return daoAcao.recuperaTodos();
	}
	
	Acao recuperaAcaoPorNome(String nome) {
		return daoAcao.recuperaPorNome(nome);
	}
	
	Acao recuperaAcaoPorId(String id) {
		return daoAcao.recuperaPorId(id);
	}
	
	Acao recuperaAcaoPorLinguagemCidada(String linguagemCidada) {
		return daoAcao.recuperaPorLinguagemCidada(linguagemCidada);
	}
	
	List<Acao> recuperaAcoesPorPrograma(String programa) {
		return daoAcao.recuperaAcoesPorPrograma(programa);
	}
	
	List<Favorecido> recuperaTodosFavorecidos() {
		return daoFavorecido.recuperaTodos();
	}
	
	Favorecido recuperaFavorecidoPorNome(String nome) {
		return daoFavorecido.recuperaPorNome(nome);
	}
	
	Favorecido recuperaFavorecidoPorCPF(String CPF) {
		return daoFavorecido.recuperaPorCPF(CPF);
	}
	
	Favorecido recuperaFavorecidoPorId(int id) {
		return daoFavorecido.recuperaPorId(id);
	}
	
	List<Favorecido> recuperaFavorecidoPorUnidade(String unidadeGestora) {
		return daoFavorecido.recuperaPorUnidadeGestora(unidadeGestora);
	}
	
	Favorecido recuperaFavorecidoPorPagamento(int pagamentoId) {
		return daoFavorecido.recuperaPorPagamento(pagamentoId);
	}
	
	Pagamento recuperaPagamentoPorData(String data) {
		return daoPagamento.recuperaPorData(data);
	}
	
	Pagamento recuperaPagamentoPorValor(String valor) {
		return daoPagamento.recuperaPorValor(valor);
	}
	
	Pagamento recuperaPagamentoPorID(int id) {
		return daoPagamento.recuperaPorID(id);
	}
	
	Pagamento recuperaPagamentoPorGestao(int gestaocod) {
		return daoPagamento.recuperaPorGestao(gestaocod);
	}
	
	List<Pagamento> recuperaPagamentosPorAcao(String acao) {
		return daoPagamento.recuperaPagamentosPorAcao(acao);
	}
	
	List<Pagamento> recuperaPagamentosPorFavorecido(String favorecido) {
		return daoPagamento.recuperaPagamentosPorFavorecido(favorecido);
	}
	
	List<UnidadeGestora> recuperaTodasUniGests() {
		return daoUnidadeGestora.recuperaTodos();
	}
	
	UnidadeGestora recuperaUniGestPorNome(String nome) {
		return daoUnidadeGestora.recuperaPorNome(nome);
	}
	
	UnidadeGestora recuperaUniGestPorID(String id) {
		return daoUnidadeGestora.recuperaPorID(id);
	}
	
	List<UnidadeGestora> recuperaUniGestPorOrgaoSubordinado(String orgaoSubordinado) {
		return daoUnidadeGestora.recuperaPorOrgaoSubordinado(orgaoSubordinado);
	}
	
	List<UnidadeGestora> recuperaUniGestPorFuncao(String funcao) {
		return daoUnidadeGestora.recuperaPorFuncao(funcao);
	}
	
	List<SubFuncao> recuperTodasSubFuncoes() {
		return daoSubFuncao.recuperaTodos();
	}
	
	SubFuncao recuperaSubFuncaoPorNome(String nome) {
		return daoSubFuncao.recuperaPorNome(nome);
	}
	
	SubFuncao recuperaSubFuncaoPorID(int id) {
		return daoSubFuncao.recuperaPorID(id);
	}
	
	List<SubFuncao> recuperaSubFuncaoPorFuncao(String funcao) {
		return daoSubFuncao.recuperaSubFuncaoPorFuncao(funcao);
	}
	
	List<Programa> recuperaTodosProgramas() {
		return daoPrograma.recuperaTodos();
	}
	
	Programa recuperaProgramaPorID(int id) {
		return daoPrograma.recuperaPorID(id);
	}
	
	Programa recuperaProgramaPorNome(String nome) {
		return daoPrograma.recuperaPorNome(nome);
	}
	
	List<OrgaoSuperior> recuperaTodosOrgSup() {
		return daoOrgaoSuperior.recuperaTodos();
	}
	
	OrgaoSuperior recuperaOrgSupPorID(int id) {
		return daoOrgaoSuperior.recuperaPorID(id);
	}
	
	OrgaoSuperior recuperaOrgSupPorNome(String nome) {
		return daoOrgaoSuperior.recuperaPorNome(nome);
	}
	
	List<OrgaoSubordinado> recuperaTodosOrgSub() {
		return daoOrgaoSubordinado.recuperaTodos();
	}
	
	List<OrgaoSubordinado> recuperaOrgSubPorOrgSup(String orgaoSuperior) {
		return daoOrgaoSubordinado.recuperaPorOrgaoSuperior(orgaoSuperior);
	}
	
	OrgaoSubordinado recuperaOrgSubPorNome(String nome) {
		return daoOrgaoSubordinado.recuperaPorNome(nome);
	}
	
	OrgaoSubordinado recpueraOrgSubPorID(int id) {
		return daoOrgaoSubordinado.recuperaPorID(id);
	}
	
	List<Funcao> recuperaTodasFuncoes() {
		return daoFuncao.recuperaTodos();
	}
	
	List<Funcao> recuperaFuncaoPorUniGest(String unidadeGestora) {
		return daoFuncao.recuperaPorUnidadeGestora(unidadeGestora);
	}
	
	Funcao recuperaFuncaoPorNome(String nome) {
		return daoFuncao.recuperaPorNome(nome);
	}
	
	Funcao recuperaFuncaoPorID(int id) {
		return daoFuncao.recuperarPorID(id);
	}
}
