package at.fh_joanneum.swd.pmt.documentmanager.data;

public class DocumentObject {

	private String identifier;
	private String path;
	
	public DocumentObject(String identifier, String path) {
		this.identifier = identifier;
		this.path = path;
	}
	
	public DocumentObject() {
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
	
}
