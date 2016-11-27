package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.entidades.Programa;

public interface DAOPrograma {
	public List<Programa> recuperaTodos();
	public Programa recuperaPorID(int id);
	public Programa recuperaPorNome(String nome);
}
