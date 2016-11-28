package br.unb.cic.DiariasEPassagens.integracao.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import br.unb.cic.DiariasEPassagens.integracao.DAOQuery;

public class DAOQueryJPA implements DAOQuery{


	@Override
	public void recuperaQualServidorGastouMais() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DiariasePassagens",
							"postgresql", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			ResultSet rs = stmt.executeQuery( "select f.favorecidonome, sum(p.pagamvalor) from pagamento p join "
					+ "favorecido f on f.favorecidoid = p.favorecidoid group "
					+ "by f.favorecidonome order by sum(p.pagamvalor) desc limit 1;" );
			while ( rs.next() ) {
				String  nome = rs.getString("favorecidonome");
				float valorPagam = rs.getFloat("sum");	            
				System.out.println( "Nome do favorecido: " + nome  + "Total Gasto: " + valorPagam);

			}
			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}

	}

	@Override
	public void recuperaListaGastoTotaisDecres() {
		// TODO Auto-generated method stub

	}

	@Override
	public void recuperaListaGastoTotaisCresc() {
		// TODO Auto-generated method stub

	}

	@Override
	public void recuperaQualOrgSupGastouMais() {
		// TODO Auto-generated method stub

	}

	@Override
	public void recuperaQualAcaoGastouMais() {
		// TODO Auto-generated method stub

	}

	@Override
	public void recuperaQualProgramaGastouMais() {
		// TODO Auto-generated method stub

	}

	@Override
	public void recuperaGastoPorCpf(String CPF) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DiariasePassagens",
							"postgresql", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			ResultSet rs = stmt.executeQuery( "select recuperaGastosPorCpf(CPF);" );
			while ( rs.next() ) {
				float valorPagam = rs.getFloat("recuperagastosporcpf");	            
				System.out.println("Dinheiro Gasto: " + valorPagam);

			}
			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}

	}

	@Override
	public void recuperaGastoPorNome(String nome) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DiariasePassagens",
							"postgresql", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			ResultSet rs = stmt.executeQuery( "select recuperaGastosPorNome(nome);" );
			while ( rs.next() ) {
				float valorPagam = rs.getFloat("recuperagastospornome");	            
				System.out.println("Dinheiro Gasto: " + valorPagam);

			}
			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}

	}

	@Override
	public void recuperaCodPagamGastouMais() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DiariasePassagens",
							"postgresql", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			ResultSet rs = stmt.executeQuery( "select p.pagamcod, sum(p.pagamvalor) from pagamento p group by p.pagamcod order by sum(p.pagamvalor) desc limit 1;" );
			while ( rs.next() ) {
				String pagamCod = rs.getString("pagamcod");
				float valorPagam = rs.getFloat("sum");	            
				System.out.println("Codigo do pagamento que teve o maior gasto: " + pagamCod + "Dinheiro Gasto: " + valorPagam);

			}
			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}

	}

	@Override
	public void recuperaGastoTotal() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DiariasePassagens",
							"postgresql", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			ResultSet rs = stmt.executeQuery( "select sum(p.pagamvalor) from pagamento p;" );
			while ( rs.next() ) {
				float valorPagam = rs.getFloat("sum");	            
				System.out.println("Total Gasto nos meses de Janeiro a Junho de 2013: " + valorPagam);

			}
			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}

	}

	@Override
	public void recuperaProgramadeAcaoGastouMais(String acaoNome) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DiariasePassagens",
							"postgresql", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			ResultSet rs = stmt.executeQuery( "recuperaProgramaMaisCaroAcao(acaoNome);" );
			while ( rs.next() ) {
				String retorno = rs.getString("recuperaprogramamaiscaroacao");	            
				System.out.println("Dinheiro Gasto: " + retorno);

			}
			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}

	}



}
