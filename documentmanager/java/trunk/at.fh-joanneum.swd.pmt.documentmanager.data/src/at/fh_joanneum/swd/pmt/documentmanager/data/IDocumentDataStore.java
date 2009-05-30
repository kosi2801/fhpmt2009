package at.fh_joanneum.swd.pmt.documentmanager.data;

import java.util.Collection;

public interface IDocumentDataStore {

	boolean addDocument(Document doc);
	Document removeDocument(Document doc);
	boolean updateDocument(Document doc);
	
	Document getDocumentByIdentifier(String identifier);
	
	Collection<Document> getAllDocuments();
}
