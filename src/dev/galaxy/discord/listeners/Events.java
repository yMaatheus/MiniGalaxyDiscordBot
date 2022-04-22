package dev.galaxy.discord.listeners;

import java.awt.Color;

import dev.galaxy.discord.BOT;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Events extends ListenerAdapter {
	
	@Override
	public void onGuildJoin(GuildJoinEvent event) {
		System.out.println("Jogador novo entrou!!");
		EmbedBuilder embedBuilder = new EmbedBuilder();
		embedBuilder.addField("CAPTCHA \n", "Clique no emoji para verificar sua conta.", false);
		embedBuilder.setFooter("Por: " + BOT.getJda().getSelfUser().getName(), BOT.getJda().getSelfUser().getAvatarUrl());
		embedBuilder.setColor(Color.CYAN);
		event.getGuild().getDefaultChannel().sendMessage(embedBuilder.build()).complete().addReaction("✔").queue();
	}
}