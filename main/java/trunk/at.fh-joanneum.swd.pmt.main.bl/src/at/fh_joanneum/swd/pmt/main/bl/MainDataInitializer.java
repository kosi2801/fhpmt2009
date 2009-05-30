package at.fh_joanneum.swd.pmt.main.bl;

import at.fh_joanneum.swd.pmt.bl.DataInitializerInterface;
import at.fh_joanneum.swd.pmt.main.data.User;

public class MainDataInitializer implements DataInitializerInterface {

	
	@Override
	public void initialize() {
		User user = new User();
		user.setFirstName("Max");
		user.setLastName("Mustermann");
		user.setMailAddress("max.mustermann@musterdomain.at");
//		UserDataStore.getInstance().setUser(user);
		if (Activator.getDefault().getStore() != null)
			Activator.getDefault().getStore().setUser(user);
	}

}
