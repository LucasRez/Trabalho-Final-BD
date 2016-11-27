package br.unb.cic.DiariasEPassagens.entidades;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class OrgaoSuperior {

	@Id
	@Column(name="orgsupcod")
	private int id;
	
	@Column(name="orgsupnome")
	private String nome;
	
	@OneToMany(mappedBy="orgSup")
	private ArrayList<OrgaoSubordinado> orgSubs;

	public OrgaoSuperior(int id, String nome, ArrayList<OrgaoSubordinado> orgSubs) {
		super();
		this.id = id;
		this.nome = nome;
		this.orgSubs = orgSubs;
	}

	public ArrayList<OrgaoSubordinado> getOrgSubs() {
		return orgSubs;
	}

	public void setOrgSubs(ArrayList<OrgaoSubordinado> orgSubs) {
		this.orgSubs = orgSubs;
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
