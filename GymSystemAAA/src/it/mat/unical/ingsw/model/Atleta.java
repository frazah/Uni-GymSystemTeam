package it.mat.unical.ingsw.model;

public class Atleta extends Utente{
	private Tessera tessera;
	
	public Atleta() {
		tessera = new Tessera();
	}
	
	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}
	
	public Tessera getTessera() {
		return tessera;
	}
}
