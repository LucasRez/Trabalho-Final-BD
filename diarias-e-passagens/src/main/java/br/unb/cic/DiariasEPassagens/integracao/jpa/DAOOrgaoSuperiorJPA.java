package br.unb.cic.DiariasEPassagens.integracao.jpa;
import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.entidades.OrgaoSuperior;
import br.unb.cic.DiariasEPassagens.integracao.DAOOrgaoSuperior;

public class DAOOrgaoSuperiorJPA implements DAOOrgaoSuperior{
	
	private EntityManager em;
	
	@Override
	public List<OrgaoSuperior> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM orgao_superior").getResultList();
	}

	@Override
	public OrgaoSuperior recuperaPorNome(String Nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<OrgaoSuperior> OrgaoSuperiores = em.createQuery("FROM OrgaoSuperior WHERE orgsupnome = :NomeParam").setParameter("NomeParam", Nome).getResultList();
		return OrgaoSuperiores.size() == 1 ? OrgaoSuperiores.get(0) : null;
	}
	
	@Override
	public OrgaoSuperior recuperaPorID(int id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<OrgaoSuperior> OrgaoSuperiores = em.createQuery("FROM OrgaoSuperior WHERE orgsupcod = :IdParam").setParameter("IdParam", id).getResultList();
		return OrgaoSuperiores.size() == 1 ? OrgaoSuperiores.get(0) : null;
	}


}
