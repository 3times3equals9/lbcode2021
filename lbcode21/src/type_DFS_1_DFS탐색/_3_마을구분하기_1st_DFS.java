package type_DFS_1_DFS탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _3_마을구분하기_1st_DFS {
	
	static final int MAX_NUM = 25;
	static final int DIR_NUM = 4;
	
	static int n;
	static int[][] grid;
	static boolean[][] visited;
	static ArrayList<Integer> people_nums = new ArrayList<>();
	static int people_num;
	
	// 탐색하는 위치가 격자 범위 내에 있는지 여부를 반환합니다.
	static boolean InRange(int x, int y) {
	    return x >= 0 && x < n && y >= 0 && y < n;
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
	    //0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
	    int[] dx = {0, 1, 0, -1};
	    int[] dy = {1, 0, -1, 0};

	    // 네 방향에 각각에 대하여 DFS 탐색을 합니다.
	    for(int dir = 0; dir < DIR_NUM; dir++) {
	        int new_x = x + dx[dir];
	        int new_y = y + dy[dir];

	        if(CanGo(new_x, new_y)){
	            visited[new_x][new_y] = true;
	            // 마을에 존재하는 사람을 한 명 추가해줍니다.
	            people_num++;
	            DFS(new_x, new_y);
	        }
	    }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int grid[MAX_NUM][MAX_NUM];
//		bool visited[MAX_NUM][MAX_NUM];
		n = sc.nextInt();
		grid = new int[n][n];
		visited = new boolean[n][n];
		
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < n; j++)
	            grid[i][j] = sc.nextInt();
		
	    // 격자의 각 위치에서 탐색을 시작할 수 있는 경우
	    // 한 마을에 대한 DFS 탐색을 수행합니다.
	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < n; j++) {
	            if(CanGo(i, j)) {
	                // 해당 위치를 방문할 수 있는 경우 visited 배열을 갱신하고
	                // 새로운 마을을 탐색한다는 의미로 people_num을 1으로 갱신합니다.
	                visited[i][j] = true;
	                people_num = 1;

	                DFS(i, j);

	                // 한 마을에 대한 탐색이 끝난 경우 마을 내의 사람 수를 저장합니다.
	                people_nums.add(people_num);
	            }
	        }
	    }
	    
	    // 각 마을 내 사람의 수를 오름차순으로 정렬합니다.
	    //sort(people_nums.begin(), people_nums.end());
	    Collections.sort(people_nums);
	    
	    System.out.println(people_nums.size());
	    
	    for(int i = 0; i < (int) people_nums.size(); i++)
	    	System.out.println(people_nums.get(i));
	    	
		sc.close();
	}
}









































































