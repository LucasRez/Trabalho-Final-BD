package br.unb.cic.DiariasEPassagens.integracao.jpa;
import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.entidades.Programa;
import br.unb.cic.DiariasEPassagens.integracao.DAOPrograma;

public class DAOProgramaJPA implements DAOPrograma{
	
	private EntityManager em;
	
	@Override
	public List<Programa> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Programas").getResultList();
	}

	@Override
	public Programa recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Programa> Programas = em.createQuery("FROM Programa WHERE Nome = :NomeParam").setParameter("NomeParam", nome).getResultList();
		return Programas.size() == 1 ? Programas.get(0) : null;
	}
	
	@Override
	public Programa recuperaPorID(int id) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Programa> Programas = em.createQuery("FROM Programa WHERE Id = :IdParam").setParameter("IdParam", id).getResultList();
		return Programas.size() == 1 ? Programas.get(0) : null;
	}


}
