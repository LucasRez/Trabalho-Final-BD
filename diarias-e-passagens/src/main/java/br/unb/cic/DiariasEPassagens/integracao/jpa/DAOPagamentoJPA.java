package br.unb.cic.DiariasEPassagens.integracao.jpa;

import java.util.List;



import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.integracao.DAOPagamento;
import br.unb.cic.DiariasEPassagens.negocio.Pagamento;
import br.unb.cic.DiariasEPassagens.negocio.Favorecido;
import br.unb.cic.DiariasEPassagens.negocio.Acao;


public class DAOPagamentoJPA implements DAOPagamento{

	private EntityManager em;

	@Override
	public List<Pagamento> recuperaPagamentosPorAcao(String acao) {
		acao object;
		object = new DAOacaoJPA().recuperaPorNome(acao);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Pagamento WHERE acao = :acaoParam").setParameter("acaoParam", object).getResultList();
	}



	@Override
	public List<Pagamento> recuperaPagamentosPorFavorecido(String favorecido) {
		favorecido object;
		object = new DAOFavorecidoJPA().recuperaPorNome(favorecido);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();

		return em.createQuery("FROM Pagamento WHERE favorecido = :favorecidoParam").setParameter("favorecidoParam", object).getResultList();

	}

}