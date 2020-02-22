package it.mat.unical.ingsw.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

import it.mat.unical.persistence.DBManager;

public class Tessera {
	private LocalDateTime dataDiIscrizione;
	private LocalDateTime dataDiScadenza;
	private int id; 	
	private ArrayList<Corso> corsi;


	
	
	
	
	public String getIscrizione() {
		String iscrizione = new String();
		
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		iscrizione = dataDiIscrizione.format(myFormatObj);
		
		return iscrizione;
	}

	

	public String getScadenza() {
		
		String scadenza = new String();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		scadenza = dataDiScadenza.format(myFormatObj);
		return scadenza;
	}

	
	public Tessera(LocalDateTime dataDiIscrizione, LocalDateTime dataDiScadenza, ArrayList<Corso> corsi) {
		super();
		this.dataDiIscrizione = dataDiIscrizione;
		this.dataDiScadenza = dataDiScadenza;
		List<Tessera> tessere = DBManager.getInstance().getTessere();
		int n;
		if (tessere.size() == 0)
			n = 1;
			
		else
			n = tessere.get(tessere.size()-1).getID()+1;
		
		setID(n);
		this.corsi = corsi;
		
	}
	
	public Tessera() {
		corsi = new ArrayList<Corso>();
	}

	public LocalDateTime getDataDiIscrizione() {
		return dataDiIscrizione;
	}
	public void setDataDiIscrizione(LocalDateTime dataDiIscrizione) {
		this.dataDiIscrizione = dataDiIscrizione;
	}
	
	public LocalDateTime getDataDiScadenza() {
		return dataDiScadenza;
	}
	public void setDataDiScadenza(LocalDateTime dataDiScadenza) {
		this.dataDiScadenza = dataDiScadenza;
	}
	public int getID() {
		return id;
	}
	public void setID(int iD) {
		id = iD;
	}
	public ArrayList<Corso> getCorsi() {
		return corsi;
	}
	public void setCorsi(ArrayList<Corso> corsi) {
		this.corsi = corsi;
	}

	
	
}
