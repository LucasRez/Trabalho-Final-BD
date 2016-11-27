package br.unb.cic.DiariasEPassagens.entidades;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Programa {

	@Id
	@Column(name="progcod")
	private int id;
	
	@Column(name="prognome")
	private String nome;
	
	@OneToMany(mappedBy="programa")
	private ArrayList<Acao> acoes;
	
	public Programa(int id, String nome, ArrayList<Acao> acoes) {
		this.id = id;
		this.nome = nome;
		this.acoes = acoes;
	}

	public ArrayList<Acao> getAcoes() {
		return acoes;
	}

	public void setAcoes(ArrayList<Acao> acoes) {
		this.acoes = acoes;
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
