package at.fh_joanneum.swd.pmt.documentmanager.data;

public class Document {

	private String owner;
	private String identifier;
	private String path;
	
	public Document(String owner, String identifier, String path) {
		this.setOwner(owner);
		this.identifier = identifier;
		this.path = path;
	}
	
	public Document() {
		//empty
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return path;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}
	
}
