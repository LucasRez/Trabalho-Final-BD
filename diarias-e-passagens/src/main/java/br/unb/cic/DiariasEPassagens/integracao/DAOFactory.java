package br.unb.cic.DiariasEPassagens.integracao;

public abstract class DAOFactory {
	
	public enum DataBase {
		MEMORIA, 
		SQLDB,
		COUCHDB
	}; 
	
	
	private static DAOFactory instance;
	protected DAOFactory() {} 
		
	public static DAOFactory instance(DataBase impl) {
		if(instance == null) {
			switch(impl) {
			 case SQLDB : instance = new br.unb.cic.DiariasEPassagens.integracao.jpa.DAOFactoryImpl(); break;
			 case COUCHDB : instance = null; break;
			}
		}
		return instance;
	}

	public abstract DAOQuery createDAOQuery();
}
