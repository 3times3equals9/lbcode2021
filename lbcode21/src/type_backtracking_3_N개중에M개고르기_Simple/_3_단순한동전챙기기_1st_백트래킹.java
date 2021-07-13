package type_backtracking_3_N개중에M개고르기_Simple;

import java.util.ArrayList;
import java.util.Scanner;

public class _3_단순한동전챙기기_1st_백트래킹 {
	
	static class Pair{
		int row;
		int col;
		public Pair() {
			super();
		}
		
		public Pair(Pair p) {
			this.row = p.row;
			this.col = p.col;
		}

		public Pair(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	static final int MAX_N = 20;
	static final int COIN_NUM = 9;
	
	static int n;
	static int m = 3;
	
	static char[][] grid;

	static ArrayList<Pair> coin_pos = new ArrayList<>(); 
	static ArrayList<Pair> selected_pos = new ArrayList<>(); 
	
	static Pair start_pos = new Pair();
	static Pair end_pos = new Pair();
	
	static int ans = Integer.MAX_VALUE;
	
	static int Dist(Pair a, Pair b) {
	    int ax, ay;
	    //tie(ax, ay) = a;
	    ax = a.row;
	    ay = a.col;
	    
	    int bx, by;
	    //tie(bx, by) = b;
	    bx = b.row;
	    by = b.col;
	    
		return Math.abs(ax - bx) + Math.abs(ay - by);
	}

	static int Calc() {
	    int num_moves = Dist(start_pos, selected_pos.get(0));
	    for(int i = 0; i < m - 1; i++)
	        num_moves += Dist(selected_pos.get(i), selected_pos.get(i + 1));
	    num_moves += Dist(selected_pos.get(m - 1), end_pos);
	    
		return num_moves;
	}
	
	static void FindMinMoves(int curr_idx, int cnt) {
	    if(cnt == m) {
	        // 선택된 모든 조합에 대해 이동 횟수를 계산합니다.
	        ans = Math.min(ans, Calc());
	        return;
	    }

	    if(curr_idx == (int) coin_pos.size()) 
	        return;

	    // curr_idx index 에 있는 동전을 선택하지 않은 경우
	    FindMinMoves(curr_idx + 1, cnt);
	    
	    // curr_idx index 에 있는 동전을 선택한 경우
	    //selected_pos.add(new Pair(coin_pos.get(curr_idx)));
	    selected_pos.add(coin_pos.get(curr_idx));
	    FindMinMoves(curr_idx + 1, cnt + 1);
	    int tmp_len = selected_pos.size();
	    selected_pos.remove(tmp_len-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//char grid[MAX_N][MAX_N];
		n = sc.nextInt();
		grid = new char[n][n];
		
		//String tmp_str;
		for(int i = 0; i < n; i++) {
			String tmp_str = sc.next();
			for(int j = 0; j < n; j++) {
				grid[i][j] = tmp_str.charAt(j);
				if(grid[i][j] == 'S')
					start_pos = new Pair(i, j);
				if(grid[i][j] == 'E')
					end_pos = new Pair(i, j);
			}
		}
		
		// 동전을 오름차순으로 각 위치를 집어넣습니다.
	    // 이후에 증가하는 순서대로 방문하기 위함입니다.
	    for(int num = 1; num <= COIN_NUM; num++) 
	        for(int i = 0; i < n; i++)
			    for(int j = 0; j < n; j++)
	                if(grid[i][j] == num + '0')
	                    coin_pos.add(new Pair(i, j));
	   
	    FindMinMoves(0, 0);
	    
	    if(ans == Integer.MAX_VALUE)
			ans = -1;
	    
	    System.out.println(ans);
		sc.close();
	}
}









































































