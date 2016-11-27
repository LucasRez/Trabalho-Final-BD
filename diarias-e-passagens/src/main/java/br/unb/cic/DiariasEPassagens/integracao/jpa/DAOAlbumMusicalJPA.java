package br.unb.cic.DiariasEPassagens.integracao.jpa;



import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.entidades.AlbumMusical;
import br.unb.cic.DiariasEPassagens.entidades.Autor;
import br.unb.cic.DiariasEPassagens.integracao.DAOAlbumMusical;
import br.unb.cic.DiariasEPassagens.negocio.Genero;



public class DAOAlbumMusicalJPA implements DAOAlbumMusical{

	

	private EntityManager em;



	@Override

	public void salvar(AlbumMusical album) {

		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		em.getTransaction().begin();

		em.persist(album);

		em.getTransaction().commit();

	}



	@Override

	public List<AlbumMusical> recuperaTodos() {

		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM AlbumMusical").getResultList();

	}



	@Override

	public AlbumMusical recuperaPorTitulo(String titulo) {
		

		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		List<AlbumMusical> albumMusical = em.createQuery("FROM AlbumMusical WHERE titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();

		return albumMusical.size() == 1 ? albumMusical.get(0) : null;

	}



	@Override

	public List<AlbumMusical> recuperaAlbunsPorGenero(String genero) {
		Genero object;
		object = new DAOGeneroJPA().recuperaPorTitulo(genero);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM AlbumMusical WHERE genero = :generoParam").setParameter("generoParam", object).getResultList();

	}



	@Override

	public List<AlbumMusical> recuperaAlbunsPorAutor(String autor) {
		Autor object;
		object = new DAOAutorJPA().recuperaPorNome(autor);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM AlbumMusical WHERE autor = :autorParam").setParameter("autorParam", object).getResultList();
	}



	@Override

	public List<AlbumMusical> recuperaAlbunsPorAno(int ano) {

		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM AlbumMusical WHERE ano = :anoParam").setParameter("anoParam", ano).getResultList();

	}



}