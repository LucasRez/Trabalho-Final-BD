package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.entidades.Acao;



public interface DAOAcao {
	
	public List<Acao> recuperaTodos();
	public Acao recuperaPorNome(String nome);
	public Acao recuperaPorId(String id);
	public Acao recuperaPorLinguagemCidada(String linguagemCidada);
	public List<Acao> recuperaAcoesPorPrograma(String programa);

}