package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.negocio.OrgaoSuperior;

public interface DAOPrograma {
	public List<OrgaoSuperior> recuperaTodos();
	public OrgaoSuperior recuperaPorID(String id);
	public OrgaoSuperior recuperaPorNome(String nome);
}