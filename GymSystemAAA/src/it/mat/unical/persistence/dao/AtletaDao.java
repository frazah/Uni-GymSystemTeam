package it.mat.unical.persistence.dao;

import java.util.List;

import it.mat.unical.ingsw.model.Atleta;

public interface AtletaDao {

	public void save(Atleta atleta);  // Create
	public Atleta findByPrimaryKey(String mail);     // Retrieve
	public List<Atleta> findAll();       
	public void update(Atleta atleta); //Update
	public void delete(Atleta atleta); //Delete
}
