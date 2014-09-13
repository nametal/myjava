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
	
	// more efficient way
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
	/* End of 3 */
	
	/* 4. Largest palindrome product */
	// my solution
	public static boolean isPalindromeNum(int n) {
		String s = String.valueOf(n);
		int d = s.length();
		int j = d-1;
		for (int i = 0; i < d/2; i++) {
//			System.out.println("s"+"["+i+"]="+s.charAt(i)+" vs s"+"["+j+"]=" + s.charAt(j));
			if(s.charAt(i) != s.charAt(j--)) return false;
		}
		return true;
	}
	public static int largestPalindromeProduct(int digit) {
		int max = (int)Math.pow(10,(double)digit);
		int min = max/10;
		int p = 0;
		int largestP = 0;
		String products = "";
		for (int x = max-1; x > min-1; x--) {
			for (int y = x; y > min-1; y--) {
				p = x*y;
//				System.out.println(i + " x " + j + "\t" + p);
				if(p <= largestP) break; // stop checking because x*y is going to be smaller
				if(isPalindromeNum_f(p)) {
					largestP = p; // automatically p > largestP
					products = x + " x " + y;
				}
			}
		}
		System.out.println(products);
		return largestP;
	}
	
	// efficient palindrome for number
	public static boolean isPalindromeNum_f(int n) {
		int ori = n;
		int rev = 0;
		while(n>0) {
			rev = 10*rev + n % 10;
			n /= 10;
		}
		return ori==rev;
	}
	/* End of 4 */
	
	/* 5. Smallest multiple */
	public static int smallestMul(int n) {
		int a = n;
		int b = 2;
		while (b<n) {
			b = 2;
			while (b <= n) {
				if(a%b!=0) break;
				b++;
			}
			a++;
		}
		return a-1;
	}
	/* End of 5 */
	
	/* 6. Sum square difference */
	// my solution
	public static int sumSquareDiff(int n) {
		int sumOfSq = 0;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sumOfSq += i*i;
			sum += i;
		}
		return sum*sum - sumOfSq;
	}
	
	// efficient way
	public static int sumSquareDiff_f(int n) {
		int sumOfSq = (2*n+1)*(n+1)*n/6;
		int sum = n*(n+1)/2;
		return sum*sum - sumOfSq;
	}
	/* End of 6 */
	
	/* 7. 10 001st prime */
	public static boolean isPrime(int n) {
//		System.out.printf("%d=",n);
		if(n == 2) return true; // the only even prime
		if(n < 2 || n % 2 == 0) return false;
		int upper = (int) Math.sqrt(n) + 1;
		for (int i = 3; i < upper; i+=2) {
			if(n % i == 0) return false;
		}
		return true;
	}
	
	public static int primeAt(int n) {
		if(n == 1) return 2;
		int c = 1;
		int x = 1;
		while(c < n) {
			x += 2;
			if (isPrime(x)) {
				c++;
//				System.out.println(c+" -> "+x);
			}
		}
		return x;
	}
	/* End of 7 */
	
	public static void main(String[] args) {
		/*int n=1000;
		System.out.println(multiplesBy3Or5(n));
		System.out.println(multiplesBy3Or5_f(n));*/
//		System.out.println(sumOfEvenFibo(4000000));
//		System.out.println(largestPrimeFactor2(600851475143L));
//		System.out.println(isPalindromeNum(9009));
//		System.out.println(isPalindromeNum_f(9009));
//		System.out.println(largestPalindromeProduct(3));
//		System.out.println(smallestMul(11)); // should be 27720
//		System.out.println(smallestMul(9));
//		System.out.println(sumSquareDiff(100));
		System.out.println(primeAt(10001));
	}
}