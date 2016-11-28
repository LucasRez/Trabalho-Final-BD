package br.unb.cic.DiariasEPassagens.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="funcao")
public class Funcao {

	@Id
	@Column(name="funccod")
	private int id;
	
	@Column(name="funcnome")
	private String nome;
	
	@ManyToMany
	@JoinTable(name="possui")
	private List<SubFuncao> subFuncoes;
	
	@ManyToMany(mappedBy="funcoes")
	private List<UnidadeGestora> uniGests;

	public Funcao(int id, String nome) {
		this.id = id;
		this.nome = nome;
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
