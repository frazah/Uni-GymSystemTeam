package it.mat.unical.ingsw.model;

import java.util.ArrayList;

public class Corso {
	private String nome;
	private Trainer trainer;
	private ArrayList<Atleta> iscritti;
	private String descrizione;
	private String linkVideo;
	private String url;
	//Mettere feedback
	
	public Corso(String nome,Trainer trainer, ArrayList<Atleta> iscritti, String descrizione, String linkVideo, String url) {
		super();
		this.nome = nome;
		this.trainer = trainer;
		this.iscritti = iscritti;
		this.descrizione = descrizione;
		this.linkVideo = linkVideo;
		this.url = url;
	}
	
	
	
	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
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
	
	
	
}
