package br.unb.cic.DiariasEPassagens.integracao.jpa;



import br.unb.cic.DiariasEPassagens.entidades.Autor;
import br.unb.cic.DiariasEPassagens.integracao.DAOAutor;

import javax.persistence.EntityManager;



import java.util.List;



public class DAOAutorJPA implements DAOAutor{

	

	private EntityManager em;

	@Override

	public void salvar(Autor autor) {

		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		em.getTransaction().begin();

		em.persist(autor);

		em.getTransaction().commit();

	}



	@Override

	public List<Autor> recuperaTodos() {

		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM Autor").getResultList();

	}



	@Override

	public Autor recuperaPorNome(String nome) {

		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		List<Autor> autor = em.createQuery("FROM Autor WHERE nome = :nomeParam").setParameter("nomeParam", nome).getResultList();

		return autor.size() == 1 ? autor.get(0): null;

	}



	@Override

	public List<Autor> recuperaAutoresPorTrabalhoArtistico(String trabalho) {

		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM Autor WHERE trabalho = :trabalhoParam").setParameter("nomeParam", trabalho).getResultList();

	}



	@Override

	public List<Autor> recuperaAutoresPorGenero(String genero) {

		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM Autor WHERE genero = :generoParam").setParameter("nomeParam", genero).getResultList();

	}



}