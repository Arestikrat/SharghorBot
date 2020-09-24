package Actions;

import java.util.HashMap;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.api.ChannelProperty;
import com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.Channel;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import Server.Bot;

public class ClientLeave {

	private ClientLeaveEvent event;
	private TS3Api api;

	public ClientLeave(ClientLeaveEvent event, TS3Api api) {
		this.event = event;
		this.api = api;
	}


	public void Supportleave() {


		HashMap<ChannelProperty, String> options = new HashMap<>();
		int i = 0;

		for(Client clients : api.getClients()){
			if(clients.isInServerGroup(50) || clients.isInServerGroup(52) || clients.isInServerGroup(9)){
				i++;
			}
		}
		if(i >= 2 ){
			for(Channel channels : api.getChannels()){


				if(channels.getId() == 81 && channels.getName().equals("[cspacer102]����( Support - Closed)����")){

					options.put(ChannelProperty.CHANNEL_NAME, "[cspacer102]����( Support - Open)����");
					api.editChannel(81, options);
				}
			}

		}else{
			for(Channel channels : api.getChannels()){
				if(channels.getId() == 81 && channels.getName().equals("[cspacer102]����( Support - Open)����")){

					options.put(ChannelProperty.CHANNEL_NAME, "[cspacer102]����( Support - Closed)����");
					api.editChannel(81, options);
				}
			}
		}
	}


}


// Test Comment
//Test Command 2
// Test Comment 3
