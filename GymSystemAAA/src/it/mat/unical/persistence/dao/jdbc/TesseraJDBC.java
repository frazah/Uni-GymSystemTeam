package it.mat.unical.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.mat.unical.ingsw.model.Tessera;
import it.mat.unical.ingsw.model.Tessera;
import it.mat.unical.persistence.DBManager;
import it.mat.unical.persistence.DataSource;
import it.mat.unical.persistence.dao.TesseraDao;

public class TesseraJDBC implements TesseraDao{

	private DataSource dataSource;

	public TesseraJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Tessera tessera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tessera findByPrimaryKey(int id) {
		Connection connection = null;
		Tessera tessera = null;
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from tessera where id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				tessera = new Tessera();
				tessera.setID(result.getInt("id"));				
				tessera.setDataDiIscrizione(result.getTimestamp("datadiiscrizione").toLocalDateTime());
				tessera.setDataDiScadenza(result.getTimestamp("datadiscadenza").toLocalDateTime());
				
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
		return tessera;
	}

	@Override
	public List<Tessera> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tessera tessera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Tessera tessera) {
		// TODO Auto-generated method stub
		
	}

}
