package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.entidades.Pagamento;
import br.unb.cic.DiariasEPassagens.entidades.SubFuncao;


public interface DAOPagamento {
	public Pagamento recuperaPorData(String data);
	public Pagamento recuperaPorValor(String valor);
	public Pagamento recuperaPorID(int id);
	public Pagamento recuperaPorGestao(int gestaocod);
	public List<Pagamento> recuperaPagamentosPorAcao(String acao);
	public List<Pagamento> recuperaPagamentosPorFavorecido(String favorecido);
}