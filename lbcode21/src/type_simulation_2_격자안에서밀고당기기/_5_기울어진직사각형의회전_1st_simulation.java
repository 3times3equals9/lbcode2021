package type_simulation_2_격자안에서밀고당기기;

import java.util.Scanner;

public class _5_기울어진직사각형의회전_1st_simulation {
	
	static final int DIR_NUM = 4;
	static final int CCW = 0;
	static final int CW = 1;
	// 전역 변수 선언:
	static int n;
	static int[][] grid, temp; 
	
	static void Shift(int x, int y, int k, int l, int move_dir) {
	    //vector<int> dx, dy, move_nums;
	    int[] dx, dy, move_nums;
		dx = new int[4];
		dy = new int[4];
		move_nums = new int[4];
		if(move_dir == CCW) {
			//dx = {-1, -1, 1, 1};
			dx[0] = -1; dx[1] = -1; dx[2] = 1; dx[3] = 1;
			//dy = {1, -1, -1, 1};
			dy[0] = 1; dy[1] = -1; dy[2] = -1; dy[3] = 1;
			//move_nums = {k, l, k, l};
			move_nums[0] = k; move_nums[1] = l; 
			move_nums[2] = k; move_nums[3] = l;
		} else {
			//dx = {-1, -1, 1, 1};
			dx[0] = -1; dx[1] = -1; dx[2] = 1; dx[3] = 1;
			//dy = {-1, 1, 1, -1};
			dy[0] = -1; dy[1] = 1; dy[2] = 1; dy[3] = -1;
			//move_nums = {l, k, l, k};
			move_nums[0] = l; move_nums[1] = k; 
			move_nums[2] = l; move_nums[3] = k;
		}
	    
		temp  = new int[n][n];
		
	    // Step1. temp 배열에 grid 값을 복사합니다.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				temp[i][j] = grid[i][j];

	    // Step2. 기울어진 직사각형의 경계를 쭉 따라가면서
	    //        숫자를 한 칸씩 밀었을 때의 결과를
	    //        temp에 저장합니다.
	    for(int d = 0; d < DIR_NUM; d++)
	        for(int q = 0; q < move_nums[d]; q++) {
	            int nx = x + dx[d], ny = y + dy[d];
	            temp[nx][ny] = grid[x][y];
				x = nx; y = ny;
	        }
	    
	    // Step3. temp값을 grid에 옮겨줍니다.
	    for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				grid[i][j] = temp[i][j];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		grid = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) 
				grid[i][j] = sc.nextInt();
		
		//temp  = new int[n][n];
		
		int x = sc.nextInt(); 
		int y = sc.nextInt(); 
		int m1 = sc.nextInt(); 
		int m2 = sc.nextInt(); 
		int m3 = sc.nextInt(); 
		int m4 = sc.nextInt(); 
		int d = sc.nextInt();
		
		Shift(x - 1, y - 1, m1, m2, d);
		
		// 출력:
	    for(int row = 0; row < n; row++) {
	        for(int col = 0; col < n; col++)
	        	System.out.print(grid[row][col] + " ");
	        System.out.println();
	    }
	    
		sc.close();
	}
}









































































