package at.fh_joanneum.swd.pmt.main.data;

public class UserDataStore implements IUserDataStore {
	private User user;

//	private static UserDataStore instance;
//	
//	
//	public static UserDataStore getInstance() {
//		if (instance == null)
//			instance = new UserDataStore();
//		return instance;
//	}
//	
//	private UserDataStore(){}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
