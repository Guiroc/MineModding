package data;

public class modspack {
	
	private Integer id;
	private String label;
	private modspackversion Version;
	
	public modspack() {
		this.id = null;
		this.label = null;
		this.Version = null;
	}
	
	public modspack(int id, String label, modspackversion version) {
		this.id = id;
		this.label = label;
		this.Version = version;
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

	public modspackversion getVersion() {
		return Version;
	}

	public void setVersion(modspackversion version) {
		Version = version;
	}
	
}
