package fr.minemodding.data;

import java.util.ArrayList;
import java.util.List;

public class ModsPackVersion {
	
	private Integer id;
	private String label;
	private ModsPack unModspackversion;
	private GameVersion uneVersion;
	private List<Mod> lesMods;
	
	public ModsPackVersion() {
		this.id = null;
		this.label = null;
		this.unModspackversion = null;
		this.uneVersion = null;
		this.lesMods = new ArrayList<Mod>();
	}
	
	public ModsPackVersion(Integer id, String label, ModsPack unModspackversion, GameVersion uneVersion, List<Mod> lesMods) {
		this.id = id;
		this.label = label;
		this.unModspackversion = unModspackversion;
		this.uneVersion = uneVersion;
		this.lesMods = lesMods;
	}

	public Integer getId() {
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

	public ModsPack getunModspackversion() {
		return unModspackversion;
	}

	public void setunModspackversion(ModsPack unModspackversion) {
		this.unModspackversion = unModspackversion;
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
	
}
