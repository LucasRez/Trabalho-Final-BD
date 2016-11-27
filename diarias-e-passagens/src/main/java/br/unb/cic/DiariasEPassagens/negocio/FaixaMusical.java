package br.unb.cic.DiariasEPassagens.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.unb.cic.DiariasEPassagens.entidades.AlbumMusical;

@Entity
public class FaixaMusical{
	
	@Column
	private String titulo;
	
	@Column
	private int duracao;
	
	@ManyToOne
	private AlbumMusical Album;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	FaixaMusical(String titulo, int duracao, AlbumMusical album){
		this.titulo = titulo;
		this.duracao = duracao;
		this.Album = album;
	}
	public FaixaMusical(){
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public void setAlbumMusical(AlbumMusical album){
		this.Album = album;
	}
	public AlbumMusical getAlbumMusical(){
		return Album;
	}
	public long getId(){
		return id;
	}
	
}
