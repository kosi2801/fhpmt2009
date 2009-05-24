package at.fh_joanneum.swd.pmt.addressbook.data;

import java.util.Vector;

public class AddressDataStore implements IAddressDataStore {

	private Vector<Address> address;

	public AddressDataStore(){
		this.address = new Vector<Address>();
		this.address.add(new Address("SchnurliBrum", "Langer Weg", "666", "Hintertupfing",
			"Niemandsland", "schnurlibrum@hintertupfing.ht", "123456", "789123456"));
		this.address.add(new Address("name", "street", "zip", "city",
				"country", "e-mail", "phone", "mobile"));
	}
	
	@Override
	public void addAddress(Address newAddr) {
		this.address.add(newAddr);		
	}

	@Override
	public Address getAddressByName(String name) {		
		int idx = findAddress(name);
		if( idx>=0)
			return this.address.elementAt(idx);
		else
			return null;
	}

	@Override
	public Vector<Address> getAllAddresses() {
		return this.address;
	}

	@Override
	public void setAddress(Address address) {
		int idx = findAddress(address.getName());
		if(idx>=0){
			this.address.setElementAt(address, idx);
		}
		
	}
	
	private int findAddress(String name){
		for(int i=0; i<=this.address.size();i++){
			if(this.address.elementAt(i).getName().equalsIgnoreCase(name))
				return i;
		}
		return -1;
	}
}
