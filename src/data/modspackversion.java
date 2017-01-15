package data;

import java.util.ArrayList;
import java.util.List;

public class modspackversion {
	
	private Integer id;
	private List<mod> lesMods;
	private gameversion uneVersion;
	
	public modspackversion() {
		this.id = null;
		this.lesMods = new ArrayList<mod>();
		this.uneVersion = null;
	}
	
	public modspackversion(Integer id, List<mod> lesMods, gameversion uneVersion) {
		this.id = id;
		this.lesMods = lesMods;
		this.uneVersion = uneVersion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
