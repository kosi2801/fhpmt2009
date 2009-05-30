package at.fh_joanneum.swd.pmt.documentmanager.bl;
import at.fh_joanneum.swd.pmt.bl.DataInitializerInterface;
import at.fh_joanneum.swd.pmt.documentmanager.data.Document;


public class DocumentDataInitializer implements DataInitializerInterface {

	public DocumentDataInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		Document doc = new Document();
		doc.setIdentifier("defaultIdentifier");
		doc.setOwner("defaultOwner");
		doc.setPath("file:///C:/tmp.tmp");
//		UserDataStore.getInstance().setUser(user);
		if (Activator.getDefault().getStore() != null)
			Activator.getDefault().getStore().addDocument(doc);
	}

}
