package br.unb.cic.DiariasEPassagens.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@AttributeOverrides({
@AttributeOverride(name="titulo", column=@Column),
@AttributeOverride(name="anoProducao", column=@Column),
@AttributeOverride(name="genero", column=@Column(name = "genero_id")),
@AttributeOverride(name="autor", column=@Column(name = "autor_id"))
})
public class AlbumMusical extends TrabalhoArtistico{
	
	@OneToMany(mappedBy = "album")
	private List<Avaliacao> nota;
	
	@OneToMany(mappedBy = "Album")
	List<FaixaMusical> listaFaixas = new ArrayList<FaixaMusical>();
	
	
	public AlbumMusical(String titulo, int ano,Genero genero,Autor autor){
		super(titulo,ano,genero,autor);
	}
	
	public AlbumMusical(){
	}
	
	public void adicionaFaixaMusical(FaixaMusical faixa){
		listaFaixas.add(faixa);
	}
	public List<FaixaMusical> getAlbumMusical(){
		return listaFaixas;
	}
	public void setAlbumMusical(ArrayList<FaixaMusical> albumMusical){
		this.listaFaixas = albumMusical;
	}
	
}