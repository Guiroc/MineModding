package data;

import java.util.ArrayList;
import java.util.List;

public class mod {
	
	private Integer id;
	private String label;
	private List<modversion> lesModVersion;
	private gameversion uneVersion;
	
	public mod() {
		id = null;
		label = null;
		lesModVersion = new ArrayList<modversion>();
		uneVersion = null;
	}
	
	public mod(int id, String label, List<modversion> lesmodVersion, gameversion uneVersion) {
		super();
		this.id = id;
		this.label = label;
		lesModVersion = lesmodVersion;
		this.uneVersion = uneVersion;
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

	public List<modversion> getLesModVersion() {
		return lesModVersion;
	}

	public void setLesModVersion(List<modversion> lesModVersion) {
		this.lesModVersion = lesModVersion;
	}

	public gameversion getUneVersion() {
		return uneVersion;
	}

	public void setUneVersion(gameversion uneVersion) {
		this.uneVersion = uneVersion;
	}
	
}
