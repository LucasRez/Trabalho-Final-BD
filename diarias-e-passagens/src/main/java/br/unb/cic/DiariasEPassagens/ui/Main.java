package br.unb.cic.DiariasEPassagens.ui;

import br.unb.cic.DiariasEPassagens.entidades.OrgaoSuperior;

import br.unb.cic.DiariasEPassagens.negocio.Facade;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
   public static void main(String args[]) {
      Connection c = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/testdb",
            "postgres", "02101995");
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   }
}

//public class Main {
//
//	public static void main(String[] args) {
//		Facade facade = new Facade();
//		
//		OrgaoSuperior orgSup;
//		
//		orgSup = facade.recuperaOrgSupPorNome("PRESIDENCIA DA REPUBLICA");
//		
//		System.out.println(orgSup.getNome());
//	}
//
//}
