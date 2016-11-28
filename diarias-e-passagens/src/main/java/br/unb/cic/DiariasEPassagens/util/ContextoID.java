package br.unb.cic.DiariasEPassagens.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.unb.cic.DiariasEPassagens.negocio.Facade;

public class ContextoID {

	private ContextoID() { } 
	
	private static ContextoID instance;
	private Facade facade; 
	
	public static ContextoID instance() {
		if(instance == null) {
			instance = new ContextoID();
		}
		return instance; 
	}
	
	public Facade facade() {
		if(facade == null) {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			facade = (Facade)context.getBean("facade");
		}
		return facade;
	}
}
