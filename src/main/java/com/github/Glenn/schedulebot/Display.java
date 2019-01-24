package com.github.Glenn.schedulebot;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.channel.Channel;


public class Display {

		// private WizardListener wizListener;
		private ChannelWizard channelWizard;

		public Display(ChannelWizard channelWizard) {
			this.channelWizard = channelWizard;
		}

		public void outputDisplay(String title, String image, String description) {
			Color magenta = new Color(255, 0, 255);
			EmbedBuilder eBuilder = new EmbedBuilder().setTitle(title).setImage(image).setDescription(description)
					.setColor(magenta);

			for (Channel currChannel : channelWizard.getChannelSet())
			{
				//currChannel.sendMessage("", eBuilder);
				currChannel.asTextChannel().get().sendMessage(eBuilder);
			}
		}

}
