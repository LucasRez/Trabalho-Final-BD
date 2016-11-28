package br.unb.cic.DiariasEPassagens.integracao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactoryHelper {

    private EntityManagerFactory factory;
    private static EMFactoryHelper instance;
    
    private EMFactoryHelper() {
       factory = Persistence.createEntityManagerFactory("TrabFinalBD");
    }
    
    public static EMFactoryHelper instance() {
    		if(instance == null) {
    			instance = new EMFactoryHelper();
    		}
    		return instance;
    }
    
    public EntityManagerFactory getFactory() {
        return factory;
    }

}