package br.unb.cic.imdb.cadastro;

import br.unb.cic.imdb.integracao.jpa.*;
import br.unb.cic.imdb.negocio.*;
import br.unb.cic.imdb.util.ContextoID;

public class Cadastro {
	private String loginUsuario;
	private String senhaUsuario;
	private String dataNascimentoUsuario;
	private String nomeUsuario;
	IMDBFacade facade = ContextoID.instance().facade();
	Usuario usuario;
 
	public Cadastro(String nomeUsuario, String dataNascimentoUsuario,String loginUsuario, String senhaUsuario){
			this.loginUsuario = loginUsuario;
			this.nomeUsuario = nomeUsuario;
			this.dataNascimentoUsuario = dataNascimentoUsuario;
			this.senhaUsuario = senhaUsuario;
			usuario = new Usuario(nomeUsuario,loginUsuario,senhaUsuario,dataNascimentoUsuario);
			verificaUsuarioExistente(usuario);
	}	
	
	public void verificaUsuarioExistente(Usuario usuario){
		if(facade.recuperarUsuarioPorLogin(usuario.getLogin()) != null){
			System.out.println("_______________________Usuario ja existe!______________________________");
		}else{
			facade.adicionaUsuario(usuario);
		}
	}
}