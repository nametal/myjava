package sys.twitter;

public class Message {
	int messageId;
	int senderId;
	String text;
	
	public Message(String text) {
		this.text = text;
	}
	
	public void setFromUserId(int userId) {
		this.senderId = userId;
	}
	
	@Override
	public String toString() {
		return text + " from " + senderId;
	}
}
