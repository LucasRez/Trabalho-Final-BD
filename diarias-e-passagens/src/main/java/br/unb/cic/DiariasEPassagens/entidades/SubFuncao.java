package br.unb.cic.DiariasEPassagens.entidades;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class SubFuncao {

	@Id
	@Column(name="subfunccod")
	private int id;
	
	@Column(name="subfuncnome")
	private String nome;
	
	@ManyToMany(mappedBy="subFuncoes")
	private ArrayList<Funcao> funcoes;
 
	public SubFuncao(int id, String nome, ArrayList<Funcao> funcoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcoes = funcoes;
	}

	public ArrayList<Funcao> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(ArrayList<Funcao> funcoes) {
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
