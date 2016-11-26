package br.unb.cic.DiariasEPassagens.integracao.jpa;
import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.integracao.DAOFavorecido;
import br.unb.cic.DiariasEPassagens.negocio.CPF;
import br.unb.cic.DiariasEPassagens.negocio.Favorecido;
import br.unb.cic.DiariasEPassagens.negocio.PagamValor;

public class DAOFavorecidoJPA implements DAOFavorecido{
	
	private EntityManager em;
	
	@Override
	public List<Favorecido> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Favorecidos").getResultList();
	}

	@Override
	public Favorecido recuperaPorNome(String Nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Favorecido> Favorecidos = em.createQuery("FROM Favorecido WHERE Nome = :NomeParam").setParameter("NomeParam", Nome).getResultList();
		return Favorecidos.size() == 1 ? Favorecidos.get(0) : null;
	}

	@Override
	public List<Favorecido> recuperaPorCPF(String CPF){
	//public Favorecido recuperaPorCPF(String CPF) {
		CPF object;
		
		object = new DAOCPFJPA().recuperaPorNome(CPF);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Favorecido WHERE CPF = :CPFParam").setParameter("CPFParam", object).getResultList();
		//return Favorecidos.size() == 1 ? Favorecidos.get(0) : null;
	}

	
	@Override
	//public Favorecido recuperaPorPagamValor(String PagamValor) {
	public List<Favorecido>  recuperaPorPagamValor(String PagamValor){
		PagamValor object;
		
		object = new DAOPagamValorJPA().recuperaPorNome(PagamValor);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Favorecido WHERE PagamValor =:PagamValorParam").setParameter("PagamValorParam", object).getResultList();
		//return Favorecidos.size() == 1 ? Favorecidos.get(0) : null;
	}
	
}
