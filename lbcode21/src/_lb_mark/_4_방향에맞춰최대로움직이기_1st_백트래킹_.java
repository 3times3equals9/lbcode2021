package _lb_mark;

import java.util.Scanner;

public class _4_방향에맞춰최대로움직이기_1st_백트래킹_ {
	
	static final int MAX_N = 4;
	static final int DIR_NUM = 8;
	
	static int n;
	static int[][] num, move_dir;
	static int ans;

	static boolean InRange(int x, int y) {
	    return 0 <= x && x < n && 0 <= y && y < n;
	}
	
	static boolean CanGo(int x, int y, int prev_num) {
	    return InRange(x, y) && num[x][y] > prev_num;
	}
	
	static void FindMax(int x, int y, int cnt) {
	    // 언제 끝날지 모르기 때문에
	    // 항상 최댓값을 갱신해줍니다.
		ans = Math.max(ans, cnt);
		
		int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
		int d = move_dir[x][y] - 1;
		
		for(int i = 0; i < n; i++) {
			int nx = x + dx[d] * i, ny = y + dy[d] * i;
			if(CanGo(nx, ny, num[x][y]))
				FindMax(nx, ny, cnt + 1);
		}
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int num[MAX_N][MAX_N], move_dir[MAX_N][MAX_N];
		n = sc.nextInt();
		num = new int[n][n];
		move_dir = new int[n][n];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				num[i][j] = sc.nextInt();
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				move_dir[i][j] = sc.nextInt();
		
		int r, c;
		r = sc.nextInt();
		c = sc.nextInt();
		
		FindMax(r - 1, c - 1, 0);
		System.out.println(ans);
		sc.close();
	}
}

/*
Intuition
특정 위치로부터 주어진 방향에 놓여있는 칸 중 어떤 칸으로 움직일 것인지를 선택하는 재귀함수를 작성합니다. 이때, 현재 숫자보다 큰 칸으로만 움직이면 총 탐색 시간을 줄일 수 있습니다.

Algorithm
Backtracking을 이용하면 어느 위치로 움직일지에 대해 모든 조합을 만들어볼 수 있습니다. 이 각각의 조합에 대해 진행을 해본 후 그 중 최대 움직임 횟수를 출력하면 됩니다.

다만, 언제 움직임이 끝날지 확실하게 정의하기가 어려운 문제이기 때문에 함수가 호출될 때마다 항상 최댓값을 갱신해주는 것이 좋습니다. 또, 그 다음 위치를 선택할 시 현재 숫자보다 큰 숫자로만 이동해야만 원하는 답을 구할 수 있습니다.

*/




































































