package com.github.Glenn.schedulebot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;


public class DiscordConnector {
	
	public DiscordConnector()
	{
		DiscordApi api = new DiscordApiBuilder().setToken(getToken()).login().join();
		System.out.println("Logged In!");
		System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
		//ListenerManager listenManager = new ListenerManager(api);
		ListenerCreator.initializeFromAPI(api);
	}
	
	private String getToken()
	{
		String token = "";
		InputStream in = getClass().getClassLoader().getResourceAsStream("DiscordToken.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
			line = reader.readLine();
			if (line != null)
				token = line;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}
}
