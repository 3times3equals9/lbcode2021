package type_BFS_1_BFS탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2_갈수있는곳들_1st_시작점이여러개인BFS {
	
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
	static final int DIR_NUM = 4;	
	
	// 전역 변수 선언:
	static int n, k;
	static int[][] grid;
	// bfs에 필요한 변수들 입니다.
	//static Queue<Pair > bfs_q = new LinkedList<>();
	static Queue<Pair > bfs_q;
	static boolean[][] visited;
	
	static boolean InRange(int x, int y) {
	    return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	static boolean CanGo(int x, int y) {
	    return InRange(x, y) && grid[x][y] == 0 && !visited[x][y];
	}
	
	static void BFS() {
	    // queue에 남은 것이 없을때까지 반복합니다.
	    while(!bfs_q.isEmpty()) {
	        // queue에서 가장 먼저 들어온 원소를 뺍니다.
	        Pair curr_pos = bfs_q.peek();
	        int x = curr_pos.row;
    		int y = curr_pos.col;
    		bfs_q.poll();

	        int[] dx = {1, -1, 0, 0};
	        int[] dy = {0, 0, 1, -1};

	        // queue에서 뺀 원소의 위치를 기준으로 4방향을 확인해봅니다.
	        for(int dir = 0; dir < 4; dir++) {
	            int nx = x + dx[dir], ny = y + dy[dir];

	            // 아직 방문한 적이 없으면서 갈 수 있는 곳이라면
	            // 새로 queue에 넣어주고 방문 여부를 표시해줍니다. 
	            if(CanGo(nx, ny)){
	            	bfs_q.offer(new Pair(nx, ny));
	                visited[nx][ny] = true;
	            }
	        }
	    }

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int grid[MAX_N][MAX_N];
		//bool visited[MAX_N][MAX_N];
	    // 입력:
		n = sc.nextInt();
		k = sc.nextInt();
		grid = new int[n][n];
		visited = new boolean[n][n];
		
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	        	grid[i][j] = sc.nextInt();
		
	    bfs_q = new LinkedList<>();
	    // 시작점을 모두 bfs queue에 넣습니다.
	    while(k-- > 0) {
	        int x, y;
	        x = sc.nextInt();
	        y = sc.nextInt();
	        bfs_q.offer(new Pair(x - 1, y - 1));
	        visited[x - 1][y - 1] = true;
	    }
	    
	    // bfs를 진행합니다
	    BFS();
	    
	    int ans = 0;
	    
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            if(visited[i][j])
	                ans++;
	    
	    System.out.println(ans);
		sc.close();
	}
}

/**

Intuition
시작점이 여러 개인 경우의 bfs 탐색의 경우 처음 queue에 모든 시작점을 집어 넣고 시작하는 것으로 간단히 해결할 수 있습니다.

Algorithm
그래프 탐색 방법에는 크게 dfs, bfs 이렇게 2가지가 있습니다. 2가지 탐색 방법 모두 시작점으로부터 도달 가능한 정점들을 탐색하는 역할을 합니다.

하지만 시작점이 여러 개인 경우라면 두 방법의 차이가 조금은 나타납니다. dfs의 경우에는 특정 위치 한 곳을 기준으로 진행을 하기 때문에, 각 시작점에 대해 각각 탐색을 진행해야만 합니다. 그와는 다르게 bfs의 경우에는 queue라는 자료구조를 이용해 현재 방문한 위치를 여러 곳 담을 수 있기 때문에, 시작점이 여러 개인 경우에는 초기 queue에 시작점들을 전부 집어 넣고 시작하는 것으로 깔끔하게 여러 시작점으로 부터 도달 가능한 위치를 구해줄 수 있습니다.

시작점이 여러 개더라도 마찬가지로 각 칸에 방문은 최대 1번씩 일어나게 되므로, 시간복잡도는 O(N^2)입니다. 

*/







































































