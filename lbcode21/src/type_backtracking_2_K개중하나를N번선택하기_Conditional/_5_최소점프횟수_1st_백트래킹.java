package type_backtracking_2_K개중하나를N번선택하기_Conditional;

import java.util.Scanner;

public class _5_최소점프횟수_1st_백트래킹 {
	
	static final int MAX_N = 10;
	static int n;
	static int[] num;
	static int ans = Integer.MAX_VALUE;
	
	static void FindMin(int idx, int cnt) {
	    // 마지막 위치를 넘었을 때
	    // 그 중 최소 이동 횟수를 갱신합니다.
		if(idx >= n - 1) {
			ans = Math.min(ans, cnt);
			return;
		}
	    
		for(int dist = 1; dist <= num[idx]; dist++)
			FindMin(idx + dist, cnt + 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		num = new int[n];
		
		for(int i=0; i<n; i++) {
			num[i] = sc.nextInt();
		}
		
		FindMin(0,0);
		if(ans == Integer.MAX_VALUE)
			ans = -1;
		
		System.out.println(ans);
		sc.close();
	}
}









































































