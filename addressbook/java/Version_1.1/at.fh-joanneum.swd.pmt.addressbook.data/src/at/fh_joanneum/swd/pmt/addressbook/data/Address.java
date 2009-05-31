package at.fh_joanneum.swd.pmt.addressbook.data;


public class Address {
	private String name;
	private String street;
	private String zip;
	private String city;
	private String country;
	private String email;
	private String phone;
	private String mobile;
	private String picture;
	
	public Address(){		
		
	}
	
	public Address(String name, String street, String zip, String city,
			String country, String email, String phone, String mobile, String picture) {
		this.name = name;
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.country = country;
		this.email = email;
		this.phone = phone;
		this.mobile = mobile;
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getPicture(){
		return this.picture;
	}
	
	public void setPicture( String picture){
		this.picture = picture;
	}
}
