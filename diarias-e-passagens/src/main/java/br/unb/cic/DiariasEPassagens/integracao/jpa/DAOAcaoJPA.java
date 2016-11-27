package br.unb.cic.DiariasEPassagens.integracao.jpa;




import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.entidades.Acao;
import br.unb.cic.DiariasEPassagens.entidades.Programa;
import br.unb.cic.DiariasEPassagens.integracao.DAOAcao;



public class DAOAcaoJPA implements DAOAcao{

	

	private EntityManager em;

	@Override
	public List<Acao> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Acao").getResultList();
	}



	@Override
	public Acao recuperaPorNome(String nome) {
		
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Acao> Acao = em.createQuery("FROM Acao WHERE acaonome = :NomeParam").setParameter("NomeParam", nome).getResultList();
		return Acao.size() == 1 ? Acao.get(0) : null;
	}



	@Override
	public Acao recuperaPorId(String id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Acao> Acao = em.createQuery("FROM Acao WHERE acaocod = :IdParam").setParameter("IdParam", id).getResultList();
		return Acao.size() == 1 ? Acao.get(0) : null;
	}

	@Override
	public Acao recuperaPorLinguagemCidada(String linguagemCidada){
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Acao> Acao = em.createQuery("FROM Acao WHERE linguagem_cidada = :linguagemCidadaParam").setParameter("linguagemCidadaParam", linguagemCidada).getResultList();
		return Acao.size() == 1 ? Acao.get(0) : null;
	}

	


	@Override
	public List<Acao> recuperaAcoesPorPrograma(String programa) {
		Programa object;
		object = new DAOProgramaJPA().recuperaPorNome(programa);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM Acao WHERE progcod = :programaParam").setParameter("programaParam", object.getId()).getResultList();
	}

}