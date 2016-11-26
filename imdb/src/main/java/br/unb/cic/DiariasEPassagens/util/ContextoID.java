package br.unb.cic.DiariasEPassagens.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.unb.cic.DiariasEPassagens.negocio.IMDBFacade;

public class ContextoID {

	private ContextoID() { } 
	
	private static ContextoID instance;
	private IMDBFacade facade; 
	
	public static ContextoID instance() {
		if(instance == null) {
			instance = new ContextoID();
		}
		return instance; 
	}
	
	public IMDBFacade facade() {
		if(facade == null) {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			facade = (IMDBFacade)context.getBean("facade");
		}
		return facade;
	}
}
