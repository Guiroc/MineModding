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
		lesModVersion = new ArrayList();
		uneVersion = null;
	}
	
	public mod(int id, String label, List<modversion> lesmodVersion, gameversion uneVersion) {
		super();
		this.id = id;
		this.label = label;
		lesModVersion = lesmodVersion;
		this.uneVersion = uneVersion;
	}
	
}
