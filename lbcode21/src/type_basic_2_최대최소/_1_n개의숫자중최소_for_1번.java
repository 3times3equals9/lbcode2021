package type_basic_2_최대최소;

import java.util.Scanner;

public class _1_n개의숫자중최소_for_1번 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 // 변수 선언
	    int n, min, cnt;
	    int[] A = new int[100];
	    
	    // 입력:
	    n = sc.nextInt();
	    for (int i = 0; i < n; i++)
	        A[i] = sc.nextInt();
	    
	    // 초기값을 적습니다. 최소가 될 첫 번째 후보입니다.
	    min = A[0];
	    cnt = 1; // Case 1

	    // 나머지 원소들을 보며 답을 갱신합니다.
	    for (int i = 1; i < n; i++){
			// Case 1
	    	if (min > A[i]){ // 지금까지 나왔던 값들 보다 더 작은 값이라면
	            min = A[i];  // 최초의 최솟값이 되므로 그 값을 갱신하고
	            cnt = 1;     // Count를 1로 초기화합니다.
	    	} 
			// Case 2
	        else if (min == A[i]){ // 지금까지의 최소와 같다면
	            cnt++;             // Count를 1 증가해줍니다.
	        }
	    }

	    // 출력:
	    System.out.println(min + " " + cnt);
		sc.close();
	}
}

/*
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int[] arr = new int[n];
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] < min) {
				min = arr[i];
				cnt = 1;
			}else if(arr[i] == min) {
				cnt++;
			}
		}
		
		System.out.println(min + " " + cnt);
		sc.close();
	}
}
*/




























