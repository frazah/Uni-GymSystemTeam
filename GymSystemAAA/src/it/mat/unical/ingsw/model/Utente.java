package it.mat.unical.ingsw.model;

import java.awt.Image;

public class Utente {
	private Image fotoProfilo;
	private String password;
	private String nome;
	private String cognome;
	private String mail;
	private int eta;
	
	
	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
}
