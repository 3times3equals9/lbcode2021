package _lb_mark;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1_최소경로로탈출하기_2st_BFS_main {
	
	static class Pair{
		public int row;
		public int col;
		public Pair(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	static final int MAX_N = 100;
	static final int MAX_M = 100;
	
	// 전역 변수 선언:
	static int n, m;
	static int[][] a;
    // bfs에 필요한 변수들 입니다.
    static Queue<Pair> q = new LinkedList<>();
    static boolean[][] visited;
    static int[][] step;
    // step[i][j] : 시작점으로부터 
    // (i, j) 지점에 도달하기 위한 
    // 최단거리를 기록합니다.
    
    static int ans = Integer.MAX_VALUE;

    static boolean InRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    
	// 격자를 벗어나지 않으면서, 뱀도 없고, 아직 방문한 적이 없는 곳이라면
	// 지금 이동하는 것이 최단거리임을 보장할 수 있으므로 가야만 합니다.
	static boolean CanGo(int x, int y) {
		return InRange(x, y) && a[x][y] > 0 && !visited[x][y];
	}
 
	// queue에 새로운 위치를 추가하고
	// 방문 여부를 표시해줍니다.
	// 시작점으로 부터의 최단거리 값도 갱신해줍니다.
	static void Push(int nx, int ny, int new_step) {
	    q.offer(new Pair(nx, ny));
	    visited[nx][ny] = true;
	    step[nx][ny] = new_step;
	}

	// bfs를 통해 최소 이동 횟수를 구합니다.
	static void FindMin() {
	    // queue에 남은 것이 없을때까지 반복합니다.
	    while(!q.isEmpty()) {
	        // queue에서 가장 먼저 들어온 원소를 뺍니다.
	    	Pair curr_pos = q.peek();
	        int x = curr_pos.row, y = curr_pos.col;
	        q.poll();

	        int[] dx = {1, -1, 0, 0};
	        int[] dy = {0, 0, 1, -1};

	        // queue에서 뺀 원소의 위치를 기준으로 4방향을 확인해봅니다.
	        for(int dir = 0; dir < 4; dir++) {
	            int nx = x + dx[dir], ny = y + dy[dir];

	            // 아직 방문한 적이 없으면서 갈 수 있는 곳이라면
	            // 새로 queue에 넣어줍니다.
	            if(CanGo(nx, ny))
	                // 최단 거리는 이전 최단거리에 1이 증가하게 됩니다. 
	                Push(nx, ny, step[x][y] + 1);
	        }
	    }

	    // 우측 하단에 가는 것이 가능할때만
	    // 답을 갱신해줍니다.
	    if(visited[n - 1][m - 1])
	        ans = step[n - 1][m - 1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    // 입력:
		n = sc.nextInt();
		m = sc.nextInt();
		//int a[MAX_N][MAX_M];
		//bool visited[MAX_N][MAX_M];
		//int step[MAX_N][MAX_M];
		a = new int[n][m];
		visited = new boolean[n][m];
		step = new int[n][m];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				a[i][j] = sc.nextInt();
	    // bfs를 이용해 최소 이동 횟수를 구합니다.
	    // 시작점을 queue에 넣고 시작합니다.
	    Push(0, 0, 0);
	    FindMin();
	    
	    // 출력:
	    if(ans == Integer.MAX_VALUE) {  // 불가능한 경우라면 // -1을 답으로 넣어줍니다.
	    	ans = -1;
	    }
	    System.out.println(ans);
		sc.close();
	}
}









































































