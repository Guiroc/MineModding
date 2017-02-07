package fr.minemodding.data;

import java.util.ArrayList;
import java.util.List;

public class GameVersion {
		
	private Integer id;
	private String label;
	private List<Mod> lesMods;
	
	public GameVersion(int id, String label) {
		this.id = id;
		this.label = label;
		this.lesMods = new ArrayList<Mod>();
	}
	
	public GameVersion(int id, String label, List<Mod> lesMods) {
		this.id = id;
		this.label = label;
		this.lesMods = lesMods;
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
	
	public List<Mod> getLesMods() {
		return lesMods;
	}
	
	public void setLesMods(List<Mod> lesMods) {
		this.lesMods = lesMods;
	}
	
	public void addlesMods(Mod unmod){
		this.lesMods.add(unmod);
	}

	@Override
	public String toString() {
		return "gameversion [id=" + id + ", label=" + label + ", lesMods=" + lesMods + "]";
	}

}
