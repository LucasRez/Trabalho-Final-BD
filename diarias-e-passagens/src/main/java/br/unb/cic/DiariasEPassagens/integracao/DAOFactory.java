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
			 case MEMORIA: instance = new br.unb.cic.DiariasEPassagens.integracao.memoria.DAOFactoryImpl();
			}
		}
		return instance;
	}
	
	public abstract DAOUnidadeGestora createDAOGenero();
	public abstract DAOFuncao createDAOTrabalhoArtistico();
	public abstract DAOFavorecido createDAOFilme();
	public abstract DAOFaixaMusical createDAOFaixaMusical();
	public abstract DAOSubFuncao createDAOAutor();
	public abstract DAOAcao createDAOAcao();
	public abstract DAOUsuario createDAOUsuario();
	public abstract DAOAvaliacao createDAOAvaliacao();
}
