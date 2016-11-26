package br.unb.cic.imdb.integracao.jpa;
import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOFilme;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Filme;
import br.unb.cic.imdb.negocio.Genero;

public class DAOFilmeJPA implements DAOFilme{
	
	private EntityManager em;

	@Override
	public void salvar(Filme filme) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(filme);
		em.getTransaction().commit();
	}

	@Override
	public List<Filme> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Filme").getResultList();
	}

	@Override
	public Filme recuperaPorTitulo(String titulo) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Filme> filmes = em.createQuery("FROM Filme WHERE titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return filmes.size() == 1 ? filmes.get(0) : null;
	}

	@Override
	public List<Filme> recuperaPorGenero(String genero){
	//public Filme recuperaPorGenero(String genero) {
		Genero object;
		
		object = new DAOGeneroJPA().recuperaPorTitulo(genero);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Filme WHERE genero = :generoParam").setParameter("generoParam", object).getResultList();
		//return filmes.size() == 1 ? filmes.get(0) : null;
	}

	
	@Override
	//public Filme recuperaPorAutor(String autor) {
	public List<Filme>  recuperaPorAutor(String autor){
		Autor object;
		
		object = new DAOAutorJPA().recuperaPorNome(autor);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Filme WHERE autor =:autorParam").setParameter("autorParam", object).getResultList();
		//return filmes.size() == 1 ? filmes.get(0) : null;
	}
	
}
