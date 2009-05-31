package at.fh_joanneum.swd.pmt.addressbook.bl;

import at.fh_joanneum.swd.pmt.addressbook.data.Address;
import at.fh_joanneum.swd.pmt.bl.DataInitializerInterface;

public class AddressBookDataInitializer implements DataInitializerInterface {

	@Override
	public void initialize() {	
		if(Activator.getDefault().getStore() != null){
			Activator.getDefault().getStore().addAddress(
					new Address("name", "street", "zip", "city",
							"country", "email", "phone", "mobile", "SamplePic" )
					);
		}

	}

}
