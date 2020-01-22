package it.mat.unical.ingsw.model;


public class Trainer extends Utente{
	
	Corso corsoOccupato;
	
	public Trainer() {
		super();
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
