package it.mat.unical.ingsw.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Tessera {
	private LocalDateTime dataDiIscrizione;
	private LocalDateTime dataDiScadenza;
	private String id;
	private ArrayList<Corso> corsi;

	
	
	public Tessera(LocalDateTime dataDiIscrizione, LocalDateTime dataDiScadenza, String id, ArrayList<Corso> corsi) {
		super();
		this.dataDiIscrizione = dataDiIscrizione;
		this.dataDiScadenza = dataDiScadenza;
		this.id = id;
		this.corsi = corsi;
	}
	
	public Tessera() {
		corsi = new ArrayList<Corso>();
		/*LocalDateTime localTime = LocalDateTime.now();
		LocalDateTime scadenza = localTime.plusDays(90);
		System.out.println(localTime);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String adesso = localTime.format(myFormatObj);
		String dopo = scadenza.format(myFormatObj);
		if (localTime.isAfter(scadenza))
		System.out.println(adesso + " " + dopo);*/
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
	public String getID() {
		return id;
	}
	public void setID(String iD) {
		id = iD;
	}
	public ArrayList<Corso> getCorsi() {
		return corsi;
	}
	public void setCorsi(ArrayList<Corso> corsi) {
		this.corsi = corsi;
	}
	
	
}
