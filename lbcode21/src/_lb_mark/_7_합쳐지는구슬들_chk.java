package _lb_mark;

import java.util.ArrayList;
import java.util.Scanner;

public class _7_합쳐지는구슬들_chk {
	
	static class Marble {
		public int row;
		public int col;
		public int weight;
		public int dir;
		public int num;
		public Marble() {
			super();
		}
		public Marble(int row, int col, int weight, int dir, int num) {
			super();
			this.row = row;
			this.col = col;
			this.weight = weight;
			this.dir = dir;
			this.num = num;
		}
	}
	
	static final int MAX_N = 50;
	static final int ASCII_NUM = 128;
	static final int DIR_NUM = 4;
	
	static int n, m, t;
	static ArrayList<Marble>[][] grid;
	static ArrayList<Marble>[][] next_grid;
	static int[] dir_mapper = new int[ASCII_NUM];
	
	static final int[] dr = {-1, 0, 0, 1};
	static final int[] dc = {0, 1, -1, 0};
	
	static boolean InRange(int x, int y) {
	    return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	// 해당 구슬의 1초 후의 위치를 계산하여 반환합니다.
	static Marble Move(Marble marble) {
	    int row, col, weight, dir, num;
	    row = marble.row;
	    col = marble.col;
	    weight = marble.weight;
	    dir = marble.dir;
	    num = marble.num;
	    
	    int nr = row + dr[dir]; 
		int nc = col + dc[dir];
		int ndir = dir;
		
		if(!InRange(nr, nc)) {
			nr = row;
			nc = col;
			ndir = 3-dir;
		}
		
	    return new Marble(nr, nc, weight, ndir, num);
	}
		
	static void MoveAll() {
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				for(int i = 0; i < grid[r][c].size(); i++) {
					Marble moved_marble = Move(grid[r][c].get(i));
					int next_r = moved_marble.row;
					int next_c = moved_marble.col;
					next_grid[next_r][next_c].add(moved_marble);
				}
			}
		}
	}
	
	static void MergeMarbles() {
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				if(next_grid[r][c].size() >= 2) {
					int nr = r;
					int nc = c;
					int nweight = 0;
					int ndir = -2;
					int nnum = -1;
					/*
					grid 가지고 노는건 끝났어!!! next_grid 가지고 해야해!!
					*/
					for(int i = 0; i < next_grid[r][c].size(); i++) {
						nweight += next_grid[r][c].get(i).weight;
						if(nnum < next_grid[r][c].get(i).num) {
							nnum = next_grid[r][c].get(i).num;
							ndir = next_grid[r][c].get(i).dir;
						}
					}
					next_grid[r][c] = new ArrayList<>();
					next_grid[r][c].add(new Marble(nr, nc, nweight, ndir, nnum));
				}
			}
		}
	}
	
	static void Simulate() {
		/**
    	next_grid[i][j].clear(); 하니까 밑에서 
    	grid[i][j] = next_grid[i][j]; 한거때문에
    	grid도 다 날라감... 
    	꼭!!! new 로 초기화 해야함. 새로 선언. 
    	next_grid[i][j] = new ArrayList<>();
		*/
	    // Step1. next_grid를 초기화합니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            next_grid[i][j] = new ArrayList<>();
			
	    // Step2. 구슬들을 전부 움직입니다.
	    MoveAll();
	    
	    // Step3. 움직인 구슬들 합치기
	    MergeMarbles();
	    
	    // Step4. next_grid 값을 grid로 옮겨줍니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            grid[i][j] = next_grid[i][j];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dir_mapper['U'] = 0;
		dir_mapper['R'] = 1;
		dir_mapper['L'] = 2;
		dir_mapper['D'] = 3;
		
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		
		next_grid = new ArrayList[n][n];
		grid = new ArrayList[n][n];
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				grid[r][c] = new ArrayList<>();
			}
		}
		
		for(int i = 1; i <= m; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			char d = sc.next().charAt(0);
			int w = sc.nextInt();
	        
			grid[r - 1][c - 1].add(new Marble(r-1, c-1, w, dir_mapper[d], i+1));
		}
		
		// t초에 걸쳐 시뮬레이션을 반복합니다.
		while(t-- > 0)
			Simulate();
		
		//여전히 남아있는 구슬의 수
		//가장 무거운 구슬의 무게
		int ans = 0;
		int max_weight = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j].size() == 1) {
					ans++;
					//어차피 구슬은 하나로 합쳐지니깐... 인덱스 0 번쓰면 구슬 한개 가져올 수 있음
					max_weight = Math.max(max_weight, grid[i][j].get(0).weight);
				}
			}
		}
		
		System.out.println(ans + " " + max_weight);
		sc.close();
	}
}









































































