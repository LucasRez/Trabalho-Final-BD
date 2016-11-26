package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.negocio.Autor;



public interface DAOAutor {

	public void salvar(Autor autor);

	public List<Autor> recuperaTodos();

	public Autor recuperaPorNome(String nome);

	public List<Autor> recuperaAutoresPorTrabalhoArtistico(String trabalho);

	public List<Autor> recuperaAutoresPorGenero(String genero);

}