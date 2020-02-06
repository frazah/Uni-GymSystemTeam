package it.mat.unical.persistence.dao;

import java.util.List;

import it.mat.unical.ingsw.model.Utente;

public interface UtenteDao {

	public void save(Utente utente);  // Create
	public Utente findByPrimaryKey(String mail);     // Retrieve
	public List<Utente> findAll();       
	public void update(Utente utente); //Update
	public void delete(Utente utente); //Delete
}
