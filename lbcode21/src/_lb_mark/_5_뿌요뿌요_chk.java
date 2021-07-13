package _lb_mark;

import java.util.Scanner;

public class _5_뿌요뿌요_chk {
	
	static final int DIR_NUM = 4;	
	static final int BOMB_NUM = 4;	
	
	static int n;
	static int[][] grid;
	static boolean[][] visited;
	
	static int total_bomb_cnt;
	static int[] curr_bomb = new int[1];
	static int max = Integer.MIN_VALUE;
	
	// 탐색하는 위치가 격자 범위 내에 있는지 여부를 반환합니다.
	static boolean InRange(int x, int y) {
	    return x >= 0 && x < n && y >= 0 && y < n;
	}

//	// 탐색하는 위치로 움직일 수 있는지 여부를 반환합니다.
//	static boolean CanGo(int x, int y, int k) {
//	    if(!InRange(x, y)) 
//	        return false;
//
//	    if(visited[x][y] || grid[x][y] != k)
//	        return false;
//
//	    return true;
//	}
//	
	// 탐색하는 위치로 움직일 수 있는지 여부를 반환합니다.
	static boolean CanGo(int x, int y, int k) {
	    return InRange(x, y) && !visited[x][y] && grid[x][y] == k;
	}
	
	static void DFS(int x, int y, int curr_num, int[] bomb) {
	    //0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
	    int[] dx = {0, 1, 0, -1};
	    int[] dy = {1, 0, -1, 0};

	    // 네 방향에 각각에 대하여 DFS 탐색을 합니다.
	    for(int dir = 0; dir < DIR_NUM; dir++) {
	        int new_x = x + dx[dir];
	        int new_y = y + dy[dir];

	        if(CanGo(new_x, new_y, curr_num)){
	            visited[new_x][new_y] = true;
	            bomb[0]++;
	            DFS(new_x, new_y, curr_num, bomb);
	        }
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		visited = new boolean[n][n];
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				grid[r][c] = sc.nextInt();
			}
		}
		
		total_bomb_cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					
					curr_bomb[0] = 1;
					int cur = grid[i][j];
					visited[i][j] = true;
					DFS(i, j, cur, curr_bomb);
					
					max = Math.max(max, curr_bomb[0]);
					
					if(curr_bomb[0] >= 4) {
						total_bomb_cnt++;
					}
				}
			}
		}
		
		System.out.println(total_bomb_cnt + " " + max);
		sc.close();
	}
}









































































