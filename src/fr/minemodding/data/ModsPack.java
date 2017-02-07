package fr.minemodding.data;

import java.util.ArrayList;
import java.util.List;

public class ModsPack {
	
	private Integer id;
	private String label;
	private List<ModsPackVersion> uneVersion;
	
	public ModsPack() {
		this.id = null;
		this.label = null;
		this.uneVersion = new ArrayList<ModsPackVersion>();
	}
	
	public ModsPack(int id, String label, List<ModsPackVersion> uneVersion) {
		this.id = id;
		this.label = label;
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

	public List<ModsPackVersion> getuneVersion() {
		return uneVersion;
	}

	public void setuneVersion(List<ModsPackVersion> uneVersion) {
		this.uneVersion = uneVersion;
	}
	
}
