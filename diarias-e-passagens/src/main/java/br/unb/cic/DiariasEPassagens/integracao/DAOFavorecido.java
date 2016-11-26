package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.negocio.Favorecido;

public interface DAOFavorecido {
	public List<Favorecido> recuperaTodos();
	public Beneficiario recuperaPorNome(String Nome);
	public List<Favorecido> recuperaPorCPF(String CPF);
	public List<Favorecido> recuperaPorPagamValor(String PagamValor);
}
