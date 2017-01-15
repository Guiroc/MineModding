package data;

import java.util.ArrayList;
import java.util.List;

public class profile {

	private Integer id;
	private String label;
	private List<mod> lesMods;
	private gameversion uneVersion;
	
	public profile() {
		this.id = null;
		this.label = null;
		this.lesMods = new ArrayList<mod>();
		this.uneVersion = null;
	}
	
	public profile(int id, String label, List<mod> lesMods, gameversion uneVersion) {
		this.id = id;
		this.label = label;
		this.lesMods = lesMods;
		this.uneVersion = uneVersion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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
