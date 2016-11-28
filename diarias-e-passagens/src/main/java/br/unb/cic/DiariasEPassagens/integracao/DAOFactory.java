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
	
	public abstract DAOUnidadeGestora createDAOUnidadeGestora();
	public abstract DAOFuncao createDAOFuncao();
	public abstract DAOFavorecido createDAOFavorecido();
	public abstract DAOPagamento createDAOPagamento();
	public abstract DAOSubFuncao createDAOSubFuncao();
	public abstract DAOAcao createDAOAcao();
	public abstract DAOOrgaoSubordinado createDAOOrgaoSubordinado();
	public abstract DAOOrgaoSuperior createDAOOrgaoSuperior();
	public abstract DAOPrograma  createDAOPrograma();
	public abstract DAOQuery createDAOQuery();
}
