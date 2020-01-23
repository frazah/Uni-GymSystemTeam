package it.mat.unical.ingsw.model;

import java.util.ArrayList;

public class Corso {
	private String nome;
	private Trainer trainer;
	private ArrayList<Atleta> iscritti;
	private String fasciaOraria;
	private String giorni[];
	private String descrizione;
	private String linkVideo;
	//Mettere feedback
	
	
	public Corso(String nome, Trainer trainer, ArrayList<Atleta> iscritti, String fasciaOraria, String [] giorni,
			String descrizione, String linkVideo) {
		super();
		this.nome = nome;
		this.trainer = trainer;
		this.iscritti = iscritti;
		this.fasciaOraria = fasciaOraria;
		this.setGiorni(giorni);
		this.descrizione = descrizione;
		this.linkVideo = linkVideo;
		
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



	public Trainer getTrainer() {
		return trainer;
	}
	
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
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
	
	
	
}
