package type_backtracking_3_N개중에M개고르기_Simple;

import java.util.Scanner;

public class _4_2n개중에n개의숫자를적절하게고르기_2nd_계산을동시에하는백트래킹 {
	
	static final int MAX_N = 10;
	
	static int n;
	static int[] num;

	static int ans = Integer.MAX_VALUE;
	
	static void FindMin(int idx, int cnt, int diff) {
		if(idx == 2 * n) {
			if(cnt == n)
				ans = Math.min(ans, Math.abs(diff));
			return;
		}
	    
	    // 현재 숫자를 더하는 역할로 사용한 경우입니다.
		FindMin(idx + 1, cnt + 1, diff + num[idx]);
	    // 현재 숫자를 더하는 빼는 역할로 사용한 경우입니다.
		FindMin(idx + 1, cnt, diff - num[idx]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int num[2 * MAX_N];
		n = sc.nextInt();
		num = new int[2*n];
		
		for(int i = 0; i < 2 * n; i++)
			num[i] = sc.nextInt();
	   
		FindMin(0, 0, 0);
	    
	    System.out.println(ans);
		sc.close();
	}
}









































































