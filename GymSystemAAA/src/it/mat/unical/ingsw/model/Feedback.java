package it.mat.unical.ingsw.model;

public class Feedback 
{
	private int voto;
	private String testo;
	private String autore;
	private static int count = 0;
	private int id;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public Feedback(int voto, String testo, String autore) {
		super();
		setId(++count);
		this.voto = voto;
		this.testo = testo;
		this.autore = autore;
	}
	
	public Feedback() {
	}

	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	
	
}
