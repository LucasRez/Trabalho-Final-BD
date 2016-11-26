package br.unb.cic.DiariasEPassagens.integracao;
import java.util.List;

import br.unb.cic.DiariasEPassagens.negocio.FaixaMusical;

public interface DAOFaixaMusical {
	public void salvar(FaixaMusical faixaMusical);
	public List<FaixaMusical> recuperaTodos();
	public FaixaMusical recuperaPorTitulo(String titulo);
	public List<FaixaMusical> recuperaFaixasPorAlbum(String album);
	public List<FaixaMusical> recuperaFaixasPorAutor(String autor);
	public List<FaixaMusical> recuperaFaixasPorGenero(String genero);
}