package data;

import java.util.ArrayList;
import java.util.List;

public class modspack {
	
	private Integer id;
	private String label;
	private List<modspackversion> uneVersion;
	
	public modspack() {
		this.id = null;
		this.label = null;
		this.uneVersion = new ArrayList<modspackversion>();
	}
	
	public modspack(int id, String label, List<modspackversion> uneVersion) {
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

	public List<modspackversion> getuneVersion() {
		return uneVersion;
	}

	public void setuneVersion(List<modspackversion> uneVersion) {
		this.uneVersion = uneVersion;
	}
	
}
