package br.unb.cic.DiariasEPassagens.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="programa")
public class Programa {

	@Id
	@Column(name="progcod")
	private int id;
	
	@Column(name="prognome")
	private String nome;
	
	@OneToMany(mappedBy="programa")
	private List<Acao> acoes;
	
	public Programa(int id, String nome, List<Acao> acoes) {
		this.id = id;
		this.nome = nome;
		this.acoes = acoes;
	}

	public List<Acao> getAcoes() {
		return acoes;
	}

	public void setAcoes(List<Acao> acoes) {
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
