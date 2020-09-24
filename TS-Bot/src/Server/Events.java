package Server;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.api.event.ChannelCreateEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDeletedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDescriptionEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelPasswordChangedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.PrivilegeKeyUsedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ServerEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3Listener;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;

import Actions.*;
import Usefull.SupportChannel;

public class Events implements TS3Listener {
	
	
	private TS3Api api;
	
	public Events(TS3Api api) {
		this.api = api;
	}
	
	

	@Override
	public void onChannelCreate(ChannelCreateEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChannelDeleted(ChannelDeletedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChannelEdit(ChannelEditedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChannelMoved(ChannelMovedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChannelPasswordChanged(ChannelPasswordChangedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClientJoin(ClientJoinEvent e) {
		Join action = new Join(e,this.api);
		action.join();
	//	SupportChannel action2 = new SupportChannel(e,this.api);
	//	action2.SupportJoin();
		
	}

	@Override
	public void onClientLeave(ClientLeaveEvent e) {
	//	SupportChannel action = new SupportChannel(e,this.api);
	//	action.SupportLeave();
	}

	@Override
	public void onClientMoved(ClientMovedEvent e) {
		ClientMoved Action = new ClientMoved(e,this.api);
		Action.UserNeedsSupport();
		
	}

	@Override
	public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onServerEdit(ServerEditedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTextMessage(TextMessageEvent e) {
		Commands action = new Commands(e,this.api);
		action.registration();
		
	}

}
