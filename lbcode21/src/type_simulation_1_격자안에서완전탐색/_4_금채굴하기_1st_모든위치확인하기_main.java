package type_simulation_1_격자안에서완전탐색;

import java.util.Scanner;

public class _4_금채굴하기_1st_모든위치확인하기_main {
	
	static int n, m;
	static int[][] grid;
	
	// 주어진 k에 대하여 마름모의 넓이를 반환합니다.
	static int GetArea(int k) {
	    return k * k + (k+1) * (k+1); 
	}
	
	// 주어진 k에 대하여 채굴 가능한 금의 개수를 반환합니다.
	static int GetNumOfGold(int row, int col, int k) {
	    int num_of_gold = 0;

	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            if(Math.abs(row - i) + Math.abs(col - j) <= k)
	                num_of_gold += grid[i][j];

	    return num_of_gold;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max_gold = 0;
		// 입력:
		n = sc.nextInt();
		m = sc.nextInt();
		
		grid = new int[n][n];
		for(int row = 0; row < n; row++)
	        for(int col = 0; col < n; col++)
	        	grid[row][col] = sc.nextInt();
		
		// 격자의 각 위치가 마름모의 중앙일 때 채굴 가능한 금의 개수를 구합니다.
	    for(int row = 0; row < n; row++) {
	        for(int col = 0; col < n; col++) {
	            for(int k = 0; k <= 2 * (n-1); k++) {
	                int num_of_gold = GetNumOfGold(row, col, k);

	                // 손해를 보지 않으면서 채굴할 수 있는 최대 금의 개수를 저장합니다.
	                if(num_of_gold * m >= GetArea(k))
	                    max_gold = Math.max(max_gold, num_of_gold);
	            }
	        }
	    }
		
	    System.out.println(max_gold);
		sc.close();
	}
}









































































