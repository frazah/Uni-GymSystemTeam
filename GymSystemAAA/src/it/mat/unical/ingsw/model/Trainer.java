package it.mat.unical.ingsw.model;

import it.mat.unical.persistence.dao.jdbc.CorsoJDBC;

public class Trainer extends Utente{
	
	Corso corsoOccupato;
	

	public Trainer() {
		super();
	}
	
	public int getType()
	{
		return 2;
	}

	
	public Trainer(String nome, String cognome, String mail, String password)
	{
		super(nome,cognome,mail,password);


	}

	public Corso getCorso() {
		return corsoOccupato;
	}

	public void setCorso(Corso corso) {
		this.corsoOccupato = corso;
	}	

}
