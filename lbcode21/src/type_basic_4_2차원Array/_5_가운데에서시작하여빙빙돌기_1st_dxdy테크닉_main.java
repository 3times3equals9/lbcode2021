package type_basic_4_2차원Array;

import java.util.Scanner;

public class _5_가운데에서시작하여빙빙돌기_1st_dxdy테크닉_main {
	
	static final int DIR_NUM = 4;
	static final int MAX_N = 499;
	
	// 전역 변수 선언:
	static int n;

	static int curr_x, curr_y;
	static int move_dir, move_num;

	static int[][] grid = new int[MAX_N][MAX_N];
	
	static boolean InRange(int x, int y) {
	    return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	// 한 칸 움직입니다.
	static void Move() {
	    // 문제에서 원하는 진행 순서대로 
	    // 오른쪽 위 왼쪽 아래 방향이 되도록 정의합니다.
	    int[] dx = {0, -1, 0, 1};
	    int[] dy = {1, 0, -1, 0};

	    curr_x += dx[move_dir]; 
	    curr_y += dy[move_dir];
	}
	
	static boolean End() {
	    return !InRange(curr_x, curr_y);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력:
	    n = sc.nextInt();
		
	    // 시작 위치와 방향, 
	    // 해당 방향으로 이동할 횟수를 설정합니다. 
	    curr_x = n / 2; curr_y = n / 2;
	    move_dir = 0; move_num = 1;
	    
	    int cnt = 1;
	    
	    while(!End()) {
	        // move_num 만큼 이동합니다.
	        for(int i = 0; i < move_num; i++) {
	            grid[curr_x][curr_y] = cnt++;
	            Move();
	            
	            // 이동하는 도중 격자를 벗어나게 되면,
	            // 움직이는 것을 종료합니다.
	            if(End())
	                break;
	        }
	        
	        // 방향을 바꿉니다.
	        move_dir = (move_dir + 1) % 4;
	        // 만약 현재 방향이 왼쪽 혹은 오른쪽이 된 경우에는
	        // 특정 방향으로 움직여야 할 횟수를 1 증가시킵니다.
	        if(move_dir == 0 || move_dir == 2)
	            move_num++;
	    }
	    
	    // 출력:
	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < n; j++)
	        	System.out.print(grid[i][j] + " ");
        	System.out.println();
	    }
	    
		sc.close();
	}
}









































































