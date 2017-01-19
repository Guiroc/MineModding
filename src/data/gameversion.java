package data;

import java.util.ArrayList;
import java.util.List;

public class gameversion {
		
	private Integer id;
	private String label;
	private List<mod> lesMods;
	
	public gameversion(int id, String label) {
		this.id = id;
		this.label = label;
		this.lesMods = new ArrayList<mod>();
	}
	
	public gameversion(int id, String label, List<mod> lesMods) {
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
	
	public List<mod> getLesMods() {
		return lesMods;
	}
	
	public void setLesMods(List<mod> lesMods) {
		this.lesMods = lesMods;
	}

}
