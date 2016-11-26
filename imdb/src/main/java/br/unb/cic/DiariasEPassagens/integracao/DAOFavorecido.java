package br.unb.cic.imdb.integracao;

import java.util.List;
import br.unb.cic.imdb.negocio.Filme;

public interface DAOFilme {
	public void salvar(Filme filme);
	public List<Filme> recuperaTodos();
	public Filme recuperaPorTitulo(String titulo);
	public List<Filme> recuperaPorGenero(String genero);
	public List<Filme> recuperaPorAutor(String autor);
}
