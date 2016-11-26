package br.unb.cic.imdb.integracao;

import br.unb.cic.imdb.negocio.AlbumMusical;

import java.util.List;



public interface DAOAlbumMusical {

	public void salvar(AlbumMusical album);

	public List<AlbumMusical> recuperaTodos();

	public AlbumMusical recuperaPorTitulo(String titulo);

	public List<AlbumMusical> recuperaAlbunsPorGenero(String genero);

	public List<AlbumMusical> recuperaAlbunsPorAutor(String autor);

	public List<AlbumMusical> recuperaAlbunsPorAno(int ano);

}