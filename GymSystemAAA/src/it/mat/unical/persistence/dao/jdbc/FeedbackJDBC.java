package it.mat.unical.persistence.dao.jdbc;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.ingsw.model.Feedback;
import it.mat.unical.ingsw.model.Feedback;
import it.mat.unical.ingsw.model.Feedback;
import it.mat.unical.persistence.DBManager;
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
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String insert = "insert into feedback(voto, autore, testo, id) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, feedback.getVoto());
			statement.setString(2, feedback.getAutore());
			statement.setString(3, feedback.getTesto());
			statement.setInt(4, feedback.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (connection != null)
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
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
		Connection connection = null;
		List<Feedback> feedbacks = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			Feedback feedback;
			PreparedStatement statement;
			String query = "select * from feedback";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				feedback = new Feedback();
				feedback.setVoto(result.getInt("voto"));				
				feedback.setTesto(result.getString("testo"));
				feedback.setAutore(result.getString("autore")); 
				feedback.setId(result.getInt("id"));
				
				feedbacks.add(feedback);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return feedbacks;
	}

	@Override
	public void update(Feedback feedback) {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String update = "update feedback SET voto = ?, autore = ?, testo = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, feedback.getVoto());
			statement.setString(2, feedback.getAutore());
			statement.setString(3, feedback.getTesto());
			statement.setInt(4, feedback.getId());
			
			
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	@Override
	public void delete(Feedback feedback) {
		// TODO Auto-generated method stub
		
	}

}
