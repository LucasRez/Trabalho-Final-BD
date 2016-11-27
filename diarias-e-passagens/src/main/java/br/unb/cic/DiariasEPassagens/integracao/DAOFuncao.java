package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.entidades.Funcao;


public interface DAOFuncao {
	public List<Funcao> recuperaTodos();
	public List<Funcao> recuperaPorUnidadeGestora(String unidadeGestora);
 	public Funcao recuperaPorNome(String nome);
	public Funcao recuperarPorID(int id);
}	
