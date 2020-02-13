package it.mat.unical.persistence.dao.jdbc;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.ingsw.model.Corso;
import it.mat.unical.ingsw.model.Tessera;
import it.mat.unical.ingsw.model.Atleta;
import it.mat.unical.persistence.DBManager;
import it.mat.unical.persistence.DataSource;
import it.mat.unical.persistence.dao.AtletaDao;

public class AtletaJDBC implements AtletaDao{

	
	private DataSource dataSource;

	public AtletaJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Atleta atleta) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String insert = "insert into atleta(fotoProfilo, nome, cognome,"
					+ " mail, password, tipotessera) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(2, atleta.getNome());
			statement.setString(3, atleta.getCognome());
			statement.setString(1, atleta.getFotoProfilo());			
			statement.setString(5, atleta.getPassword());
			statement.setString(6, atleta.getTipoTessera());
			//statement.setLong(7, );
			statement.setString(4, atleta.getMail());
			statement.executeUpdate();
			//System.out.println(statement);

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
	public Atleta findByPrimaryKey(String mail) {
		Connection connection = null;
		Atleta atleta = null;
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from atleta where mail = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, mail);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				atleta = new Atleta();
				atleta.setNome(result.getString("nome"));				
				atleta.setCognome(result.getString("cognome"));
				atleta.setFotoProfilo(result.getString("fotoprofilo"));
				atleta.setMail(result.getString("mail"));
				atleta.setPassword(result.getString("password"));
				Tessera tessera = DBManager.getInstance().getTesseraDAO().findByPrimaryKey(result.getInt("idtessera"));
				atleta.setTessera(tessera);
				atleta.setTipoTessera(result.getString("tipotessera"));
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
		return atleta;
	}

	@Override
	public List<Atleta> findAll() {
		Connection connection = null;
		List<Atleta> atleti = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			Atleta atleta;
			PreparedStatement statement;
			String query = "select * from atleta";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				atleta = new Atleta();
				atleta = new Atleta();
				atleta.setNome(result.getString("nome"));				
				atleta.setCognome(result.getString("cognome"));
				atleta.setFotoProfilo(result.getString("fotoprofilo"));
				atleta.setMail(result.getString("mail"));
				atleta.setPassword(result.getString("password"));
				Tessera tessera = DBManager.getInstance().getTesseraDAO().findByPrimaryKey(result.getInt("idtessera"));
				atleta.setTessera(tessera);
				atleta.setTipoTessera(result.getString("tipotessera"));
				
				atleti.add(atleta);
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
		return atleti;
	}

	@Override
	public void update(Atleta atleta) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String update = "update atleta SET nome = ?, cognome = ?, fotoprofilo = ?, password = ?, tipotessera = ?, idtessera = ? WHERE mail=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, atleta.getNome());
			statement.setString(2, atleta.getCognome());
			statement.setString(3, atleta.getFotoProfilo());			
			statement.setString(4, atleta.getPassword());
			statement.setString(5, atleta.getTipoTessera());
			statement.setLong(6, atleta.getTessera().getID());
			statement.setString(7, atleta.getMail());
			
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
	public void delete(Atleta atleta) {
		// TODO Auto-generated method stub
		
	}

}
