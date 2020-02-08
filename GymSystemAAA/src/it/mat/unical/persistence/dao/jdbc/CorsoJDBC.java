package it.mat.unical.persistence.dao.jdbc;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.ingsw.model.Trainer;
import it.mat.unical.persistence.DBManager;
import it.mat.unical.persistence.DataSource;
import it.mat.unical.persistence.dao.CorsoDao;

public class CorsoJDBC implements CorsoDao{

	private DataSource dataSource;

	public CorsoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Corso corso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corso findByPrimaryKey(String nome) {
		Connection connection = null;
		Corso corso = null;
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from corso where nome = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, nome);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				corso = new Corso();
				corso.setNome(result.getString("nome"));				
				corso.setFasciaOraria(result.getString("fasciaoraria"));
				Array days = (Array) result.getArray("giorni");
				corso.setGiorni((String[]) days.getArray()); 
				corso.setDescrizione(result.getString("descrizione"));
				corso.setLinkVideo(result.getString("linkvideo"));
				Array id = (Array) result.getArray("idfeedback");
				ArrayList<Integer> feed =(ArrayList<Integer>) id;
				corso.impostaFeedback(feed);
				
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
		return corso;
	}

	@Override
	public List<Corso> findAll() {
		return null;
	}

	@Override
	public void update(Corso corso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Corso corso) {
		// TODO Auto-generated method stub
		
	}

}
