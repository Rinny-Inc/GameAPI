package io.noks.api.caches;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TwoTeams {
	private List<UUID> blue;
	private List<UUID> red;
	private int maxTeamSize;
	
	public TwoTeams(int playerPerTeam) {
		this.maxTeamSize = playerPerTeam;
		this.blue = new ArrayList<UUID>(playerPerTeam);
		this.red = new ArrayList<UUID>(playerPerTeam);
	}
	
	public List<UUID> blue() {
		return this.blue;
	}
	
	public List<UUID> red() {
		return this.red;
	}
	
	public List<UUID> getPlayerTeam(UUID uuid) {
		if (this.blue.contains(uuid)) {
			return this.blue;
		}
		if (this.red.contains(uuid)) {
			return this.red;
		}
		return null;
	}
	
	public int getMaxTeamSize() {
		return this.maxTeamSize;
	}
}
