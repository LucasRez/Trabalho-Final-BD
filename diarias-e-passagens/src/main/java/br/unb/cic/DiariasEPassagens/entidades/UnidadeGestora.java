package br.unb.cic.DiariasEPassagens.entidades;

public class UnidadeGestora {

	private int id;
	
	private String nome;
	
	private OrgaoSubordinado orgSub;

	public UnidadeGestora(int id, String nome, OrgaoSubordinado orgSub) {
		this.id = id;
		this.nome = nome;
		this.orgSub = orgSub;
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
