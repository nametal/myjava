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
	public static long productOfAdjacent(String series, int digit, int offset) {
		long prod = 1;
		for (int i = 0; i < digit; i++) {
			String s = series.charAt(offset + i) + "";
			prod *= Integer.valueOf(s);
		}
//		System.out.println("off["+offset+"] = " + prod);
		return prod;
	}
	public static long largestProductInSeries(String series, int digit) {
		long max = 0;
		for(int offset=0; offset <= series.length()-digit; offset++) {
			long n = productOfAdjacent(series, digit, offset);
			if(n > max) max = n;
		}
		return max;
	}
	/* End of 8 */
	
	/* 9. Special Pythagorean triplet */
	public static boolean isPythagoras(int a, int b, int c) {
		return (c-a-b>0) && (c*c == a*a + b*b);
	}
	
	public static int largestPythagTriplet() {
		// TODO
		return 0;
	}
	/* End of 9 */
	
	/* 10. Summation of primes */
	public static long sumOfPrimeBelow(long n) {
		long s = 2;
		if(n<2) s=0;
		for (int i = 3; i<n; i+=2) {
			if(isPrime(i)) {
				s += i;
				System.out.println(i);
			}
		}
		return s;
	}
//	TODO
	/* End of 10 */
	
	/* 11. Largest product in a grid */
	public static int GRID[][] = { // [row][col]
			{ 8,02,22,97,38,15,00,40,00,75,04,05,07,78,52,12,50,77,91, 8},
			{49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48,04,56,62,00},
			{81,49,31,73,55,79,14,29,93,71,40,67,53,88,30,03,49,13,36,65},
			{52,70,95,23,04,60,11,42,69,24,68,56,01,32,56,71,37,02,36,91},
			{22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80},
			{24,47,32,60,99,03,45,02,44,75,33,53,78,36,84,20,35,17,12,50},
			{32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70},
			{67,26,20,68,02,62,12,20,95,63,94,39,63, 8,40,91,66,49,94,21},
			{24,55,58,05,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72},
			{21,36,23, 9,75,00,76,44,20,45,35,14,00,61,33,97,34,31,33,95},
			{78,17,53,28,22,75,31,67,15,94,03,80,04,62,16,14, 9,53,56,92},
			{16,39,05,42,96,35,31,47,55,58,88,24,00,17,54,24,36,29,85,57},
			{86,56,00,48,35,71,89,07,05,44,44,37,44,60,21,58,51,54,17,58},
			{19,80,81,68,05,94,47,69,28,73,92,13,86,52,17,77,04,89,55,40},
			{04,52, 8,83,97,35,99,16,07,97,57,32,16,26,26,79,33,27,98,66},
			{88,36,68,87,57,62,20,72,03,46,33,67,46,55,12,32,63,93,53,69},
			{04,42,16,73,38,25,39,11,24,94,72,18, 8,46,29,32,40,62,76,36},
			{20,69,36,41,72,30,23,88,34,62,99,69,82,67,59,85,74,04,36,16},
			{20,73,35,29,78,31,90,01,74,31,49,71,48,86,81,16,23,57,05,54},
			{01,70,54,71,83,51,54,69,16,92,33,48,61,43,52,01,89,19,67,48}};
	
	/* End of 11 */
	
	public static void main(String[] args) {
//		(1)
//		System.out.println(multiplesBy3Or5(1000));
//		System.out.println(multiplesBy3Or5_f(1000));
//		(2)
//		System.out.println(sumOfEvenFibo(4000000));
//		(3)
//		System.out.println(largestPrimeFactor2(600851475143L));
//		(4)
//		System.out.println(largestPalindromeProduct(3));
//		(5)
//		System.out.println(smallestMul(11)); // should be 27720
//		System.out.println(smallestMul(9));
//		(6)
//		System.out.println(sumSquareDiff(100));
//		(7)
//		System.out.println(primeAt(10001));
//		(8)
//		System.out.println(largestProductInSeries(DIGITS, 13));
//		(9)
//		TODO
//		(10)
//		System.out.println(sumOfPrimeBelow(2000000));
//		(11)
		System.out.println(GRID[1][2]);
	}
}