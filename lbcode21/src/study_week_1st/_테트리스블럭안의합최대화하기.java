package study_week_1st;

import java.util.Scanner;

public class _테트리스블럭안의합최대화하기 {

	static int ROW, COL, MAX;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dr = { -1, 0, +1, 0 };
	static int[] dc = { 0, +1, 0, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ROW = sc.nextInt();
		COL = sc.nextInt();
		arr = new int[ROW][COL];
		visit = new boolean[ROW][COL];
		
		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		MAX = 0;
		
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				dfs(r, c, 0, 0);
				if(r<=ROW-3) {
					int temp = arr[r][c]+ arr[r+1][c] + arr[r+2][c];
					if(c>=1) {//ㅓ
						int tBlock = temp + arr[r+1][c-1];
						if(tBlock > MAX) {
							MAX = tBlock;
						}
					}
					if(c<=COL-2) {//ㅏ
						int tBlock = temp + arr[r+1][c+1];
						if(tBlock > MAX) {
							MAX = tBlock;
						}
					}
				}
				if(c<=COL-3) {
					int temp = arr[r][c] + arr[r][c+1] + arr[r][c+2];
					if(r>=1) {//ㅗ
						int tBlock = temp + arr[r-1][c+1];
						if(tBlock > MAX) {
							MAX = tBlock;
						}
					}
					if(r<=ROW-2) {//ㅜ
						int tBlock = temp + arr[r+1][c+1];
						if(tBlock > MAX) {
							MAX = tBlock;
						}
					}
				}
			}
		}
		
		System.out.println(MAX);
		
	}

	static void dfs(int r, int c, int sum, int cnt) {
		//종료조건
		if (cnt == 4) {
			if (MAX < sum) {
				MAX = sum;
			}
			return;
		}
		
		//범위 체크하고, 이미 방문한건지 체크하고
		if(0<=r && r<ROW && 0<=c && c<COL && !visit[r][c]) {
			visit[r][c] = true;
			for(int i=0; i<4; i++) {
				dfs(r+dr[i],c+dc[i],sum+arr[r][c],cnt+1);
			}
			visit[r][c] = false;
		}
	}

}

