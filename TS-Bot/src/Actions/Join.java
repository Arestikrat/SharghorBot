package Actions;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

public class Join 
{
	private ClientJoinEvent event;
	private TS3Api api;
	public Join(ClientJoinEvent event, TS3Api api) 
	{
		this.event = event;
		this.api = api;
	}
	
	public void join() 
	{		
		int id = event.getClientId();
		String uname = event.getClientNickname();
		String clientUId = event.getUniqueClientIdentifier();
		Client clients = api.getClientByUId(clientUId);
		if(clients.isInServerGroup(8) && clients.isRegularClient())
		{
			api.sendPrivateMessage(id, "Herzlich Willkommen auf ts.Sharghor.com @" + uname);
			//api.sendPrivateMessage(id, "Solltest du dich noch nicht registriert haben, kannst du dies mit dem Befehl !register nachholen.");
			
			
		}else if(clients.isRegularClient())
		{
			if(clients.isInServerGroup(37))
			{
				
			}else
			{
				api.sendPrivateMessage(id, "Hallo "  +uname + "!  Willkommen zurück.");
				
			}
			
		}else
		{
			
		}
	}
}