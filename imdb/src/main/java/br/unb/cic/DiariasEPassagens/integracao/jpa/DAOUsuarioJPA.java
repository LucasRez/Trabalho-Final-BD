package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOUsuario;
import br.unb.cic.imdb.negocio.Usuario;


public class DAOUsuarioJPA implements DAOUsuario{
	
	private EntityManager em;

	@Override
	public void salvar(Usuario usuario) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}

	@Override
	public List<Usuario> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Usuario").getResultList();
	}

	@Override
	public Usuario recuperaPorLogin(String login) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Usuario> usuario = em.createQuery("FROM Usuario WHERE login = :loginParam").setParameter("loginParam", login).getResultList();
		return usuario.size() == 1 ? usuario.get(0) : null;
	}

	@Override
	public Usuario recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Usuario> usuario = em.createQuery("FROM Usuario WHERE nome = :nomeParam").setParameter("nomeParam", nome).getResultList();
		return usuario.size() == 1 ? usuario.get(0) : null;
	}

	@Override
	public Usuario recuperaPorSenha(String senha) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Usuario> usuario = em.createQuery("FROM Usuario WHERE senha = :senhaParam").setParameter("senhaParam", senha).getResultList();
		return usuario.size() == 1 ? usuario.get(0) : null;
	}

}