package it.prova.gestionecompagnia.dao.compagnia.impiegato;

import java.sql.Date;
import java.util.List;

import it.prova.gestionecompagnia.dao.IBaseDAO;
import it.prova.gestionecompagnia.model.Compagnia;
import it.prova.gestionecompagnia.model.Impiegato;

public interface ImpiegatoDAO extends IBaseDAO<Impiegato> {
	public List<Impiegato> findAllByCompagnia(Compagnia compagniaInput);

	public int countByDataFondazioneGreaterThen(Date dataInput);

	public List<Impiegato> findAllByCompagniaConFatturazioneMAggioreDi(int fatturatoInput);

	public List<Impiegato> findAllErroriAssunzione(); // assunzione<dataazienda

}
