package at.fh_joanneum.swd.pmt.birthday.data;

import at.fh_joanneum.swd.pmt.birthday.data.User;

public interface IUserDataStore
{
	User getUser();

	void setUser(User user);
}
