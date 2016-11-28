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
							"postgres", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			ResultSet rs = stmt.executeQuery( "select f.favorecidonome, sum(p.pagamvalor) from pagamento p join "
					+ " favorecido f on f.favorecidoid = p.favorecidoid group "
					+ " by f.favorecidonome order by sum(p.pagamvalor) desc limit 1;" );
			while ( rs.next() ) {
				String  nome = rs.getString("favorecidonome");
				float valorPagam = rs.getFloat("sum");	            
				System.out.println( "Nome do favorecido: " + nome  + " |Total Gasto: " + valorPagam);

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
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DiariasePassagens",
							"postgres", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			ResultSet rs = stmt.executeQuery("select f.favorecidonome, sum(p.pagamvalor) from pagamento p join favorecido f on f.favorecidoid = p.favorecidoid group by f.favorecidonome order by sum(p.pagamvalor) desc;");
			while ( rs.next() ) {
				String  nome = rs.getString("favorecidonome");
				float valorPagam = rs.getFloat("sum");	            
				System.out.println( "Nome do favorecido: " + nome  + " | Total Gasto: " + valorPagam);

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
	public void recuperaListaGastoTotaisCresc() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DiariasePassagens",
							"postgres", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			ResultSet rs = stmt.executeQuery("select f.favorecidonome, sum(p.pagamvalor) from pagamento p"
					+ " join favorecido f on f.favorecidoid = p.favorecidoid group by f.favorecidonome order by sum(p.pagamvalor)"
					+ " asc;");
			while ( rs.next() ) {
				String  nome = rs.getString("favorecidonome");
				float valorPagam = rs.getFloat("sum");	            
				System.out.println( "Nome do favorecido: " + nome  + " | Total Gasto: " + valorPagam);

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
	public void recuperaQualOrgSupGastouMais() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DiariasePassagens",
							"postgres", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			ResultSet rs = stmt.executeQuery("select osup.orgsupnome, sum(p.pagamvalor) from orgao_superior osup"
					+ " join orgao_subordinado osub on osup.orgsupcod = osub.orgsupcod "
					+ " join unidade_gestora u on u.orgsubcod = osub.orgsubcod"
					+ " join favorecido f on f.unigestcod = u.unigestcod join pagamento p on f.favorecidoid = p.favorecidoid group by osup.orgsupnome order by sum(p.pagamvalor) "
					+ " desc limit 1;");
			while ( rs.next() ) {
				String  nome = rs.getString("orgsupnome");
				float valor = rs.getFloat("sum");	            
				System.out.println( "Nome do Org�o que mais gastou: " + nome + " | Total gasto: " + valor);

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
	public void recuperaQualAcaoGastouMais() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DiariasePassagens",
							"postgres", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			ResultSet rs = stmt.executeQuery("select a.acaonome, sum(p.pagamvalor) from pagamento p"
					+ " join acao a on p.acaocod = a.acaocod group by a.acaonome order by sum(p.pagamvalor)"
					+ " desc limit 1;");
			while ( rs.next() ) {
				String  nome = rs.getString("acaonome");
				float valor = rs.getFloat("sum");	            
				System.out.println( "Nome da acao que gastou mais: " + nome + " | Total gasto: " + valor);

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
	public void recuperaQualProgramaGastouMais() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DiariasePassagens",
							"postgres", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			ResultSet rs = stmt.executeQuery("select pr.prognome, sum(p.pagamvalor) from pagamento p join acao a on p.acaocod = a.acaocod"
					+ " join programa pr on a.progcod = pr.progcod group by pr.prognome order by sum(p.pagamvalor)"
					+ " desc limit 1;");
			while ( rs.next() ) {
				String  nome = rs.getString("prognome");
				float valor = rs.getFloat("sum");	            
				System.out.println( "Nome do favorecido: " + nome  + " | Total Gasto: " + valor);

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
	public void recuperaGastoPorCpf(String CPF) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/DiariasePassagens",
							"postgres", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			
			String query = "select recuperaGastosPorCpf(" + "'" + CPF + "'" +  ");";
			ResultSet rs = stmt.executeQuery(query);
			
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
							"postgres", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			
			String query = "select recuperaGastosPorNome(" + "'" + nome.toUpperCase() + "'" +  ");";
			ResultSet rs = stmt.executeQuery(query);
			
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
							"postgres", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			ResultSet rs = stmt.executeQuery( "select p.pagamcod, sum(p.pagamvalor) from pagamento p group by p.pagamcod order by sum(p.pagamvalor) desc limit 1;" );
			while ( rs.next() ) {
				String pagamCod = rs.getString("pagamcod");
				float valorPagam = rs.getFloat("sum");	            
				System.out.println("Codigo do pagamento que teve o maior gasto: " + pagamCod + "| Dinheiro Gasto: " + valorPagam);

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
							"postgres", "02101995");
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
							"postgres", "02101995");
			c.setAutoCommit(false);

			stmt =  c.createStatement();
			
			String query = "select recuperaProgramaMaisCaroAcao(" + "'" + acaoNome + "'" +  ");";
			ResultSet rs = stmt.executeQuery(query);
	
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
