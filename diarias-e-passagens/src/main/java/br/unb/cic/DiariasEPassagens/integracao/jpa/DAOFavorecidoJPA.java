package br.unb.cic.DiariasEPassagens.integracao.jpa;
import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.integracao.DAOFavorecido;
import br.unb.cic.DiariasEPassagens.negocio.UnidadeGestora;
import br.unb.cic.DiariasEPassagens.negocio.Pagamento;

public class DAOFavorecidoJPA implements DAOFavorecido{
	
	private EntityManager em;
	
	@Override
	public List<Favorecido> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Favorecidos").getResultList();
	}

	@Override
	public Favorecido recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Favorecido> Favorecidos = em.createQuery("FROM Favorecido WHERE Nome = :NomeParam").setParameter("NomeParam", nome).getResultList();
		return Favorecidos.size() == 1 ? Favorecidos.get(0) : null;
	}
	
	@Override
	public Favorecido recuperaPorCPF(String CPF) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Favorecido> Favorecidos = em.createQuery("FROM Favorecido WHERE Nome = :CPFParam").setParameter("CPFParam", CPF).getResultList();
		return Favorecidos.size() == 1 ? Favorecidos.get(0) : null;
	}

	public Favorecido recuperaPorPagamValor(String pagamValor) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Favorecido> Favorecidos = em.createQuery("FROM Favorecido WHERE PagamValor = :pagamValorParam").setParameter("pagamValorParam", pagamValor).getResultList();
		return Favorecidos.size() == 1 ? Favorecidos.get(0) : null;
	}
	
	@Override
	public List<Favorecido> recuperaPorUnidadeGestora(String unidadeGestora){
		unidadeGestora object;
		
		object = new DAOUnidadeGestoraJPA().recuperaPorNome(unidadeGestora);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Favorecido WHERE unidadeGestora = :unidadeGestoraParam").setParameter("unidadeGestoraParam", object).getResultList();
		//return Favorecidos.size() == 1 ? Favorecidos.get(0) : null;
	}

	
	@Override
	//public Favorecido recuperaPorPagamValor(String PagamValor) {
	public List<Favorecido> recuperaPorPagamento(String pagamento){
		pagamento object;
		
		object = new DAOPagamentoJPA().recuperaPorNome(pagamento);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Favorecido WHERE pagamento =:pagamentoParam").setParameter("pagamentoParam", object).getResultList();
		//return Favorecidos.size() == 1 ? Favorecidos.get(0) : null;
	}
}
