package br.unb.cic.DiariasEPassagens.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="unidade_gestora")
public class UnidadeGestora {

	@Id
	@Column(name="unigestcod")
	private int id;
	
	@Column(name="unigestnome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="orgsubcod", nullable=false)
	private OrgaoSubordinado orgSub;
	
	@ManyToMany
	@JoinTable(name="exerce")
	private List<Funcao> funcoes;

	public UnidadeGestora(int id, String nome, OrgaoSubordinado orgSub, List<Funcao> funcoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.orgSub = orgSub;
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

	public OrgaoSubordinado getOrgSub() {
		return orgSub;
	}

	public void setOrgSub(OrgaoSubordinado orgSub) {
		this.orgSub = orgSub;
	}
	
	
}
