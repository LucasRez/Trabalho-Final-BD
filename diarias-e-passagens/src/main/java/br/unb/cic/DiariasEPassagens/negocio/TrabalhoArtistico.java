package br.unb.cic.DiariasEPassagens.negocio;

import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "TB_TRABALHO_ARTISTICO")
public class TrabalhoArtistico {

	@Id
	@GeneratedValue
	private Long id; 
	
	@Column
	private String titulo;
	
	@Column
	private int ano;
	
	@ManyToOne
	private Genero genero;
	
	@ManyToOne
	private Autor autor;

	public TrabalhoArtistico(String titulo, int ano,Genero genero,Autor autor) {
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.autor = autor;
	}
	
	public TrabalhoArtistico() {
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
