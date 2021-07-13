package study_week_3rd;

import java.util.Scanner;

public class _디버깅 {
	
	static int N,M,H;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	static boolean ok;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		
		map = new int[H+2][N+1];
		
		for(int i=0; i<M; i++) {
			//이미 가로줄 조각 놓아진 경우.
			map[sc.nextInt()][sc.nextInt()] = 1;
		}
		
		for(int i=0; i<=3; i++) {
			max = i;
			solve(1,1,0);
			if(ok) {
				break;
			}
		}

		System.out.println(ok ? max : -1);
		sc.close();
	}

	private static void solve(int r, int c, int cnt) {
		if(ok) {
			return;
		}
		
		if(max == cnt) {
			if(check()) {
				ok = true;
			}
			return;
		}
		
		for(int i = (c<N ? r: r+1); i<=H; i++) {
			for(int j=1; j<N; j++) {
				if(map[i][j] == 1 || map[i][j-1] == 1 || map[i][j+1] == 1) {
					continue;
				}
				map[i][j] = 1;
				solve(i,j,cnt+1);
				map[i][j] = 0;
			}
		}
	}
	
	private static boolean check() {
		for(int j=1; j<=N; j++) {
			int i=1;
			int temp = j;//도착점.
			// 진짜 사다리 타듯 내려가봄.
			while(i<=H+1) {
				if(map[i][temp] == 1) {
					temp++;
				}else if(map[i][temp-1] == 1) {
					temp--;
				}
				i++;
			}
			if(j != temp) {
				return false;
			}
		}
		return true;
	}
	
}
