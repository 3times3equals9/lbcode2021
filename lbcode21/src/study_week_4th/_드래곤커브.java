package study_week_4th;

import java.util.Scanner;

public class _드래곤커브 {
	static final int[] dx = {0,-1,0,+1};
	static final int[] dy = {+1,0,-1,0};
	
	static int N;
	static boolean[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new boolean[101][101];
		
		N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int dir = sc.nextInt();
			int gen = sc.nextInt();
			
			map[sx][sy] = true;
			
			int limit = 1;
			for(int k=0; k<gen; k++) {
				limit *= 2;
			}
			int[] dir_arr = new int[limit];
			dir_arr[0] = dir;
			
			limit = 1;
			for(int k=0; k<gen; k++) {
				limit *= 2;
				for(int r=(limit/2); r<limit; r++) {
					dir_arr[r] = (dir_arr[limit-r-1] + 1) % 4;
				}
			}
			
			int nx = sx;
			int ny = sy;
			for(int k=0; k<limit; k++) {
				nx = nx + dx[dir_arr[k]];
				ny = ny + dy[dir_arr[k]];
				map[nx][ny] = true;
			}
		}
		
		int count = 0;
		for (int y = 0; y <= 99; y++) {
			for (int x = 0; x <= 99; x++) {
				if (map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1]) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		sc.close();
	}

}

