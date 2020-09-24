package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConfigFile.ConfigFileReader;

//import de.Arestikrat.ConfigFile.Configuration;

public class MySQL 
{

	public static Connection conn;
	public static void connect()
	{
		if (!isConnected())
		{
			/*String url = "jdbc:mysql://85.25.185.240:3306/tsb";
			String url = Configuration.dburl;
			String username = ConfigFileReader.mysqluser;
			String password = ConfigFileReader.mysqlpasswd;
			*/
			String url = ConfigFileReader.mysqlurl;
			String username = ConfigFileReader.mysqluser;
			String password = ConfigFileReader.mysqlpasswd;

			System.out.println("Connecting database...");

			try {
				conn = DriverManager.getConnection(url, username, password);
			    System.out.println("Database connected!");
			} catch (SQLException e) {
			    throw new IllegalStateException("Cannot connect the database!", e);
			}
			
		}
	}
	
	public static boolean isConnected() {
		// TODO Auto-generated method stub
		return (conn == null ? false : true);
	}

	public static void disconnect()
	{
		
	}
	
	
	public static void insert(String qry)
	{
		
	}
	
	public static boolean getResult(String qry)
	{
		return false;
	}

	public static ResultSet Quary(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
