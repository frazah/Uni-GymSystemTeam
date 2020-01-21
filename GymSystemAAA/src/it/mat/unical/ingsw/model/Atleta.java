package it.mat.unical.ingsw.model;

public class Atleta extends Utente{
	private Tessera tessera;
	private String tipoTessera;
	
	
	public String getTipoTessera() {
		return tipoTessera;
	}

	public void setTipoTessera(String tipoTessera) {
		this.tipoTessera = tipoTessera;
	}

	public Atleta() {
		super();
	}
	
	public Atleta(String nome, String cognome, String mail, String password) {
		super(nome,cognome,mail,password);
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
	
	public void creaTessera()
	{
		tessera = new Tessera();
	}
}
