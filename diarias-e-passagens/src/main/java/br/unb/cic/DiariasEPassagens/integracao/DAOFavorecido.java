package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.entidades.Favorecido;

public interface DAOFavorecido {
	public List<Favorecido> recuperaTodos();
	public Favorecido recuperaPorNome(String nome);
	public Favorecido recuperaPorCPF(String CPF);
	public Favorecido recuperaPorId(int id);
	public List<Favorecido> recuperaPorUnidadeGestora(String unidadeGestora);
	public Favorecido recuperaPorPagamento(int pagamentoId);
}
