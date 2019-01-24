package com.github.Glenn.schedulebot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.channel.ServerChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;


public class ChannelWizard extends Wizard {

	//private Collection<Channel> wizChannels;
	private Collection<ServerChannel> wizChannels;
	private ArrayList<Channel> wizAL;

	@Override
	//public void onMessageCreate(DiscordApi api, Message messageWiz) {
	public void onMessageCreate(MessageCreateEvent event) {
		//wizChannels = messageWiz.getChannelReceiver().getServer().getChannels();
		//wizChannels = messageWiz.getServer().get().getChannels();
		wizChannels = event.getServer().get().getChannels();
		wizAL = new ArrayList<Channel>();
		wizAL.addAll(wizChannels);
		//runWizard(messageWiz);
		runWizard(event.getMessage());
	}

	@Override
	public void validResponse(Message messageWiz) {
		//messageWiz.reply("Valid Channel");
		messageWiz.getChannel().sendMessage("Valid Chanel");
	}

	@Override
	public void invalidResponse(Message messageWiz) {
		//messageWiz.reply("Invalid Channel, try again or type exit to leave wizard");
		messageWiz.getChannel().sendMessage("Invalid Channel, try again or type exit to leave sizard");
	}

	@Override
	public void validOperation(Message messageWiz, int index) {
		addChannelSet(wizAL.get(index - 1));
	}

	@Override
	public int getRange() {
		int returnValue = -1;
		returnValue = wizChannels.size();
		return returnValue;
	}

	public void addChannelSet(Channel newChannel) {
		System.out.println("ADDCHANNEL_ADDCHANNEL_ADDCHANNEL");
		channelSet.add(newChannel);

	}

	public void removeChannelSet(Channel toDeleteChannel) {
		channelSet.remove(toDeleteChannel);
	}

	public Set<Channel> getChannelSet() {
		return channelSet;
	}

	@Override
	public void displayOptions(Message message) {
		String replyString = "Please enter the number of the channel you want Announcements to be posted.\n";
		replyString += "Or type exit to get out of this wizard\n\n";

		int counter = 1;
		//Collection<Channel> channels = message.getChannelReceiver().getServer().getChannels();
		Collection<ServerChannel> channels = message.getServer().get().getChannels();

		for (ServerChannel currChannel : channels)
		{
			replyString += counter + ": " + currChannel.getName() + "\n";
			counter++;
		}
		//message.reply(replyString);
		message.getChannel().sendMessage(replyString);

	}

}

