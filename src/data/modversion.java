package data;

public class modversion {
	
	private Integer id;
	private String label;
	private mod unMod;
	
	public modversion() {
		this.id = null;
		this.label = null;
		this.unMod = null;
	}
	
	public modversion(Integer id, String label, mod unMod) {
		this.id = id;
		this.label = label;
		this.unMod = unMod;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getlabel() {
		return label;
	}

	public void setVersion(String label) {
		this.label = label;
	}

	public mod getUnMod() {
		return unMod;
	}

	public void setUnMod(mod unMod) {
		this.unMod = unMod;
	}
		
}
