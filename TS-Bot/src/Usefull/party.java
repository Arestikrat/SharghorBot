package Usefull;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.api.TextMessageTargetMode;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;

import DataBase.MySQL;

public class party 
{
	private TextMessageEvent event;
	private TS3Api api;
	
	public party(TextMessageEvent event, TS3Api api) 
	{
		this.event = event;
		this.api = api;
	}
	
	//Party erstellen
	public void addparty()
	{
		int TSID = event.getInvokerId();
		String TSUID = event.getInvokerUniqueId();
		String nickname = event.getInvokerName();
		String pname = event.getInvokerName();
		int id = 1;//time millis number - System generated
		
		if(event.getTargetMode() == TextMessageTargetMode.SERVER)
		{
			String msg = event.getMessage();
			if(msg.equalsIgnoreCase("!createparty"))
			{
				MySQL.connect();
				if(MySQL.isConnected())
				{
					
					java.sql.PreparedStatement ps1;
					java.sql.PreparedStatement ps2;
					try
					{
						String otsuid = null;
						ps1 = MySQL.conn.prepareStatement("select otsuid from partyowner where owner = ?");
						ps1.setString(1, TSUID);
						ResultSet rs = ps1.executeQuery();
						while(rs.next())
						{
							otsuid = rs.getString(1);	
							if(otsuid.equals(TSUID))
							{
								api.pokeClient(TSID, "Du bist bereits in einer Party!");
							}
							else
							{
								ps2 = MySQL.conn.prepareStatement("insert into partyowner (owner, nickname, pname, active) values (?,?,?,?)");
								ps2.setString(1, TSUID);
								ps2.setString(2, nickname);
								ps2.setString(3, pname);
								ps2.setInt(4, 1);
								ps2.execute();
								api.pokeClient(TSID, "Deine Party mit dem Namen " + pname + " wurde erstellt!");
								api.pokeClient(TSID, "Andere Teilnehmer können über die ID " + id +" der Party beitreten!!");
							}
						}
					}
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	//Partys auflisten
	public void listparty()
	{
		int TSID = event.getInvokerId();
		String TSUID = event.getInvokerUniqueId();
		if(event.getTargetMode() == TextMessageTargetMode.SERVER)
		{
			String msg = event.getMessage();
			if(msg.equalsIgnoreCase("!listparty"))
			{
				MySQL.connect();
				if(MySQL.isConnected())
				{
					
					java.sql.PreparedStatement ps1;
					java.sql.PreparedStatement ps2;
					try
					{
						String otsuid = null;
						ps1 = MySQL.conn.prepareStatement("select user from partyuser where owner = ?");
						ps1.setString(1, TSUID);
						ResultSet rs = ps1.executeQuery();
						while(rs.next())
						{
							otsuid = rs.getString(1);	
							if(otsuid.equals(TSUID))
							{
								api.pokeClient(TSID, "Du bist bereits in einer Party!");
							}
						}
					}
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	//Party beitreten
	public void joinparty()
	{
		int TSID = event.getInvokerId();
		String TSUID = event.getInvokerUniqueId();
		if(event.getTargetMode() == TextMessageTargetMode.SERVER)
		{
			String msg = event.getMessage();
			if(msg.equalsIgnoreCase("!joinparty"))
			{
				MySQL.connect();
				if(MySQL.isConnected())
				{
					try
					{
						java.sql.PreparedStatement ps1;
						ps1 = MySQL.conn.prepareStatement("select * from");
					}
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}
