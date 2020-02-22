package it.mat.unical.persistence.dao;

import java.util.List;

import it.mat.unical.ingsw.model.Feedback;


public interface FeedbackDao {

	public void save(Feedback feedback);  // Create
	public Feedback findByPrimaryKey(int id);     // Retrieve
	public List<Feedback> findAll();       
	public void update(Feedback feedback); //Update
	public void delete(Feedback feedback); //Delete
}
