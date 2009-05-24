package at.fh_joanneum.swd.pmt.birthday.data;

import java.util.Vector;

import at.fh_joanneum.swd.pmt.birthday.data.User;

public interface IUserDataStore
{
	User getUserByLastName(String lastName);
	boolean setUser(User user);
	boolean addUser(User user);
	boolean removeUser(User user);
	Vector<User> getAllUser();
}
