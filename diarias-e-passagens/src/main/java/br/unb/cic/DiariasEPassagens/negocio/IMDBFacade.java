package br.unb.cic.DiariasEPassagens.negocio;

import java.util.List;

import br.unb.cic.DiariasEPassagens.integracao.DAOAlbumMusical;
import br.unb.cic.DiariasEPassagens.integracao.DAOAutor;
import br.unb.cic.DiariasEPassagens.integracao.DAOAvaliacao;
import br.unb.cic.DiariasEPassagens.integracao.DAOFactory;
import br.unb.cic.DiariasEPassagens.integracao.DAOFaixaMusical;
import br.unb.cic.DiariasEPassagens.integracao.DAOFavorecido;
import br.unb.cic.DiariasEPassagens.integracao.DAOUnidadeGestora;
import br.unb.cic.DiariasEPassagens.integracao.DAOFuncao;
import br.unb.cic.DiariasEPassagens.integracao.DAOUsuario;
import br.unb.cic.DiariasEPassagens.integracao.DAOFactory.DataBase;

/**
 * Classe de fachada (Facade class) que vai servir de comunicacao 
 * entre a camada de apresentacao (ui) e a camada de negocio. Caso 
 * se torne excessivamente complexa, essa classe deve ser sub-dividida.
 *  
 * @author rbonifacio
 */
public class IMDBFacade {
	
	private DAOUnidadeGestora daoGenero;
	private DAOFuncao daoTrabalhoArtistico;
	private DAOFavorecido daoFilme;
	private DAOFaixaMusical daoFaixaMusical;
	private DAOAutor daoAutor;
	private DAOAlbumMusical daoAlbumMusical;
	private DAOUsuario daoUsuario;
	private DAOAvaliacao daoAvaliacao;

	//public IMDBFacade() {}
	
	//Usando o Spring Framework, o construtor declarado 
	//nas proximas linhas se torna desnecessario, uma vez 
	//que o proprio Spring injeta as implementacoes corretas das classes DAOs. 
	
	public IMDBFacade() {
			daoGenero = DAOFactory.instance(DataBase.SQLDB).createDAOGenero();
			daoTrabalhoArtistico = DAOFactory.instance(DataBase.SQLDB).createDAOTrabalhoArtistico();
			daoFilme = DAOFactory.instance(DataBase.SQLDB).createDAOFilme();
			daoFaixaMusical = DAOFactory.instance(DataBase.SQLDB).createDAOFaixaMusical();
			daoAutor = DAOFactory.instance(DataBase.SQLDB).createDAOAutor();
			daoAlbumMusical = DAOFactory.instance(DataBase.SQLDB).createDAOAlbumMusical();
			daoUsuario = DAOFactory.instance(DataBase.SQLDB).createDAOUsuario();
			daoAvaliacao = DAOFactory.instance(DataBase.SQLDB).createDAOAvaliacao();
	}
	
	//Avaliacao
	public void adicionaAvaliacao(Avaliacao avaliacao){
		//if(recuperarAvaliacaoPorUsuario(avaliacao.getUsuario()) == null){
			daoAvaliacao.salvar(avaliacao);
		//}else{
		//	throw new IllegalArgumentException();
		//}
	}
	
	public List<Avaliacao> recuperarAvaliacoesPorFilme(String filme){
		return daoAvaliacao.recuperaAvaliacoesPorFilme(filme);
	}
	
	public List<Avaliacao> recuperarAvaliacoesPorAlbum(String album){
		return daoAvaliacao.recuperaAvaliacoesPorAlbum(album);
	}
	
	public Avaliacao recuperarAvaliacaoPorUsuario(Usuario usuario){
		return daoAvaliacao.recuperaAvaliacaoPorUsuario(usuario);
	}
	
	//Genero
	public void adicionaGenero(Genero genero) {
		if(recuperarPorTitulo(genero.getTitulo()) == null) {
			daoGenero.salvar(genero);
		}
		else { 
			throw new IllegalArgumentException();
		}
	}

	public List<Genero> recuperarGeneros() {
		return daoGenero.recuperaTodos();
	}

	public Genero recuperarPorTitulo(String titulo) {
		return daoGenero.recuperaPorTitulo(titulo);
	}
	
	public void setDaoGenero(DAOUnidadeGestora daoGenero) {
		this.daoGenero = daoGenero;
	}
	
	//TrabalhoArtistico
	public void adicionaTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico){
		if(recuperarTrabalhoArtisticoPorTitulo(trabalhoArtistico.getTitulo()) == null){
			daoTrabalhoArtistico.salvar(trabalhoArtistico);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	public List<TrabalhoArtistico> recuperarTrabalhosArtisticos() {
		return daoTrabalhoArtistico.recuperaTodos();
	}

	public TrabalhoArtistico recuperarTrabalhoArtisticoPorTitulo(String titulo) {
		return daoTrabalhoArtistico.recuperaPorTitulo(titulo);
	}
	
	public TrabalhoArtistico recuperarTrabalhoArtisticoPorGenero(String genero) {
		return daoTrabalhoArtistico.recuperarPorGenero(genero);
	}
	
	public TrabalhoArtistico recuperarTrabalhoArtisticoPorAutor(String autor) {
		return daoTrabalhoArtistico.recuperarPorAutor(autor);
	}
	
	public void setDaoTrabalhoArtistico(DAOFuncao daoTrabalhoArtistico) {
		this.daoTrabalhoArtistico = daoTrabalhoArtistico;
	}
	
	//Filme
	public void adicionaFilme(Filme filme){
		if(recuperarFilmePorTitulo(filme.getTitulo()) == null){
			daoFilme.salvar(filme);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	public List<Filme> recuperarFilme() {
		return daoFilme.recuperaTodos();
	}

	public Filme recuperarFilmePorTitulo(String titulo) {
		return daoFilme.recuperaPorTitulo(titulo);
	}
	
	public List<Filme> recuperarFilmePorGenero(String genero) {
		return daoFilme.recuperaPorGenero(genero);
	}
	
	public List<Filme> recuperarFilmePorAutor(String autor) {
		return daoFilme.recuperaPorAutor(autor);
	}
	
	public void setDaoFilme(DAOFavorecido daoFilme) {
		this.daoFilme = daoFilme;
	}
	
	//FaixaMusical
	public void adicionaFaixaMusical(FaixaMusical faixaMusical){
		if(recuperarFaixaMusicalPorTitulo(faixaMusical.getTitulo()) == null){
			daoFaixaMusical.salvar(faixaMusical);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	public List<FaixaMusical> recuperarFaixaMusical() {
		return daoFaixaMusical.recuperaTodos();
	}

	public FaixaMusical recuperarFaixaMusicalPorTitulo(String titulo) {
		return daoFaixaMusical.recuperaPorTitulo(titulo);
	}
	
	public List<FaixaMusical> recuperarFaixaMusicalporGenero(String genero) {
		return daoFaixaMusical.recuperaFaixasPorGenero(genero);
	}
	
	public List<FaixaMusical> recuperarFaixaMusicalPorAutor(String autor) {
		return daoFaixaMusical.recuperaFaixasPorAutor(autor);
	}
	
	public List<FaixaMusical> recuperarFaixaMusicalPorAlbum(String album){
		return daoFaixaMusical.recuperaFaixasPorAlbum(album);
	}
	
	public void setDaoFaixaMusical(DAOFaixaMusical daoFaixaMusical) {
		this.daoFaixaMusical = daoFaixaMusical;
	}
	
	//Autor
	public void adicionaAutor(Autor autor){
		if(recuperarAutorPorNome(autor.getNome()) == null){
			daoAutor.salvar(autor);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	public List<Autor> recuperarAutor() {
		return daoAutor.recuperaTodos();
	}

	public Autor recuperarAutorPorNome(String nome) {
		return daoAutor.recuperaPorNome(nome);
	}
	
	public List<Autor> recuperarAutoresPorGenero(String genero) {
		return daoAutor.recuperaAutoresPorGenero(genero);
	}
	
	public List<Autor> recuperarAutoresPorTrabalhoArtistico(String trabalho) {
		return daoAutor.recuperaAutoresPorTrabalhoArtistico(trabalho);
	}
	
	public void setDaoAutor(DAOAutor daoAutor) {
		this.daoAutor = daoAutor;
	}
	
	//AlbumMusical
	public void adicionaAlbumMusical(AlbumMusical album){
		if(recuperarAlbumMusicalPorTitulo(album.getTitulo()) == null){
			daoAlbumMusical.salvar(album);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	public List<AlbumMusical> recuperarAlbumMusical() {
		return daoAlbumMusical.recuperaTodos();
	}

	public AlbumMusical recuperarAlbumMusicalPorTitulo(String titulo) {
		return daoAlbumMusical.recuperaPorTitulo(titulo);
	}
	
	public List<AlbumMusical> recuperarAlbunsMusicalPorGenero(String genero) {
		return daoAlbumMusical.recuperaAlbunsPorGenero(genero);
	}
	
	public List<AlbumMusical> recuperarAlbunsMusicalPorAutor(String autor) {
		return daoAlbumMusical.recuperaAlbunsPorAutor(autor);
	}
	
	public List<AlbumMusical> recuperarAlbunsMusicalPorAno(int ano) {
		return daoAlbumMusical.recuperaAlbunsPorAno(ano);
	}
	
	public void setDaoAlbumMusical(DAOAlbumMusical daoAlbumMusical) {
		this.daoAlbumMusical = daoAlbumMusical;
	}
	
	//Usuario
	public void adicionaUsuario(Usuario usuario){
		if(recuperarUsuarioPorLogin(usuario.getLogin()) == null){
			daoUsuario.salvar(usuario);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	public List<Usuario> recuperarUsuario() {
		return daoUsuario.recuperaTodos();
	}

	public Usuario recuperarUsuarioPorNome(String nome) {
		return daoUsuario.recuperaPorNome(nome);
	}
	
	public Usuario recuperarUsuarioPorLogin(String login) {
		return daoUsuario.recuperaPorLogin(login);
	}
	
	public Usuario recuperarUsuarioPorSenha(String senha){
		return daoUsuario.recuperaPorSenha(senha);
	}
	
	public void setDaoUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
}