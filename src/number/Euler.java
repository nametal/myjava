package number;


public class Euler {
	/* 1. Multiples of 3 or 5 */
	// my solution (easy way)
	public static int multiplesBy3Or5(int n) {
		int c=0;
		for (int i = 1; i < n; i++) c += (i%3==0 || i%5==0) ? i : 0;
		return c;
	}
	// efficient way
	public static int sumDivisibleBy(int n, int x) {
		int p = n / x;
		return x*(p*(1+p)/2);
	}
	public static int multiplesBy3Or5_f(int n) {
		return sumDivisibleBy(n-1, 3) + sumDivisibleBy(n-1, 5) - sumDivisibleBy(n-1, 15);
	}
	/* End of 1 */
	
	/* 2. Even Fibonacci numbers */
	// my solution
	public static int fibonacci(int n) {
		if(n<=2) return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	public static int sumOfEvenFibo(int max) {
		int c=0;
		for (int i = 1; fibonacci(i) <= max; i++) c += (fibonacci(i) % 2 == 0) ? fibonacci(i) : 0;
		return c;
	}
	/* End of 2 */
	
	/* 3. Largest prime factor */
	// my solution
	public static int largestPrimeFactor(long n) {
		int p = 1;
		for (int i = 2; n>1; i++) {
			while(n%i==0) {
				p = i;
				n /= i;
			}
		}
		return p;
	}
	// more efficient
	public static int largestPrimeFactor2(long n) {
		int p = 1;
		while(n%2==0) { // since 2 is the only even prime, we can treat it separately
			p = 2;
			n /= 2;
		}
		for (int i = 3; n>1; i+=2) { // reduce loop count by increase iteration with 2 every step
			while(n%i==0) {
				p = i;
				n /= i;
			}
		}
		return p;
	}
	
	public static void main(String[] args) {
		/*int n=1000;
		System.out.println(multiplesBy3Or5(n));
		System.out.println(multiplesBy3Or5_f(n));*/
//		System.out.println(sumOfEvenFibo(4000000));
		System.out.println(largestPrimeFactor2(600851475143L));
	}
}
