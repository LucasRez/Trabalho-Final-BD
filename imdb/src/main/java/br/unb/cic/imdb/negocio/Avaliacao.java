package br.unb.cic.imdb.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.unb.cic.imdb.negocio.*;
@Entity
public class Avaliacao {
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Filme filme;
	
	@ManyToOne
	private AlbumMusical album;
	
	@Column
	private int avaliacao;
	
	@Column
	private String comentario;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	public Avaliacao(){
		
	}
	
	public Avaliacao(int avaliacao, String comentario){
		this.avaliacao = avaliacao;
		this.comentario = comentario;
	}
	
	public long getId(){
		return id;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Filme getFilme() {
		return filme;
	}


	public void setFilme(Filme filme) {
		this.filme = filme;
	}


	public AlbumMusical getAlbum() {
		return album;
	}


	public void setAlbum(AlbumMusical album) {
		this.album = album;
	}


	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}