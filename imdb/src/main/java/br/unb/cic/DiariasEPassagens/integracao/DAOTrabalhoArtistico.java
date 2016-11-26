package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.negocio.TrabalhoArtistico;

public interface DAOTrabalhoArtistico {
	public void salvar(TrabalhoArtistico trabalhoArtistico);
	public List<TrabalhoArtistico> recuperaTodos();
	public TrabalhoArtistico recuperaPorTitulo(String trabalhoArtistico);
	public TrabalhoArtistico recuperarPorGenero(String genero);
	public TrabalhoArtistico recuperarPorAutor(String autor);
}	
