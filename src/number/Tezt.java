package number;


public class Tezt {
	public static double pow(double x, double n) {
		if(n==0) return 1;
		if(x==0) {
			if(n<0) return Double.POSITIVE_INFINITY;
			return 0;
		}
		double mul = 1;
		for (int i = 0; i < Math.abs(n); i++) {
			mul *= x;
		}
		if(n>0) return mul;
		return 1/mul;
	}
	
	public static double powR(double x, double n) {
		if(n==0) return 1;
		if(x==0) {
			if(n>=0) return 0;
			return Double.POSITIVE_INFINITY;
		}
		if(n%2==0) return powR(x,n/2) * powR(x,n/2);
		if(n>0) return x * powR(x,n-1);
		return 1/x * powR(x,n+1);
	}
	
	public static void main(String[] args) {
		double[][] d = { {0,0}, {0,1}, {1,0}, {2,2}, {2,3}, {-2,3}, {-3,2}, {-2,-1}, {3,3}, {2,-3}, {0,-2}, {57,1}, {1,83} };
		for (int i = 0; i < d.length; i++) {
			System.out.printf(" pow(%5.1f,%5.1f) = %8.4f\n",d[i][0] ,d[i][1], pow(d[i][0], d[i][1]));
			System.out.printf("powR(%5.1f,%5.1f) = %8.4f\n",d[i][0] ,d[i][1], powR(d[i][0], d[i][1]));
		}
	}
}