package number;

public class Series {
	public static int maxTriple(int[] nums) {
		int max = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max)
				max = nums[i];
		}
		return max;
	}

	public static int[] make2(int[] a, int[] b) {
		int[] x = new int[a.length + b.length];
		for (int i = 0; i < x.length; i++) {
			if (i < a.length) {
				x[i] = a[i];
			} else
				x[i] = b[i - a.length];
				
		}
		return x;
	}
	
	public static int countCode(String str) {
		  int c=0;
		  for(int i=0;i<str.length()-3;i++){
		   if(str.substring(i,i+2).equals("co") && str.charAt(i+3)=='e') c++;
		  }
		  return c;
		}


	public static void main(String[] args) {
		/*
		 * StringBuffer buf = new StringBuffer(); int n = 100; for (int i = 1; i
		 * <= n; i++) { buf.append(i); System.out.println("length " + i + " = "
		 * + buf.length() + " on " + buf.charAt(i-1)); }
		 */
		System.out.println(countCode("codexxcode"));
	}
}
