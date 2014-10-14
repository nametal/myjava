package sys.twitter;

import java.util.ArrayList;
import java.util.Iterator;

public class User {
	int userId;
	String name;
	Server server;
	
	ArrayList<Integer> follows = new ArrayList<Integer>();
	ArrayList<Integer> followers = new ArrayList<Integer>();
	ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	ArrayList<Message> messages = new ArrayList<Message>();
	ArrayList<List> lists = new ArrayList<List>();
	
	public User(Server s, int userId, String name) {
		this.userId =  userId;
		this.name = name;
		this.server = s;
		s.users.add(this);
	}
	
	public void follow(int userId) {
		User u = findUser(userId);
		u.followedBy(this.userId);
		this.follows.add(userId);
	}
	
	public User findUser(int userId) {
		for(User u:server.users) {
			if(u.userId == userId)
				return u;
		}
		return null;
	}
	
	private void followedBy(int userId) {
		this.followers.add(userId);
	}
	
	public ArrayList<Integer> getFollowings() {
		return this.follows;
	}

	public ArrayList<Integer> getFollowers() {
		return this.followers;
	}
	
	public void addTweet(Tweet t) {
		t.setUserId(this.userId);
		this.tweets.add(0,t); // add new at head
	}
	
	public ArrayList<Tweet> getTweets() {
		return this.tweets;
	}
	
	private void addMessage(Message m) {
		this.messages.add(m);
	}
	
	public void sendMessage(Message m, User u) {
		m.setFromUserId(this.userId);
		u.addMessage(m);
	}
	
	public ArrayList<Message> getAllMessages() {
		return this.messages;
	}
	
	@Override
	public String toString() {
		return '@' + this.name;
	}
	
	public int getUserId() { return this.userId; }
	
	public void addList(List li) {
		li.setUserId(this.userId);
		this.lists.add(li);
	}
	
	public ArrayList<List> getLists() {
		ArrayList<List> publicList = new ArrayList<List>();
		for (Iterator<List> iterator = lists.iterator(); iterator.hasNext();) {
			List list = (List) iterator.next();
			if(!list.isPrivate) 
				publicList.add(list);
		}
		return publicList;
	}
}
