package sys.twitter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class User {
	int userId;
	String name;
	
	ArrayList<User> follows = new ArrayList<User>();
	ArrayList<User> followers = new ArrayList<User>();
	ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	ArrayList<Message> messages = new ArrayList<Message>();
	ArrayList<List> lists = new ArrayList<List>();
	
	public User(String name) {
		this.userId = UUID.randomUUID().hashCode();
		this.name = name;
	}
	
	public void follow(User u) {
		u.followedBy(this);
		this.follows.add(u);
	}
	
	private void followedBy(User u) {
		this.followers.add(u);
	}
	
	public ArrayList<User> getFollowings() {
		return this.follows;
	}

	public ArrayList<User> getFollowers() {
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
