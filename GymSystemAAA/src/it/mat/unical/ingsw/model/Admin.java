package it.mat.unical.ingsw.model;

public class Admin extends Utente{
	
	public Admin() {
		super("Admin", "Admin", "admin@admin.com", "admin");
		super.setFotoProfilo("immagini/admin.jpg");
	}

}
