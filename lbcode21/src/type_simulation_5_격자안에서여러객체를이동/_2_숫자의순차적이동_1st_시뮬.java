package type_simulation_5_격자안에서여러객체를이동;

import java.util.Scanner;

public class _2_숫자의순차적이동_1st_시뮬 {
	
	static class Pair{
		public int row;
		public int col;
		
		public Pair() {
			super();
		}

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static final int MAX_N = 20;
	static final int DIR_NUM = 8;
	// 전역 변수 선언:
	static int n, m;
	static int[][] grid;
	
	static boolean InRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	} 
	
	static Pair FindPos(int num) {
		Pair res = new Pair();
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            if(grid[i][j] == num) {
	            	res.row = i;
	            	res.col = j;
	                return res;
	            }
	    
	    return res;
	}
	
	// 그 다음 위치를 찾아 반환합니다.
	static Pair NextPos(Pair pos) {
	    int[] dx = {-1, -1, -1,  0, 0,  1, 1, 1};
	    int[] dy = { -1, 0,  1, -1, 1, -1, 0, 1};
	    
	    int x, y;
	    //tie(x, y) = pos;
	    x = pos.row;
	    y = pos.col;
	    
	    // 인접한 8개의 칸 중 가장 값이 큰 위치를 찾아 반환합니다.
	    int max_val = -1;
	    Pair max_pos = new Pair();
	    for(int i = 0; i < 8; i++) {
	        int nx = x + dx[i], ny = y + dy[i];
	        if(InRange(nx, ny) && grid[nx][ny] > max_val) {
	            max_val = grid[nx][ny];
	            //max_pos = make_pair(nx, ny);
	            max_pos.row = nx;
	            max_pos.col = ny;
	        }
	    }
	    
	    return max_pos;
	}
	
	static void Swap(Pair pos, Pair next_pos) {
	    int x, y, nx, ny;
	    //tie(x, y) = pos;
	    x = pos.row;
	    y = pos.col;
	    //tie(nx, ny) = next_pos;
	    nx = next_pos.row;
	    ny = next_pos.col;
	    
	    int temp = grid[x][y];
	    grid[x][y] = grid[nx][ny];
	    grid[nx][ny] = temp;
	}
	
	static void Simulate() {
	    // 번호가 증가하는 순으로
	    // 그 다음 위치를 구해
	    // 한 칸씩 움직입니다.
	    for(int num = 1; num <= n * n; num++) {
	    	Pair pos = FindPos(num);
	    	Pair next_pos = NextPos(pos);
	        Swap(pos, next_pos);
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int grid[MAX_N][MAX_N];
		// 입력:
		n = sc.nextInt();
		m = sc.nextInt();
		
		grid = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();
		
		// m번 시뮬레이션을 진행합니다.
		while(m-- > 0)
			Simulate();
	    
	    // 출력:
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}









































































