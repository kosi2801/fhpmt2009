package at.fh_joanneum.swd.pmt.documentmanager.data;

public class DocumentDataStore implements IDocumentDataStore {
	private Document document;

	public Document getDocument() {
		return document;
	}
	
	public void setDocument(Document document) {
		this.document = document;
	}
	
}
