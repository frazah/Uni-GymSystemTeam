package it.mat.unical.ingsw.model;

import java.awt.Image;

public class Utente {
	private String fotoProfilo;
	private String password;
	private String nome;
	private String cognome;
	private String mail;

	public Utente(String nome, String cognome, String mail, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.password = password;
	}
	
	public int getType()
	{
		return 0;
	}

	public Utente() {
		// TODO Auto-generated constructor stub
	}

	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Override
	public String toString() {
		String s = nome+" "+cognome+" "+mail+" "+password;
		return s;
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

	public String getFotoProfilo() {
		return fotoProfilo;
	}

	public void setFotoProfilo(String fotoProfilo) {
		this.fotoProfilo = fotoProfilo;
	}
	
	
}
