package fr.minemodding.data;

import java.util.ArrayList;

public class Profile {

	private String name;
	private GameVersion uneGameVersion;
	private ArrayList<ModVersion> lesModsVersion;
//	private ModsPackVersion modsPackVersion;
	
	public Profile(String name) {
		this.name = name;
		this.uneGameVersion = null;
		this.lesModsVersion = new ArrayList<ModVersion>();
	}
	
	public Profile(String name, GameVersion uneGameVersion, ArrayList<ModVersion> desModVersion) {
		this.name = name;
		this.uneGameVersion = uneGameVersion;
		this.lesModsVersion = desModVersion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ModVersion> getMods() {
		return lesModsVersion;
	}

	public void setMods(ModVersion mods) {
		this.lesModsVersion.add(mods);
	}

	public GameVersion getUneGameVersion() {
		return uneGameVersion;
	}

	public void setUneGameVersion(GameVersion uneGameVersion) {
		this.uneGameVersion = uneGameVersion;
	}

//	public ModsPackVersion getModsPackVersion() {
//		return modsPackVersion;
//	}
//
//	public void setModsPackVersion(ModsPackVersion modsPackVersion) {
//		this.modsPackVersion = modsPackVersion;
//	}
}
