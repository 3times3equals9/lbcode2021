package type_simulation_3_격자안에서터지고떨어지는경우;

import java.util.Scanner;

public class _7_최적의십자모양폭발_chk {
	
	static int n;
	static int[][] original, grid, next_grid;
	
	static boolean InBombRange(int x, int y, int center_x, int center_y, int bomb_range) {
	    return (x == center_x || y == center_y) && 
	           Math.abs(x - center_x) + Math.abs(y - center_y) < bomb_range;
	}
	
	static void Bomb(int center_x, int center_y) {
		//십자 모양의 크기는 선택된 위치에 적혀있는 숫자로 정해지며,
		int bomb_range = grid[center_x][center_y];
	    
	    // Step1. 폭탄이 터질 위치는 0으로 채워줍니다.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(InBombRange(i, j, center_x, center_y, bomb_range))
					grid[i][j] = 0;
		
	    // Step2. 폭탄이 터진 이후의 결과를 next_grid에 저장합니다.
		for(int j = 0; j < n; j++) {
	        int next_row = n - 1;
			for(int i = n - 1; i >= 0; i--) {
				if(grid[i][j] > 0)
					next_grid[next_row--][j] = grid[i][j];
			}
	    }
		
	    // Step3. grid로 다시 값을 옮겨줍니다.
	    for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
	            grid[i][j] = next_grid[i][j];
	}
	
	static void copy() {
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				grid[i][j] = original[i][j];
	}
	
	static int CountCouple() {
		int cnt = 0;
		//가로
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-1; j++) {
				if(grid[i][j] != 0 && grid[i][j] == grid[i][j+1])
					cnt++;
			}
		}
		//세로
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] != 0 && grid[i][j] == grid[i+1][j])
					cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력:
		n = sc.nextInt();
		
		original = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				original[i][j] = sc.nextInt();
		
		int max = Integer.MIN_VALUE;
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				grid = new int[n][n];
				next_grid = new int[n][n];
				copy();
				
				Bomb(r, c);
				max = Math.max(max, CountCouple());
			}
		}
		
		System.out.println(max);
		sc.close();
	}
}









































































