package at.fh_joanneum.swd.pmt.addressbook.data;

import java.util.Vector;

public interface IAddressDataStore {
	Address getAddressByName(String name);
	void setAddress(Address address);
	boolean addAddress(Address newAddr);
	boolean removeAddress(String name);
	Vector<Address> getAllAddresses();
}
