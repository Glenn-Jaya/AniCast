package com.github.Glenn.schedulebot;

import org.javacord.api.DiscordApi;

public class ListenerManager {
	
	private DiscordApi api;
	
	public ListenerManager(DiscordApi api)
	{
		this.api = api;
		createPingPong();
	}
	
	private void createListeners()
	{
		createPingPong();
	}
	
	private void createPingPong()
	{
		// Add a listener which answers with "Pong!" if someone writes "!ping"
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("++ping")) {
                event.getChannel().sendMessage("Pong!");
            }
        });
	}
	
}
