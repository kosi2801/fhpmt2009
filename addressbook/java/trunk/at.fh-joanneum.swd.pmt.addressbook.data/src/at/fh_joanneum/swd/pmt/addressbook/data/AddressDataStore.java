package at.fh_joanneum.swd.pmt.addressbook.data;

import java.util.Vector;

import javax.print.attribute.standard.Fidelity;

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
	public boolean addAddress(Address newAddr) {
		return this.address.add(newAddr);		
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
	public boolean setAddress(String name, Address address) {
		int idx = findAddress(name);
		if(idx>=0){
			this.address.setElementAt(address, idx);
			return true;
		}else
			return false;
		
	}
	
	private int findAddress(String name){
		for(int i=0; i<=this.address.size();i++){
			if(this.address.elementAt(i).getName().equalsIgnoreCase(name))
				return i;
		}
		return -1;
	}

	@Override
	public boolean removeAddress(String name) {
		int idx = findAddress(name);
		if(idx>=0)
			return this.address.remove(this.address.get(idx));
		return false;
	}
}
