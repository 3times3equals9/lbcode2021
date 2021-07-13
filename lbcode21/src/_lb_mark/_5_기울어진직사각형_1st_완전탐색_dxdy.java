package _lb_mark;

import java.util.Scanner;

public class _5_기울어진직사각형_1st_완전탐색_dxdy {
	
	static int n;
	static int[][] grid;
	static final int DIR_NUM = 4;
	
	// 주어진 좌표가 격자에 포함되는지 여부를 반환합니다.
	static boolean InRange(int x, int y) {
	    return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	static int GetScore(int x, int y, int k, int l) {
	    int[] dx = {-1, -1, 1, 1};
	    int[] dy = {1, -1, -1, 1};
	    int[] move_num = {k, l, k, l};
	    
	    int sum_of_nums = 0;

	    // 기울어진 직사각형의 경계를 쭉 따라가봅니다.
	    for(int d = 0; d < DIR_NUM; d++)
	        for(int q = 0; q < move_num[d]; q++) {
	            x += dx[d]; y += dy[d];
	                
	            // 기울어진 직사각형이 경계를 벗어나는 경우라면
	            // 불가능하다는 의미로 답이 갱신되지 않도록
	            // 0을 반환합니다.
	            if(!InRange(x, y))
	                return 0;
				
	            sum_of_nums += grid[x][y];
	        }
	    
	    return sum_of_nums;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		grid = new int[n][n];
		for(int row = 0; row < n; row++)
	        for(int col = 0; col < n; col++)
	        	grid[row][col] = sc.nextInt();
		
		int ans = 0;
		
		// (i, j)를 시작으로 1, 2, 3, 4 방향
	    // 순서대로 길이 [k, l, k, l] 만큼 이동하면 그려지는
	    // 기울어진 직사각형을 잡아보는
	    // 완전탐색을 진행해봅니다.
	    for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				for(int k = 1; k < n; k++)
					for(int l = 1; l < n; l++)
	                    ans = Math.max(ans, GetScore(i, j, k, l));
	    
	    System.out.println(ans);
		sc.close();
	}
}









































































