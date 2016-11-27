package br.unb.cic.DiariasEPassagens.integracao.jpa;



import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.entidades.Funcao;
import br.unb.cic.DiariasEPassagens.entidades.SubFuncao;
import br.unb.cic.DiariasEPassagens.integracao.DAOSubFuncao;



public class DAOSubFuncaoJPA implements DAOSubFuncao{

	

	private EntityManager em;


	@Override

	public List<SubFuncao> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM subFuncao").getResultList();
	}



	@Override
	public SubFuncao recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<SubFuncao> subFuncao = em.createQuery("FROM subFuncao WHERE subfuncnome = :nomeParam").setParameter("nomeParam", nome).getResultList();
		return subFuncao.size() == 1 ? subFuncao.get(0): null;
	}

	@Override
	public SubFuncao recuperaPorID(int id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<SubFuncao> subFuncao = em.createQuery("FROM subFuncao WHERE subfunccod = :idParam").setParameter("idParam", id).getResultList();
		return subFuncao.size() == 1 ? subFuncao.get(0): null;
	}

	@Override
	public List<SubFuncao> recuperaSubFuncaoPorFuncao(String funcao){
		Funcao object;
		
		object = new DAOFuncaoJPA().recuperaPorNome(funcao);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM subFuncao WHERE funccod = :funcaoParam").setParameter("funcaoParam", object.getId()).getResultList();
		
	}
}