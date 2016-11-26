package br.unb.cic.DiariasEPassagens.negocio;

import java.util.List;

import javax.persistence.*;

@Entity
@AttributeOverrides({
@AttributeOverride(name="titulo", column=@Column),
@AttributeOverride(name="anoProducao", column=@Column),
@AttributeOverride(name="genero", column=@Column(name = "genero_id")),
@AttributeOverride(name="autor", column=@Column(name = "autor_id"))
})
public class Filme extends TrabalhoArtistico{
	
	@OneToMany(mappedBy = "filme")
	private List<Avaliacao> nota;
	
	@Column
	private int duracao;

	public Filme(String titulo, int ano,Genero genero,Autor autor,int duracao){
		super(titulo,ano,genero,autor);
		setDuracao(duracao);
	}
	
	public Filme(){
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	

	
	
}