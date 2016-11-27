package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.negocio.SubFuncao;



public interface DAOSubFuncao {

	public List<SubFuncao> recuperaTodos();
	public SubFuncao recuperaPorNome(String nome);
	public SubFuncao recuperaPorID(String id);
	public List<SubFuncao> recuperaSubFuncaoPorTrabalhoArtistico(String trabalho);
	public List<SubFuncao> recuperaSubFuncaoPorGenero(String genero);

}