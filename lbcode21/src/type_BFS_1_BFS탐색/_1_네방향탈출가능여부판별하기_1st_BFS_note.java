package type_BFS_1_BFS탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1_네방향탈출가능여부판별하기_1st_BFS_note {
	
	static class Pair{
		int row;
		int col;
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
	//static Queue<Pair > q = new LinkedList<>();
	static Queue<Pair > q;
	static boolean[][] visited;
	
	static boolean InRange(int x, int y) {
	    return 0 <= x && x < n && 0 <= y && y < m;
	}
	
	static boolean CanGo(int x, int y) {
	    return InRange(x, y) && a[x][y] > 0 && !visited[x][y];
	}
	
	static void BFS() {
	    // queue에 남은 것이 없을때까지 반복합니다.
	    while(!q.isEmpty()) {
	        // queue에서 가장 먼저 들어온 원소를 뺍니다.
	        Pair curr_pos = q.peek();
	        int x = curr_pos.row;
    		int y = curr_pos.col;
	        q.poll();

	        int[] dx = {1, -1, 0, 0};
	        int[] dy = {0, 0, 1, -1};

	        // queue에서 뺀 원소의 위치를 기준으로 4방향을 확인해봅니다.
	        for(int dir = 0; dir < 4; dir++) {
	            int nx = x + dx[dir], ny = y + dy[dir];

	            // 아직 방문한 적이 없으면서 갈 수 있는 곳이라면
	            // 새로 queue에 넣어주고 방문 여부를 표시해줍니다. 
	            if(CanGo(nx, ny)){
	                q.offer(new Pair(nx, ny));
	                visited[nx][ny] = true;
	            }
	        }
	    }

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int a[MAX_N][MAX_M];
		//bool visited[MAX_N][MAX_M];
	    // 입력:
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n][m];
		visited = new boolean[n][m];
		
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++)
	        	a[i][j] = sc.nextInt();
		
	    // bfs를 이용해 최소 이동 횟수를 구합니다.
	    // 시작점을 queue에 넣고 시작합니다.
	    q = new LinkedList<>();
	    q.offer(new Pair(0, 0));
	    visited[0][0] = true;
	    
	    BFS();
	    
	    // 우측 하단을 방문한 적이 있는지 여부를 출력합니다.
	    System.out.println(visited[n - 1][m - 1] ? 1 : 0);
		sc.close();
	}
}

/*
해당 문제를 DFS로 풀 수는 없을까요?

이 문제의 경우 단순히 탈출 가능 여부를 판단하기 때문에 DFS를 사용해도 무방합니다. 하지만 문제가 탈출 가능한 최소 경로를 구하라는 문제로 가볍게 바뀌기만 해도 BFS가 훨씬 더 효율적으로 탐색을 할 수 있습니다. 따라서 DFS와 BFS 모두 잘 학습이 되어있어야 합니다. * 
 * 
 */








































































