package io.noks.api.caches;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Team {
	private List<UUID> blue;
	private List<UUID> green;
	private List<UUID> red;
	private List<UUID> yellow;
	
	public Team(int playerPerTeam) {
		this.blue = new ArrayList<UUID>(playerPerTeam);
		this.green = new ArrayList<UUID>(playerPerTeam);
		this.red = new ArrayList<UUID>(playerPerTeam);
		this.yellow = new ArrayList<UUID>(playerPerTeam);
	}
	
	public List<UUID> blue() {
		return this.blue;
	}
	
	public List<UUID> green() {
		return this.green;
	}
	
	public List<UUID> red() {
		return this.red;
	}
	
	public List<UUID> yellow() {
		return this.yellow;
	}
	
	public List<UUID> getPlayerTeam(UUID uuid) {
		if (this.blue.contains(uuid)) {
			return this.blue;
		}
		if (this.green.contains(uuid)) {
			return this.green;
		}
		if (this.red.contains(uuid)) {
			return this.red;
		}
		if (this.yellow.contains(uuid)) {
			return this.yellow;
		}
		return null;
	}
}
