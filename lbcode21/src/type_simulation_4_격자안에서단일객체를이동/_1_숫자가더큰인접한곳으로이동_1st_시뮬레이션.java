package type_simulation_4_격자안에서단일객체를이동;

import java.util.ArrayList;
import java.util.Scanner;

public class _1_숫자가더큰인접한곳으로이동_1st_시뮬레이션 {
	
	//static final int MAX_N = 100;
	static final int DIR_NUM = 4;
	// 전역 변수 선언:
	static int n;
	static int curr_x, curr_y; // 현재 위치를 의미합니다.
	static int[][] a; //int a[MAX_N + 1][MAX_N + 1];
	
	// 방문하게 되는 숫자들을 담을 곳입니다.
	/** 아직 크기는 모르는데, 순서대로 조회해야하는 자료! ArrayList */
	static ArrayList<Integer> visited_nums = new ArrayList<>();
	
	// 범위가 격자 안에 들어가는지 확인합니다.
	static boolean InRange(int x, int y) {
	    return 1 <= x && x <= n && 1 <= y && y <= n;
	}
	
	// 범위가 격자 안이고, 해당 위치의 값이 더 큰지 확인합니다.
	static boolean CanGo(int x, int y, int curr_num) {
	    return InRange(x, y) && a[x][y] > curr_num;
	}
	
	// 조건에 맞춰 움직여봅니다.
	// 움직였다면 true를 반환하고
	// 만약 움직일 수 있는 곳이 없었다면 false를 반환합니다.
	static boolean Simulate() {
	    // 코딩의 간결함을 위해 
	    // 문제 조건에 맞게 상하좌우 순서로
	    // 방향을 정의합니다.
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};

	    // 각각의 방향에 대해 나아갈 수 있는 곳이 있는지 확인합니다.
	    for(int i = 0; i < DIR_NUM; i++) {
	        int next_x = curr_x + dx[i];
	        int next_y = curr_y + dy[i];
	        
	        // 갈 수 있는 곳이라면
	        // 이동하고 true를 반환합니다.
	        if(CanGo(next_x, next_y, a[curr_x][curr_y])) {
	            curr_x = next_x;
	            curr_y = next_y;
	            return true;
	        }
	    }
	    
	    // 움직일 수 있는 곳이 없었다는 의미로
	    // false 값을 반환합니다.
	    return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력:
		n = sc.nextInt();
		curr_x = sc.nextInt();
		curr_y = sc.nextInt();
		//int a[MAX_N + 1][MAX_N + 1];
		a = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++)
	        for(int j = 1; j <= n; j++)
	        	a[i][j] = sc.nextInt();
		
		// 초기 위치에 적혀있는 값을 답에 넣어줍니다.
		visited_nums.add(a[curr_x][curr_y]);
		
		while(true) {
	        // 조건에 맞춰 움직여봅니다.
	        boolean greater_number_exist = Simulate();
	        
	        // 인접한 곳에 더 큰 숫자가 없다면 종료합니다.
	        if(!greater_number_exist)
	            break;
	        
	        // 움직이고 난 후의 위치를 답에 넣어줍니다.
	        visited_nums.add(a[curr_x][curr_y]);
	    }
		
		// 출력:
	    for(int i = 0; i < (int) visited_nums.size(); i++)
	    	System.out.print(visited_nums.get(i) + " ");
	    
		sc.close();
	}
}









































































