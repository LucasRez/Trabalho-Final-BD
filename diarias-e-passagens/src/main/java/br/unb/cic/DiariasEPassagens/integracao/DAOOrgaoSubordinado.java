package br.unb.cic.DiariasEPassagens.integracao;
import java.util.List;

import br.unb.cic.DiariasEPassagens.entidades.OrgaoSubordinado;

public interface DAOOrgaoSubordinado {
	public List<OrgaoSubordinado> recuperaTodos();
	public List<OrgaoSubordinado> recuperaPorOrgaoSuperior(String orgaoSuperior);
	public OrgaoSubordinado recuperaPorNome(String nome);
	public OrgaoSubordinado recuperaPorID(int id);
}