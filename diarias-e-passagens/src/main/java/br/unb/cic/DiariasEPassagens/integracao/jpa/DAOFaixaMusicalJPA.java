package br.unb.cic.DiariasEPassagens.integracao.jpa;

import br.unb.cic.DiariasEPassagens.integracao.DAOFaixaMusical;
import br.unb.cic.DiariasEPassagens.negocio.FaixaMusical;

import java.util.List;
import javax.persistence.EntityManager;

public class DAOFaixaMusicalJPA implements DAOFaixaMusical{
	
	private EntityManager em;

	@Override
	public void salvar(FaixaMusical faixaMusical) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(faixaMusical);
		em.getTransaction().commit();
	}

	@Override
	public List<FaixaMusical> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM FaixaMusical").getResultList();
	}

	@Override
	public FaixaMusical recuperaPorTitulo(String titulo) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<FaixaMusical> faixa = em.createQuery("FROM FaixaMusical WHERE titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return faixa.size() == 1 ? faixa.get(0) : null;
	}

	@Override
	public List<FaixaMusical> recuperaFaixasPorAlbum(String album) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM FaixaMusical WHERE album = :albumParam").setParameter("albumParam", album).getResultList();
	}

	@Override
	public List<FaixaMusical> recuperaFaixasPorAutor(String autor) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM FaixaMusical WHERE album = :autorParam").setParameter("autorParam", autor).getResultList();
	}

	@Override
	public List<FaixaMusical> recuperaFaixasPorGenero(String genero) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM FaixaMusical WHERE genero = :generoParam").setParameter("generoParam", genero).getResultList();
	}

}