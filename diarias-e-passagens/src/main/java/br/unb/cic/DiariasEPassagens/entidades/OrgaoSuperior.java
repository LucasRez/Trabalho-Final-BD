package br.unb.cic.DiariasEPassagens.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orgao_superior")
public class OrgaoSuperior {

	@Id
	@Column(name="orgsupcod")
	private int id;
	
	@Column(name="orgsupnome")
	private String nome;
	
	@OneToMany(mappedBy="orgSuperior")
	private List<OrgaoSubordinado> orgSubs;

	public OrgaoSuperior(int id, String nome, List<OrgaoSubordinado> orgSubs) {
		super();
		this.id = id;
		this.nome = nome;
		this.orgSubs = orgSubs;
	}

	public List<OrgaoSubordinado> getOrgSubs() {
		return orgSubs;
	}

	public void setOrgSubs(List<OrgaoSubordinado> orgSubs) {
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
