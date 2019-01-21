package com.github.Glenn.schedulebot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

	public static void main(String[] args) {
		
		DiscordConnector discordConnector = new DiscordConnector();
		CalendarConnector calendarConnect = new CalendarConnector(discordConnector);
		System.out.println("hello");
	}

}
