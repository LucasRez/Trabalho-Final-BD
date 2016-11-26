package br.unb.cic.imdb.ui;

import br.unb.cic.imdb.negocio.*;
import br.unb.cic.imdb.util.ContextoID;
import br.unb.cic.imdb.integracao.jpa.*;


public class ConfirmacaoLogin {

	Usuario usuario;
	IMDBFacade facade = ContextoID.instance().facade();

	public ConfirmacaoLogin(){
	}

	public boolean verificaLoginSenha(String login,String senha){
		if(facade.recuperarUsuarioPorLogin(login)!= null){
			usuario = facade.recuperarUsuarioPorLogin(login);
			if(usuario.getSenha().equals(senha)){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
}