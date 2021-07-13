package type_simulation_1_격자안에서완전탐색;

import java.util.Scanner;

public class _1_최고의33위치_1st_시뮬레이션_main {
	
	static int n;
	static int[][] grid;
	
	// (row_s, col_s) ~ (row_e, col_e) 사이의 금의 개수를 계산합니다.
	static int GetNumOfGold(int row_s, int col_s, int row_e, int col_e) {
	    int num_of_gold = 0;

	    for(int i = row_s; i <= row_e; i++)
	        for(int j = col_s; j <= col_e; j++)
	            num_of_gold += grid[i][j];

	    return num_of_gold;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max_gold = 0;
		
		// 입력:
		n = sc.nextInt();
		grid = new int[n][n];
				
		for(int row = 0; row < n; row++)
	        for(int col = 0; col < n; col++)
	            grid[row][col] = sc.nextInt();
	    
		// (row, col)이 3 * 3 격자의 좌측 상단 모서리인 경우를 전부 탐색합니다. 
	    for(int row = 0; row < n; row++) {
	        for(int col = 0; col < n; col++) {
	            // 3 * 3 격자가 n * n 격자를 벗어나는 경우는 계산하지 않습니다.
	            if(row + 2 >= n || col + 2 >= n) continue;
	            
	            // 금의 개수를 계산합니다.
	            int num_of_gold = GetNumOfGold(row, col, row + 2, col + 2);

	            // 최대 금의 개수를 저장합니다.
	            max_gold = Math.max(max_gold, num_of_gold);
	        }
	    }
		
	    System.out.println(max_gold);
		sc.close();
	}
}






































































