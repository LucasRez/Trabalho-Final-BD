package br.unb.cic.DiariasEPassagens.entidades;

public class OrgaoSubordinado {

	private int id;
	
	private String nome;
	
	private OrgaoSuperior orgSup;

	public OrgaoSubordinado(int id, String nome, OrgaoSuperior orgSup) {
		this.id = id;
		this.nome = nome;
		this.orgSup = orgSup;
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
