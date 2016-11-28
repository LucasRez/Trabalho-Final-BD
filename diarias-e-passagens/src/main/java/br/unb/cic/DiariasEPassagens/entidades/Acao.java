package br.unb.cic.DiariasEPassagens.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="acao")
public class Acao {
	
	@Id
	@Column(name="acaocod")
	private String id;
	
	@Column(name="acaonome")
	private String nome;
	
	@Column(name="lingagem_cidada")
	private String linguagemCidada;
	
	@ManyToOne
	@JoinColumn(name="progcod")
	private Programa programa;

	@OneToMany(targetEntity=Pagamento.class)
	private List<Pagamento> pagamentos;
	
	public Acao(String id, String nome, String linguagemCidada, Programa programa, List<Pagamento> pagamentos) {
		this.id = id;
		this.nome = nome;
		this.linguagemCidada = linguagemCidada;
		this.programa = programa;
		this.pagamentos = pagamentos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLinguagemCidada() {
		return linguagemCidada;
	}

	public void setLinguagemCidada(String linguagemCidada) {
		this.linguagemCidada = linguagemCidada;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	
	
}
