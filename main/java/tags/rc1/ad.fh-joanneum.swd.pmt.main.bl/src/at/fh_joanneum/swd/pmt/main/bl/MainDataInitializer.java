package at.fh_joanneum.swd.pmt.main.bl;

import at.fh_joanneum.swd.pmt.bl.DataInitializerInterface;
import at.fh_joanneum.swd.pmt.main.data.User;
import at.fh_joanneum.swd.pmt.main.data.UserDataStore;

public class MainDataInitializer implements DataInitializerInterface {

	@Override
	public void initialize() {
		User user = new User();
		user.setFirstName("Max");
		user.setLastName("Mustermann");
		user.setMailAddress("max.mustermann@musterdomain.at");
		UserDataStore.getInstance().setUser(user);
	}

}
