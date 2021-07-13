package type_simulation_4_격자안에서단일객체를이동;

import java.util.Scanner;

public class _7_핀볼게임_chk_프린트로디버깅찍어보기 {
	
	//
	static final int[] dr = {0, +1, 0, -1};
	static final int[] dc = {+1, 0, -1, 0};
	
	static int n, dir;
	static int[][] grid, tmp;
	
	static boolean InRange(int r, int c) {
		return 0<=r && r<n && 0<=c && c<n;
	}
	
	static int NextDir(int dir, int type) {
		int next_dir = -1;
		if(type == 1) { // 1 은 /
			if(dir == 0) {
				next_dir = 3; 
			}else if(dir == 1) {
				next_dir = 2;
			}else if(dir == 2) {
				next_dir = 1;
			}else if(dir == 3) {
				next_dir = 0;
			}
		} else if(type ==2) { // 2는 \
			if(dir == 0) { 
				next_dir = 1; 
			}else if(dir == 1) {
				next_dir = 0;
			}else if(dir == 2) {
				next_dir = 3;
			}else if(dir == 3) {
				next_dir = 2;
			}
		}
		return next_dir;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid = new int[n][n];
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				grid[r][c] = sc.nextInt();
			}
		}
		
		//int cnt;
		int ans = Integer.MIN_VALUE;
		for(int d=0; d<4; d++) {
			for(int st = 0; st<n; st++) {
				//임시로 초기화
				int cur_row = -1;
				int cur_col = -1;
				int cur_dir = d;
				if(d == 0) {
					cur_row = st;
					cur_col = -1;
				}else if(d == 1) {
					cur_row = -1;
					cur_col = st;
				}else if(d == 2) {
					cur_row = st;
					cur_col = n;
				}else if(d == 3) {
					cur_row = n;
					cur_col = st;
				}
				
				tmp = new int[n][n];
				for(int r=0; r<n; r++) {
					for(int c=0; c<n; c++) {
						tmp[r][c] = grid[r][c];
					}
				}
				
				int cnt = 0;
				boolean out = false;
				do{
					int next_row = cur_row + dr[cur_dir];
					int next_col = cur_col + dc[cur_dir];
					
					if(InRange(next_row, next_col)) {
						if(grid[next_row][next_col] == 0) {
							cnt++;
							cur_row = next_row;
							cur_col = next_col;
							tmp[cur_row][cur_col] = 3;
						} else {
							cnt++;
							cur_row = next_row;
							cur_col = next_col;
							int type = grid[next_row][next_col];
							int next_dir = NextDir(cur_dir, type);
							cur_dir = next_dir;
							tmp[cur_row][cur_col] = type;
						}
					} else {
						cnt++;
						out = true;
					}
				}while(!out);
				
				ans = Math.max(ans, cnt);
				
				System.out.println("d : " + d + " / st : " + st);
				System.out.println("cnt : " + cnt + " / ans : " + ans);
				for(int r=0; r<n; r++) {
					for(int c=0; c<n; c++) {
						System.out.print(tmp[r][c] + " ");
					}
					System.out.println();
				}
				System.out.println("===================");
				
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
}









































































