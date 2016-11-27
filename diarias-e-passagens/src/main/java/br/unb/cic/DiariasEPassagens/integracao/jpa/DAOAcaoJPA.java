package br.unb.cic.DiariasEPassagens.integracao.jpa;



import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.integracao.Acao;
import br.unb.cic.DiariasEPassagens.integracao.DAOAcao;
import br.unb.cic.DiariasEPassagens.negocio.acao;
import br.unb.cic.DiariasEPassagens.negocio.Pagamento;
import br.unb.cic.DiariasEPassagens.negocio.Programa;



public class DAOAcaoJPA implements DAOAcao{

	

	private EntityManager em;

	@Override
	public List<acao> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM acao").getResultList();
	}



	@Override
	public acao recuperaPorNome(String nome) {
		
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<acao> acao = em.createQuery("FROM acao WHERE Nome = :NomeParam").setParameter("NomeParam", nome).getResultList();
		return acao.size() == 1 ? acao.get(0) : null;
	}



	@Override
	public acao recuperaPorId(String id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<acao> acao = em.createQuery("FROM acao WHERE ID = :IdParam").setParameter("IdParam", id).getResultList();
		return acao.size() == 1 ? acao.get(0) : null;
	}

	@Override
	public acao recuperaPorLinguagemCidada(String linguagemCidada){
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<acao> acao = em.createQuery("FROM acao WHERE linguagemCidada = :linguagemCidadaParam").setParameter("linguagemCidadaParam", linguagemCidada).getResultList();
		return acao.size() == 1 ? acao.get(0) : null;
	}

	


	@Override
	public List<Acao> recuperaAcoesPorPrograma(String programa) {
		programa object;
		object = new DAOProgramaJPA().recuperaPorNome(programa);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM acao WHERE Programa = :programaParam").setParameter("programaParam", object).getResultList();
	}



	@Override

	public List<acao> recuperaAlbunsPorAno(int ano) {

		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM acao WHERE ano = :anoParam").setParameter("anoParam", ano).getResultList();

	}



}