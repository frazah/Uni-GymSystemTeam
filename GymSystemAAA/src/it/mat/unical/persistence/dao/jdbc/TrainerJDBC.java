package it.mat.unical.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.mat.unical.ingsw.model.Corso;
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
		return null;
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
				String mail = result.getString("mail");
				trainer.setMail(mail);
				/*PreparedStatement statement2;
				String query2 = "select nomecorso from associazionecorsotrainer where mailtrainer = ?";
				statement2 = connection.prepareStatement(query2);
				statement2.setString(1, mail);
				ResultSet result2 = statement2.executeQuery();
				trainer.setPassword(result.getString("password"));
				CorsoJDBC corsoDB = new CorsoJDBC(dataSource);
				trainer.setCorso(corsoDB.findByPrimaryKey(result2.getString("nomecorso")));*/
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Trainer trainer) {
		// TODO Auto-generated method stub
		
	}

}
