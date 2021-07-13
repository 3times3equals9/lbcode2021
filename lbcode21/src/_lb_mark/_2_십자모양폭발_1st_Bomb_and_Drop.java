package _lb_mark;

import java.util.Scanner;

public class _2_십자모양폭발_1st_Bomb_and_Drop {
	
	static int n;
	static int[][] grid, next_grid;
	
	static boolean InBombRange(int x, int y, int center_x, int center_y, int bomb_range) {
	    return (x == center_x || y == center_y) && 
	           Math.abs(x - center_x) + Math.abs(y - center_y) < bomb_range;
	}
	
	static void Bomb(int center_x, int center_y) {
		next_grid = new int[n][n];
		
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력:
		n = sc.nextInt();
		
		grid = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();
		
		int r, c;
		r = sc.nextInt();
		c = sc.nextInt();
		
		Bomb(r - 1, c - 1);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				System.out.print(grid[i][j] + " ");
			System.out.println();
		}
		
		sc.close();
	}
}









































































