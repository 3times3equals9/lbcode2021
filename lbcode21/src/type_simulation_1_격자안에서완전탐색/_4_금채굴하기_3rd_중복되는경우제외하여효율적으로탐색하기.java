package type_simulation_1_격자안에서완전탐색;

import java.util.Scanner;

public class _4_금채굴하기_3rd_중복되는경우제외하여효율적으로탐색하기 {
	
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
	
	// 주어진 k에 대하여 모서리에서 채굴 가능한 금의 개수를 반환합니다.
	static int GetNumOfGoldInBorder(int row, int col, int k) {
	    int num_of_gold = 0;
	    int[] dx = {1, 1, -1, -1};
	    int[] dy = {-1, 1, 1, -1}; 
	    // 방향에 따라 바뀌는 x와 y의 변화량을 정의합니다.
	    
	    if(k == 0)
	        return grid[row][col];

	    int curr_x = row - k, curr_y = col; // 순회 시작점 설정

	    for(int curr_dir = 0; curr_dir < 4; curr_dir++) {
	        for(int step = 0; step < k; step++) {
	            if(InRange(curr_x, curr_y)) {
	                num_of_gold += grid[curr_x][curr_y];
	            }
	            curr_x = curr_x + dx[curr_dir];
	            curr_y = curr_y + dy[curr_dir];
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
	            int num_of_gold = 0;
	            for(int k = 0; k <= 2 * (n-1); k++) {
	                // 이전 k까지 구한 금의 개수에
	                // 해당 k의 모서리에 존재하는 금의 개수를 더해줍니다.
	                num_of_gold += GetNumOfGoldInBorder(row, col, k);

	                if(num_of_gold * m >= GetArea(k))
	                    max_gold = Math.max(max_gold, num_of_gold);
	            }
	        }
	    }
		
		System.out.println(max_gold);
		sc.close();
	}
}

/*
Intuition
solution2에서는 임의의 위치에서 가능한 K 범위에 대하여 모두 탐색할 때 매번 새로 마름모를 탐색하였습니다. 잘 생각해보면 K=a 일 때 내부에 있는 금의 개수는 (K=a-1 일 때의 금의 개수) + (K=a 일 때 그려지는 마름모의 가장자리에 있는 금의 개수)로 구할 수 있습니다. 이러한 특성을 활용하여 보다 효율적으로 탐색할 수 있습니다.

Algorithm
아래의 그림과 같이 k=2일 때 아래의 그림과 같이 k=1일 때와 k=2일 때의 가장자리의 합으로 구할 수 있습니다. 따라서 가능한 K 범위인 0~2*(n-1)에 대해서 탐색을 할 때 매번 새로 마름모 안의 영역을 탐색하는 것이 아니라 이전에 탐색했던 마름모 내부의 금 개수에 해당 마름모의 모서리에 있는 금의 개수만 더해주면 됩니다.
*/






































































