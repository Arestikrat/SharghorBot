package Actions;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import Server.Bot;

public class ClientMoved {
	
	
	private ClientMovedEvent event;
	private TS3Api api;
	
	public ClientMoved(ClientMovedEvent event, TS3Api api) {
		this.event = event;
		this.api = api;
	}

	

	public void UserNeedsSupport() {
		int clientID = event.getClientId();
		
		if(event.getTargetChannelId() == 82) {
			
			int i = 0;
			for(Client clients : api.getClients()){
				if(clients.isInServerGroup(50) || clients.isInServerGroup(52) || clients.isInServerGroup(9)){
					i++;
					api.pokeClient(clients.getId(), 
							"Ein User benötigt Support");
				}
			}
			
			if(i <= 1){
				api.sendPrivateMessage(clientID, 
						"Es sind zurzeit keine Teammitgliederonline!");
			}else {
				api.sendPrivateMessage(clientID, 
						"Es wurden " + i + " Teammitglieder benachrichtigt.");
			}
		}
	}
	
	
	
}
	
	
