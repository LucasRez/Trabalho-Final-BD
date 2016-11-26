package br.unb.cic.DiariasEPassagens.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.integracao.DAOUnidadeGestora;
import br.unb.cic.DiariasEPassagens.negocio.UnidadeGestora;


public class DAOUnidadeGestoraJPA implements DAOUnidadeGestora {

	private EntityManager em; 
	
	@Override
	public List<UnidadeGestora> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM UnidadeGestora").getResultList();
	}

	@Override
	public UnidadeGestora recuperaPorNome(String Nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<UnidadeGestora> UnidadeGestoras = em.createQuery("FROM UnidadeGestora WHERE Nome = :nomeParam").setParameter("NomeParam", nome).getResultList();
		return UnidadeGestoras.size() == 1 ? UnidadeGestoras.get(0): null;
	}
	
	@Override
	public UnidadeGestora recuperaPorID(String ID) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<UnidadeGestora> UnidadeGestoras = em.createQuery("FROM UnidadeGestora WHERE ID = :IDParam").setParameter("IDParam", ID).getResultList();
		return UnidadeGestoras.size() == 1 ? UnidadeGestoras.get(0): null;
	}
	
	@Override
	public UnidadeGestora recuperaPorFuncao(String funcao) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<UnidadeGestora> UnidadeGestoras = em.createQuery("FROM UnidadeGestora WHERE Funcao = :FuncaoParam").setParameter("FuncaoParam", funcao).getResultList();
		return UnidadeGestoras.size() == 1 ? UnidadeGestoras.get(0): null;
	}
	
	@Override
	public List<UnidadeGestora> recuperaPorOrgaoSubordinado(String orgaoSubordinado){
		orgaoSubordinado object;
		
		object = new DAOrgaoSubordinadoJPA().recuperaPorNome(orgaoSubordinado);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM UnidadeGestora WHERE orgaoSubordinado = :orgaoSubordinado").setParameter("orgaoSubordinadoParam", object).getResultList();
		//return Favorecidos.size() == 1 ? Favorecidos.get(0) : null;
	}
}