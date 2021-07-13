package type_simulation_5_격자안에서여러객체를이동;

import java.util.ArrayList;
import java.util.Scanner;

public class _7_합쳐지는구슬들_1st_시뮬레이션 {
	
	static class Marble {
		public int num;
		public int weight;
		public int dir;

		public Marble(int num, int weight, int dir) {
			super();
			this.num = num;
			this.weight = weight;
			this.dir = dir;
		}
	}
	
	static class Cell {
		public int row;
		public int col;
		public int dir;
		public Cell(int row, int col, int dir) {
			super();
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
	}
	
	static final int MAX_N = 50;
	static final int ASCII_NUM = 128;
	static final int DIR_NUM = 4;
	static final Marble EMPTY = new Marble(0,0,0);
	
	static int n, m, t;
	static ArrayList<Marble>[][] grid;
	static ArrayList<Marble>[][] next_grid;
	
	static boolean InRange(int x, int y) {
	    return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	static Cell NextPos(int x, int y, int move_dir) {
		// 벽에 부딪힌 이후 방향을 쉽게 반대로 뒤집기 위해 dx, dy테크닉을 적용할 시
		// [0, 3], [1, 2]가 서로 반대 방향이 되도록 설정합니다.
		int[] dx = {-1, 0, 0, 1};
		int[] dy = {0, 1, -1, 0};
	    
	    int nx = x + dx[move_dir], ny = y + dy[move_dir];
	    if(!InRange(nx, ny))
	        move_dir = 3 - move_dir;
	    else {
	        x = nx; y = ny;
	    }
	    
	    return new Cell(x, y, move_dir);
	}
	
	// (x, y) 위치에 새로운 구슬이 들어왔을 때 갱신을 진행합니다.
	static void Update(int x, int y, Marble new_marble) {
	    // 기존 구슬 정보입니다.
	    int num, weight, move_dir;
	    //tie(num, weight, move_dir) = next_grid[x][y];
	    if(next_grid[x][y].size() > 0) {
		    num = next_grid[x][y].get(0).num;
		    weight = next_grid[x][y].get(0).weight;
		    move_dir = next_grid[x][y].get(0).dir;
	    } else {
	    	num = 0;
		    weight = 0;
		    move_dir = 0;
	    }
	    // 새롭게 들어온 구슬 정보입니다.
	    int new_num, new_weight, new_dir;
	    //tie(new_num, new_weight, new_dir) = new_marble;
	    new_num = new_marble.num;
	    new_weight = new_marble.weight;
	    new_dir = new_marble.dir;
	    
	    // 새로 들어온 구슬이 더 우선순위가 높다면
	    // 번호와 방향은 새로운 구슬을 따르게 됩니다.
	    if(new_num > num) {
	    	//next_grid[x][y] = make_tuple(new_num, weight + new_weight, new_dir);
	    	if(next_grid[x][y].size() > 0) {
	    		next_grid[x][y].set(0, new Marble(new_num, weight + new_weight, new_dir));
	    	}else {
	    		next_grid[x][y].add(new Marble(new_num, weight + new_weight, new_dir));
	    	}
	    }
	    // 기존 구슬의 우선순위가 더 높다면
	    // 무게만 더해집니다.
	    else {
	    	//next_grid[x][y] = make_tuple(num, weight + new_weight, move_dir);
	    	if(next_grid[x][y].size() > 0) {
	    		next_grid[x][y].set(0, new Marble(num, weight + new_weight, move_dir));
	    	}else {
	    		next_grid[x][y].add(new Marble(num, weight + new_weight, move_dir));
	    	}
	    }
	}
	
	static void Move(int x, int y) {
	    int num, weight, move_dir;
	    //tie(num, weight, move_dir) = grid[x][y];
	    num = grid[x][y].get(0).num;
	    weight = grid[x][y].get(0).weight;
	    move_dir = grid[x][y].get(0).dir;
	    
	    // Step1. 현재 구슬의 다음 위치와 방향을 구합니다.
	    int nx, ny, next_dir; 
	    //tie(nx, ny, next_dir) = NextPos(x, y, move_dir);
	    Cell next_pos = NextPos(x, y, move_dir);
	    nx = next_pos.row;
	    ny = next_pos.col;
	    next_dir = next_pos.dir;
	    
	    // Step2. 구슬을 옮겨줍니다.
	    Update(nx, ny, new Marble(num, weight, next_dir));
	}
	
	static void Simulate() {
	    // Step1. next_grid를 초기화합니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            next_grid[i][j] = new ArrayList<>();
	    
	    // Step2. 각 구슬들을 한 칸씩 움직여줍니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            if(grid[i][j].size() > 0)
	                Move(i, j);

	    // Step3. next_grid 값을 grid로 옮겨줍니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            grid[i][j] = next_grid[i][j];
	}
	
	static int GetMarbleNum() {
	    int cnt = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
	            if(grid[i][j].size() > 0)
	                cnt++;
	    
	    return cnt;
	}

	static int GetMaxWeight() {
	    int max_weight = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
	            if(grid[i][j].size() > 0) {
				    int weight;
				    //tie(ignore, weight, ignore) = grid[i][j];
				    weight = grid[i][j].get(0).weight;
				    max_weight = Math.max(max_weight, weight);
			    }

	    return max_weight;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		tuple<int, int, int> grid[MAX_N][MAX_N];
//		tuple<int, int, int> next_grid[MAX_N][MAX_N];
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		
		grid = new ArrayList[n][n];
		next_grid = new ArrayList[n][n];
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				grid[r][c] = new ArrayList<>();
				next_grid[r][c] = new ArrayList<>();
			}
		}
		
		int[] dir_mapper = new int[ASCII_NUM];
		dir_mapper['U'] = 0;
		dir_mapper['R'] = 1;
		dir_mapper['L'] = 2;
		dir_mapper['D'] = 3;
		
		for(int i = 0; i < m; i++) {
			//cin >> r >> c >> d >> w;
			int r = sc.nextInt();
			int c = sc.nextInt();
			char d = sc.next().charAt(0);
			int w = sc.nextInt();
			
			//grid[r - 1][c - 1] = new Marble(i + 1, w, dir_mapper[d]);
			grid[r - 1][c - 1].add(new Marble(i + 1, w, dir_mapper[d]));
		}
		
		// t초에 걸쳐 시뮬레이션을 진행합니다.
		while(t-- > 0)
			Simulate();
		
	    int marble_num = GetMarbleNum();
	    int max_weight = GetMaxWeight();
	    
	    System.out.println(marble_num + " " + max_weight);
		sc.close();
	}
}

/*
Intuition
벽에 부딪힌 이후 방향을 쉽게 반대로 뒤집기 위해 dx, dy테크닉을 적용할 시 [0, 3], [1, 2]가 서로 반대 방향이 되도록 설정합니다. 
충돌에 대한 처리를 쉽게 하기 위해서는 격자로 구슬의 목록을 관리하는 것이 좋고, 시뮬레이션 진행시에는 구슬이 이동하기 전과 후를 깔끔하게 구분짓기 위해 새로운 2차원 배열을 만들어 관리하는 것이 좋습니다.

Algorithm
이 문제에서는 구슬 목록을 하나의 리스트로 관리하지 않고, n * n 격자를 이용하여 구슬을 관리하는 것이 구현상 더 편리합니다. 격자를 이용하여 관리하면, 충돌에 대한 처리를 쉽게 할 수 있습니다.

시뮬레이션을 진행할 때 이미 이동한 구슬과 이동하기 전의 구슬을 명확하게 구분하기 위해서는 새로운 n * n 격자를 만들어 그 이후의 결과를 저장한 뒤, 다시 결과를 옮겨주는 것이 좋습니다. 구슬이 이동하다 방향을 반대로 틀어야 할 때 숫자 3에서 현재 방향에 해당하는 값을 빼면 방향을 반대로 뒤집은 효과가 되게끔 dx, dy테크닉을 적용할 시 [0, 3], [1, 2]가 서로 반대 방향이 되도록 설정하는 것이 좋습니다.
*/




































































