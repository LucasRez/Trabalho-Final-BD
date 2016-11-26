package br.unb.cic.DiariasEPassagens.entidades;

public class Acao {
	
	private String cod;
	
	private String nome;
	
	private String linguagemCidada;
	
	private Programa programa;

	
	
	public Acao(String cod, String nome, String linguagemCidada, Programa programa) {
		this.cod = cod;
		this.nome = nome;
		this.linguagemCidada = linguagemCidada;
		this.programa = programa;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLinguagemCidada() {
		return linguagemCidada;
	}

	public void setLinguagemCidada(String linguagemCidada) {
		this.linguagemCidada = linguagemCidada;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	
	
}
