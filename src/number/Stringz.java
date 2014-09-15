package number;

public class Stringz {
	public static boolean xyzMiddle(String str) {
		  int idx = str.indexOf("xyz");
		  int mid = str.length()/2;
		  System.out.println("mid="+mid);
		  System.out.println("idx="+idx);
		  return idx >= mid-2 && idx <= mid+1; // odd
		}

	public static void main(String[] args) {
		System.out.println(xyzMiddle("AxyzCB"));
	}
}
