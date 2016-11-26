package br.unb.cic.DiariasEPassagens.integracao.jpa;

import br.unb.cic.DiariasEPassagens.integracao.DAOOrgaoSubordinado;
import br.unb.cic.DiariasEPassagens.negocio.OrgaoSubordinado;

import java.util.List;
import javax.persistence.EntityManager;

public class DAOOrgaoSubordinadoJPA implements DAOOrgaoSubordinado{
	
	private EntityManager em;

	@Override
	public List<OrgaoSubordinado> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM OrgaoSubordinado").getResultList();
	}

	@Override
	public OrgaoSubordinado recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<OrgaoSubordinado> orgaoSubordinado = em.createQuery("FROM OrgaoSubordinado WHERE Nome = :NomeParam").setParameter("NomeParam", nome).getResultList();
		return orgaoSubordinado.size() == 1 ? orgaoSubordinado.get(0) : null;
	}
	
	@Override
	public OrgaoSubordinado recuperaPorID(String id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<OrgaoSubordinado> orgaoSubordinado = em.createQuery("FROM OrgaoSubordinado WHERE ID = :IDParam").setParameter("idParam", id).getResultList();
		return orgaoSubordinado.size() == 1 ? orgaoSubordinado.get(0) : null;
	}
	
	@Override
	public OrgaoSubordinado recuperaPorUnidadeGestora(String unidadeGestora) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<OrgaoSubordinado> orgaoSubordinado = em.createQuery("FROM OrgaoSubordinado WHERE unidadeGestora = :unidadeGestoraParam").setParameter("unidadeGestoraParam", unidadeGestora).getResultList();
		return orgaoSubordinado.size() == 1 ? orgaoSubordinado.get(0) : null;
	}
	
	@Override
	public List<OrgaoSubordinado> recuperaPorOrgaoSuperior(String orgaoSuperior){
		orgaoSuperior object;
		
		object = new DAOOrgaoSuperiorJPA().recuperaPorNome(orgaoSuperior);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM orgaoSubordinado WHERE orgaoSuperior = :orgaoSuperiorParam").setParameter("orgaoSuperiorParam", object).getResultList();
		//return orgaoSubordinados.size() == 1 ? orgaoSubordinados.get(0) : null;
	}
	
	//@Override
	//public List<OrgaoSubordinado> recuperaorgaoSubordinadosPorGenero(String genero) {
	//	em = EMFactoryHelper.instance().getFactory().createEntityManager();
	//	return em.createQuery("FROM OrgaoSubordinado WHERE genero = :generoParam").setParameter("generoParam", genero).getResultList();
	//}

}