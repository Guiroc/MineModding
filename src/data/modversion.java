package data;

public class modversion {
	
	private Integer id;
	private String version;
	private mod unMod;
	
	public modversion() {
		this.id = null;
		this.version = null;
		this.unMod = null;
	}
	
	public modversion(Integer id, String version, mod unMod) {
		this.id = id;
		this.version = version;
		this.unMod = unMod;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public mod getUnMod() {
		return unMod;
	}

	public void setUnMod(mod unMod) {
		this.unMod = unMod;
	}
		
}
