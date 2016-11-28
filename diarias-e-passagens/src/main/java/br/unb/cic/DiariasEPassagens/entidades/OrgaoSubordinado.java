package br.unb.cic.DiariasEPassagens.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class OrgaoSubordinado {

	@Id
	@Column(name="orgsubcod")
	private int id;
	
	@Column(name="orgsubnome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="orgsupcod", nullable=false)
	private OrgaoSuperior orgSup;
	
	@OneToMany(mappedBy="orgSub")
	private List<UnidadeGestora> uniGests;

	public OrgaoSubordinado(int id, String nome, OrgaoSuperior orgSup, List<UnidadeGestora> uniGests) {
		super();
		this.id = id;
		this.nome = nome;
		this.orgSup = orgSup;
		this.uniGests = uniGests;
	}

	public List<UnidadeGestora> getUniGests() {
		return uniGests;
	}

	public void setUniGests(List<UnidadeGestora> uniGests) {
		this.uniGests = uniGests;
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

	public OrgaoSuperior getOrgSup() {
		return orgSup;
	}

	public void setOrgSup(OrgaoSuperior orgSup) {
		this.orgSup = orgSup;
	}
	
	
}
