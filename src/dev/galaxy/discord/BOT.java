package dev.galaxy.discord;

import javax.security.auth.login.LoginException;

import dev.galaxy.discord.listeners.Events;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Game.GameType;

public class BOT {
	
	private static JDA jda;
	
	@SuppressWarnings("deprecation")
	public void load() {
		String token = "";
		JDABuilder builder = new JDABuilder(AccountType.BOT);
		builder.setToken(token);
		try {
			jda = builder.buildBlocking();
		} catch (LoginException | InterruptedException e) {
			e.printStackTrace();
		}

		if (jda == null) {
			System.out.println("[BOT] Failed to log in api.");
			return;
		}

		builder.setAutoReconnect(true);
		builder.setGame(Game.of(GameType.DEFAULT, "-help"));

		builder.addEventListener(new Events());
		/*builder.addEventListener(new MessageListener());*/
	}
	
	public static JDA getJda() {
		return jda;
	}
}