package type_basic_2_최대최소;

import java.util.Arrays;
import java.util.Scanner;

public class _2_n개의숫자중최대2개_3rd_sorting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 변수 선언: 
	    int n;
	    // 입력:
	    n = sc.nextInt();
	    int[] A = new int[n];
	    
	    for (int i = 0; i < n; i++)
	        A[i] = sc.nextInt();
	     
	    // 내림차순으로 정렬합니다.
	    Arrays.sort(A);
	    /*
	    	배열크기를 알고있어야 함.
	    	Arrays.sort 는 오름차순임.
	    */
	    
	    
	    // 출력:
	    System.out.println(A[n-1] + " " + A[n-2]);
		sc.close();
	}
}

/*
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE;
		int sub = Integer.MIN_VALUE;
		int maxidx = -1;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(max <= arr[i]) {
				max = arr[i];
				maxidx = i;
			}
		}
		arr[maxidx] = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			if(sub <= arr[i]) {
				sub = arr[i];
			}
		}
		System.out.println(max + " " + sub);
		sc.close();
	}
}
*/




























