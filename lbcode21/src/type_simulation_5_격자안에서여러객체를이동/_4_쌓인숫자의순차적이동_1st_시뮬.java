package type_simulation_5_격자안에서여러객체를이동;

import java.util.ArrayList;
import java.util.Scanner;

public class _4_쌓인숫자의순차적이동_1st_시뮬 {
	
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
	static final Pair OUT_OF_GRID = new Pair(-1, -1);
	
	static int n, m;
	static ArrayList<Integer>[][] grid;
	
	static Pair GetPos(int num) {
		Pair res = new Pair();
		
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            for(int k = 0; k < grid[i][j].size(); k++)
	                if(grid[i][j].get(k) == num) {
	                	//return new Pair(i, j);
	                	res.row = i;
	                	res.col = j;
	                }
	    //자리만 차지하는거
	    return res;
	}
	
	static boolean InRange(int x, int y) {
	    return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	// 그 다음 위치를 찾아 반환합니다.
	static Pair NextPos(Pair pos) {
	    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	    
	    int x, y;
	    //tie(x, y) = pos;
	    x = pos.row;
	    y = pos.col;
	    
	    // 인접한 8개의 칸 중 가장 값이 큰 위치를 찾아 반환합니다.
	    int max_val = -1;
	    Pair max_pos = OUT_OF_GRID;
	    for(int i = 0; i < 8; i++) {
	        int nx = x + dx[i], ny = y + dy[i];
	        if(InRange(nx, ny)) {
	            for(int j = 0; j < (int) grid[nx][ny].size(); j++) {
	                if(grid[nx][ny].get(j) > max_val) {
	                    max_val = grid[nx][ny].get(j);
	                    max_pos = new Pair(nx, ny);
	                }
	            }
	        }
	    }
	    
	    return max_pos;
	}
	
	static void Move(Pair pos, Pair next_pos, int move_num) {
	    int x, y;
	    //tie(x, y) = pos;
	    x = pos.row;
	    y = pos.col;
	    
	    int nx, ny;
	    //tie(nx, ny) = next_pos;
	    nx = next_pos.row;
	    ny = next_pos.col;
	    
	    // Step1. (x, y) 위치에 있던 숫자들 중
	    // move_num 위에 있는 숫자들을 전부 옆 위치로 옮겨줍니다.
	    boolean to_move = false;
	    for(int i = 0; i < (int) grid[x][y].size(); i++) {
	        if(grid[x][y].get(i) == move_num)
	            to_move = true;
	        
	        if(to_move)
	            //grid[nx][ny].push_back(grid[x][y].get(i));
	        	grid[nx][ny].add(grid[x][y].get(i));
	    }
	    
	    // Step2. (x, y) 위치에 있던 숫자들 중
	    // 움직인 숫자들을 전부 비워줍니다.
	    int list_size = grid[x][y].size();
	    while(grid[x][y].get(list_size-1) != move_num) {
	        grid[x][y].remove(list_size-1);
	        list_size--;
	        
	    }
	    //grid[x][y].pop_back();
	    grid[x][y].remove(list_size-1);
	}
	
	static void Simulate(int move_num) {
	    // 그 다음으로 나아가야할 위치를 구해
	    // 해당 위치로 숫자들을 옮겨줍니다.
		Pair pos = GetPos(move_num);
		Pair next_pos = NextPos(pos);
	    if(next_pos != OUT_OF_GRID)
	        Move(pos, next_pos, move_num);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//vector<int> grid[MAX_N][MAX_N];
		n = sc.nextInt();
		m = sc.nextInt();
		
		grid = new ArrayList[n][n];
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				grid[r][c] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int num = sc.nextInt();
	            grid[i][j].add(num);
			}
		}
		
		// m번 시뮬레이션을 진행합니다.
		while(m-- > 0) {
			int move_num = sc.nextInt();
	        Simulate(move_num);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j].size() == 0)
					System.out.print("None");
				else {
					for(int k = grid[i][j].size() - 1; k >= 0; k--)
						System.out.print(grid[i][j].get(k) + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}









































































