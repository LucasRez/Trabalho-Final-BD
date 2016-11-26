package br.unb.cic.DiariasEPassagens.entidades;

public class Favorecido {

	private int id;
	
	private String nome;
	
	private String cpf;
	
	private UnidadeGestora uniGest;

	public Favorecido(int id, String nome, String cpf, UnidadeGestora uniGest) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.uniGest = uniGest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public UnidadeGestora getUniGest() {
		return uniGest;
	}

	public void setUniGest(UnidadeGestora uniGest) {
		this.uniGest = uniGest;
	}
	
	
}
