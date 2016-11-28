package br.unb.cic.DiariasEPassagens.entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Pagamento {

	//TODO: consolidar classe pagamento
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="favorecidoid")
	private int id;
	
	@Column(name="pagamcod")
	private String codigo;
	
	@Column(name="pagamdata")
	private String data;
	
	@Column(name="pagamvalor")
	private String valor;
	
	@Column(name="pagamgestcod")
	private int gestCod;
	
	@ManyToOne
	@JoinColumn(name="favorecidocpf", referencedColumnName="favorecidocpf", nullable=false)
	private Favorecido favorecido;
	
	@ManyToOne(targetEntity=Acao.class)
	@JoinColumn(name="acaocod", nullable=false, referencedColumnName="acaocod")
	private Acao acaoPag;

	public Pagamento(int id, String codigo, String data, String valor, int gestCod, Favorecido favorecido, Acao acao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.data = data;
		this.valor = valor;
		this.gestCod = gestCod;
		this.favorecido = favorecido;
		this.acaoPag = acao;
	}
	
	public int getId() {
		return id;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getGestCod() {
		return gestCod;
	}

	public void setGestCod(int gestCod) {
		this.gestCod = gestCod;
	}

	public Favorecido getFavorecido() {
		return favorecido;
	}

	public void setFavorecido(Favorecido favorecido) {
		this.favorecido = favorecido;
	}

	public Acao getAcao() {
		return acaoPag;
	}

	public void setAcao(Acao acao) {
		this.acaoPag = acao;
	}	
	
}
