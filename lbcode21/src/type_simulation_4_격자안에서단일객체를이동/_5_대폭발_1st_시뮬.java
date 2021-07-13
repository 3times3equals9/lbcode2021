package type_simulation_4_격자안에서단일객체를이동;

import java.util.Scanner;

public class _5_대폭발_1st_시뮬 {
	
	static final int MAX_N = 100;
	static final int DIR_NUM = 4;
	
	static int n, m, r, c;
	static int[][] grid, next_grid;
	
	static boolean InRange(int x, int y) {
	    return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	static void Expand(int x, int y, int dist) {
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};
	    for(int i = 0; i < 4; i++) {
	        int nx = x + dx[i] * dist, ny = y + dy[i] * dist;
	        if(InRange(nx, ny))
	            next_grid[nx][ny] = 1;
	    }
	}
	
	static void Simulate(int dist) {
	    // Step1. next_grid 값을 0으로 초기화합니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            next_grid[i][j] = 0;
	    
	    // Step2. 폭탄을 던지는 시뮬레이션을 진행합니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            if(grid[i][j] > 0)
	                Expand(i, j, dist);

	    // Step3. next_grid 값을 grid로 업데이트 해줍니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            if(next_grid[i][j] > 0)
	                grid[i][j] = 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		//int grid[MAX_N][MAX_N];
		//int next_grid[MAX_N][MAX_N];
		grid = new int[n][n];
		next_grid = new int[n][n];
		
		grid[r - 1][c - 1] = 1;
		
		// 총 m번 시뮬레이션을 진행합니다.
	    int dist = 1;
	    while(m-- > 0) {
	        Simulate(dist);
	        dist *= 2;
	    }
	    
	    int ans = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				ans += grid[i][j];
		
		System.out.println(ans);
		sc.close();
	}
}









































































