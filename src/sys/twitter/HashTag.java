package sys.twitter;

public class HashTag {
	int hashTagId;
	String name;
	
	public HashTag(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return '#' + this.name;
	}
}
