package br.unb.cic.DiariasEPassagens.integracao;

import javax.*;
import javax.persistence.EntityManager;

import br.unb.cic.DiariasEPassagens.integracao.jpa.EMFactoryHelper;
import junit.framework.TestCase;

public class FactoryTest extends TestCase{

	public void testFactory() {
		try {
			EntityManager em = EMFactoryHelper.instance().getFactory().createEntityManager();
			em.close();
			EMFactoryHelper.instance().getFactory().close();
			assertTrue(true);
		}
		catch(Throwable t) {
			t.printStackTrace();
			fail();
		}
	}
}
