package br.unb.cic.imdb.integracao;

import br.unb.cic.imdb.negocio.Avaliacao;

import br.unb.cic.imdb.negocio.Usuario;



import java.util.List;



public interface DAOAvaliacao {

	public void salvar(Avaliacao avaliacao);

	public List<Avaliacao> recuperaAvaliacoesPorFilme(String filme);

	public List<Avaliacao> recuperaAvaliacoesPorAlbum(String album);

	public Avaliacao recuperaAvaliacaoPorUsuario(Usuario usuario);



}