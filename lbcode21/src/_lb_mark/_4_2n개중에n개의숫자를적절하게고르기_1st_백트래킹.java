package _lb_mark;

import java.util.ArrayList;
import java.util.Scanner;

public class _4_2n개중에n개의숫자를적절하게고르기_1st_백트래킹 {
	
	static final int MAX_N = 10;
	
	static int n;
	static int[] num;
	static boolean[] visited;

	static int ans = Integer.MAX_VALUE;
	
	static int Calc() {
	    int diff = 0;
	    for(int i = 0; i < 2 * n; i++)
	        diff = (visited[i]) ? (diff + num[i]) : (diff - num[i]);
	    
	    return Math.abs(diff);
	}
	
	static void FindMin(int idx, int cnt) {
		if(cnt == n) {
			ans = Math.min(ans, Calc());
	        return;
	    }
	    
	    if(idx == 2 * n)
			return;
	    
	    // 현재 숫자를 첫 번째 그룹에 사용한 경우입니다.
	    visited[idx] = true;
		FindMin(idx + 1, cnt + 1);
	    visited[idx] = false;
	    
	    // 현재 숫자를 두 번째 그룹에 사용한 경우입니다.
		FindMin(idx + 1, cnt);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int num[2 * MAX_N];
		//bool visited[2 * MAX_N];
		n = sc.nextInt();
		num = new int[2*n];
		visited = new boolean[2*n];
		
		for(int i = 0; i < 2 * n; i++)
			num[i] = sc.nextInt();
	   
		FindMin(0, 0);
	    
	    System.out.println(ans);
		sc.close();
	}
}









































































