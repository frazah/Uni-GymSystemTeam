package it.mat.unical.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.ingsw.model.Tessera;
import it.mat.unical.ingsw.model.Trainer;
import it.mat.unical.persistence.DBManager;
import it.mat.unical.persistence.DataSource;
import it.mat.unical.persistence.dao.TrainerDao;

public class TrainerJDBC implements TrainerDao{
	
	private DataSource dataSource;

	public TrainerJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Trainer trainer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Trainer findByPrimaryKey(String mail) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Trainer trainer = null;
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from trainer where mail = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, mail);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				trainer = new Trainer();
				trainer.setNome(result.getString("nome"));				
				trainer.setCognome(result.getString("cognome"));
				trainer.setFotoProfilo(result.getString("fotoprofilo"));
				trainer.setMail(result.getString("mail"));
				trainer.setPassword(result.getString("password"));
				Corso corso = DBManager.getInstance().getCorsoDAO().findByPrimaryKey(result.getString("nomecorsooccupato"));
				trainer.setCorso(corso);
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
		return trainer;
	}

	@Override
	public List<Trainer> findAll() {
		Connection connection = null;
		List<Trainer> trainers = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			Trainer trainer;
			PreparedStatement statement;
			String query = "select * from trainer";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				trainer = new Trainer();
				trainer.setFotoProfilo(result.getString("fotoprofilo"));		
				trainer.setNome(result.getString("nome"));
				trainer.setCognome(result.getString("cognome"));
				trainer.setPassword(result.getString("password"));
				String mail = result.getString("mail");
				trainer.setMail(mail);
				Corso corso = DBManager.getInstance().getCorsoDAO().findByPrimaryKey(result.getString("nomecorsooccupato"));
				trainer.setCorso(corso);
				
				trainers.add(trainer);
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
		return trainers;
	}

	@Override
	public void update(Trainer trainer) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String update = "update trainer SET nome = ?, cognome = ?, fotoprofilo = ?, password = ?, nomecorsooccupato = ? WHERE mail=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, trainer.getNome());
			statement.setString(2, trainer.getCognome());
			statement.setString(3, trainer.getFotoProfilo());			
			statement.setString(4, trainer.getPassword());
			statement.setString(6, trainer.getMail());
			String nomeCorso;
			if (trainer.getCorso() == null)
				nomeCorso = "null";
			else
				nomeCorso = trainer.getCorso().getNome();
			statement.setString(5, nomeCorso);
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
	public void delete(Trainer trainer) {
		// TODO Auto-generated method stub
		
	}

}
