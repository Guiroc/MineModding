package data;

import java.util.ArrayList;
import java.util.List;

public class modspackversion {
	
	private Integer id;
	private modspack unModspackversion;
	private gameversion uneVersion;
	private List<mod> lesMods;
	
	public modspackversion() {
		this.id = null;
		this.unModspackversion = null;
		this.uneVersion = null;
		this.lesMods = new ArrayList<mod>();
	}
	
	public modspackversion(Integer id, modspack unModspackversion, gameversion uneVersion, List<mod> lesMods) {
		this.id = id;
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
	
	
	public modspack getunModspackversion() {
		return unModspackversion;
	}

	public void setunModspackversion(modspack unModspackversion) {
		this.unModspackversion = unModspackversion;
	}

	public List<mod> getLesMods() {
		return lesMods;
	}

	public void setLesMods(List<mod> lesMods) {
		this.lesMods = lesMods;
	}

	public gameversion getUneVersion() {
		return uneVersion;
	}

	public void setUneVersion(gameversion uneVersion) {
		this.uneVersion = uneVersion;
	}
	
}
