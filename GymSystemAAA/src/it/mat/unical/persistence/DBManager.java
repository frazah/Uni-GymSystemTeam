package it.mat.unical.persistence;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import it.mat.unical.ingsw.model.Admin;
import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.ingsw.model.Tessera;
import it.mat.unical.ingsw.model.Trainer;
import it.mat.unical.ingsw.model.Utente;

public class DBManager {
	
	private static DBManager instance = null;
	ArrayList<Atleta> registrati;
	ArrayList<Corso> corsi;
	ArrayList<Trainer> trainer;
	Admin admin;
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
		

	



	public ArrayList<Corso> getCorsi() {
		return corsi;
	}



	public ArrayList<Trainer> getTrainer() {
		return trainer;
	}



	private DBManager() {
		registrati = new ArrayList<Atleta>();
		admin = new Admin();
		corsi = new ArrayList<Corso>();
		trainer = new ArrayList<Trainer>();
		creaCorsiDefault();
		creaTrainerDefault();
		creaRegistratiDefault();
		assegnamentoTrainerCorsi();
		
	}
	
	private void assegnamentoTrainerCorsi() {
		corsi.get(0).setTrainer(trainer.get(0)); //Pugilato --> Tyson
		trainer.get(0).setCorso(corsi.get(0)); //Tyson --> Pugilato
		
	}


	private void creaRegistratiDefault() {
		Atleta a1 = new Atleta("Marco","Grande","marcogrande1998@gmail.com","slaythespire");
		Atleta a2 = new Atleta("Andrea","De Seta","squame4@gmail.com","h22rew");
		Atleta a3 = new Atleta("Francesco","Corigliano","francesco.fbhz@gmail.com","pagliusi");
		Atleta a4 = new Atleta("Antonino","Scarpelli","antonino@gmail.com","royaldoppioperry");
		
		ArrayList<Corso> corsiA1 = new ArrayList<Corso>();
		
		corsiA1.add(corsi.get(0));
		corsiA1.add(corsi.get(0));
		corsiA1.add(corsi.get(0));
		a1.creaTessera();
		a1.getTessera().setCorsi(corsiA1);
		
		registrati.add(a1);
		registrati.add(a2);
		registrati.add(a3);
		registrati.add(a4);
	}

	private void creaCorsiDefault() {
		Corso c1 = new Corso("Pugilato", null, null, "1", null, null, null, "corsoPugilato.jsp");
		Corso c2 = new Corso("UFC", null, null, "2", null, null, null, "corsoPugilato.jsp");
		corsi.add(c1);
		corsi.add(c2);
	}
	
	private void creaTrainerDefault()
	{
		Trainer t1 = new Trainer("Mike","Tyson","tyson@hothotmail.com","onepunchman");
		Trainer t2 = new Trainer("Connor","McGreggor","ufc@hothotmail.com","notorius");

		/*Trainer t1 = new Trainer("Mike","Tyson","tyson@hothotmail.com","onepunchman");
		Trainer t1 = new Trainer("Mike","Tyson","tyson@hothotmail.com","onepunchman");
		Trainer t1 = new Trainer("Mike","Tyson","tyson@hothotmail.com","onepunchman");*/
		trainer.add(t1);
		trainer.add(t2);
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
	
	public Admin getAdmin() {
		return admin;
	}




	public void stampaRegistrati()
	{
		for (int i = 0; i<registrati.size();i++)
			System.out.println(registrati.get(i));
	}
	
	public Utente login(String username, String password) {
		if (username.equals("admin@admin.com") && password.equals("admin"))
			return admin;
		
		for (int i = 0; i<registrati.size();i++)
			if (username.equals(registrati.get(i).getMail()) && password.equals(registrati.get(i).getPassword()))
				return registrati.get(i);

		
		for (int i = 0; i<trainer.size();i++)
			if (username.equals(trainer.get(i).getMail()) && password.equals(trainer.get(i).getPassword()))
				return trainer.get(i);

		return null;
	}
}
