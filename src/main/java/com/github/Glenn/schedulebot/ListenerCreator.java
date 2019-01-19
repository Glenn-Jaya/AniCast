package com.github.Glenn.schedulebot;

import org.javacord.api.DiscordApi;
/*
 * I'm assuming this class doesn't need to have instances.
 * If we do we'll have to remove all the static stuff.
 */
public class ListenerCreator {

	public static final void initializeFromAPI(DiscordApi api)
	{
		createListeners(api);
	}
	
	private static void createListeners(DiscordApi api)
	{
		createPingPong(api);
	}
	
	private static void createPingPong(DiscordApi api)
	{
		// Add a listener which answers with "Pong!" if someone writes "!ping"
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("++ping")) {
                event.getChannel().sendMessage("Pong!");
            }
        });
	}
	
}
