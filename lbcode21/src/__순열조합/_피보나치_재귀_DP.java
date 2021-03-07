package __순열조합;

public class _피보나치_재귀_DP {

	public static void main(String[] args) {
		
		System.out.println("피보나치 재귀");
		for(int i = 0; i<10; i++) {
			System.out.print(Fibonacci(i) + " ");
		}
		System.out.println();
		System.out.println("피보나치 DP");
		for(int i = 0; i<10; i++) {
			System.out.print(dynamicFibo(i) + " ");
		}
	}

	//재귀.
	private static int Fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return Fibonacci(n - 2) + Fibonacci(n - 1);
		}
	}
	
	//동적프로그래밍. 중간중간 계산된것을 재활용.
	private static int dynamicFibo(int n) {
		int last1, last2, result = 0;
		
		if(n <= 1) {
			return n;
		}
		
		last1 = 0;
		last2 = 1;
		// ... last1 -> last2 -> result
		for(int i=2; i<=n; i++) {
			result = last1 + last2;
			last1 = last2;
			last2 = result;
		}
		
		return result;
	}
}
