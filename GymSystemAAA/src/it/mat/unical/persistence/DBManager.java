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
import it.mat.unical.persistence.dao.AdminDao;
import it.mat.unical.persistence.dao.AtletaDao;
import it.mat.unical.persistence.dao.CorsoDao;
import it.mat.unical.persistence.dao.FeedbackDao;
import it.mat.unical.persistence.dao.TesseraDao;
import it.mat.unical.persistence.dao.TrainerDao;
import it.mat.unical.persistence.dao.UtenteDao;
import it.mat.unical.persistence.dao.jdbc.AdminJDBC;
import it.mat.unical.persistence.dao.jdbc.AtletaJDBC;
import it.mat.unical.persistence.dao.jdbc.CorsoJDBC;
import it.mat.unical.persistence.dao.jdbc.FeedbackJDBC;
import it.mat.unical.persistence.dao.jdbc.TesseraJDBC;
import it.mat.unical.persistence.dao.jdbc.TrainerJDBC;
import it.mat.unical.persistence.dao.jdbc.UtenteJDBC;


public class DBManager {
	
	private static DBManager instance = null;

	
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

	public List<Atleta> getRegistrati()
	{
		return getAtletaDAO().findAll();
	}



	public List<Corso> getCorsi() {
		return getCorsoDAO().findAll();
	}

	public List<Trainer> getTrainer() {
		return getTrainerDAO().findAll();
	}
	
	private DBManager() {

	}


	public void svuotaRegistrati()
	{
		//registrati.clear();
	}
	
	public void registraUtente(Atleta atleta)
	{
		getAtletaDAO().save(atleta);
	}
	
	public void registraTessera(Tessera tessera)
	{
		getTesseraDAO().save(tessera);
	}
	
	public void registraCorso(Corso corso)
	{
		getCorsoDAO().save(corso);
	}
	
	public Admin getAdmin() {
		return getAdminDAO().findByPrimaryKey("admin@admin.com");
	}
	
	public List<Tessera> getTessere() {
		return getTesseraDAO().findAll();
	}

	public void aggiornaAdmin(Admin admin)
	{
		getAdminDAO().update(admin);
	}
	
	public void aggiornaTessera(Tessera t)
	{
		getTesseraDAO().update(t);
	}
	
	
	
	public void aggiornaAtleta(Atleta a)
	{
		getAtletaDAO().update(a);
	}
	


	public void aggiornaTrainer(Trainer trainer)
	{
		getTrainerDAO().update(trainer);
	}
	
	public Utente login(String username, String password) {

		Utente user = null;
		
		user = getAdminDAO().findByPrimaryKey(username);
		
		if (user != null && password.equals(user.getPassword()))
			return user;
		
		user = getTrainerDAO().findByPrimaryKey(username);
		
		if (user != null && password.equals(user.getPassword()))
			return user;
		
		user = getAtletaDAO().findByPrimaryKey(username);
		
		if (user != null && password.equals(user.getPassword()))
			return user;
		
		return null;
	}
	
	public AdminDao getAdminDAO() {
		return new AdminJDBC(dataSource);
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

	public FeedbackDao getFeedbackDAO() {
		return new FeedbackJDBC(dataSource);
	}

	public TesseraDao getTesseraDAO() {
		return new TesseraJDBC(dataSource);
	}
}
