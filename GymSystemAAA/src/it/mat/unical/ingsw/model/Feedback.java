package it.mat.unical.ingsw.model;

import java.util.List;

import it.mat.unical.persistence.DBManager;

public class Feedback 
{
	private int voto;
	private String testo;
	private String autore;
	private int id;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public Feedback(int voto, String testo, String autore) {
		super();
		int n;
		List<Feedback> feedback = DBManager.getInstance().getFeedbackDAO().findAll();
		if (feedback.size() == 0)
			n = 1;
		else
			n = feedback.get(feedback.size()-1).getId()+1;
		
		setId(n);
		this.voto = voto;
		this.testo = testo;
		this.autore = autore;
	}
	
	public Feedback() {
	}

	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	
	
}
