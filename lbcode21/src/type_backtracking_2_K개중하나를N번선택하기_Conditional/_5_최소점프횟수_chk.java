package type_backtracking_2_K개중하나를N번선택하기_Conditional;

import java.util.Scanner;

public class _5_최소점프횟수_chk {
	
	static int n;
	static int[] jump;
	static int min = Integer.MAX_VALUE;
	
	static void dfs(int idx, int cnt) {
		if(idx == n-1) {
			min = Math.min(min, cnt);
			return;
		}
		
		for(int k=1; k<=jump[idx]; k++) {
			int next_idx = idx + k;
			if(next_idx < n) {
				dfs(next_idx, cnt+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		jump = new int[n];
		
		for(int i=0; i<n; i++) {
			jump[i] = sc.nextInt();
		}
		
		dfs(0,0);
		System.out.println(min == Integer.MAX_VALUE? -1: min);
		sc.close();
	}
}









































































