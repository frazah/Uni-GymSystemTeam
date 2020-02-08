package it.mat.unical.persistence.dao.jdbc;

import java.util.List;

import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.persistence.DataSource;
import it.mat.unical.persistence.dao.AtletaDao;

public class AtletaJDBC implements AtletaDao{

	
	private DataSource dataSource;

	public AtletaJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Atleta atleta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Atleta findByPrimaryKey(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atleta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Atleta atleta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Atleta atleta) {
		// TODO Auto-generated method stub
		
	}

}
