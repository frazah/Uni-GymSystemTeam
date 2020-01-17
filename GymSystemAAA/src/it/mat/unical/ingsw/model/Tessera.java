package it.mat.unical.ingsw.model;

import java.util.ArrayList;

public class Tessera {
	private String dataDiIscrizione;
	private String dataDiScadenza;
	private String id;
	private ArrayList<Corso> corsi;

	
	
	public Tessera(String dataDiIscrizione, String dataDiScadenza, String id, ArrayList<Corso> corsi) {
		super();
		this.dataDiIscrizione = dataDiIscrizione;
		this.dataDiScadenza = dataDiScadenza;
		this.id = id;
		this.corsi = corsi;
	}
	
	public Tessera() {
		// TODO Auto-generated constructor stub
	}

	public String getDataDiIscrizione() {
		return dataDiIscrizione;
	}
	public void setDataDiIscrizione(String dataDiIscrizione) {
		this.dataDiIscrizione = dataDiIscrizione;
	}
	public String getDataDiScadenza() {
		return dataDiScadenza;
	}
	public void setDataDiScadenza(String dataDiScadenza) {
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
