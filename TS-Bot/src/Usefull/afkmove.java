package Usefull;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import Server.Bot;

public class afkmove 
{
	public static HashMap<String, Long> AFK = new HashMap<>();
	public static HashMap<String, Boolean> Moved = new HashMap<>();
	public static HashMap<String, Integer> Channel = new HashMap<>();
	public static int away = 60000;
	Timer timer;
	
	public static void start(TS3Api api)
	{
		Integer i = 1;
		Long t = new Long(i);
		Timer timer = new Timer();
		timer.schedule(new TimerTask()
		{

			@Override
			public  void run() 
			{
				for(Client c : api.getClients())
				{
					if(!(c.isInServerGroup(67)) || !(c.isServerQueryClient()))
					{
						if(c.isAway() || c.isInputMuted())
						{
							if(!(Moved.containsKey(c.getUniqueIdentifier())))
							{
								if(AFK.containsKey(c.getUniqueIdentifier()))
								{
									AFK.put(c.getUniqueIdentifier(), System.currentTimeMillis());
								}else{
									Long current = AFK.get(c.getUniqueIdentifier()) +t;
									Long aktuell = System.currentTimeMillis();
									Long wech = (aktuell) + (current);
									if(wech >= away)
									{
										Moved.put(c.getUniqueIdentifier(), true);
										Channel.put(c.getUniqueIdentifier(), c.getChannelId());
										AFK.remove(c.getUniqueIdentifier());
										api.sendPrivateMessage(c.getId(), "You have been moved to Channel [B]AFK-Moved[/B].");
										api.moveClient(c.getId(), 64);
									}
								}
							}
						}
					}
				}
			}
			
		}, 1000, 5000);
	}
}