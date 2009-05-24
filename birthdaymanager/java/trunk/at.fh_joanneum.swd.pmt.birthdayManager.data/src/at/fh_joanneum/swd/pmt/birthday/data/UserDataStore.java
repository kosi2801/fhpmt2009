package at.fh_joanneum.swd.pmt.birthday.data;

public class UserDataStore implements IUserDataStore
{
	private User user;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

}
