package at.fh_joanneum.swd.pmt.documentmanager.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DocumentDataStore implements IDocumentDataStore {

	private Map<String, Document> documentMap;
	
	public DocumentDataStore() {
		documentMap = new HashMap<String, Document>();
	}
	
	@Override
	public Collection<Document> getAllDocuments() {
		return documentMap.values();
	}

	@Override
	public boolean addDocument(Document doc) {
		if(documentMap.containsKey(doc.getIdentifier()))
			return false;
		documentMap.put(doc.getIdentifier(), doc);
		return true;
	}

	@Override
	public boolean updateDocument(Document doc) {
		if(documentMap.containsKey(doc.getIdentifier())) {
			documentMap.put(doc.getIdentifier(), doc);
			return true;
		}
		else
			return false;
	}
	
	@Override
	public Document getDocumentByIdentifier(String identifier) {
		return documentMap.get(identifier);
	}

	@Override
	public Document removeDocument(Document doc) {
		return documentMap.remove(doc.getIdentifier());
	}
	
}
