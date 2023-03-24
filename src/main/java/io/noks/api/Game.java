package io.noks.api;

import java.util.List;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

import io.noks.api.caches.TwoTeams;
import io.noks.api.caches.FourTeams;
import io.noks.api.caches.TeamOf2;
import io.noks.api.enums.GameState;
import net.minecraft.util.com.google.common.collect.Lists;

public class Game extends JavaPlugin {
	private List<UUID> players;
	private GameState state;
	private TeamOf2 teamOf2;
	private TwoTeams twoTeams;
	private FourTeams fourTeams;
	private int maxPlayers;
	
	public Game(int maxPlayers) {
		this.players = Lists.newArrayList();
		this.state = GameState.WAITING;
		this.maxPlayers = maxPlayers;
	}
	public Game(TwoTeams teams) {
		this.players = Lists.newArrayList();
		this.state = GameState.WAITING;
		this.twoTeams = teams;
		this.maxPlayers = teams.getMaxTeamSize() * 2;
	}
	public Game(FourTeams teams, int maxPlayers) {
		this.players = Lists.newArrayList();
		this.state = GameState.WAITING;
		this.fourTeams = teams;
		this.maxPlayers = teams.getMaxTeamSize() * 4;
	}
	
	public List<UUID> getPlayers() {
		return this.players;
	}
	
	public boolean isWinned() {
		if (this.twoTeams == null && this.fourTeams == null) {
			return this.players.size() == 1;
		}
		// TODO: CHECK IF THERE'S A KOTH AND CHECK IF THE KOTH IS WINNED BEFORE CHECKING IF TEAMS ARE EMPTY
		int nonEmptyCount = 0;

		if (this.twoTeams != null) {
			if (!this.twoTeams.blue().isEmpty()) {
				nonEmptyCount++;
			}
			if (!this.twoTeams.red().isEmpty()) {
				nonEmptyCount++;
			}
		}
		if (this.fourTeams != null) {
		    if (!this.fourTeams.blue().isEmpty()) {
		        nonEmptyCount++;
		    }
		    if (!this.fourTeams.green().isEmpty()) {
		        nonEmptyCount++;
		    }
		    if (!this.fourTeams.red().isEmpty()) {
		        nonEmptyCount++;
		    }
		    if (!this.fourTeams.yellow().isEmpty()) {
		        nonEmptyCount++;
		    }
		}
	    return nonEmptyCount == 1;
	}

	public boolean isPlayerInGame(UUID uuid) {
		return this.players.contains(uuid);
	}
	
	public void updateState(GameState newState) {
		this.state = newState;
	}
	
	public GameState getState() {
		return this.state;
	}
	
	public int getMaxPlayers() {
		return this.maxPlayers;
	}
}
