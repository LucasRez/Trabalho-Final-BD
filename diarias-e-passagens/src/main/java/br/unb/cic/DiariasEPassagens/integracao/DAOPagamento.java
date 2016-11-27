package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.negocio.Pagamento;
import br.unb.cic.DiariasEPassagens.negocio.Acao;
import br.unb.cic.DiariasEPassagens.negocio.Favorecido;


public interface DAOPagamento {
	public SubFuncao recuperaPorData(String data);
	public SubFuncao recuperaPorValor(String valor);
	public SubFuncao recuperaPorNome(String nome);
	public SubFuncao recuperaPorID(String id);
	public List<Pagamento> recuperaPagamentosPorAcao(String acao);
	public List<Pagamento> recuperaPagamentosPorFavorecido(String favorecido);

}