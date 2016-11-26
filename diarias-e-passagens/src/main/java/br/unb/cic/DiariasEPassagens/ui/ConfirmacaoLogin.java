package br.unb.cic.DiariasEPassagens.ui;

import br.unb.cic.DiariasEPassagens.integracao.jpa.*;
import br.unb.cic.DiariasEPassagens.negocio.*;
import br.unb.cic.DiariasEPassagens.util.ContextoID;


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