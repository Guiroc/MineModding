package fr.minemodding.data;

import java.util.ArrayList;
import java.util.List;

public class Profile {

	private Integer id;
	private String label;
	private List<Mod> lesMods;
	private GameVersion uneVersion;
	private ModsPackVersion unModspackversion;
	
	public Profile() {
		this.id = null;
		this.label = null;
		this.lesMods = new ArrayList<Mod>();
		this.uneVersion = null;
		this.unModspackversion = null;
	}
	
	public Profile(int id, String label, List<Mod> lesMods, GameVersion uneVersion) {
		this.id = id;
		this.label = label;
		this.lesMods = lesMods;
		this.uneVersion = uneVersion;
		this.unModspackversion = null;
	}
	
	public Profile(int id, String label, List<Mod> lesMods, GameVersion uneVersion, ModsPackVersion unModspackversion) {
		this.id = id;
		this.label = label;
		this.lesMods = lesMods;
		this.uneVersion = uneVersion;
		this.unModspackversion = unModspackversion;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Mod> getLesMods() {
		return lesMods;
	}

	public void setLesMods(List<Mod> lesMods) {
		this.lesMods = lesMods;
	}

	public GameVersion getUneVersion() {
		return uneVersion;
	}

	public void setUneVersion(GameVersion uneVersion) {
		this.uneVersion = uneVersion;
	}

	public ModsPackVersion getunModspackversion() {
		return unModspackversion;
	}

	public void setunModspackversion(ModsPackVersion unModspackversion) {
		this.unModspackversion = unModspackversion;
	}

}
