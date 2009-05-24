package at.fh_joanneum.swd.pmt.birthday.data;

import java.util.Date;

public class User {

	private String firstName;
	
	private String lastName;
	
	private String  birthday;
	
	
	public User (String firstName, String lastName, String birthday) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
	}

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

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public String getBirthday()
	{
		return birthday;
	}

}