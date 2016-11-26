package br.unb.cic.DiariasEPassagens.negocio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario{
	
	@OneToMany(mappedBy = "usuario")
	private List<Avaliacao> nota;
	
	@Column
	private String login;
	
	@Column
	private String senha;
	
	@Column
	private String nome;
	
	@Column
	private String dataNascimento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public Usuario(String nome, String login, String senha, String dataNascimento){
		setLogin(login);
		setSenha(senha);
		setNome(nome);
		setDataNascimento(dataNascimento);	
	}
	
	public Usuario(){
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	/*public void Avaliar(int avaliacao, String comentario){
		//TODO: pensar um jeito para depois nao permitir que o usuario de uma avaliacao maior que 5 ou menor que 1
			trabalhoArtistico.setAvaliacao(avaliacao);
			trabalhoArtistico.setComentario(comentario);
	}*/
	
}
