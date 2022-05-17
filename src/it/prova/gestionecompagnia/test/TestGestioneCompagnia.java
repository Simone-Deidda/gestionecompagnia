package it.prova.gestionecompagnia.test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

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
			
			//testUpdateCompagnia(compagniaDAOInstance);
			//testUpdateImpiegato(impiegatoDAOInstance);
			System.out.println("Nella tabella Compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");
			System.out.println("Nella tabella Impiegato ci sono " + impiegatoDAOInstance.list().size() + " elementi.");
			
			//testInserimentoCompagnia(compagniaDAOInstance);
			//testInserimentoImpiegato(impiegatoDAOInstance);
			System.out.println("Nella tabella Compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");
			System.out.println("Nella tabella Impiegato ci sono " + impiegatoDAOInstance.list().size() + " elementi.");
			
			//testCancellazioneCompagnia(compagniaDAOInstance);
			//testCancellazioneImpiegato(impiegatoDAOInstance);
			System.out.println("Nella tabella Compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");
			System.out.println("Nella tabella Impiegato ci sono " + impiegatoDAOInstance.list().size() + " elementi.");
			
			testFindCompagniaByExample(compagniaDAOInstance);
			testFindImpiegatoByExample(impiegatoDAOInstance);
			System.out.println("Nella tabella Compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");
			System.out.println("Nella tabella Impiegato ci sono " + impiegatoDAOInstance.list().size() + " elementi.");
			
			testFindCompagnieByDataAssunzione(compagniaDAOInstance, impiegatoDAOInstance);
			System.out.println("Nella tabella Compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");
			testFindCompagnieByRagioneSociale(compagniaDAOInstance);
			System.out.println("Nella tabella Compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");
			testFindCompagnieByCodiceFiscaleImpiegato(compagniaDAOInstance, impiegatoDAOInstance);
			System.out.println("Nella tabella Compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");
			
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
		System.out.println("\n<<<<<<testInserimentoCompagnia: inizio>>>>>>");
		
		Date data = new Date(new java.util.Date().getTime());
		Compagnia compagnia = new Compagnia("ragioneSociale1", 100000000, data);
		compagnia.setId((long) compagniaDAOInstance.list().size() + 1);
		
		int resultInsert = compagniaDAOInstance.insert(compagnia);
		if (resultInsert < 1)
			throw new RuntimeException("testInserimentoCompagnia : FAILED");
		else System.out.println("testInserimentoCompagnia : SUCCESS");
		
		System.out.println("<<<<<<testInserimentoCompagnia: fine>>>>>>\n");
	}
	
	public static void testInserimentoImpiegato(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("\n<<<<<<testInserimentoImpiegato: inizio>>>>>>");
		
		Date data = new Date(new java.util.Date().getTime());
		Impiegato impiegato = new Impiegato("nome1", "cognome1", "NNNCCC11A22Z", data,  data);
		impiegato.setId((long) impiegatoDAOInstance.list().size() + 1);
		
		int resultInsert = impiegatoDAOInstance.insert(impiegato);
		if (resultInsert < 1)
			throw new RuntimeException("testInserimentoImpiegato : FAILED");
		else System.out.println("testInserimentoImpiegato : SUCCESS");
		
		System.out.println("<<<<<<testInserimentoImpiegato: fine>>>>>>\n");
	}
	
	public static void testCancellazioneImpiegato(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("\n<<<<<<testCancellazioneImpiegato: inizio>>>>>>");
		
		Impiegato primoImpiegato = impiegatoDAOInstance.list().get(0);
		
		int resultDelete = impiegatoDAOInstance.delete(primoImpiegato);
		if (resultDelete < 1)
			throw new RuntimeException("testCancellazioneImpiegato : FAILED");
		else System.out.println("testCancellazioneImpiegato : SUCCESS");
		
		System.out.println("<<<<<<testCancellazioneImpiegato: fine>>>>>>\n");
	}
	
	public static void testCancellazioneCompagnia(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println("\n<<<<<<testCancellazioneCompagnia: inizio>>>>>>");
		
		Date data = new Date(new java.util.Date().getTime());
		Compagnia daCancellare = new Compagnia("ragioneSoc", 10000000, data);
		daCancellare.setId((long) (compagniaDAOInstance.list().size() + 1));
		
		int resultDelete = compagniaDAOInstance.insert(daCancellare);
		resultDelete = compagniaDAOInstance.delete(daCancellare);
		if (resultDelete < 1)
			throw new RuntimeException("testCancellazioneCompagnia : FAILED");
		else System.out.println("testCancellazioneCompagnia : SUCCESS");
		
		System.out.println("<<<<<<testCancellazioneCompagnia: fine>>>>>>\n");
	}
	
	public static void testFindImpiegatoByExample(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("\n<<<<<<testFindImpiegatoByExample: inizio>>>>>>");
		
		// con nessuna inizializzazione nei dati dovrebbe ritornare la ista intera 
		List<Impiegato> listaImpiegatiTrovati;
		Impiegato example = new Impiegato();
		listaImpiegatiTrovati = impiegatoDAOInstance.findByExample(example);
		
		if (listaImpiegatiTrovati.size() != impiegatoDAOInstance.list().size())
			throw new RuntimeException("testFindImpiegatoByExample : FAILED");
		else System.out.println("testFindImpiegatoByExample: SUCCESS");
		
		// con nome inizializzato dovrebbe ritornare elementi con almeno l'iniziale uguale al nome
		String iniziale = "no";
		example.setNome(iniziale);
		listaImpiegatiTrovati = impiegatoDAOInstance.findByExample(example);
		
		for (Impiegato impiegato : listaImpiegatiTrovati) {
			System.out.println(impiegato);
			if(!impiegato.getNome().startsWith(iniziale))
				throw new RuntimeException("testFindImpiegatoByExample : FAILED");
		}
		
		System.out.println("<<<<<<testFindImpiegatoByExample: fine>>>>>>\n");
	}
	
	public static void testFindCompagniaByExample(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println("\n<<<<<<testFindCompagniaByExample: inizio>>>>>>");
		
		// con nessuna inizializzazione nei dati dovrebbe ritornare la ista intera 
		List<Compagnia> listaCompagnieTrovati;
		Compagnia example = new Compagnia();
		listaCompagnieTrovati = compagniaDAOInstance.findByExample(example);
		
		if (listaCompagnieTrovati.size() != compagniaDAOInstance.list().size())
			throw new RuntimeException("testFindCompagniaByExample : FAILED");
		else System.out.println("testFindCompagniaByExample: SUCCESS");
		
		// con nome inizializzato dovrebbe ritornare elementi con almeno l'iniziale uguale al nome
		String iniziale = "ra";
		example.setRagioneSociale(iniziale);
		listaCompagnieTrovati = compagniaDAOInstance.findByExample(example);
		
		for (Compagnia compagnia : listaCompagnieTrovati) {
			System.out.println(compagnia);
			if(!compagnia.getRagioneSociale().startsWith(iniziale))
				throw new RuntimeException("testFindCompagniaByExample : FAILED");
		}
		
		System.out.println("<<<<<<testFindCompagniaByExample: fine>>>>>>\n");
	}
	
	public static void testFindCompagniaById(ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("\n<<<<<<testFindCompagniaById: inizio>>>>>>");
		
		Impiegato primoImpiegato = impiegatoDAOInstance.list().get(0);
		
		Impiegato impiegatoRicercato = impiegatoDAOInstance.get(primoImpiegato.getId());
		if (!impiegatoRicercato.equals(primoImpiegato))
			throw new RuntimeException("testFindCompagniaById : FAILED");
		else System.out.println("testFindCompagniaById: SUCCESS");
		
		System.out.println("<<<<<<testFindCompagniaById: fine>>>>>>\n");
	}
	
	public static void testFindCompagnieByDataAssunzione(CompagniaDAO compagniaDAOInstance, ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("\n<<<<<<testFindCompagnieByDataAssunzione: inizio>>>>>>");
		
		Impiegato primoImpiegato = impiegatoDAOInstance.list().get(0);
		
		List<Compagnia> listaCompagniaTrovate = compagniaDAOInstance.findAllByDataAssunzione(primoImpiegato.getDataAssunzione());
		if (listaCompagniaTrovate.size() < 1)
			throw new RuntimeException("testFindCompagnieByDataAssunzione : FAILED");
		else System.out.println("testFindCompagnieByDataAssunzione: SUCCESS");
		
		System.out.println("<<<<<<testFindCompagnieByDataAssunzione: fine>>>>>>\n");
	}
	
	public static void testFindCompagnieByRagioneSociale(CompagniaDAO compagniaDAOInstance) throws Exception {
		System.out.println("\n<<<<<<testFindCompagnieByRagioneSociale: inizio>>>>>>");
		
		Compagnia primaCompagnia = compagniaDAOInstance.list().get(0);
		
		List<Compagnia> listaCompagniaTrovate = compagniaDAOInstance.findAllByRagioneSociale(primaCompagnia.getRagioneSociale());
		if (listaCompagniaTrovate.size() < 1)
			throw new RuntimeException("testFindCompagnieByRagioneSociale : FAILED");
		else System.out.println("testFindCompagnieByRagioneSociale: SUCCESS");
		
		System.out.println("<<<<<<testFindCompagnieByRagioneSociale: fine>>>>>>\n");
	}
	
	public static void testFindCompagnieByCodiceFiscaleImpiegato(CompagniaDAO compagniaDAOInstance, ImpiegatoDAO impiegatoDAOInstance) throws Exception {
		System.out.println("\n<<<<<<testFindCompagnieByCodiceFiscaleImpiegato: inizio>>>>>>");
		
		Impiegato primoImpiegato = impiegatoDAOInstance.list().get(0);
		
		List<Compagnia> listaCompagniaTrovate = compagniaDAOInstance.findAllByCodiceFiscaleImpiegato(primoImpiegato.getCodiceFiscale());
		if (listaCompagniaTrovate.size() < 1)
			throw new RuntimeException("testFindCompagnieByCodiceFiscaleImpiegato : FAILED");
		else System.out.println("testFindCompagnieByCodiceFiscaleImpiegato: SUCCESS");
		
		System.out.println("<<<<<<testFindCompagnieByCodiceFiscaleImpiegato: fine>>>>>>\n");
	}
}
