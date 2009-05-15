package at.fh_joanneum.swd.pmt.addressbook.data;

public class AddressDataStore implements IAddressDataStore {

	private Address address;
	
	@Override
	public Address getAddress() {
		return this.address;
	}

	@Override
	public void setAddress(Address address) {
		this.address = address;

	}

}
