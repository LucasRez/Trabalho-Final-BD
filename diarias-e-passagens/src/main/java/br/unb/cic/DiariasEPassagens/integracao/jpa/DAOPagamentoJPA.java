package br.unb.cic.DiariasEPassagens.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.entidades.Acao;
import br.unb.cic.DiariasEPassagens.entidades.Favorecido;
import br.unb.cic.DiariasEPassagens.entidades.Pagamento;
import br.unb.cic.DiariasEPassagens.integracao.DAOPagamento;


public class DAOPagamentoJPA implements DAOPagamento{

	//TODO: implementar a porra toda
	private EntityManager em;

	@Override
	public List<Pagamento> recuperaPagamentosPorAcao(String acao) {
		Acao object;
		object = new DAOAcaoJPA().recuperaPorNome(acao);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Pagamento WHERE acaocod = :acaoParam").setParameter("acaoParam", object.getId()).getResultList();
	}



	@Override
	public List<Pagamento> recuperaPagamentosPorFavorecido(String favorecido) {
		Favorecido object;
		object = new DAOFavorecidoJPA().recuperaPorNome(favorecido);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM Pagamento WHERE favorecidoid = :favorecidoParam").setParameter("favorecidoParam", object.getId()).getResultList();

	}

	@Override
	public Pagamento recuperaPorData(String data) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Pagamento> Pagamentos = em.createQuery("FROM Pagamento WHERE pagamdata = :DataParam").setParameter("dataParam", data).getResultList();
		return Pagamentos.size() == 1 ? Pagamentos.get(0) : null;
	
	}


	@Override
	public Pagamento recuperaPorValor(String valor) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Pagamento> Pagamentos = em.createQuery("FROM Pagamento WHERE pagamvalor = :ValorParam").setParameter("ValorParam", valor).getResultList();
		return Pagamentos.size() == 1 ? Pagamentos.get(0) : null;
	}


	@Override
	public Pagamento recuperaPorID(int id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Pagamento> Pagamentos = em.createQuery("FROM Pagamento WHERE pagamcod = :IDParam").setParameter("IDParam", id).getResultList();
		return Pagamentos.size() == 1 ? Pagamentos.get(0) : null;
	}
	
	@Override
	public Pagamento recuperaPorGestao(int gestaocod){
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Pagamento> Pagamentos = em.createQuery("FROM Pagamento WHERE pagamgestcod = :GestaoParam").setParameter("GestaoParam", gestaocod).getResultList();
		return Pagamentos.size() == 1 ? Pagamentos.get(0) : null;
	}
}