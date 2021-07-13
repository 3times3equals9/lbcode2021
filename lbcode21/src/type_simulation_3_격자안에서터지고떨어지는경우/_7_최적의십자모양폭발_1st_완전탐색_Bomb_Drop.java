package type_simulation_3_격자안에서터지고떨어지는경우;

import java.util.Scanner;

public class _7_최적의십자모양폭발_1st_완전탐색_Bomb_Drop {
	
	//static final int MAX_N = 50;
	static final int DIR_NUM = 4;
	
	static int n;
	static int[][] grid, next_grid, temp;
	
	static boolean InBombRange(int x, int y, int center_x, int center_y, int bomb_range) {
	    return (x == center_x || y == center_y) && 
	           Math.abs(x - center_x) + Math.abs(y - center_y) < bomb_range;
	}
	
	static void Bomb(int center_x, int center_y) {
		// Step1. next_grid 값을 0으로 초기화합니다.
	    for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
	            next_grid[i][j] = 0;

	    // Step2. 폭탄이 터질 위치는 0으로 채워줍니다.
		int bomb_range = grid[center_x][center_y];
	    
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(InBombRange(i, j, center_x, center_y, bomb_range))
					grid[i][j] = 0;
		
	    // Step3. 폭탄이 터진 이후의 결과를 next_grid에 저장합니다.
		for(int j = 0; j < n; j++) {
	        int next_row = n - 1;
			for(int i = n - 1; i >= 0; i--) {
				if(grid[i][j] > 0)
					next_grid[next_row--][j] = grid[i][j];
			}
	    }
		
	    // Step4. grid로 다시 값을 옮겨줍니다.
	    for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
	            grid[i][j] = next_grid[i][j];
	}
	
	static void SaveGrid() {
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				temp[i][j] = grid[i][j];
	}
	
	static void LoadGrid() {
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				grid[i][j] = temp[i][j];
	}
	
	static boolean InRange(int x, int y) {
	    return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	static boolean MeetTheCondition(int x, int y, int nx, int ny) {
	    return InRange(nx, ny) && (grid[x][y] > 0) && grid[x][y] == grid[nx][ny];
	}
	
	static int Calc() {
		int cnt = 0;
		for(int x = 0; x < n; x++)
			for(int y = 0; y < n; y++) {
				int[] dx = {-1, 1, 0, 0};
				int[] dy = {0, 0, 1, -1};
	            
				for(int k = 0; k < 4; k++) {
					int nx = x + dx[k], ny = y + dy[k];
	                if(MeetTheCondition(x, y, nx, ny))
					    cnt++;
				}
			}
		
	    // 중복되어 2번씩 count되므로
	    // 2로 나누어줍니다.
		return cnt / 2;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		grid = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();
		
		int ans = 0;
		
		// 각 위치에 대해 진행해보고
	    // 그 중 최대 만족 횟수를 구합니다.
	    for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				temp = new int[n][n];
				SaveGrid();
				next_grid = new int[n][n];
				Bomb(i, j);
				ans = Math.max(ans, Calc());
				LoadGrid();
			}
	    }
	    
	    System.out.println(ans);
		sc.close();
	}
}









































































