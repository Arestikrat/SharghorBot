package Server;

import java.io.IOException;
import java.util.logging.Level;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.TS3Query.FloodRate;

import ConfigFile.ConfigFileWriter;
import ConfigFile.ConfigFileReader;


public class Bot {

	
	private String name;
	public static TS3Config config = new TS3Config();
	public static TS3Query query = new TS3Query(config);
	public static TS3Api api = query.getApi();
	
	
	
	public Bot (String name) {
		this.name = name;
	}
	
	
	public void activateBot() throws IOException {
		
		System.out.println("Activating the Bot: "+this.name);
		
		ConfigFileWriter CFW = new ConfigFileWriter(name);
		CFW.writeDefaultBot();
		
		ConfigFileReader CFR = new ConfigFileReader(name);
		CFR.ReadConfigFile();
		
		
		config.setHost(CFR.getHost());
		config.setFloodRate(FloodRate.UNLIMITED);
		//config.setDebugLevel(Level.WARNING);

		
		query.connect();
		
		api.login(CFR.getUserName(), CFR.getPassword());
		api.selectVirtualServerById(1);
		api.setNickname(CFR.getNickname());
		
		
		api.registerAllEvents();
		api.addTS3Listeners(new Events(api));
		//Usefull.afkmove.start(api);
		
		System.out.println("===============     =========     ||========= ");
		System.out.println("      |||           ||            ||       || ");
		System.out.println("      |||           ||            ||       || ");
		System.out.println("      |||           ||            ||     ==== ");
		System.out.println("      |||           =========     ||=====     ");
		System.out.println("      |||                  ||     ||     ==== ");
		System.out.println("      |||                  ||     ||       || ");
		System.out.println("      |||                  ||     ||       || ");
		System.out.println("      |||           =========     ||========= ");
		System.out.println("");
		
		System.out.println("TS-Bot "+this.name+" activated.");
	}
	
}
