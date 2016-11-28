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
	
	public List<Acao> recuperaTodasAcoes() {
		return daoAcao.recuperaTodos();
	}
	
	public Acao recuperaAcaoPorNome(String nome) {
		return daoAcao.recuperaPorNome(nome);
	}
	
	public Acao recuperaAcaoPorId(String id) {
		return daoAcao.recuperaPorId(id);
	}
	
	public Acao recuperaAcaoPorLinguagemCidada(String linguagemCidada) {
		return daoAcao.recuperaPorLinguagemCidada(linguagemCidada);
	}
	
	public List<Acao> recuperaAcoesPorPrograma(String programa) {
		return daoAcao.recuperaAcoesPorPrograma(programa);
	}
	
	public List<Favorecido> recuperaTodosFavorecidos() {
		return daoFavorecido.recuperaTodos();
	}
	
	public Favorecido recuperaFavorecidoPorNome(String nome) {
		return daoFavorecido.recuperaPorNome(nome);
	}
	
	public Favorecido recuperaFavorecidoPorCPF(String CPF) {
		return daoFavorecido.recuperaPorCPF(CPF);
	}
	
	public Favorecido recuperaFavorecidoPorId(int id) {
		return daoFavorecido.recuperaPorId(id);
	}
	
	public List<Favorecido> recuperaFavorecidoPorUnidade(String unidadeGestora) {
		return daoFavorecido.recuperaPorUnidadeGestora(unidadeGestora);
	}
	
	public Favorecido recuperaFavorecidoPorPagamento(int pagamentoId) {
		return daoFavorecido.recuperaPorPagamento(pagamentoId);
	}
	
	public Pagamento recuperaPagamentoPorData(String data) {
		return daoPagamento.recuperaPorData(data);
	}
	
	public Pagamento recuperaPagamentoPorValor(String valor) {
		return daoPagamento.recuperaPorValor(valor);
	}
	
	public Pagamento recuperaPagamentoPorID(int id) {
		return daoPagamento.recuperaPorID(id);
	}
	
	public Pagamento recuperaPagamentoPorGestao(int gestaocod) {
		return daoPagamento.recuperaPorGestao(gestaocod);
	}
	
	public List<Pagamento> recuperaPagamentosPorAcao(String acao) {
		return daoPagamento.recuperaPagamentosPorAcao(acao);
	}
	
	public List<Pagamento> recuperaPagamentosPorFavorecido(String favorecido) {
		return daoPagamento.recuperaPagamentosPorFavorecido(favorecido);
	}
	
	public List<UnidadeGestora> recuperaTodasUniGests() {
		return daoUnidadeGestora.recuperaTodos();
	}
	
	public UnidadeGestora recuperaUniGestPorNome(String nome) {
		return daoUnidadeGestora.recuperaPorNome(nome);
	}
	
	public UnidadeGestora recuperaUniGestPorID(String id) {
		return daoUnidadeGestora.recuperaPorID(id);
	}
	
	public List<UnidadeGestora> recuperaUniGestPorOrgaoSubordinado(String orgaoSubordinado) {
		return daoUnidadeGestora.recuperaPorOrgaoSubordinado(orgaoSubordinado);
	}
	
	public List<UnidadeGestora> recuperaUniGestPorFuncao(String funcao) {
		return daoUnidadeGestora.recuperaPorFuncao(funcao);
	}
	
	public List<SubFuncao> recuperTodasSubFuncoes() {
		return daoSubFuncao.recuperaTodos();
	}
	
	public SubFuncao recuperaSubFuncaoPorNome(String nome) {
		return daoSubFuncao.recuperaPorNome(nome);
	}
	
	public SubFuncao recuperaSubFuncaoPorID(int id) {
		return daoSubFuncao.recuperaPorID(id);
	}
	
	public List<SubFuncao> recuperaSubFuncaoPorFuncao(String funcao) {
		return daoSubFuncao.recuperaSubFuncaoPorFuncao(funcao);
	}
	
	public List<Programa> recuperaTodosProgramas() {
		return daoPrograma.recuperaTodos();
	}
	
	public Programa recuperaProgramaPorID(int id) {
		return daoPrograma.recuperaPorID(id);
	}
	
	public Programa recuperaProgramaPorNome(String nome) {
		return daoPrograma.recuperaPorNome(nome);
	}
	
	public List<OrgaoSuperior> recuperaTodosOrgSup() {
		return daoOrgaoSuperior.recuperaTodos();
	}
	
	public OrgaoSuperior recuperaOrgSupPorID(int id) {
		return daoOrgaoSuperior.recuperaPorID(id);
	}
	
	public OrgaoSuperior recuperaOrgSupPorNome(String nome) {
		return daoOrgaoSuperior.recuperaPorNome(nome);
	}
	
	public List<OrgaoSubordinado> recuperaTodosOrgSub() {
		return daoOrgaoSubordinado.recuperaTodos();
	}
	
	public List<OrgaoSubordinado> recuperaOrgSubPorOrgSup(String orgaoSuperior) {
		return daoOrgaoSubordinado.recuperaPorOrgaoSuperior(orgaoSuperior);
	}
	
	public OrgaoSubordinado recuperaOrgSubPorNome(String nome) {
		return daoOrgaoSubordinado.recuperaPorNome(nome);
	}
	
	public OrgaoSubordinado recpueraOrgSubPorID(int id) {
		return daoOrgaoSubordinado.recuperaPorID(id);
	}
	
	public List<Funcao> recuperaTodasFuncoes() {
		return daoFuncao.recuperaTodos();
	}
	
	public List<Funcao> recuperaFuncaoPorUniGest(String unidadeGestora) {
		return daoFuncao.recuperaPorUnidadeGestora(unidadeGestora);
	}
	
	public Funcao recuperaFuncaoPorNome(String nome) {
		return daoFuncao.recuperaPorNome(nome);
	}
	
	public Funcao recuperaFuncaoPorID(int id) {
		return daoFuncao.recuperarPorID(id);
	}
}
