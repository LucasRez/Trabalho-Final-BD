package br.unb.cic.DiariasEPassagens.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.entidades.Acao;
import br.unb.cic.DiariasEPassagens.entidades.Favorecido;
import br.unb.cic.DiariasEPassagens.entidades.Pagamento;
import br.unb.cic.DiariasEPassagens.integracao.DAOPagamento;


public class DAOPagamentoJPA implements DAOPagamento{

	//TODO: implementar a porra toda
	private EntityManager em;

	@Override
	public List<Pagamento> recuperaPagamentosPorAcao(String acao) {
		Acao object;
		object = new DAOAcaoJPA().recuperaPorNome(acao);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Pagamento WHERE acao = :acaoParam").setParameter("acaoParam", object).getResultList();
	}



	@Override
	public List<Pagamento> recuperaPagamentosPorFavorecido(String favorecido) {
		Favorecido object;
		object = new DAOFavorecidoJPA().recuperaPorNome(favorecido);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM Pagamento WHERE favorecido = :favorecidoParam").setParameter("favorecidoParam", object).getResultList();

	}



	@Override
	public Pagamento recuperaPorData(String data) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Pagamento recuperaPorValor(String valor) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Pagamento recuperaPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Pagamento recuperaPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}