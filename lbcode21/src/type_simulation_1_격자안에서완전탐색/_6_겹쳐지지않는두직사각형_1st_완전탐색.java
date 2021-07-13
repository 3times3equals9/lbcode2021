package type_simulation_1_격자안에서완전탐색;

import java.util.Scanner;

public class _6_겹쳐지지않는두직사각형_1st_완전탐색 {
	
	static int n, m;
	static int[][] grid, board;
	
	static void ClearBoard() {
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++)
	            board[i][j] = 0;
	}
	
	static void Draw(int x1, int y1, int x2, int y2) {
	    for(int i = x1; i <= x2; i++)
	        for(int j = y1; j <= y2; j++)
	            board[i][j]++;
	}
	
	static boolean CheckBoard() {
	    // 동일한 칸을 2개의 직사각형이 모두 포함한다면
	    // 겹치게 됩니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++)
	            if(board[i][j] >= 2)
	                return true;
	    return false;
	}
	
	// (x1, y1), (x2, y2) 그리고
	// (x3, y3), (x4, y4) 로 이루어져있는
	// 두 직사각형이 겹치는지 확인하는 함수
	static boolean Overlapped(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
	    ClearBoard();
	    Draw(x1, y1, x2, y2);
	    Draw(x3, y3, x4, y4);
	    return CheckBoard();
	}
	
	static int RectSum(int x1, int y1, int x2, int y2) {
	    int sum_of_nums = 0;
	    for(int i = x1; i <= x2; i++)
	        for(int j = y1; j <= y2; j++)
	            sum_of_nums += grid[i][j];
	    
	    return sum_of_nums;
	}
	
	// 첫 번째 직사각형이 (x1, y1), (x2, y2)를 양쪽 꼭지점으로 할 때
	// 두 번째 직사각형을 겹치지 않게 잘 잡아
	// 최대 합을 반환하는 함수
	static int FindMaxSum(int x1, int y1, int x2, int y2) {
	    int max_sum = Integer.MIN_VALUE;
	    
	    // (i, j), (k, l)을 양쪽 꼭지점으로 하는
	    // 두 번째 직사각형을 정하여
	    // 겹치지 않았을 때 중
	    // 최댓값을 찾아 반환합니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++)
	            for(int k = i; k < n; k++)
	                for(int l = j; l < m; l++) {
	                    if(!Overlapped(x1, y1, x2, y2, i, j, k, l))
	                        max_sum = Math.max(max_sum, 
	                                      RectSum(x1, y1, x2, y2) +
	                                      RectSum(i, j, k, l));
	                }
	    
	    return max_sum;
	}
	
	// 두 직사각형을 잘 잡았을 때의 최대 합을 반환하는 함수
	static int FindMaxSum() {
	    int max_sum = Integer.MIN_VALUE;
	    
		// (i, j), (k, l)을 양쪽 꼭지점으로 하는
	    // 첫 번째 직사각형을 정하여
	    // 그 중 최댓값을 찾아 반환합니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++)
	            for(int k = i; k < n; k++)
	                for(int l = j; l < m; l++)
	                    max_sum = Math.max(max_sum,
	                                  FindMaxSum(i, j, k, l));
	    return max_sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		grid = new int[n][m];
		board = new int[n][m];
		
		for(int row = 0; row < n; row++)
	        for(int col = 0; col < m; col++)
	        	grid[row][col] = sc.nextInt();
		
		int ans = FindMaxSum();
		System.out.println(ans);
		sc.close();
	}
}

/*
Intuition
두 직사각형을 전부 잡아서 겹치지 않는 경우 중 최대 합을 구합니다. 두 직사각형이 겹쳐지는지에 대한 여부는 새로운 배열을 이용하면 비교적 쉽게 계산할 수 있습니다.

Algorithm
가능한 모든 2개의 직사각형 쌍을 잡아보면서, 겹치지 않을 경우에만 두 직사각형 내 숫자들의 합을 구하여 최대 값을 갱신합니다. 이때 두 직사각형이 겹쳐지는지에 대한 여부는, 격자에 각 직사각형 영역마다 1씩 증가시켜 숫자가 2 이상인 칸이 있는지를 확인하면 쉽게 구현이 가능합니다.
*/







































































