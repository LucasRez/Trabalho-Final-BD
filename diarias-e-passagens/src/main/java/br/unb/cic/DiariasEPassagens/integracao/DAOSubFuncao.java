package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.entidades.SubFuncao;



public interface DAOSubFuncao {

	public List<SubFuncao> recuperaTodos();
	public SubFuncao recuperaPorNome(String nome);
	public SubFuncao recuperaPorID(int id);
	public List<SubFuncao> recuperaSubFuncaoPorFuncao(String funcao);

}