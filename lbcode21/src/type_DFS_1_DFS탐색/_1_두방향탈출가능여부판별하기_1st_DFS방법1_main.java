package type_DFS_1_DFS탐색;

import java.util.Scanner;

public class _1_두방향탈출가능여부판별하기_1st_DFS방법1_main {
	
	static final int MAX_NUM = 100;
	static final int DIR_NUM = 2;
	
	static int n, m;
	static int[][] grid;
	static boolean[][] visited;
	
	// 탐색하는 위치가 격자 범위 내에 있는지 여부를 반환합니다.
	static boolean InRange(int x, int y) {
	    return x >= 0 && x < n && y >= 0 && y < m;
	}

	// 탐색하는 위치로 움직일 수 있는지 여부를 반환합니다.
	static boolean CanGo(int x, int y) {
	    if(!InRange(x, y))
	        return false;

	    if(visited[x][y] || grid[x][y] == 0)
	        return false;

	    return true;
	}
	
	static void DFS(int x, int y) {
	    int[] dx = {0, 1};
	    int[] dy = {1, 0};

	    // 아래쪽과 오른쪽 각각에 대하여 DFS 탐색을 합니다.
	    for(int i = 0; i < DIR_NUM; i++) {
	        int new_x = x + dx[i];
	        int new_y = y + dy[i];
	        if(CanGo(new_x, new_y)) {
	            visited[new_x][new_y] = true;
	            DFS(new_x, new_y);
	        }
	    }
	    
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int grid[MAX_NUM][MAX_NUM];
//		bool visited[MAX_NUM][MAX_NUM];
		n = sc.nextInt();
		m = sc.nextInt();
		
		grid = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++)
	            grid[i][j] = sc.nextInt();
		
		visited[0][0] = true;
		DFS(0, 0);
		
		System.out.println(visited[n - 1][m - 1] ? 1 : 0);
		sc.close();
	}
}

/**
CanGo 함수에서 아래의 코드와 같이 조건문을 확인하는 순서가 바뀌면 어떨까요?

bool CanGo(int x, int y) {
    if(visited[x][y] || grid[x][y] == 0)
        return false;

    if(!InRange(x, y))
        return false;

    return true;
}
(x, y) 좌표가 범위 내에 있는지를 먼저 확인해주지 않으면 visited 배열이나 grid 배열을 접근할 때 out-of-range 에러가 발생할 수 있습니다.

따라서 반드시 해당 좌표가 범위 내에 있는지를 먼저 확인해주도록 합니다.
*/





































































