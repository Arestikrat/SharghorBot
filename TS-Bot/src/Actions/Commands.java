package Actions;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.api.TextMessageTargetMode;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;

import DataBase.MySQL;
import Server.Bot;

public class Commands {
	
	private TextMessageEvent event;
	private TS3Api api;
	
	public Commands(TextMessageEvent event, TS3Api api) 
	{
		this.event = event;
		this.api = api;
	}

	
	
	public void registration() {
		
		int TSID = event.getInvokerId();
		String TSUID = event.getInvokerUniqueId();
		String nickname = event.getInvokerName();
		
		
		
		
		/*if((event.getTargetMode() == TextMessageTargetMode.SERVER) || (event.getTargetMode() == TextMessageTargetMode.CHANNEL)){
			String msg1 = event.getMessage();
			if(msg1.equalsIgnoreCase("!registration"))
			{
				
				MySQL.connect();
				if(MySQL.isConnected())
				{
					java.sql.PreparedStatement ps;
					java.sql.PreparedStatement ps2;
					try {
						String tsid = null;
						ps = MySQL.conn.prepareStatement("SELECT TSID FROM registration WHERE TSID = ?");
						ps.setString(1, TSUID);
						ResultSet rs = ps.executeQuery();
						while(rs.next()){
							tsid = rs.getString(1);	
							if(tsid.equals(TSUID))
							{
								api.pokeClient(TSID, "Du bist bereits registriert!");
							}else
							{
								api.addClientToServerGroup(53, TSID);
								ps2 = MySQL.conn.prepareStatement("insert into TSID (nickname, TSUID, TSID) values (?,?,?))");
								ps2.setString(1, nickname);
								ps2.setString(1, TSUID);
								ps2.setInt(1, TSID);
								ps2.execute();
								api.pokeClient(TSID, "Du bist nun registriert!");
							}
						}
					} 
					catch (SQLException e) {
					// 	TODO Auto-generated catch block
						e.printStackTrace();		
					}
				}
			}
		}*/
	}
}