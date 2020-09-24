package ConfigFile;

import java.io.*;

public class ConfigFileWriter {
	
	private String name = null;
	
	public ConfigFileWriter(String name) {
		this.name = name;
	}
	
	
	public void writeDefaultBot() {
		
		PrintWriter PW = null;
		
		
		
		
		try {                                             //Dieses try versucht die Config datei auszulesen. Ist sie vorhanden passoert nichts, ist sie nicht vorhanden
			                                              //dann wird in dem catch Block eine neue erstellt
			ConfigFileReader RCF = new ConfigFileReader(name);
			RCF.readln(2);
		}catch (IOException ioe){
			try {
				PW = new PrintWriter(new BufferedWriter(new FileWriter((this.name+"-Config-File.txt"),true)));
				PW.println("Host-adresse:");
				PW.println("IP-Adresse");
				PW.println("Query log in Nutzername:");
				PW.println("Username");
				PW.println("Query log in Passwort:");
				PW.println("Password");
				PW.println("Nickanme:");
				PW.println(name);
				PW.println("mysql URL:");
				PW.println("jdbc:mysql://localhost:3306/tsb");
				PW.println("mysql Username:");
				PW.println("Username");
				PW.println("mysql Passwort:");
				PW.println("Password");
				PW.println("Register system state:");
				PW.println("FALSE");
				PW.println("Guest group ID:");
				PW.println("0");
				PW.println("Registered group ID:");
				PW.println("0");
				PW.println("Coin system state:");
				PW.println("FALSE");
				PW.println("Support system state:");
				PW.println("FALSE");
				
				
				
			} catch (IOException ioe2) {
				ioe2.printStackTrace();
			} finally {
				if(PW != null) {
					PW.flush();
					PW.close();
				}
			}
		}
	}
	
	
	public void writeDefaultDatabase() {
		
	}
}
