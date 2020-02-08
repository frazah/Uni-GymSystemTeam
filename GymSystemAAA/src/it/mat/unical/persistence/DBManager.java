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
import it.mat.unical.persistence.dao.AtletaDao;
import it.mat.unical.persistence.dao.CorsoDao;
import it.mat.unical.persistence.dao.TrainerDao;
import it.mat.unical.persistence.dao.UtenteDao;
import it.mat.unical.persistence.dao.jdbc.AtletaJDBC;
import it.mat.unical.persistence.dao.jdbc.CorsoJDBC;
import it.mat.unical.persistence.dao.jdbc.TrainerJDBC;
import it.mat.unical.persistence.dao.jdbc.UtenteJDBC;


public class DBManager {
	
	private static DBManager instance = null;
	/*ArrayList<Atleta> registrati;
	ArrayList<Corso> corsi;
	ArrayList<Trainer> trainer;
	Admin admin;*/
	
	private static  DataSource dataSource;

	static {
		try {
			
			//Class.forName("org.postgresql.Driver");
			//questi vanno messi in file di configurazione!!!	
//			dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			dataSource=new DataSource("jdbc:postgresql://localhost:5432/GymSystemDB","postgres","Marco1604");
			
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
			System.out.println("NON SI CONNETTE");
		}
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	public ArrayList<Atleta> getRegistrati()
	{
		//return registrati;
		return null;
	}



	public ArrayList<Corso> getCorsi() {
		//return corsi;
		return null;
	}

	public ArrayList<Trainer> getTrainer() {
		//return trainer;
		return null;
	}
	
	private DBManager() {
		/*registrati = new ArrayList<Atleta>();
		admin = new Admin();
		corsi = new ArrayList<Corso>();
		trainer = new ArrayList<Trainer>();
		creaCorsiDefault();
		creaTrainerDefault();
		creaRegistratiDefault();
		assegnamentoTrainerCorsi();*/
		
		
	}
	
	private void assegnamentoTrainerCorsi() {
		/*corsi.get(0).setTrainer(trainer.get(0)); //Pugilato --> Tyson
		trainer.get(0).setCorso(corsi.get(0)); //Tyson --> Pugilato*/
		
	}


	private void creaRegistratiDefault() {
		/*Atleta a1 = new Atleta("Marco","Grande","marcogrande1998@gmail.com","slaythespire");
		Atleta a2 = new Atleta("Andrea","De Seta","squame4@gmail.com","h22rew");
		Atleta a3 = new Atleta("Francesco","Corigliano","francesco.fbhz@gmail.com","pagliusi");
		Atleta a4 = new Atleta("Antonino","Scarpelli","antonino@gmail.com","royaldoppioperry");

		registrati.add(a1);
		registrati.add(a2);
		registrati.add(a3);
		registrati.add(a4);*/
	}

	private void creaCorsiDefault() {

		/*String[] giorni1 = new String[]{"1", "2", "3"};
		String[] giorni2 = new String[]{"1", "4", "3"};
		String[] giorni3 = new String[]{"5", "2", "3"};
		
		Corso c1 = new Corso("Pugilato", null, null, "1", giorni1, "Corso Pugilato OwO", "https://www.youtube.com/embed/3gHcQe8Q56s?autoplay=1");
		Corso c2 = new Corso("UFC", null, null, "2", giorni2, null, null);
		Corso c3 = new Corso("Danza",null,null,"3",giorni3,null,null);

		corsi.add(c1);
		corsi.add(c2);
		corsi.add(c3);*/
	}
	
	private void creaTrainerDefault()
	{
		/*Trainer t1 = new Trainer("Mike","Tyson","tyson@hothotmail.com","onepunchman");
		t1.setFotoProfilo("immagini/trainerMikeTyson.jpeg");
		Trainer t2 = new Trainer("Connor","McGregor","ufc@hothotmail.com","notorius");
		t2.setFotoProfilo("immagini/mcgregor.jpg");*/


		/*Trainer t1 = new Trainer("Mike","Tyson","tyson@hothotmail.com","onepunchman");
		Trainer t1 = new Trainer("Mike","Tyson","tyson@hothotmail.com","onepunchman");
		Trainer t1 = new Trainer("Mike","Tyson","tyson@hothotmail.com","onepunchman");*/
		/*trainer.add(t1);
		trainer.add(t2);*/
	}

	public void svuotaRegistrati()
	{
		//registrati.clear();
	}
	
	public void registraUtente(Atleta atleta)
	{
		getAtletaDAO().save(atleta);
	}
	
	public Admin getAdmin() {
		//return admin;
		return null;
	}




	public void stampaRegistrati()
	{
		/*for (int i = 0; i<registrati.size();i++)
			System.out.println(registrati.get(i));*/
	}
	
	public Utente login(String username, String password) {

		/*if (username.equals("admin@admin.com") && password.equals("admin"))
			return admin;
		

		for (int i = 0; i<registrati.size();i++)
			if (username.equals(registrati.get(i).getMail()) && password.equals(registrati.get(i).getPassword()))
				return registrati.get(i);

		
		for (int i = 0; i<trainer.size();i++)
			if (username.equals(trainer.get(i).getMail()) && password.equals(trainer.get(i).getPassword()))
				return trainer.get(i);*/

		return null;
	}
	
	public AtletaDao getAtletaDAO() {
		return new AtletaJDBC(dataSource);
	}
	
	public UtenteDao getUtenteDAO() {
		return new UtenteJDBC(dataSource);
	}
	
	public TrainerDao getTrainerDAO() {
		return new TrainerJDBC(dataSource);
	}
	
	public CorsoDao getCorsoDAO() {
		return new CorsoJDBC(dataSource);
	}
}
