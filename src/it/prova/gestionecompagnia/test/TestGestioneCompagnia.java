package it.prova.gestionecompagnia.test;

import java.sql.Connection;
import java.sql.Date;

import it.prova.gestionecompagnia.connection.MyConnection;
import it.prova.gestionecompagnia.dao.Constants;
import it.prova.gestionecompagnia.dao.compagnia.CompagniaDAO;
import it.prova.gestionecompagnia.dao.compagnia.CompagniaDAOImpl;
import it.prova.gestionecompagnia.dao.compagnia.impiegato.ImpiegatoDAO;
import it.prova.gestionecompagnia.dao.compagnia.impiegato.ImpiegatoDAOImpl;
import it.prova.gestionecompagnia.model.Compagnia;
import it.prova.gestionecompagnia.model.Impiegato;

public class TestGestioneCompagnia {

	public static void main(String[] args) {
		CompagniaDAO compagniaDAOInstance = null;
		ImpiegatoDAO impiegatoDAOInstance = null;
		
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
			compagniaDAOInstance = new CompagniaDAOImpl(connection);
			impiegatoDAOInstance = new ImpiegatoDAOImpl(connection);
			
			System.out.println("Nella tabella Compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");
			System.out.println("Nella tabella Impiegato ci sono " + impiegatoDAOInstance.list().size() + " elementi.");
			
			
			
			testFindCompagniaById(compagniaDAOInstance);
			testFindImpiegatoById(impiegatoDAOInstance);
			System.out.println("Nella tabella Compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");
			System.out.println("Nella tabella Impiegato ci sono " + impiegatoDAOInstance.list().size() + " elementi.");
			
			testUpdateCompagnia(compagniaDAOInstance);
			testUpdateImpiegato(impiegatoDAOInstance);
			System.out.println("Nella tabella Compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");
			System.out.println("Nella tabella Impiegato ci sono " + impiegatoDAOInstance.list().size() + " elementi.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testFindCompagniaById(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println("\n<<<<<<testFindCompagniaById: inizio>>>>>>");
		
		Compagnia primaCompagnia = compagniaDAOInstance.list().get(0);
		
		Compagnia compagniaRicercata = compagniaDAOInstance.get(primaCompagnia.getId());
		if (!compagniaRicercata.equals(primaCompagnia))
			throw new RuntimeException("testFindCompagniaById : FAILED");
		else System.out.println("testFindCompagniaById: SUCCESS");
		
		System.out.println("<<<<<<testFindCompagniaById: fine>>>>>>\n");
	}
	
	public static void testFindImpiegatoById(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("\n<<<<<<testFindImpiegatoById: inizio>>>>>>");
		
		Impiegato primoImpiegato = impiegatoDAOInstance.list().get(0);
		
		Impiegato impiegatoRicercato = impiegatoDAOInstance.get(primoImpiegato.getId());
		if (!impiegatoRicercato.equals(primoImpiegato))
			throw new RuntimeException("testFindImpiegatoById : FAILED");
		else System.out.println("testFindImpiegatoById: SUCCESS");
		
		System.out.println("<<<<<<testFindImpiegatoById: fine>>>>>>\n");
	}
	
	public static void testUpdateCompagnia(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println("\n<<<<<<testUpdateCompagnia: inizio>>>>>>");
		
		Compagnia primaCompagnia = compagniaDAOInstance.list().get(0);
		primaCompagnia.setFatturatoAnnuo(50000000);
		
		int resultUpdate = compagniaDAOInstance.update(primaCompagnia);
		if (resultUpdate < 1)
			throw new RuntimeException("testUpdateCompagnia : FAILED");
		else System.out.println("testUpdateCompagnia: SUCCESS");
		
		System.out.println("<<<<<<testUpdateCompagnia: fine>>>>>>\n");
	}
	
	public static void testUpdateImpiegato(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("\n<<<<<<testUpdateImpiegato: inizio>>>>>>");
		
		Impiegato primoImpiegato = impiegatoDAOInstance.list().get(0);
		primoImpiegato.setNome("Gianna");
		primoImpiegato.setCognome("Nannini");
		
		int resultUpdate = impiegatoDAOInstance.update(primoImpiegato);
		if (resultUpdate < 1)
			throw new RuntimeException("testUpdateImpiegato : FAILED");
		else System.out.println("testUpdateImpiegato: SUCCESS");
		
		System.out.println("<<<<<<testUpdateImpiegato: fine>>>>>>\n");
	}
	
	public static void testInserimentoCompagnia(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println("/n<<<<<<testInserimentoCompagnia: inizio>>>>>>");
		
		Date data = new Date(new java.util.Date().getTime());
		Compagnia compagnia = new Compagnia("ragioneSociale1", 100000000, data);
		compagnia.setId((long) compagniaDAOInstance.list().size() + 1);
		
		int resultInsert = compagniaDAOInstance.insert(compagnia);
		if (resultInsert < 1)
			throw new RuntimeException("testInserimentoCompagnia : FAILED");
		
		System.out.println("<<<<<<testInserimentoCompagnia: fine>>>>>>");
	}
}
