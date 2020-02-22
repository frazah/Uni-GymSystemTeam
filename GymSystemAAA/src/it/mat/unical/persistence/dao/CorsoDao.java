package it.mat.unical.persistence.dao;

import java.util.List;

import it.mat.unical.ingsw.model.Corso;

public interface CorsoDao {

	public void save(Corso corso);  // Create
	public Corso findByPrimaryKey(String nome);     // Retrieve
	public List<Corso> findAll();       
	public void update(Corso corso); //Update
	public void delete(Corso corso); //Delete
}
