package br.unb.cic.DiariasEPassagens.negocio;

import br.unb.cic.DiariasEPassagens.negocio.IMDBFacade;
import br.unb.cic.DiariasEPassagens.negocio.Usuario;
import br.unb.cic.DiariasEPassagens.util.ContextoID;
import junit.framework.TestCase;

public class IMDBFacadeTest5 extends TestCase {

	 public void testeAdicionaUsuario() {
		  try {
		   IMDBFacade facade = ContextoID.instance().facade();
		  
		   Usuario user = new Usuario("Rodrigo Bonifácio","Rbonifacio","CIC"," 06/12/2015");
		  
		   int quantidadeUsuarios = facade.recuperarUsuario().size();
		  
		   facade.adicionaUsuario(user);
		  
		   Usuario resultadoConsulta = facade.recuperarUsuarioPorLogin("Rbonifacio");
		  
		   assertEquals(quantidadeUsuarios+1, facade.recuperarUsuario().size());
		   assertNotNull(resultadoConsulta);  
		  }
		  catch(Throwable t) {
			  t.printStackTrace();
			  fail();
		  }
	}
}