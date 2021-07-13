package type_basic_2_최대최소;

import java.util.Scanner;

public class _5_자동차단일거래이익최대화하기_chk {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for(int k=0; k<n; k++) {
			a[k] = sc.nextInt();
		}
		
		int ans = 0;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				int val = a[j] - a[i];
				if(val > ans) {
					ans = val;
				}
			}
		}
		
		System.out.println(ans);
		
		sc.close();
	}
}

/*
import java.util.Scanner;

public class _5_자동차단일거래이익최대화하기_chk {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				int val = a[i] - a[j];
				if(val > 0 && val > ans) {
					ans = val;
				}
			}
		}
		
		if(ans == Integer.MIN_VALUE) {
			ans = 0;
		}
		System.out.println(ans);
		
		sc.close();
	}
}

*/





































































