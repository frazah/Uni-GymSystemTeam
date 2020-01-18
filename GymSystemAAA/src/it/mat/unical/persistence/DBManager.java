package it.mat.unical.persistence;

import java.util.ArrayList;
import java.util.List;

import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.ingsw.model.Tessera;
import it.mat.unical.ingsw.model.Utente;

public class DBManager {
	private static DBManager instance = null;
	List<Atleta> atleti;
	Atleta u;
	
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
			Atleta u = new Atleta();
			u.setMail("atleta@atleta");
			u.setPassword("atleta");
			u.setNome("Atleta");
			u.setCognome("Atletoso");
			u.setEta(22);
			ArrayList<Corso> corsi = new ArrayList<Corso>();
			Corso corso1 = new Corso ("Pugilato",null,null,null,null, "corsoPugilato.jsp");
			Corso corso2 = new Corso ("Kickboxing",null,null,null,null, null);
			Corso corso3 = new Corso ("Karate",null,null,null,null, null);
			corsi.add(corso1);
			corsi.add(corso2);
			corsi.add(corso3);
			Tessera tessera = new Tessera("11/11/2011","11/11/2012","1",corsi);
			u.setTessera(tessera);
			return u;
		}
		return null;
	}
}
