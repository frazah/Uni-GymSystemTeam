package it.mat.unical.ingsw.model;

public class Atleta extends Utente{
	private Tessera tessera;
	
	
	public Atleta() {
		super();
		tessera = new Tessera();
	}
	
	public Atleta(String nome, String cognome, String mail, String password) {
		super(nome,cognome,mail,password);
		tessera = new Tessera();
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}
	
	public Tessera getTessera() {
		return tessera;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
