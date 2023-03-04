package io.noks.api.listeners;

import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import io.noks.api.Game;

public class PlayerListener implements Listener {
	private Game game;
	public PlayerListener(Game game) {
		this.game = game;
		this.game.getServer().getPluginManager().registerEvents(this, this.game);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		final UUID uuid = event.getPlayer().getUniqueId();
		this.game.getPlayers().add(uuid);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		final UUID uuid = event.getPlayer().getUniqueId();
		this.game.getPlayers().remove(uuid);
	}
	
	@EventHandler
	public void onKick(PlayerKickEvent event) {
		this.onQuit(new PlayerQuitEvent(event.getPlayer(), event.getLeaveMessage()));
	}
}
