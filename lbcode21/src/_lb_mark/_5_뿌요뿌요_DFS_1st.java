package _lb_mark;

import java.util.Scanner;

public class _5_뿌요뿌요_DFS_1st {
	
	static final int MAX_NUM = 100;	
	static final int DIR_NUM = 4;	
	
	static int n;
	static int[][] grid;
	static boolean[][] visited;
	
	static int max_block;
	static int bomb_cnt;
	static int curr_block_num;
	
	// 탐색하는 위치가 격자 범위 내에 있는지 여부를 반환합니다.
	static boolean InRange(int x, int y) {
	    return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	// 탐색하는 위치로 움직일 수 있는지 여부를 반환합니다.
	static boolean CanGo(int x, int y, int color) {
	    if(!InRange(x, y))
	        return false;

	    if(visited[x][y] || grid[x][y] != color)
	        return false;

	    return true;
	}
	
	static void DFS(int x, int y) {
	    //0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
	    int[] dx = {0, 1, 0, -1};
	    int[] dy = {1, 0, -1, 0};

	    // 네 방향에 각각에 대하여 DFS 탐색을 합니다.
	    for(int dir = 0; dir < DIR_NUM; dir++) {
	        int new_x = x + dx[dir];
	        int new_y = y + dy[dir];

	        if(CanGo(new_x, new_y, grid[x][y])){
	            visited[new_x][new_y] = true;
	            // 블럭이 하나 추가됩니다.
	            curr_block_num++;
	            DFS(new_x, new_y);
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
		
		// 격자의 각 위치에서 탐색을 시작할 수 있는 경우
	    // 한 블럭에 대한 DFS 탐색을 수행합니다.
	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < n; j++) {
	            if(!visited[i][j] && grid[i][j] > 0) {
	                // 해당 블럭을 방문할 수 있는 경우 visited 배열을 갱신하고
	                // 새로운 블럭을 탐색한다는 의미로 curr_block_num을 1으로 갱신합니다.
	                visited[i][j] = true;
	                curr_block_num = 1;
	                
	                DFS(i, j);

	                // 한 블럭 묶음에 대한 탐색이 끝난 경우 답을 갱신합니다.
	                if(curr_block_num >= 4)
	                    bomb_cnt++;
	                
	                max_block = Math.max(max_block, curr_block_num);
	            }
	        }
	    }
		
		System.out.println(bomb_cnt + " " + max_block);
		sc.close();
	}
}









































































