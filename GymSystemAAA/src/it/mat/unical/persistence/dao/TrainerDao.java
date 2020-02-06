package it.mat.unical.persistence.dao;

import java.util.List;

import it.mat.unical.ingsw.model.Trainer;

public interface TrainerDao {
	
	public void save(Trainer trainer);  // Create
	public Trainer findByPrimaryKey(String mail);     // Retrieve
	public List<Trainer> findAll();       
	public void update(Trainer trainer); //Update
	public void delete(Trainer trainer); //Delete

}
