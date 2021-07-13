package type_simulation_1_격자안에서완전탐색;

import java.util.Scanner;

public class _7_양수직사각형의최대크기_chk_1 {
	
	static int n, m, ans;
	static int[][] grid;
	
	static boolean CheckBoard(int x1, int y1, int x2, int y2) {
	    // 직사각형 안이 모두 양수인지 확인
		for(int i = x1; i <= x2; i++)
	        for(int j = y1; j <= y2; j++)
	            if(grid[i][j] <= 0)
	                return false;
	                
	    return true;
	}
	
	static int RectCount(int x1, int y1, int x2, int y2) {
	    int cnt_of_nums = 0;
	    for(int i = x1; i <= x2; i++)
	        for(int j = y1; j <= y2; j++)
	        	cnt_of_nums++;
	    
	    return cnt_of_nums;
	}
	
	static void FindMaxCnt() {
		// (i, j), (k, l)을 양쪽 꼭지점으로 하는
	    // 첫 번째 직사각형을 정하여
	    // 그 중 최댓값을 찾아 반환합니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++)
	            for(int k = i; k < n; k++)
	                for(int l = j; l < m; l++)
	                	if(CheckBoard(i, j, k, l))
	                		ans = Math.max(ans, RectCount(i, j, k, l));
	    
	    return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		grid = new int[n][m];
		for(int row = 0; row < n; row++)
	        for(int col = 0; col < m; col++)
	        	grid[row][col] = sc.nextInt();
		
		ans = Integer.MIN_VALUE;
		FindMaxCnt();
		
		if(ans == Integer.MIN_VALUE) {
			ans = -1;
		}
		
		System.out.println(ans);
		sc.close();
	}
}









































































