package it.mat.unical.ingsw.model;

import java.util.ArrayList;

public class Admin extends Utente{
	
	ArrayList <String> richieste;	//inserisco le richieste per modiche ai corsi eccetera
	
	public Admin() {
		super("Admin", "Admin", "admin@admin.com", "admin");
		super.setFotoProfilo("immagini/admin.jpg");
	}

}
