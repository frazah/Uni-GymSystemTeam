package it.mat.unical.persistence;

import java.util.ArrayList;
import java.util.List;

import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.ingsw.model.Utente;

public class DBManager {
	private static DBManager instance = null;
	List<Atleta> atleti;
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {
	}
	
	public Utente login(String username, String password) {
		if (username.equals("atleta@atleta") && password.equals("atleta")) {
			Utente u = new Utente();
			u.setUsername("atleta");
			u.setPassword("atleta");
			return u;
		}
		return null;
	}
}
