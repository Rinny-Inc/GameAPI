package io.noks.api;

import java.util.List;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

import io.noks.api.caches.TeamOf2;
import io.noks.api.caches.TeamOf4;
import io.noks.api.enums.GameState;
import net.minecraft.util.com.google.common.collect.Lists;

public class Game extends JavaPlugin {
	private List<UUID> players;
	private GameState state;
	private TeamOf2 teamOf2;
	private TeamOf4 teamOf4;
	private int maxPlayers;
	
	public Game(int maxPlayers) {
		this.players = Lists.newArrayList();
		this.state = GameState.WAITING;
		this.maxPlayers = maxPlayers;
	}
	public Game(TeamOf2 teams, int maxPlayers) {
		this.players = Lists.newArrayList();
		this.state = GameState.WAITING;
		this.teamOf2 = teams;
		this.maxPlayers = maxPlayers;
	}
	public Game(TeamOf4 teams, int maxPlayers) {
		this.players = Lists.newArrayList();
		this.state = GameState.WAITING;
		this.teamOf4 = teams;
		this.maxPlayers = maxPlayers;
	}
	
	public List<UUID> getPlayers() {
		return this.players;
	}
	
	public boolean isWinned() {
		if (this.teamOf2 == null && this.teamOf4 == null) {
			return this.players.size() == 1;
		}
		// TODO: CHECK IF THERE'S A KOTH AND CHECK IF THE KOTH IS WINNED BEFORE CHECKING IF TEAMS ARE EMPTY
		int nonEmptyCount = 0;

		if (this.teamOf2 != null) {
			// TODO
		}
		if (this.teamOf4 != null) {
		    if (!this.teamOf4.blue().isEmpty()) {
		        nonEmptyCount++;
		    }
		    if (!this.teamOf4.green().isEmpty()) {
		        nonEmptyCount++;
		    }
		    if (!this.teamOf4.red().isEmpty()) {
		        nonEmptyCount++;
		    }
		    if (!this.teamOf4.yellow().isEmpty()) {
		        nonEmptyCount++;
		    }
		}
	    return nonEmptyCount == 1;
	}

	public boolean isPlayerInGame(UUID uuid) {
		return this.players.contains(uuid);
	}
}
