package sys.twitter;

import java.util.ArrayList;

public class List {
	int listId;
	int userId;
	boolean isPrivate;
	String name;
	
	ArrayList<User> users = new ArrayList<User>();
	
	public List(String name, boolean isPrivate) {
		this.name = name;
		this.isPrivate = isPrivate;
	}
	
	public void addUser(User u) {
		this.users.add(u);
	}
	
	public ArrayList<User> getUsers() {
		return this.users;
	}
	
	public void setUserId(int userId) { this.userId = userId; }
	
	@Override
	public String toString() {
		return name;
	}
}
