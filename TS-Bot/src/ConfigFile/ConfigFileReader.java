package ConfigFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigFileReader {

	private String name = null;
	
	private String Host;
	private String UserName;
	private String Password;
	private String Nickname;
	public static String mysqlurl;
	public static String mysqluser;
	public static String mysqlpasswd;
	private String register;
	public Integer guestgroup;
	
	public Integer registergroup;
	
	public String coins;
	public String support;
	
	
	
	
	
	public ConfigFileReader(String name) throws IOException {
		this.name = name;
	}
	
	
	
	public void ReadConfigFile() throws IOException {
		String Sguestgroup = String.valueOf(guestgroup);
		String Sregistergroup = String.valueOf(registergroup);
		BufferedReader br = new BufferedReader(new FileReader(this.name+"-Config-File.txt"));
		br.readLine();
		this.Host=br.readLine();
		br.readLine();
		this.UserName = br.readLine();
		br.readLine();
		this.Password = br.readLine();
		br.readLine();
		this.Nickname = br.readLine();
		br.readLine();
		ConfigFileReader.mysqlurl = br.readLine();
		br.readLine();
		ConfigFileReader.mysqluser = br.readLine();
		br.readLine();
		ConfigFileReader.mysqlpasswd = br.readLine();
		br.readLine();
		this.register = br.readLine();
		br.readLine();
		Sguestgroup = br.readLine();
		br.readLine();
		Sregistergroup = br.readLine();
		br.readLine();
		this.coins = br.readLine();
		br.readLine();
		this.support = br.readLine();
		br.close();
	}
	
	
	
	
	
	
	
	
	
	public String readln(int line) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(this.name+"-Config-File.txt"));
		String result = null;
		
		for (int i=0; i<line-1; i++) {
			br.readLine();
		}
		result = br.readLine();
		br.close();
		
		return result;
	}
	
	
	
	
	
	
	public String getHost() {
		System.out.println("The used host adresse is: "+this.Host);
		return this.Host;
	}
	
	public String getUserName() {
		System.out.println("The used username for the query log in is: "+this.UserName);
		return this.UserName;
	}
	
	public String getPassword() {
		System.out.println("The used password for the query log in is: "+this.Password);
		return this.Password;
	}
	public String getNickname() {
		System.out.println("The used nickname for the TS-Bot is: "+this.Nickname);
		return this.Nickname;
	}
	public String getmysqlurl() {
		System.out.println("The used username for the mysql log in is: "+ConfigFileReader.mysqlurl);
		return ConfigFileReader.mysqlurl;
	}
	public String getmysqluser() {
		System.out.println("The used username for the mysql log in is: "+ConfigFileReader.mysqluser);
		return ConfigFileReader.mysqluser;
	}
	public String getmysqlpasswd() {
		System.out.println("The used password for the mysql log in is: "+ConfigFileReader.mysqlpasswd);
		return ConfigFileReader.mysqlpasswd;
	}
	public String getRegister() {
		System.out.println("The 'register' function is set to: "+this.register);
		return this.register;
	}
	public Integer getGuestgroup() {
		System.out.println("The used GuestGroup for the TS-Bot is: "+this.guestgroup);
		return this.guestgroup;
	}
	public Integer getRegistergroup() {
		System.out.println("The used nickname for the TS-Bot is: "+this.registergroup);
		return this.registergroup;
	}
	public String getCoins() {
		System.out.println("The Coin system is set to: "+this.coins);
		return this.coins;
	}
	public String getSupport() {
		System.out.println("The Coin system is set to: "+this.support);
		return this.support;
	}
}
