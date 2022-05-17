package it.prova.gestionecompagnia.model;

import java.sql.Date;
import java.util.Objects;

public class Impiegato {
	private Long id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private Date dataNascita;
	private Date dataAssunzione;
	private Compagnia compagnia;

	public Impiegato() {
	}

	public Impiegato(String nome, String cognome, String codiceFiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
	}

	public Impiegato(String nome, String cognome, String codiceFiscale, Date dataNascita, Date dataAssunzione) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataNascita = dataNascita;
		this.dataAssunzione = dataAssunzione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public Compagnia getCompagnia() {
		return compagnia;
	}

	public void setCompagnia(Compagnia compagnia) {
		this.compagnia = compagnia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiceFiscale, cognome, dataAssunzione, dataNascita, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Impiegato other = (Impiegato) obj;
		return Objects.equals(codiceFiscale, other.codiceFiscale) && Objects.equals(cognome, other.cognome)
				&& Objects.equals(dataAssunzione, other.dataAssunzione)
				&& Objects.equals(dataNascita, other.dataNascita) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Impiegato [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale
				+ ", dataNascita=" + dataNascita + ", dataAssunzione=" + dataAssunzione + "]";
	}

}
