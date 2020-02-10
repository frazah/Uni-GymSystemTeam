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
import it.mat.unical.ingsw.model.Corso;
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
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String insert = "insert into corso(nome, fasciaoraria, giorni, descrizione,"
					+ " linkvideo, idfeedback) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, corso.getNome());
			statement.setString(2, corso.getFasciaOraria());
			String[] data = corso.getGiorni();
			Array sqlArray = connection.createArrayOf("varchar", data);
			statement.setArray(3, sqlArray);
			statement.setString(4, corso.getDescrizione());
			statement.setString(5, corso.getLinkVideo());		
			statement.setArray(6, null);
			statement.executeUpdate();
			System.out.println(statement);

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
		Connection connection = null;
		List<Corso> corsi = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			Corso corso;
			PreparedStatement statement;
			String query = "select * from corso";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
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
								
				corsi.add(corso);
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
		return corsi;
	}
	

	@Override
	public void update(Corso corso) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Corso corso) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String delete = "delete FROM corso WHERE nome = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, corso.getNome());
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

}
