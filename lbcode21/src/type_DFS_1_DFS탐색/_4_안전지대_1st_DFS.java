package type_DFS_1_DFS탐색;

import java.util.Scanner;

public class _4_안전지대_1st_DFS {
	
	static final int MAX_N = 50;
	static final int MAX_M = 50;
	static final int MAX_HEIGHT = 100;
	static final int DIR_NUM = 4;
	
	static int n, m;
	static int[][] grid;
	static boolean[][] visited;
	static int zone_num;
	
	// visited 배열을 초기화해줍니다.
	static void InitializeVisited() {
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++)
	            visited[i][j] = false;
	}
	
	// 탐색하는 위치가 격자 범위 내에 있는지 여부를 반환합니다.
	static boolean InRange(int x, int y) {
	    return x >= 0 && x < n && y >= 0 && y < m;
	}
	
	// 탐색하는 위치로 움직일 수 있는지 여부를 반환합니다.
	static boolean CanGo(int x, int y, int k) {
	    if(!InRange(x, y)) 
	        return false;

	    if(visited[x][y] || grid[x][y] <= k)
	        return false;

	    return true;
	}

	static void DFS(int x, int y, int k) {
	    //0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
	    int[] dx = {0, 1, 0, -1};
	    int[] dy = {1, 0, -1, 0};

	    // 네 방향에 각각에 대하여 DFS 탐색을 합니다.
	    for(int dir = 0; dir < DIR_NUM; dir++) {
	        int new_x = x + dx[dir];
	        int new_y = y + dy[dir];

	        if(CanGo(new_x, new_y, k)){
	            visited[new_x][new_y] = true;
	            DFS(new_x, new_y, k);
	        }
	    }
	}

	static void GetZoneNum(int k) {
	    // 새로운 탐색을 시작한다는 의미로 zone_num를 0으로 갱신하고 
	    // visited 배열을 초기화해줍니다.
	    zone_num = 0;
	    InitializeVisited();
	    
	    // 격자의 각 위치에 대하여 탐색을 시작할 수 있는 경우
	    // 해당 위치로부터 시작한 DFS 탐색을 수행합니다.
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++) {
	            if(CanGo(i, j, k)) {
	                // 해당 위치를 탐색할 수 있는 경우 visited 배열을 갱신하고
	                // 안전 영역을 하나 추가해줍니다.
	                visited[i][j] = true;
	                zone_num++;

	                DFS(i, j, k);
	            }
	        }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    // 가능한 안전 영역의 최솟값이 0이므로 다음과 같이 초기화 해줄 수 있습니다.
	    int max_zone_num = -1; 
	    int answer_k = 0;
		
//		int grid[MAX_N][MAX_M];
//		bool visited[MAX_N][MAX_M];
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new int[n][m];
		visited = new boolean[n][m];
		
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < m; j++)
	            grid[i][j] = sc.nextInt();
		
	    // 각 가능한 비의 높이에 대하여 안전 영역의 수를 탐색합니다.
	    for(int k = 1; k <= MAX_HEIGHT; k++){
	        GetZoneNum(k);

	        // 기존의 최대 영역의 수보다 클 경우 이를 갱신하고 인덱스를 저장합니다.
	        if(zone_num > max_zone_num) {
	            max_zone_num = zone_num;
	            answer_k = k;
	        }
	    }
	    
    	System.out.println(answer_k + " " + max_zone_num);
	    	
		sc.close();
	}
}









































































