package type_basic_2_최대최소;

import java.util.Scanner;

public class _2_n개의숫자중최대2개_1st_반복문2번 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 변수 선언: 
	    int n, max1, max2, max1_idx;
	    int[] A = new int[100];
	    
	    // 입력:
	    n = sc.nextInt();
	    for (int i = 0; i < n; i++)
	        A[i] = sc.nextInt();
	        
	    // Step 1: max1과 해당 index를 구합니다.
	    max1 = A[0];
	    max1_idx = 0;

	    for (int i = 1; i < n; i++) {
	        if (A[i] > max1){
	            max1 = A[i];
	            max1_idx = i; // 최대 위치를 갱신합니다.
	        }
	    }

	    //자바라서 초기화 해줘야함
	    max2 = Integer.MIN_VALUE;
	    // Step 2: max1이 골라진 위치를 제외한 곳에서 최댓값을 구합니다.
	    boolean is_initialized = false;
	    for (int i = 0; i < n; i++) {
	        if (i == max1_idx) 
	            continue; // Case 1 : 1번에서 고른 케이스는 패스합니다.

	        if (is_initialized == false) {
	            // Case 2: 아직 max2 값을 초기화 하지 못했다면
	            //         현재 값으로 초기화 합니다.
	            is_initialized = true;
	            max2 = A[i];
	        }
	        else if (A[i] > max2) {
	            // Case 3: 지금까지 계산한 값보다 좋다면 갱신합니다.
	            max2 = A[i];
	        }
	    }

	    // 출력: 
	    System.out.println(max1 + " " + max2);
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




























