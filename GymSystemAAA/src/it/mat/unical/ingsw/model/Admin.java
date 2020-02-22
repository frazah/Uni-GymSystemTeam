package it.mat.unical.ingsw.model;

import java.util.ArrayList;
import java.util.List;

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
	
	public void setRichiesteJDBC(String[] richieste)
	{
		for (int i = 0; i<richieste.length;i++)
		{
			this.richieste.add(richieste[i]);
		}
	}

	
	
}
