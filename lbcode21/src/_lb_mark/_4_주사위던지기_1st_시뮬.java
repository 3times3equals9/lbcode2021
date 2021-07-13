package _lb_mark;

import java.util.Scanner;

public class _4_주사위던지기_1st_시뮬 {
	
	static class Pair {
		public int row;
		public int col;
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
		// 해당 방향으로 이동했을 때의 다음 위치를 구합니다.
		// 이동이 불가능할 경우 OUT_OF_GRID를 반환합니다.
		public static Pair NextPos(int x, int y, int move_dir) {
			int[] dx = {0, 0, -1, 1};
			int[] dy = {1, -1, 0, 0};
			int nx = x + dx[move_dir], ny = y + dy[move_dir];
			if(in_range(nx, ny))
				return new Pair(nx, ny);
			else
				return OUT_OF_GRID;
		}
	}
	
	static final int MAX_N = 100;
	static final int ASCII_NUM = 128;
	static final int DIR_NUM = 4;
	static final Pair OUT_OF_GRID = new Pair(-1, -1);
	
	static int n, m;
	static int x, y;
	
	static int[][] grid;
	
	// 주사위가 놓여있는 상태 
	static int u = 1, f = 2, r = 3;
	
	// 격자 안에 있는지를 확인합니다.
	static boolean in_range(int x, int y) {
	    return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	static void Simulate(int move_dir) {
	    // move_dir 방향으로 굴렸을 때의 격자상의 위치를 구합니다.
		Pair next_pos = Pair.NextPos(x, y, move_dir);
	    // 굴리는게 불가능한 경우라면 패스합니다.
		//if(next_pos == OUT_OF_GRID)
    	if(next_pos.row == -1 && next_pos.col == -1)
	        return;
	    
	    // 위치를 이동합니다.
	    //tie(x, y) = next_pos;
    	x = next_pos.row;
    	y = next_pos.col;
	    
	    // 주사위가 놓여있는 상태를 조정합니다.
	    if(move_dir == 0) { // 동쪽
	        //tie(u, f, r) = make_tuple(7 - r, f, u);
	    	int nu = 7-r;
	    	int nf = f;
	    	int nr = u;
	    	u = nu;
	    	f = nf;
	    	r = nr;
	    }else if(move_dir == 1) { // 서쪽
	        //tie(u, f, r) = make_tuple(r, f, 7 - u);
	    	int nu = r;
	    	int nf = f;
	    	int nr = 7 - u;
	    	u = nu;
	    	f = nf;
	    	r = nr;
	    }else if(move_dir == 2) { // 북쪽
	        //tie(u, f, r) = make_tuple(f, 7 - u, r);
	    	int nu = f;
	    	int nf = 7 - u;
	    	int nr = r;
	    	u = nu;
	    	f = nf;
	    	r = nr;
	    }else { // 남쪽
	        //tie(u, f, r) = make_tuple(7 - f, u, r);
	    	int nu = 7 - f;
	    	int nf = u;
	    	int nr = r;
	    	u = nu;
	    	f = nf;
	    	r = nr;
	    }
	    // 바닥에 적혀있는 숫자를 변경합니다.
	    int down = 7 - u;
	    grid[x][y] = down;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		x--;
		y--;
		//int grid[MAX_N][MAX_N];
		grid = new int[n][n];
		
		int[] dir_mapper = new int[ASCII_NUM];
		dir_mapper['R'] = 0;
	    dir_mapper['L'] = 1;
	    dir_mapper['U'] = 2;
	    dir_mapper['D'] = 3;
	    
	    // 시뮬레이션 진행
	    grid[x][y] = 6;
	    for(int i = 0; i < m; i++) {
	        char char_dir = sc.next().charAt(0);
	        
	        Simulate(dir_mapper[char_dir]);
	    }
	    
	    int ans = 0;
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            ans += grid[i][j];
	    
	    System.out.println(ans);
		sc.close();
	}
}









































































