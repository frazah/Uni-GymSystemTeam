package it.mat.unical.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.mat.unical.ingsw.model.Utente;
import it.mat.unical.ingsw.model.Tessera;
import it.mat.unical.ingsw.model.Utente;
import it.mat.unical.persistence.DBManager;
import it.mat.unical.persistence.DataSource;
import it.mat.unical.persistence.dao.UtenteDao;

public class UtenteJDBC implements UtenteDao {
	
	private DataSource dataSource;
	
	public UtenteJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Utente utente) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String insert = "insert into utente(fotoProfilo, nome, cognome,"
					+ " mail, password) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getFotoProfilo());
			statement.setString(2, utente.getNome());
			statement.setString(3, utente.getCognome());
			statement.setString(4, utente.getMail());
			statement.setString(5, utente.getPassword());
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
	public Utente findByPrimaryKey(String mail) {
		Connection connection = null;
		Utente utente = null;
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from utente where mail = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, mail);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setNome(result.getString("nome"));				
				utente.setCognome(result.getString("cognome"));
				utente.setFotoProfilo(result.getString("fotoprofilo"));
				utente.setMail(result.getString("mail"));
				utente.setPassword(result.getString("password"));
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
		return utente;
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utente utente) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String update = "update utente SET nome = ?, cognome = ?, fotoprofilo = ?, password = ? WHERE mail=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, utente.getNome());
			statement.setString(2, utente.getCognome());
			statement.setString(3, utente.getFotoProfilo());			
			statement.setString(4, utente.getPassword());
			statement.setString(5, utente.getMail());
			
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
	public void delete(Utente utente) {
		// TODO Auto-generated method stub

	}

}
