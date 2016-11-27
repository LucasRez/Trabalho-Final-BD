package br.unb.cic.DiariasEPassagens.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.entidades.OrgaoSubordinado;
import br.unb.cic.DiariasEPassagens.entidades.OrgaoSuperior;
import br.unb.cic.DiariasEPassagens.integracao.DAOOrgaoSubordinado;

public class DAOOrgaoSubordinadoJPA implements DAOOrgaoSubordinado{
	
	private EntityManager em;

	@Override
	public List<OrgaoSubordinado> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM orgao_subordinado").getResultList();
	}

	@Override
	public OrgaoSubordinado recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<OrgaoSubordinado> orgaoSubordinado = em.createQuery("FROM orgao_subordinado WHERE orgsubnome = :NomeParam").setParameter("NomeParam", nome).getResultList();
		return orgaoSubordinado.size() == 1 ? orgaoSubordinado.get(0) : null;
	}
	
	@Override
	public OrgaoSubordinado recuperaPorID(int id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<OrgaoSubordinado> orgaoSubordinado = em.createQuery("FROM orgao_subordinado WHERE orgsubcod = :IDParam").setParameter("IDParam", id).getResultList();
		return orgaoSubordinado.size() == 1 ? orgaoSubordinado.get(0) : null;
	}
	
	@Override
	public List<OrgaoSubordinado> recuperaPorOrgaoSuperior(String orgaoSuperior){
		OrgaoSuperior object;
		
		object = new DAOOrgaoSuperiorJPA().recuperaPorNome(orgaoSuperior);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM orgao_subordinado WHERE orgsupcod = :orgaoSuperiorParam").setParameter("orgaoSuperiorParam", object.getId()).getResultList();
	}
	
}