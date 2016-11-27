package br.unb.cic.DiariasEPassagens.integracao.jpa;



import br.unb.cic.DiariasEPassagens.integracao.DAOSubFuncao;
import br.unb.cic.DiariasEPassagens.integracao.SubFuncao;
import br.unb.cic.DiariasEPassagens.negocio.subFuncao;

import javax.persistence.EntityManager;



import java.util.List;



public class DAOSubFuncaoJPA implements DAOSubFuncao{

	

	private EntityManager em;


	@Override

	public List<subFuncao> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM subFuncao").getResultList();
	}



	@Override
	public subFuncao recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<subFuncao> subFuncao = em.createQuery("FROM subFuncao WHERE nome = :nomeParam").setParameter("nomeParam", nome).getResultList();
		return subFuncao.size() == 1 ? subFuncao.get(0): null;
	}

	@Override
	public subFuncao recuperaPorID(String id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<subFuncao> subFuncao = em.createQuery("FROM subFuncao WHERE id = :idParam").setParameter("idParam", id).getResultList();
		return subFuncao.size() == 1 ? subFuncao.get(0): null;
	}

	@Override
	public List<SubFuncao> recuperaSubFuncaoPorFuncao(String funcao){
		funcao object;
		
		object = new DAOfuncaoJPA().recuperaPorNome(funcao);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Favorecido WHERE funcao = :funcaoParam").setParameter("funcaoParam", object).getResultList();
		
	}
	}


}