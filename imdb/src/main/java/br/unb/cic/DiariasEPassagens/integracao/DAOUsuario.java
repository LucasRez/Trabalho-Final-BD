package br.unb.cic.DiariasEPassagens.integracao;

import java.util.List;

import br.unb.cic.DiariasEPassagens.negocio.Usuario;

public interface DAOUsuario {
	public void salvar(Usuario usuario);
	public List<Usuario> recuperaTodos();
	public Usuario recuperaPorLogin(String login);
	public Usuario recuperaPorNome(String nome);
	public Usuario recuperaPorSenha(String senha);
}