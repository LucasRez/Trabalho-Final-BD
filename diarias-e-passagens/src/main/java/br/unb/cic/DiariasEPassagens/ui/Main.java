package br.unb.cic.DiariasEPassagens.ui;

import br.unb.cic.DiariasEPassagens.entidades.OrgaoSuperior;
import br.unb.cic.DiariasEPassagens.negocio.Facade;

public class Main {

	public static void main(String[] args) {
		Facade facade = new Facade();
		
		OrgaoSuperior orgSup;
		
		orgSup = facade.recuperaOrgSupPorNome("PRESIDENCIA DA REPUBLICA");
		
		System.out.println(orgSup.getNome());
	}

}
