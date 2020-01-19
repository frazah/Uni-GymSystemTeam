package it.mat.unical.persistence;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.ingsw.model.Tessera;
import it.mat.unical.ingsw.model.Utente;

public class DBManager {
	private static DBManager instance = null;

	ArrayList<Atleta> registrati;
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {
		registrati = new ArrayList<Atleta>();
	}
	
	public void svuotaRegistrati()
	{
		registrati.clear();
	}
	
	public void registraUtente(Atleta atleta)
	{
		registrati.add(atleta);
		stampaRegistrati();
	}
	
	public void stampaRegistrati()
	{
		for (int i = 0; i<registrati.size();i++)
			System.out.println(registrati.get(i));
	}
	
	public Utente login(String username, String password) {

		for (int i = 0; i<registrati.size();i++)
		{
			if (username.equals(registrati.get(i).getMail()) && password.equals(registrati.get(i).getPassword())) {
				/*Atleta u = new Atleta();
				u.setMail("atleta@atleta");
				u.setPassword("atleta");
				u.setNome("Atleta");
				u.setCognome("Atletoso");
				ArrayList<Corso> corsi = new ArrayList<Corso>();
				Corso corso1 = new Corso ("Pugilato",null,null,null,null, "corsoPugilato.jsp");
				Corso corso2 = new Corso ("Kickboxing",null,null,null,null, null);
				Corso corso3 = new Corso ("Karate",null,null,null,null, null);
				corsi.add(corso1);
				corsi.add(corso2);
				corsi.add(corso3);
				u.setTessera(tessera);
				u.setFotoProfilo("immagini/trainerMikeTyson.jpeg");
				ArrayList<Corso> corsi = new ArrayList<Corso>();
				Tessera t = new Tessera("11/11/2011","11/11/2012","1",corsi);
			
				registrati.get(i).setTessera(t);*/
				return registrati.get(i);
			}
		}

		return null;
	}
}
