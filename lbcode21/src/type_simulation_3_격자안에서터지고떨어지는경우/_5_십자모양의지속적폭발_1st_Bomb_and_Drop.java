package type_simulation_3_격자안에서터지고떨어지는경우;

import java.util.Scanner;

public class _5_십자모양의지속적폭발_1st_Bomb_and_Drop {
	
	static final int MAX_N = 200;
	static final int OUT_OF_GRID = -1;

	static int n, m;
	static int[][] grid, next_grid;
	
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

	// 해당 col 열에 폭탄이 터질 위치를 구합니다.
	// 없다면 OUT_OF_GRID를 반환합니다.
	static int GetBombRow(int col) {
	    for(int row = 0; row < n; row++)
	        if(grid[row][col] != 0)
	            return row;
	    
	    return OUT_OF_GRID;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		grid = new int[n][n];
		next_grid = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();
		
		// m번에 걸쳐 폭탄이 터집니다.
		while(m-- > 0) {
			int bomb_col = sc.nextInt();
			bomb_col--;
	        
	        // 폭탄이 터지게 될 위치를 구합니다.
			int bomb_row = GetBombRow(bomb_col);
			
			if(bomb_row == OUT_OF_GRID)
				continue;
			
			Bomb(bomb_row, bomb_col);
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(grid[i][j] + " ");
			System.out.println();
		}
		
		sc.close();
	}
}









































































