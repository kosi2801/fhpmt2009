import at.fh_joanneum.swd.pmt.addressbook.bl.Activator;
import at.fh_joanneum.swd.pmt.addressbook.data.Address;
import at.fh_joanneum.swd.pmt.bl.DataInitializerInterface;


public class AddressBookDataInitializer implements DataInitializerInterface {

	@Override
	public void initialize() {
		Address tmp = new Address("SchnurliBrum", "Langer Weg", "666", "Hintertupfing",
			"Niemandsland", "schnurlibrum@hintertupfing.ht", "123456", "789123456");
		if(Activator.getDefault().getStore() != null)
			Activator.getDefault().getStore().addAddress(tmp);
	}

}
