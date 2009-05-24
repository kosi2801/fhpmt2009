package at.fh_joanneum.swd.pmt.birthday.data;

import java.util.Date;

public class User {

	private String firstName;
	
	private String lastName;
	
	private Date birthday;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public Date getBirthday()
	{
		return birthday;
	}

}