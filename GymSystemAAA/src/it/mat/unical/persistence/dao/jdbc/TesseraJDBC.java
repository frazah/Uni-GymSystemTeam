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
import it.mat.unical.ingsw.model.Tessera;
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
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String insert = "insert into tessera(datadiiscrizione, datadiscadenza, id , nomicorsi)"
					+ " values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			Date sqlDate1 = Date.valueOf(tessera.getDataDiIscrizione().toLocalDate());
			statement.setDate(1, sqlDate1);
			Date sqlDate2 = Date.valueOf(tessera.getDataDiScadenza().toLocalDate());
			statement.setDate(2, sqlDate2);
			statement.setLong(3, tessera.getID());
			ArrayList<String> nomi = new ArrayList<String>();
			for (int i = 0; i < tessera.getCorsi().size();i++)
			{
				nomi.add(tessera.getCorsi().get(i).getNome());
			}
			String[] data = nomi.toArray(new String[nomi.size()]);
			java.sql.Array sqlArray = connection.createArrayOf("varchar", data);
			statement.setArray(4, sqlArray);

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
				Array a = result.getArray("nomicorsi");
				String[] nomi = (String[])a.getArray();
				ArrayList<Corso> corsi = new ArrayList<Corso>();
				for (int i=0;i<nomi.length;i++)
				{
					corsi.add(DBManager.getInstance().getCorsoDAO().findByPrimaryKey(nomi[i]));
				}
				tessera.setCorsi(corsi);
				
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
		Connection connection = null;
		List<Tessera> tessere = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			Tessera tessera;
			PreparedStatement statement;
			String query = "select * from tessera";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				tessera = new Tessera();
				tessera.setDataDiIscrizione(result.getTimestamp("datadiiscrizione").toLocalDateTime());
				tessera.setDataDiScadenza(result.getTimestamp("datadiscadenza").toLocalDateTime());	
				tessera.setID(result.getInt("id"));
				Array a = result.getArray("nomicorsi");
				String[] nomi = (String[])a.getArray();
				ArrayList<Corso> corsi = new ArrayList<Corso>();
				for (int i=0;i<nomi.length;i++)
				{
					corsi.add(DBManager.getInstance().getCorsoDAO().findByPrimaryKey(nomi[i]));
				}
				tessera.setCorsi(corsi);
				
				tessere.add(tessera);
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
		return tessere;
	}

	@Override
	public void update(Tessera tessera) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String update = "update tessera SET datadiiscrizione = ?, datadiscadenza = ?, nomicorsi = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			Date sqlDate1 = Date.valueOf(tessera.getDataDiIscrizione().toLocalDate());
			statement.setDate(1, sqlDate1);
			Date sqlDate2 = Date.valueOf(tessera.getDataDiScadenza().toLocalDate());
			statement.setDate(2, sqlDate2);
			
			ArrayList<String> nomi = new ArrayList<String>();
			for (int i = 0; i < tessera.getCorsi().size();i++)
			{
				nomi.add(tessera.getCorsi().get(i).getNome());
			}
			String[] data = nomi.toArray(new String[nomi.size()]);
			java.sql.Array sqlArray = connection.createArrayOf("varchar", data);
			statement.setArray(3, sqlArray);
			
			statement.setLong(4, tessera.getID());
			
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
	public void delete(Tessera tessera) {
		Connection connection = null;
		try {
			connection = this.dataSource.getConnection();
			String delete = "delete FROM tessera WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, tessera.getID());
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
