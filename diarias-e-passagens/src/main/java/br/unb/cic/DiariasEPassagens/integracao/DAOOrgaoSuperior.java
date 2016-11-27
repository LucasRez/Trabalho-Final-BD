package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.entidades.OrgaoSuperior;

public interface DAOOrgaoSuperior{
	public List<OrgaoSuperior> recuperaTodos();
	public OrgaoSuperior recuperaPorID(int id);
	public OrgaoSuperior recuperaPorNome(String nome);
}