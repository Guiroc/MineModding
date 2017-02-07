package fr.minemodding.data;

import java.util.ArrayList;
import java.util.List;

public class Mod {
	
	private Integer id;
	private String label;
	private List<ModVersion> lesModVersion;
	private GameVersion uneVersion;
	
	public Mod(int id, String label, GameVersion uneVersion) {
		this.id = id;
		this.label = label;
		this.lesModVersion = new ArrayList<ModVersion>();
		this.uneVersion = uneVersion;
	}
	
	public Mod(int id, String label, List<ModVersion> lesmodVersion, GameVersion uneVersion) {
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

	public List<ModVersion> getLesModVersion() {
		return lesModVersion;
	}

	public void setLesModVersion(List<ModVersion> lesModVersion) {
		this.lesModVersion = lesModVersion;
	}

	public GameVersion getUneVersion() {
		return uneVersion;
	}

	public void setUneVersion(GameVersion uneVersion) {
		this.uneVersion = uneVersion;
	}
	
}
