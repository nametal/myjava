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
	
	static String DIGITS = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
	
	/* 8. Largest product in a series */
	public static int sumOfAdjacent(String series, int digit, int offset) {
		int prod = 1;
		for (int i = 0; i < digit; i++) {
			String s = series.charAt(offset + i) + "";
			prod *= Integer.valueOf(s);
		}
//		System.out.println("off["+offset+"] = " + prod);
		return prod;
	}
	public static int largestProductInSeries(String series, int digit) {
		int max = 0;
		int offset = 0;
		while(offset <= series.length()-digit) {
			int n = sumOfAdjacent(series, digit, offset);
			if(n > max) max = n;
			offset++;
		}
		return max;
	}
	/* End of 8 */
	
	/* 9. Special Pythagorean triplet */
	public static boolean isPythagoras(int a, int b, int c) {
		return (c-a-b>0) && (c*c == a*a + b*b);
	}
	
	
	
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
//		System.out.println(primeAt(10001));
//		String s = "9781797784617";
		System.out.println(largestProductInSeries(DIGITS, 13));
	}
}