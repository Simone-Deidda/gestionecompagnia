package it.prova.gestionecompagnia.test;

import java.sql.Connection;

import it.prova.gestionecompagnia.connection.MyConnection;
import it.prova.gestionecompagnia.dao.Constants;
import it.prova.gestionecompagnia.dao.compagnia.CompagniaDAO;
import it.prova.gestionecompagnia.dao.compagnia.CompagniaDAOImpl;
import it.prova.gestionecompagnia.dao.compagnia.impiegato.ImpiegatoDAO;
import it.prova.gestionecompagnia.dao.compagnia.impiegato.ImpiegatoDAOImpl;

public class TestGestioneCompagnia {

	public static void main(String[] args) {
		CompagniaDAO compagniaDAOInstance = null;
		ImpiegatoDAO impiegatoDAOInstance = null;
		
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
			compagniaDAOInstance = new CompagniaDAOImpl(connection);
			impiegatoDAOInstance = new ImpiegatoDAOImpl(connection);
			
			System.out.println("Nella tabella Compagnia ci sono " + compagniaDAOInstance.list().size() + " elementi.");
			System.out.println("Nella tabella Impiegato ci sono " + impiegatoDAOInstance.list().size() + " elementi.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
