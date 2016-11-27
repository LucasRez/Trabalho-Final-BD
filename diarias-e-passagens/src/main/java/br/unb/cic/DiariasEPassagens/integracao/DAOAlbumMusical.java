package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.entidades.AlbumMusical;



public interface DAOAlbumMusical {

	public void salvar(AlbumMusical album);

	public List<AlbumMusical> recuperaTodos();

	public AlbumMusical recuperaPorTitulo(String titulo);

	public List<AlbumMusical> recuperaAlbunsPorGenero(String genero);

	public List<AlbumMusical> recuperaAlbunsPorAutor(String autor);

	public List<AlbumMusical> recuperaAlbunsPorAno(int ano);

}