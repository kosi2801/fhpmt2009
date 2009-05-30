package at.fh_joanneum.swd.pmt.addressbook.bl;

import at.fh_joanneum.swd.pmt.addressbook.data.Address;

public class AddressManipulator {
	public AddressManipulator(){}
	public void fillEmptyFields(String name){
		Address tmp = Activator.getDefault().getStore().getAddressByName(name);
		tmp.setCity(tmp.getCity().isEmpty() ? "n.A." : tmp.getCity());
		tmp.setCountry(tmp.getCountry().isEmpty() ? "n.A." : tmp.getCountry());
		tmp.setEmail(tmp.getEmail().isEmpty() ? "n.A." : tmp.getEmail());
		tmp.setMobile(tmp.getMobile().isEmpty() ? "n.A." : tmp.getMobile());		
		tmp.setPhone(tmp.getPhone().isEmpty() ? "n.A." : tmp.getPhone());
		tmp.setStreet(tmp.getStreet().isEmpty() ? "n.A.": tmp.getStreet());
		tmp.setZip(tmp.getZip().isEmpty() ? "n.A." : tmp.getZip());
	}
}
