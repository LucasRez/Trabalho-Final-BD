package br.unb.cic.DiariasEPassagens.integracao;


public interface DAOQuery {
	
	public void recuperaQualServidorGastouMais();
	public void recuperaListaGastoTotaisDecres();
	public void recuperaListaGastoTotaisCresc();
	public void recuperaQualOrgSupGastouMais();
	public void recuperaQualAcaoGastouMais();
	public void recuperaQualProgramaGastouMais();
	public void recuperaGastoPorCpf(String CPF);
	public void recuperaGastoPorNome(String nome);
	public void recuperaCodPagamGastouMais();
	public void recuperaGastoTotal();
	public void recuperaProgramadeAcaoGastouMais(String acaoNome);
	
}
