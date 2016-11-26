package br.unb.cic.imdb.integracao.jpa;

import java.util.List;



import javax.persistence.EntityManager;



import br.unb.cic.imdb.integracao.DAOAvaliacao;
import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.Autor;

import br.unb.cic.imdb.negocio.Avaliacao;
import br.unb.cic.imdb.negocio.Filme;
import br.unb.cic.imdb.negocio.Usuario;


public class DAOAvaliacaoJPA implements DAOAvaliacao{

	private EntityManager em;



	@Override
	public void salvar(Avaliacao avaliacao) {

		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		em.getTransaction().begin();

		em.persist(avaliacao);

		em.getTransaction().commit();

	}



	@Override
	public List<Avaliacao> recuperaAvaliacoesPorFilme(String filme) {
		Filme object;
		object = new DAOFilmeJPA().recuperaPorTitulo(filme);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM Avaliacao WHERE filme = :filmeParam").setParameter("filmeParam", object).getResultList();
	}



	@Override
	public List<Avaliacao> recuperaAvaliacoesPorAlbum(String album) {
		AlbumMusical object;
		object = new DAOAlbumMusicalJPA().recuperaPorTitulo(album);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM Avaliacao WHERE album = :albumParam").setParameter("albumParam", object).getResultList();

	}



	@Override
	public Avaliacao recuperaAvaliacaoPorUsuario(Usuario usuario) {

		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		List<Avaliacao> avaliacao = em.createQuery("FROM Avaliacao WHERE usuario = :usuarioParam").setParameter("usuarioParam", usuario).getResultList();

		return avaliacao.size() == 1 ? avaliacao.get(0): null;

	}



}