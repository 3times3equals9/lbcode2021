package type_simulation_4_격자안에서단일객체를이동;

import java.util.Scanner;

public class _2_떨어지는1자블록_1st_Simulation {
	
	static final int MAX_N = 100;
	static int n, m, k;
	static int[][] grid;
	
	// 해당 row에 [col_s, col_e] 열에
	// 전부 블럭이 없는지를 확인합니다.
	static boolean AllBlank(int row, int col_s, int col_e) {
	    for(int col = col_s; col <= col_e ; col++)
	        if(grid[row][col] > 0)
	            return false;

	    return true;
	}
	
	// 최종적으로 도달하게 될 위치는
	// 그 다음 위치에 최초로 블럭이 존재하는 순간임을 이용합니다.
	static int GetTargetRow() {
	    for(int row = 0; row < n - 1; row++)
			if(!AllBlank(row + 1, k, k + m - 1))
	            return row;

	    return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		k--;
		
		grid = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();
		
		// 최종적으로 멈추게 될 위치를 구합니다.
	    int target_row = GetTargetRow();
	    
	    // 최종 위치에 전부 블럭을 표시합니다.
	    for(int col = k; col < k + m; col++)
	        grid[target_row][col] = 1;
	    
	    for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				System.out.print(grid[i][j] + " ");
			System.out.println();
		}
		
		sc.close();
	}
}









































































