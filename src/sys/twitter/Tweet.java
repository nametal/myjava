package sys.twitter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Tweet {
	int tweetId;
	int userId;
	String text;
	Timestamp timeStamp;
	
	ArrayList<HashTag> hashTags = new ArrayList<HashTag>();
	ArrayList<User> mentions = new ArrayList<User>();
	
	public Tweet(String text) {
		this.text = text;
		this.timeStamp = new Timestamp(new Date().getTime());
	}
	
	public void setUserId(int userId) { this.userId = userId; }
	
	public void addHashTag(HashTag h) {
		this.hashTags.add(h);
	}
	
	public void addMention(User u) {
		this.mentions.add(u);
	}
	
	@Override
	public String toString() {
		return '\n' + text + (mentions.size()>0 ? mentions : "") + (hashTags.size()>0 ? hashTags : "") + " at " + this.timeStamp;
	}
}
