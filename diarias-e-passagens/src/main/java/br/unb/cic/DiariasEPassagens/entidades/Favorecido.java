package br.unb.cic.DiariasEPassagens.entidades;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Favorecido {

	@Id
	@Column(name="favorecidoid")
	private int id;
	
	@Column(name="favorecidonome")
	private String nome;
	
	@Column(name="favorecidocpf")
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name="unigestcod")
	private UnidadeGestora uniGest;
	
	@OneToMany(mappedBy="favorecido")
	private ArrayList<Pagamento> pagamentos;

	public Favorecido(int id, String nome, String cpf, UnidadeGestora uniGest, ArrayList<Pagamento> pagamentos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.uniGest = uniGest;
		this.pagamentos = pagamentos;
	}

	public ArrayList<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(ArrayList<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public UnidadeGestora getUniGest() {
		return uniGest;
	}

	public void setUniGest(UnidadeGestora uniGest) {
		this.uniGest = uniGest;
	}
	
	
}
