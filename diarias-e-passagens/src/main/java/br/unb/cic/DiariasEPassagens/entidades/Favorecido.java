package br.unb.cic.DiariasEPassagens.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="favorecido")
public class Favorecido {

	@Id
	@Column(name="favorecidoid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="favorecidonome")
	private String nome;
	
	@Column(name="favorecidocpf")
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name="unigestcod")
	private UnidadeGestora uniGest;
	
	@OneToMany(mappedBy="favorecido")
	private List<Pagamento> pagamentos;

	public Favorecido(String nome, String cpf, UnidadeGestora uniGest, List<Pagamento> pagamentos) {
		this.nome = nome;
		this.cpf = cpf;
		this.uniGest = uniGest;
		this.pagamentos = pagamentos;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public int getId() {
		return id;
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
