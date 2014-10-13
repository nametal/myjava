package sys.twitter;

public class Twitter {
	public static void main(String[] args) {
		User user1 = new User("nametal");
		User user2 = new User("agnezmo");
		User user3 = new User("mario_teguh");
		user1.follow(user2);
		user1.follow(user3);
		
		System.out.println(user1.getFollowings());
		
		Tweet t1 = new Tweet("folbek dong kaka");
		t1.addHashTag(new HashTag("folbek"));
		t1.addMention(user2);

		Tweet t2 = new Tweet("T.G.I.F nonton");
		t2.addHashTag(new HashTag("tgif"));
		t2.addHashTag(new HashTag("salamsuper"));
		t2.addMention(user3);

		Tweet t3 = new Tweet("keren lagunya");
		t3.addMention(user2);
		
		user1.addTweet(t1);
		user1.addTweet(t2);
		user1.addTweet(t3);
		
		System.out.println(user1.getTweets());
		
		Message m1 = new Message("PIN BB ada ga?");
		user1.sendMessage(m1, user2);
		
		System.out.println(user2.getAllMessages());
		
		List l1 = new List("inspirational", false);
		l1.addUser(user2);
		l1.addUser(user3);
		user1.addList(l1);
		
		System.out.println(l1.getUsers());
		
		List l2 = new List("innerCircle", true);
		l2.addUser(user3);
		user1.addList(l2);

		System.out.println(l2.getUsers());

		System.out.println(user1.getLists());
	}
}
