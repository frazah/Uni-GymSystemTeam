package it.mat.unical.ingsw.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Tessera {
	private LocalDateTime dataDiIscrizione;
	private LocalDateTime dataDiScadenza;
	private static int count = 0;
	private int id; 	
	private ArrayList<Corso> corsi;
	private String iscrizione;
	private String scadenza;

	
	
	public String getIscrizione() {
		return iscrizione;
	}

	public void setIscrizione(String iscrizione) {
		this.iscrizione = iscrizione;
	}

	public String getScadenza() {
		return scadenza;
	}

	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}

	public Tessera(LocalDateTime dataDiIscrizione, LocalDateTime dataDiScadenza, ArrayList<Corso> corsi) {
		super();
		this.dataDiIscrizione = dataDiIscrizione;
		this.dataDiScadenza = dataDiScadenza;
		setID(++count);
		this.corsi = corsi;
		iscrizione = new String();
		scadenza = new String();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		iscrizione = dataDiIscrizione.format(myFormatObj);
		scadenza = dataDiScadenza.format(myFormatObj);
	}
	
	public Tessera() {
		corsi = new ArrayList<Corso>();
		iscrizione = new String();
		scadenza = new String();
		/*LocalDateTime localTime = LocalDateTime.now();
		LocalDateTime scadenza = localTime.plusDays(90);
		System.out.println(localTime);*/
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		iscrizione = dataDiIscrizione.format(myFormatObj);
		scadenza = dataDiScadenza.format(myFormatObj);
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
