package at.fh_joanneum.swd.pmt.birthdaymanager.bl;

import at.fh_joanneum.swd.pmt.bl.DataInitializerInterface;
import at.fh_joanneum.swd.pmt.birthday.data.User;

public class DataInitializer implements DataInitializerInterface
{

	public DataInitializer()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize()
	{
		User user = new User();
		user.setFirstName("Max");
		user.setLastName("Mustermann");
		user.setBirthday("04.09.1983");
//		UserDataStore.getInstance().setUser(user);
		if (Activator.getDefault().getStore() != null)
			Activator.getDefault().getStore().setUser(user);	
	}

}
