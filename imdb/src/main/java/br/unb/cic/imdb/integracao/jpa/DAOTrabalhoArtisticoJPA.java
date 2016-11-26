package br.unb.cic.imdb.integracao.jpa;

import br.unb.cic.imdb.integracao.DAOTrabalhoArtistico;
import java.util.List;
import javax.persistence.EntityManager;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

public class DAOTrabalhoArtisticoJPA implements DAOTrabalhoArtistico{
	
	private EntityManager em;

	@Override
	public void salvar(TrabalhoArtistico trabalhoArtistico) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(trabalhoArtistico);
		em.getTransaction().commit();
		
	}

	@Override
	public List<TrabalhoArtistico> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM TrabalhoArtistico").getResultList();
	}

	@Override
	public TrabalhoArtistico recuperaPorTitulo(String titulo) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<TrabalhoArtistico> trabalhoArtistico = em.createQuery("FROM TrabalhoArtistico WHERE titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return trabalhoArtistico.size() == 1 ? trabalhoArtistico.get(0) : null;
	}

	@Override
	public TrabalhoArtistico recuperarPorGenero(String genero) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<TrabalhoArtistico> trabalhoArtistico = em.createQuery("FROM TrabalhoArtistico WHERE genero = :generoParam").setParameter("generoParam", genero).getResultList();
		return trabalhoArtistico.size() == 1 ? trabalhoArtistico.get(0) : null;
	}

	@Override
	public TrabalhoArtistico recuperarPorAutor(String autor) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<TrabalhoArtistico> trabalhoArtistico = em.createQuery("FROM TrabalhoArtistico WHERE autor = :autorParam").setParameter("autorParam", autor).getResultList();
		return trabalhoArtistico.size() == 1 ? trabalhoArtistico.get(0) : null;
	}

}
