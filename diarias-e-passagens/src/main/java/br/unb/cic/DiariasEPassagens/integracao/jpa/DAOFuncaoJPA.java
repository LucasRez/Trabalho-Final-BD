package br.unb.cic.DiariasEPassagens.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.entidades.Funcao;
import br.unb.cic.DiariasEPassagens.entidades.UnidadeGestora;
import br.unb.cic.DiariasEPassagens.integracao.DAOFuncao;

public class DAOFuncaoJPA implements DAOFuncao{
	
	private EntityManager em;

	@Override
	public List<Funcao> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Funcao").getResultList();
	}

	@Override
	public Funcao recuperarPorID(int id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Funcao> Funcao = em.createQuery("FROM Funcao WHERE funccod = :idParam").setParameter("idParam", id).getResultList();
		return Funcao.size() == 1 ? Funcao.get(0) : null;
	}

	@Override
	public Funcao recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Funcao> Funcao = em.createQuery("FROM Funcao WHERE funcnome = :nomeParam").setParameter("nomeParam", nome).getResultList();
		return Funcao.size() == 1 ? Funcao.get(0) : null;
	}
	
	@Override
	public List<Funcao> recuperaPorUnidadeGestora(String unidadeGestora){
		UnidadeGestora object;
		
		object = new DAOUnidadeGestoraJPA().recuperaPorNome(unidadeGestora);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Funcao WHERE unigestcod = :unidadeGestoraParam").setParameter("unidadeGestoraParam", object.getId()).getResultList();
	}

}
