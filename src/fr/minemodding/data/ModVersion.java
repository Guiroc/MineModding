package fr.minemodding.data;

public class ModVersion {
	
	private Integer id;
	private String label;
	private Mod unMod;
	
	public ModVersion() {
		this.id = null;
		this.label = null;
		this.unMod = null;
	}
	
	public ModVersion(Integer id, String label, Mod unMod) {
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

	public String getLabel() {
		return label;
	}

	public void setVersion(String label) {
		this.label = label;
	}

	public Mod getUnMod() {
		return unMod;
	}

	public void setUnMod(Mod unMod) {
		this.unMod = unMod;
	}
		
}
