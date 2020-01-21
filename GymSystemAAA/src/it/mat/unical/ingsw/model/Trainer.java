package it.mat.unical.ingsw.model;

import java.util.ArrayList;

public class Trainer extends Utente{
	
	ArrayList<Corso> corsi;
	
	public Trainer() {
		super();
		corsi = new ArrayList<Corso>();
	}
	
	public Trainer(String nome, String cognome, String mail, String password)
	{
		super(nome,cognome,mail,password);
		corsi = new ArrayList<Corso>();

	}

	public ArrayList<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(ArrayList<Corso> corsi) {
		this.corsi = corsi;
	}
	
	

}
