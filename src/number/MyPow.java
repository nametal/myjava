package number;

import java.math.BigDecimal;

public class MyPow {
	public static double pow(double a, double b) {
		if(b==0) {
//			if(a==0)
//				return UNDEFINED;
			return 1;
		}
		if(a==0) {
			if(b<0) 
				return Double.POSITIVE_INFINITY;
			return 0;
		}
		if(b<0) 
			return 1/pow(a,-b);
		if(b%2==0) { 
			BigDecimal temp = BigDecimal.valueOf(pow(a,b/2));
			return temp.multiply(temp).doubleValue();
		} else {
			if(b%1!=0) { // fractional exponent
				return Double.NaN; // TODO this1
			}
			return a*pow(a,b-1);
		}
	}
	
	public static void main(String[] args) {
		double[][] ds = {{0,0}, {0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {3,1}, {2,3}, {-2,-3}, {-2,4}, {2,-2}};
		for (int i = 0; i < ds.length; i++) {
			System.out.printf("Math.pow(%4.1f,%4.1f) = %f\n",ds[i][0],ds[i][1],Math.pow(ds[i][0],ds[i][1]));
			System.out.printf("  My pow(%4.1f,%4.1f) = %f\n",ds[i][0],ds[i][1],pow(ds[i][0],ds[i][1]));
		}
	}
}
