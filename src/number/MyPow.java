package number;

public class MyPow {
	private static double IMAGINARY_NUMBER = 11.11;	// square root of negatives
	private static double UNDEFINED = 22.22;		// zero to the zero
	private static double INFINITY = 33.33;			// divide by zero
	
	public static double pow(double a, double b) {
		if(b==0) {
			if(a==0) return UNDEFINED;
			return 1;
		}
		if(a==0) {
			if(b<0) return INFINITY;
			return 0;
		}
		if(b%2==0) return pow(a,b/2) * pow(a,b/2);
		else {
			if(b<0) return 1/a*pow(a,b+1);
			return a*pow(a,b-1);
		}
	}
	
	public static void main(String[] args) {
		double x = 5;
		double y = -4;
		System.out.println(Math.pow(x,y));
		System.out.println(pow(x,y));
	}
}
