package it.mat.unical.persistence.dao.jdbc;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.mat.unical.ingsw.model.Feedback;
import it.mat.unical.ingsw.model.Feedback;
import it.mat.unical.persistence.DataSource;
import it.mat.unical.persistence.dao.FeedbackDao;

public class FeedbackJDBC implements FeedbackDao{

	private DataSource dataSource;

	public FeedbackJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Feedback feedback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Feedback findByPrimaryKey(int id) {
		Connection connection = null;
		Feedback feedback = null;
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from feedback where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				feedback = new Feedback();
				feedback.setVoto(result.getInt("voto"));				
				feedback.setTesto(result.getString("testo"));
				feedback.setAutore(result.getString("autore")); 
				feedback.setId(result.getInt("id"));
				
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}	
		return feedback;
	}

	@Override
	public List<Feedback> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Feedback feedback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Feedback feedback) {
		// TODO Auto-generated method stub
		
	}

}
