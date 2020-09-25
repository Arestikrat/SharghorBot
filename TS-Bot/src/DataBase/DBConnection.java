package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ConfigFile.ConfigFileReader;

public class DBConnection {

	private Connection conn;

	public DBConnection() {
		this.connect();
	}

	private void connect() {

		if(!isConnected()) {

			String url = ConfigFileReader.mysqlurl;
			String username = ConfigFileReader.mysqluser;
			String passwd = ConfigFileReader.mysqlpasswd;

			try {
				this.conn = DriverManager.getConnection(url,username, passwd);
			} catch (SQLException e){
				e.printStackTrace();
			}

		}

	}

	private boolean isConnected() {

		return (this.conn == null ? false:true);

	}

	public void disconnect() {

		try {
			this.conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return this.conn;
	}



}
