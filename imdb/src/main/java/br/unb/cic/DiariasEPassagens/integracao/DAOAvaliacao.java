package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.negocio.Avaliacao;
import br.unb.cic.DiariasEPassagens.negocio.Usuario;



public interface DAOAvaliacao {

	public void salvar(Avaliacao avaliacao);

	public List<Avaliacao> recuperaAvaliacoesPorFilme(String filme);

	public List<Avaliacao> recuperaAvaliacoesPorAlbum(String album);

	public Avaliacao recuperaAvaliacaoPorUsuario(Usuario usuario);



}