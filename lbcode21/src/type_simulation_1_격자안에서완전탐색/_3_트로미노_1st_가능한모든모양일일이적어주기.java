package type_simulation_1_격자안에서완전탐색;

import java.util.Scanner;

public class _3_트로미노_1st_가능한모든모양일일이적어주기 {
	
	static int n, m;
	static int[][] grid;
	// 가능한 모든 모양을 전부 적어줍니다.[6][3][3]
	static int[][][] shapes = {
	    {{1, 1, 0},
	    {1, 0, 0},
	    {0, 0, 0}},

	    {{1, 1, 0},
	    {0, 1, 0},
	    {0, 0, 0}},

	    {{1, 0, 0},
	    {1, 1, 0},
	    {0, 0, 0}},

	    {{0, 1, 0},
	    {1, 1, 0},
	    {0, 0, 0}},

	    {{1, 1, 1},
	    {0, 0, 0},
	    {0, 0, 0}},

	    {{1, 0, 0},
	    {1, 0, 0},
	    {1, 0, 0}},
	};
	
	// 주어진 위치에 대하여 가능한 모든 모양을 탐색하며 최대 합을 반환합니다.
	static int GetMaxSum(int x, int y) {
	    int max_sum = 0;
	    
	    for(int i = 0; i < 6; i++) {
	        boolean is_possible = true;
	        int sum = 0;
	        for(int dx = 0; dx < 3; dx++) {
	            for(int dy = 0; dy < 3; dy++) {
	            	//틀에서 0인건 무시
	                if(shapes[i][dx][dy] == 0) continue;
	                
	                //모양, 1일때, 1인게 튀어나가면 불가 (블럭이 튀어나가면 안됨)
	                if(x + dx >= n || y + dy >= m) is_possible = false;
	                else sum += grid[x + dx][y + dy];
	            }
	        }
	        if(is_possible) {
	            max_sum = Math.max(max_sum, sum);
	        }
	    }
	    
	    return max_sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][m];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				grid[i][j] = sc.nextInt();
		
		int ans = 0;
		
		// 격자의 각 위치에 대하여 탐색하여줍니다.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				ans = Math.max(ans, GetMaxSum(i, j));
		
		System.out.println(ans);
		sc.close();
	}
}

/*
1. Solution1에서 모양을 다음과 같이 정의하면 어떻게 될까요?

>> 대충 왼쪽 위에 딱 붙게 해야한다는 기준 세워야 한다는 뜻

Solution1에서의 풀이가 격자의 왼쪽 모서리에 각각의 3 * 3 크기의 block들이 대응된다는 것을 가정하고 풀었기 때문에, 저렇게 block을 만드는 경우 다음 예시에서 올바른 답을 구하지 못하게 됩니다.


*/






































































