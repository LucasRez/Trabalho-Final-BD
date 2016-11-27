package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.negocio.acao;



public interface DAOAcao {
	
	public List<Acao> recuperaTodos();
	public acao recuperaPorNome(String nome);
	public acao recuperaPorId(String id);
	public acao recuperaPorLinguagemCidada(String linguagemCidada);
	public List<Acao> recuperaAcoesPorPrograma(String programa);

}