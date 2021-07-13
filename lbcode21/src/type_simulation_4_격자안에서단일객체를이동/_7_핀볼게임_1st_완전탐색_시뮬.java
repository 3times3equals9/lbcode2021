package type_simulation_4_격자안에서단일객체를이동;

import java.util.Scanner;

public class _7_핀볼게임_1st_완전탐색_시뮬 {
	
	static final int MAX_N = 100;
	static final int DIR_NUM = 4;
	
	static int n;
	static int[][] grid;
	
	static boolean InRange(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	static int Calc(int x, int y, int move_dir) {	
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		// 1번 블럭에서는 방향이 다음과 같이 변합니다 : 0<->3 1<->2
		// 2번 블럭에서는 방향이 다음과 같이 변합니다 : 0<->2 1<->3
		
		int elapsed_time = 1;
		
		while(InRange(x, y)) {
			if(grid[x][y] == 1)
				move_dir = 3 - move_dir;
			else if(grid[x][y] == 2)
				move_dir = (move_dir < 2) ? (move_dir + 2) : (move_dir - 2);
			x += dx[move_dir]; y += dy[move_dir];
			elapsed_time++;
		}
		return elapsed_time;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		grid = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();
		
		// 각각의 상하좌우 방향에 대해
	    // 가능한 모든 위치에서 걸리는 시간을 계산한 후,
	    // 그 중 최댓값을 구합니다.
		int ans = 0;
		for(int i = 0; i < n; i++) {
			ans = Math.max(ans, Calc(n - 1, i, 0));
			ans = Math.max(ans, Calc(0, i, 1));
			ans = Math.max(ans, Calc(i, n - 1, 2));
			ans = Math.max(ans, Calc(i, 0, 3));
		}
		
		System.out.println(ans);
		sc.close();
	}
}









































































