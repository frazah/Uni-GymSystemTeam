package it.mat.unical.ingsw.model;

import java.util.ArrayList;

public class Admin extends Utente{
	
	ArrayList <String> richieste;
	
	public Admin() {
		super("Admin", "Admin", "admin@admin.com", "admin");
		super.setFotoProfilo("immagini/admin.jpg");
		richieste = new ArrayList<String>();
	}

	public int getType()
	{
		return 3;
	}

	
	public ArrayList<String> getRichieste() {
		return richieste;
	}

	public void setRichieste(ArrayList<String> richieste) {
		this.richieste = richieste;
	}

	
	
}
