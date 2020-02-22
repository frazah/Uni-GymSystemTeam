package it.mat.unical.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private String uri;
//	private String port;
	private String username;
	private String password;
	
	public DataSource(String uri, String username, String password) {
		super();
		this.uri = uri;
//		this.port = port;
		this.username = username;
		this.password = password;
	}
	
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(uri, username, password);
		return connection;
	}
	
	
	
}
