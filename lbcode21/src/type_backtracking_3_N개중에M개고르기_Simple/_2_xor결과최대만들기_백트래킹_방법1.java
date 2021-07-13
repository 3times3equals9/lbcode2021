package type_backtracking_3_N개중에M개고르기_Simple;

import java.util.Scanner;

public class _2_xor결과최대만들기_백트래킹_방법1 {
	
	static final int MAX_NUM = 20;
	// 전역 변수 선언:
	static int n, m;
	static int[] A;
	static boolean[] visited;
	static int ans;
	
	static int Calc() {
	    // xor 연산의 항등원인 0을 초기값으로 설정합니다.
	    int val = 0;
	    for(int i = 0; i < n; i++)
	        if(visited[i])
	            val ^= A[i];
	    
	    return val;
	}
	
	static void FindMaxXor(int curr_idx, int cnt) {
	    if(cnt == m) {
	        // 선택된 모든 조합에 대해 xor 연산을 적용해봅니다.
	        ans = Math.max(ans, Calc());
	        return;
	    }

	    if(curr_idx == n) 
	        return;

	    // curr_idx index 에 있는 숫자를 선택하지 않은 경우
	    FindMaxXor(curr_idx + 1, cnt);
	    
	    // curr_idx index 에 있는 숫자를 선택한 경우
	    visited[curr_idx] = true;
	    FindMaxXor(curr_idx + 1, cnt + 1);
	    visited[curr_idx] = false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int A[MAX_NUM];
//		bool visited[MAX_NUM];
		// 입력:
		n = sc.nextInt();
		m = sc.nextInt();
		A = new int[n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) 
			A[i] = sc.nextInt();
		
		FindMaxXor(0, 0);
		
		// 출력:
		System.out.println(ans);
		sc.close();
	}
}









































































