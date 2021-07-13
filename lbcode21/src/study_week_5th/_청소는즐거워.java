package study_week_5th;

import java.util.Scanner;

public class _청소는즐거워 {

	static int[] dr = {0,+1,0,-1};
	static int[] dc = {-1,0,+1,0};
	
	static int dir, row, col, ans;
	static int count, limit;
	
	static int n, map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		limit = 1;
		dir = 0;
		
		n = sc.nextInt();
		map = new int[n+4][n+4];
		row = (n+4)/2;
		col = (n+4)/2;
		
		for(int r=2; r<2+n; r++) {
			for(int c=2; c<2+n; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		LABEL : while(true) {

			for(int k=0; k<limit; k++) {
				row = row+dr[dir];
				col = col+dc[dir];
				pour_sand();
				if(row == 2 && col == 2) {
					break LABEL;
				}
			}
			switch_dir();
			
		}
		
		ans = 0;
		calc_ans();
		System.out.println(ans);
		
		sc.close();
	}
	
	public static void switch_dir() {
		dir = (dir+1+4)%4;
		if(dir == 2 || dir == 0) {
			limit++;
		}
	}
	
	public static void pour_sand() {
		int total_sand = map[row][col];
		if(total_sand == 0) {
			return;
		}
		map[row][col]=0;
		
		map[row + 2*dr[dir]][col + 2*dc[dir]] 
				= map[row + 2*dr[dir]][col + 2*dc[dir]] + (total_sand * 5 /100);
		
		int nd_right = (dir-1+4) % 4;
		int nd_left = (dir+1+4) % 4;
		
		map[row + dr[dir] + dr[nd_right]][col + dc[dir] + dc[nd_right]] = 
				map[row + dr[dir] + dr[nd_right]][col + dc[dir] + dc[nd_right]] + (total_sand * 10 / 100);
	
		map[row + dr[dir] + dr[nd_left]][col + dc[dir] + dc[nd_left]] = 
				map[row + dr[dir] + dr[nd_left]][col + dc[dir] + dc[nd_left]] + (total_sand * 10 / 100);
		
		map[row + dr[nd_right]][col + dc[nd_right]] = 
				map[row + dr[nd_right]][col + dc[nd_right]] + (total_sand * 7 / 100);
	
		map[row + dr[nd_left]][col + dc[nd_left]] = 
				map[row + dr[nd_left]][col + dc[nd_left]] + (total_sand * 7 / 100);
		
		map[row + 2*dr[nd_right]][col + 2*dc[nd_right]] = 
				map[row + 2*dr[nd_right]][col + 2*dc[nd_right]] + (total_sand * 2 / 100);
		
//		System.out.println("dir : " + dir);
//		System.out.println("row : " + row + ", " + "col : " + col);
//		System.out.println("nd_right : " + nd_right + ", " + "nd_left : " + nd_left);
//		System.out.println("nr : " + (row + 2*dr[nd_right]) + ", " + "nc : " + (col + 2*dc[nd_right]));
//		System.out.println();
	
		map[row + 2*dr[nd_left]][col + 2*dc[nd_left]] = 
				map[row + 2*dr[nd_left]][col + 2*dc[nd_left]] + (total_sand * 2 / 100);
		
		map[row - dr[dir] + dr[nd_right]][col - dc[dir] + dc[nd_right]] = 
				map[row - dr[dir] + dr[nd_right]][col - dc[dir] + dc[nd_right]] + (total_sand * 1 / 100);
	
		map[row - dr[dir] + dr[nd_left]][col - dc[dir] + dc[nd_left]] = 
				map[row - dr[dir] + dr[nd_left]][col - dc[dir] + dc[nd_left]] + (total_sand * 1 / 100);

		int remain = total_sand - (total_sand * 5 /100)
				- (total_sand * 10 / 100) - (total_sand * 10 / 100) 
				- (total_sand * 7 / 100) - (total_sand * 7 / 100)
				- (total_sand * 2 / 100) - (total_sand * 2 / 100)
				- (total_sand * 1 / 100) - (total_sand * 1 / 100);
		
		map[row + dr[dir]][col + dc[dir]] = map[row + dr[dir]][col + dc[dir]] + remain;
	}
	
	public static void calc_ans() {
		for(int r=0; r<n+4; r++) {
			for(int c=0; c<n+4; c++) {
				if((2<=r && r<=n+1) && (2<=c && c<=n+1)) {
					
				} else {
					ans = ans + map[r][c];
				}
			}
		}
	}
	
}
