package type_backtracking_3_N개중에M개고르기_Simple;

import java.util.Scanner;

public class _2_xor결과최대만들기_백트래킹_방법2_main {
	
	static final int MAX_NUM = 20;
	// 전역 변수 선언:
	static int n, m;
	static int[] A;
	static int ans;
	
	static void FindMaxXor(int curr_idx, int cnt, int curr_val) {
	    if(cnt == m) {
	        ans = Math.max(ans, curr_val);
	        return;
	    }

	    if(curr_idx == n) 
	        return;

	    // curr_idx index 에 있는 숫자를 선택하지 않은 경우
	    FindMaxXor(curr_idx + 1, cnt, curr_val);
	    
	    // curr_idx index 에 있는 숫자를 선택한 경우
	    FindMaxXor(curr_idx + 1, cnt + 1, curr_val ^ A[curr_idx]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int A[MAX_NUM];
		// 입력:
		n = sc.nextInt();
		m = sc.nextInt();
		A = new int[n];
		
		for(int i = 0; i < n; i++) 
			A[i] = sc.nextInt();
		
		FindMaxXor(0, 0, 0);
		
		// 출력:
		System.out.println(ans);
		sc.close();
	}
}









































































