package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.negocio.Genero;

public interface DAOUnidadeGestora {
	public List<UnidadeGestora> recuperaTodos();
	public UnidadeGestora recuperaPorNome(String nome);
	public UnidadeGestora recuperaPorID(String id);
	public List<UnidadeGestora> recuperaPorOrgaoSubordinado(String orgaoSubordinado);
	public UnidadeGestora recuperaPorFuncao(String funcao);
}