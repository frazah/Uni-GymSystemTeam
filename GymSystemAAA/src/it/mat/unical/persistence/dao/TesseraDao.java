package it.mat.unical.persistence.dao;

import java.util.List;

import it.mat.unical.ingsw.model.Tessera;

public interface TesseraDao {
	
	public void save(Tessera tessera);  // Create
	public Tessera findByPrimaryKey(int id);     // Retrieve
	public List<Tessera> findAll();       
	public void update(Tessera tessera); //Update
	public void delete(Tessera tessera); //Delete

}
