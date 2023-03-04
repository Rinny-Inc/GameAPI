package io.noks.api;

import java.util.List;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

import io.noks.api.caches.Team;
import io.noks.api.enums.GameState;
import net.minecraft.util.com.google.common.collect.Lists;

public class Game extends JavaPlugin {
	private List<UUID> players;
	private GameState state;
	private Team teams;
	private int maxPlayers;
	
	public Game(boolean teamGame, int maxPlayers) {
		this.players = Lists.newArrayList();
		this.state = GameState.WAITING;
		this.teams = (teamGame ? new Team() : null);
		this.maxPlayers = maxPlayers;
	}
	
	public List<UUID> getPlayers() {
		return this.players;
	}
	
	public boolean isWinned() {
		if (teams == null) {
			return this.players.size() == 1;
		}
		// TODO: CHECK IF THERE'S A KOTH AND CHECK IF THE KOTH IS WINNED BEFORE CHECKING IF TEAMS ARE EMPTY
		int nonEmptyCount = 0;

	    if (!teams.blue().isEmpty()) {
	        nonEmptyCount++;
	    }
	    if (!teams.green().isEmpty()) {
	        nonEmptyCount++;
	    }
	    if (!teams.red().isEmpty()) {
	        nonEmptyCount++;
	    }
	    if (!teams.yellow().isEmpty()) {
	        nonEmptyCount++;
	    }
	    return nonEmptyCount == 1;
	}

	public boolean isPlayerInGame(UUID uuid) {
		return this.players.contains(uuid);
	}
}
