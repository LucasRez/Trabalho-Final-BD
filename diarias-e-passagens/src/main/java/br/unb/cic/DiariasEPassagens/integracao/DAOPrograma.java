package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.negocio.Programa;

public interface DAOPrograma {
	public List<Programa> recuperaTodos();
	public Programa recuperaPorID(String id);
	public Programa recuperaPorNome(String nome);
}
