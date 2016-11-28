package br.unb.cic.DiariasEPassagens.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class SubFuncao {

	@Id
	@Column(name="subfunccod")
	private int id;
	
	@Column(name="subfuncnome")
	private String nome;
	
	@ManyToMany(mappedBy="subFuncoes")
	private List<Funcao> funcoes;
 
	public SubFuncao(int id, String nome, List<Funcao> funcoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcoes = funcoes;
	}

	public List<Funcao> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<Funcao> funcoes) {
		this.funcoes = funcoes;
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
	
	
}
