package it.prova.gestionecompagnia.model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Compagnia {
	private Long id;
	private String ragioneSociale;
	private int fatturatoAnnuo;
	private Date dataFondazione;
	private List<Impiegato> listaImpiegati;
	
	public Compagnia() {
	}

	public Compagnia(String ragioneSociale, int fatturatoAnnuo) {
		this.ragioneSociale = ragioneSociale;
		this.fatturatoAnnuo = fatturatoAnnuo;
	}

	public Compagnia(String ragioneSociale, int fatturatoAnnuo, Date dataFondazione, List<Impiegato> listaImpiegati) {
		this.ragioneSociale = ragioneSociale;
		this.fatturatoAnnuo = fatturatoAnnuo;
		this.dataFondazione = dataFondazione;
		this.listaImpiegati = listaImpiegati;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public int getFatturatoAnnuo() {
		return fatturatoAnnuo;
	}

	public void setFatturatoAnnuo(int fatturatoAnnuo) {
		this.fatturatoAnnuo = fatturatoAnnuo;
	}

	public Date getDataFondazione() {
		return dataFondazione;
	}

	public void setDataFondazione(Date dataFondazione) {
		this.dataFondazione = dataFondazione;
	}

	public List<Impiegato> getListaImpiegati() {
		return listaImpiegati;
	}

	public void setListaImpiegati(List<Impiegato> listaImpiegati) {
		this.listaImpiegati = listaImpiegati;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataFondazione, fatturatoAnnuo, id, listaImpiegati, ragioneSociale);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compagnia other = (Compagnia) obj;
		return Objects.equals(dataFondazione, other.dataFondazione) && fatturatoAnnuo == other.fatturatoAnnuo
				&& Objects.equals(id, other.id) && Objects.equals(listaImpiegati, other.listaImpiegati)
				&& Objects.equals(ragioneSociale, other.ragioneSociale);
	}

	@Override
	public String toString() {
		return "Compagnia [id=" + id + ", ragioneSociale=" + ragioneSociale + ", fatturatoAnnuo=" + fatturatoAnnuo
				+ ", dataFondazione=" + dataFondazione + ", listaImpiegati=" + listaImpiegati + "]";
	}

	
	
	
}
