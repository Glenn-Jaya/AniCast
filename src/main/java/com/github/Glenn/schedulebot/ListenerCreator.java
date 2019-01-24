package com.github.Glenn.schedulebot;

import org.javacord.api.DiscordApi;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.event.ListenerManager;
/*
 * I'm assuming this class doesn't need to have instances.
 * If we do we'll have to remove all the static stuff.
 */

public class ListenerCreator {
	private static ChannelWizard channelWizard;
	
	public ListenerCreator(ChannelWizard channelWizard)
	{
		this.channelWizard = channelWizard;
	}
	
	public static final void initializeFromAPI(DiscordApi api)
	{
		createListeners(api);
	}
	
	private static void createListeners(DiscordApi api)
	{
		createPingPong(api);
		createChannelWizard(api);
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
	
	private static void createChannelWizard(DiscordApi api)
	{
		api.addMessageCreateListener(event -> {
			if (event.getMessageContent().equalsIgnoreCase("++channel")) {
				event.getChannel().sendMessage("inside channel function");
				event.getMessage().getUserAuthor().ifPresent(user -> {
                    ListenerManager<MessageCreateListener> lm = user.addMessageCreateListener(channelWizard);	
                    channelWizard.turnOn(event.getMessage(), lm);
			});
			}
		});
	}
	
}
