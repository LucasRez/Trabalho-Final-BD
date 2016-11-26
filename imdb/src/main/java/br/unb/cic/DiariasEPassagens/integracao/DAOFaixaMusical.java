package br.unb.cic.imdb.integracao;
import br.unb.cic.imdb.negocio.FaixaMusical;
import java.util.List;

public interface DAOFaixaMusical {
	public void salvar(FaixaMusical faixaMusical);
	public List<FaixaMusical> recuperaTodos();
	public FaixaMusical recuperaPorTitulo(String titulo);
	public List<FaixaMusical> recuperaFaixasPorAlbum(String album);
	public List<FaixaMusical> recuperaFaixasPorAutor(String autor);
	public List<FaixaMusical> recuperaFaixasPorGenero(String genero);
}