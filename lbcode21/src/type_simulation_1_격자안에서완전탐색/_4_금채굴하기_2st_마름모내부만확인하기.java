package type_simulation_1_격자안에서완전탐색;

import java.util.Scanner;

public class _4_금채굴하기_2st_마름모내부만확인하기 {
	
	static int n, m;
	static int[][] grid;
	
	// 주어진 k에 대하여 마름모의 넓이를 반환합니다.
	static int GetArea(int k) {
	    return k * k + (k+1) * (k+1); 
	}
	
	// 주어진 좌표가 격자에 포함되는지 여부를 반환합니다.
	static boolean InRange(int x, int y) {
	    return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	// 주어진 k에 대하여 채굴 가능한 금의 개수를 반환합니다.
	static int GetNumOfGold(int row, int col, int k) {
	    int num_of_gold = 0;
	    int[] dx = {1, 1, -1, -1};
	    int[] dy = {-1, 1, 1, -1}; 
	    // 방향에 따라 바뀌는 x와 y의 변화량을 정의합니다.

	    num_of_gold += grid[row][col]; // k=0 일 때 처리

	    for(int curr_k = 1; curr_k <= k; curr_k++) {
	        int curr_x = row - curr_k, curr_y = col; // 순회 시작점 설정

	        for(int curr_dir = 0; curr_dir < 4; curr_dir++) {
	            for(int step = 0; step < curr_k; step++) {
	                if(InRange(curr_x, curr_y)) {
	                    num_of_gold += grid[curr_x][curr_y];
	                }
	                curr_x = curr_x + dx[curr_dir];
	                curr_y = curr_y + dy[curr_dir];
	            }
	        }
	    }

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
		
		for(int row = 0; row < n; row++) {
	        for(int col = 0; col < n; col++) {
	            for(int k = 0; k <= 2 * (n-1); k++) {
	                int num_of_gold = GetNumOfGold(row, col, k);

	                if(num_of_gold * m >= GetArea(k))
	                    max_gold = Math.max(max_gold, num_of_gold);
	            }
	        }
	    }
		
		System.out.println(max_gold);
		sc.close();
	}
}









































































