package at.fh_joanneum.swd.pmt.birthday.data;

import java.util.Vector;

import at.fh_joanneum.swd.pmt.birthday.data.User;

public class UserDataStore implements IUserDataStore
{
	private Vector<User> users;

	public UserDataStore()
	{
		this.users = new Vector<User>();
		this.users.add(new User("Max", "Mustermann", "27.12.1981"));
		this.users.add(new User("Andreas", "Überbacher", "20.09.1984"));
	}

	public boolean setUser(User user)
	{
		int index = findUser(user.getLastName());
		if(index >= 0)
		{
			this.users.setElementAt(user, index);
			return true;
		}
		else
			return false;
	}

	private int findUser(String lastName)
	{
		for(int i=0; i<this.users.size();i++)
		{
			if(this.users.elementAt(i).getLastName().equalsIgnoreCase(lastName))
				return i;
		}
		return -1;
	}

	@Override
	public boolean addUser(User user)
	{
		this.users.add(user);
		return true;
	}

	@Override
	public Vector<User> getAllUser()
	{
		return this.users;
	}

	@Override
	public User getUserByLastName(String lastName)
	{
		for (int i=0; i<this.users.size(); i++)
		{
			if (this.users.get(i).getLastName().equals(lastName)) 
			{
				return this.users.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean removeUser(User user)
	{
		this.users.remove(user);
		return true;
	}

}
