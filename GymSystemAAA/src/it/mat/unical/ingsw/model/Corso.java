package it.mat.unical.ingsw.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import it.mat.unical.persistence.DBManager;


public class Corso {
	private String nome;
	private ArrayList<Atleta> iscritti;
	private String fasciaOraria;
	private String giorni[];
	private String descrizione;
	private String linkVideo;
	private ArrayList<Feedback> feedback;
	
	public void stampa()
	{
		System.out.println(nome+fasciaOraria);
	}
	

	
	public Corso(String nome, Trainer trainer, ArrayList<Atleta> iscritti, String fasciaOraria, String [] giorni,
			String descrizione, String linkVideo) {
		super();
		this.nome = nome;
		this.iscritti = iscritti;
		this.fasciaOraria = fasciaOraria;
		this.setGiorni(giorni);
		this.descrizione = descrizione;
		this.linkVideo = linkVideo;
		feedback = new ArrayList<Feedback>();
	}

	
	public String getUltimaRecensione()
	{
		return feedback.get(feedback.size()-1).getTesto();
	}
	
	public int getUltimoVoto()
	{
		return feedback.get(feedback.size()-1).getVoto();
	}
	
	
	public ArrayList<Feedback> getFeedback() {
		return feedback;
	}



	public void setFeedback(ArrayList<Feedback> feedback) {
		this.feedback = feedback;
	}

	public void impostaFeedback(ArrayList<Integer> feed) {
		
		if(feedback == null)
			feedback  =new ArrayList<Feedback>();
		
		if(feed != null)
		for (int i = 0;i<feed.size();i++)
		{
			Feedback f = DBManager.getInstance().getFeedbackDAO().findByPrimaryKey(feed.get(i));
			feedback.add(f);
		}
	}

	public int getMediaFeedback()
	{
		
		if(feedback.isEmpty())
			return 1;
		else
		{
			int m = 0;
			for(Feedback f : feedback)
			{
				m+=f.getVoto();
			}
			m/=feedback.size();
			
			return m;
		}
	
	}
	
	public void aggiungiFeedback(Feedback f)
	{
		boolean presente = false;
		for(Feedback feed : feedback)
		{
			if(feed.getAutore().equals(f.getAutore()))
			{
				presente =true;
				feed.setTesto(f.getTesto());
				feed.setVoto(f.getVoto());
			}
			
		}
		
		

		if(!presente)
		feedback.add(f);
	}
	
	
	
	

	public Corso() {
		// TODO Auto-generated constructor stub
}

	public String getFasciaOraria() {
		return fasciaOraria;
	}


	public void setFasciaOraria(String fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}




	



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	
	public ArrayList<Atleta> getIscritti() {
		return iscritti;
	}
	public void setIscritti(ArrayList<Atleta> iscritti) {
		this.iscritti = iscritti;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getLinkVideo() {
		return linkVideo;
	}
	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}


	public String[] getGiorni() {
		return giorni;
	}


	public void setGiorni(String giorni[]) {
		this.giorni = giorni;
	}
	

	public Boolean contieneGiorno(String s)
	{
		for (int i = 0;i < giorni.length; i++)
		{
			if (s.contentEquals(giorni[i]))
			{
				return true;
			}
		}
		return false;
	}

	
	public Trainer getTrainer()
	{
		List<Trainer> trainer = DBManager.getInstance().getTrainer();
		Trainer t = null;
		for(Trainer i : trainer)
		{
			if(i.getCorso()!= null && i.getCorso().getNome().equals(this.getNome()))
			{
				t = i;
			}
		}
		
		
		return t;
	}
	
}
