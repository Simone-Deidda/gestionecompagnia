package it.prova.gestionecompagnia.dao.compagnia;

import java.sql.Date;
import java.util.List;

import it.prova.gestionecompagnia.dao.IBaseDAO;
import it.prova.gestionecompagnia.model.Compagnia;

public interface CompagniaDAO extends IBaseDAO<Compagnia> {
	public List<Compagnia> findAllByDataAssunzione(Date dataAssunzioneInput);
	
	public List<Compagnia> findAllByRagioneSociale(String ragioneSocialeInput);
	
	public List<Compagnia> findAllByCodiceFiscaleImpiegato(String codiceFiscaleImpiegatoInput);
}
