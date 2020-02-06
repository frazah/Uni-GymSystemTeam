package it.mat.unical.persistence.dao;

import java.util.List;

import it.mat.unical.ingsw.model.Admin;

public interface AdminDao {

	public void save(Admin admin);  // Create
	public Admin findByPrimaryKey(String mail);     // Retrieve
	public List<Admin> findAll();       
	public void update(Admin admin); //Update
	public void delete(Admin admin); //Delete	
}
