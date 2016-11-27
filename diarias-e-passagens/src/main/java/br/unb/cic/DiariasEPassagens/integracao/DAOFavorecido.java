package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.negocio.Favorecido;

public interface DAOFavorecido {
	public List<Favorecido> recuperaTodos();
	public Favorecido recuperaPorNome(String nome);
	public Favorecido recuperaPorCPF(String CPF);
	public Favorecido recuperaPorPagamValor(String pagamValor);
	public List<Favorecido> recuperaPorUnidadeGestora(String unidadeGestora);
	public List<Favorecido> recuperaPorPagamento(String pagamento);
}
