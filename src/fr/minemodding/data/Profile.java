package fr.minemodding.data;

import java.util.ArrayList;
import java.util.List;

public class Profile {

	private String name;
	private String gameDir;
	private String lastVersionId;
	private String javaDir;
	private String javaArgs;
	private List<Mod> mods;
	private ModsPackVersion modsPackVersion;
	
	public Profile(String name, String gameDir, String lastVersionId, String javaDir, String javaArgs) {
		this.name = name;
		this.gameDir = gameDir;
		this.lastVersionId = lastVersionId;
		this.javaDir = javaDir;
		this.javaArgs = javaArgs;
		this.mods = new ArrayList<Mod>();
		this.modsPackVersion = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGameDir() {
		return gameDir;
	}

	public void setGameDir(String gameDir) {
		this.gameDir = gameDir;
	}

	public String getLastVersionId() {
		return lastVersionId;
	}

	public void setLastVersionId(String lastVersionId) {
		this.lastVersionId = lastVersionId;
	}

	public String getJavaDir() {
		return javaDir;
	}

	public void setJavaDir(String javaDir) {
		this.javaDir = javaDir;
	}

	public String getJavaArgs() {
		return javaArgs;
	}

	public void setJavaArgs(String javaArgs) {
		this.javaArgs = javaArgs;
	}

	public List<Mod> getMods() {
		return mods;
	}

	public void setMods(Mod mods) {
		this.mods.add(mods);
	}

	public ModsPackVersion getModsPackVersion() {
		return modsPackVersion;
	}

	public void setModsPackVersion(ModsPackVersion modsPackVersion) {
		this.modsPackVersion = modsPackVersion;
	}
}
