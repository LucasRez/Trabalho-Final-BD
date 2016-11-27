package br.unb.cic.DiariasEPassagens.integracao.jpa;
import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.entidades.Favorecido;
import br.unb.cic.DiariasEPassagens.entidades.Pagamento;
import br.unb.cic.DiariasEPassagens.entidades.UnidadeGestora;
import br.unb.cic.DiariasEPassagens.integracao.DAOFavorecido;

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
		List<Favorecido> Favorecidos = em.createQuery("FROM Favorecido WHERE favorecidonome = :NomeParam").setParameter("NomeParam", nome).getResultList();
		return Favorecidos.size() == 1 ? Favorecidos.get(0) : null;
	}
	
	@Override
	public Favorecido recuperaPorCPF(String CPF) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Favorecido> Favorecidos = em.createQuery("FROM Favorecido WHERE favorecidocpf = :CPFParam").setParameter("CPFParam", CPF).getResultList();
		return Favorecidos.size() == 1 ? Favorecidos.get(0) : null;
	}

	@Override
	public List<Favorecido> recuperaPorUnidadeGestora(String unidadeGestora){
		UnidadeGestora object;
		
		object = new DAOUnidadeGestoraJPA().recuperaPorNome(unidadeGestora);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Favorecido WHERE unigestcod = :unidadeGestoraParam").setParameter("unidadeGestoraParam", object.getId()).getResultList();
		//return Favorecidos.size() == 1 ? Favorecidos.get(0) : null;
	}

	
	@Override
	public Favorecido recuperaPorPagamento(int pagamentoId){
		Pagamento object;
		
		object = new DAOPagamentoJPA().recuperaPorID(pagamentoId);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Favorecido> favorecidos = em.createQuery("FROM favorecido WHERE favorecidocpf =:CpfParam").setParameter("CpfParam", object.getFavorecido().getCpf()).getResultList();
		return favorecidos.size() == 1 ? favorecidos.get(0) : null;
	}

	@Override
	public Favorecido recuperaPorId(int id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Favorecido> Favorecidos = em.createQuery("FROM Favorecido WHERE favorecidoid = :IdParam").setParameter("IdParam", id).getResultList();
		return Favorecidos.size() == 1 ? Favorecidos.get(0) : null;
	}
}
