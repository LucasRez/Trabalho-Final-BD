package br.unb.cic.DiariasEPassagens.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.entidades.Funcao;
import br.unb.cic.DiariasEPassagens.entidades.OrgaoSubordinado;
import br.unb.cic.DiariasEPassagens.entidades.UnidadeGestora;
import br.unb.cic.DiariasEPassagens.integracao.DAOUnidadeGestora;


public class DAOUnidadeGestoraJPA implements DAOUnidadeGestora {

	private EntityManager em; 
	
	@Override
	public List<UnidadeGestora> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM unidade_gestora").getResultList();
	}

	@Override
	public UnidadeGestora recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<UnidadeGestora> UnidadeGestoras = em.createQuery("FROM unidade_gestora WHERE unigestnome = :nomeParam").setParameter("NomeParam", nome).getResultList();
		return UnidadeGestoras.size() == 1 ? UnidadeGestoras.get(0): null;
	}
	
	@Override
	public UnidadeGestora recuperaPorID(String ID) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<UnidadeGestora> UnidadeGestoras = em.createQuery("FROM unidade_gestora WHERE unigestcod = :IDParam").setParameter("IDParam", ID).getResultList();
		return UnidadeGestoras.size() == 1 ? UnidadeGestoras.get(0): null;
	}
	
	@Override
	public List<UnidadeGestora> recuperaPorFuncao(String funcao) {
		Funcao object;
		
		object = new DAOFuncaoJPA().recuperaPorNome(funcao);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM unidade_gestora WHERE funccod = :funcaoParam").setParameter("funcaoParam", object.getId()).getResultList();
	}
	
	
	@Override
	public List<UnidadeGestora> recuperaPorOrgaoSubordinado(String orgaoSubordinado){
		OrgaoSubordinado object;
		
		object = new DAOOrgaoSubordinadoJPA().recuperaPorNome(orgaoSubordinado);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM unidade_gestora WHERE orgsubcod = :orgaoSubordinado").setParameter("orgaoSubordinadoParam", object.getId()).getResultList();
	}
}
