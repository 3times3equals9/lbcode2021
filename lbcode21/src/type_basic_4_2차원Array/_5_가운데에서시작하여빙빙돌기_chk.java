package type_basic_4_2차원Array;

import java.util.Scanner;

public class _5_가운데에서시작하여빙빙돌기_chk {
	
	static int n;
	static int[][] ans;
	
	static final int[] dr = {0, -1, 0, 1};
	static final int[] dc = {1, 0, -1, 0};
	
	static boolean canGo(int next_r, int next_c) {
		if(0 <= next_r && next_r < n && 0 <= next_c && next_c < n) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		ans = new int[n][n];
		
		int cur_r = n/2;
		int cur_c = n/2;
		ans[cur_r][cur_c] = 1;
		int cnt = 2;
		int limit = 1;
		int direction = 0;
		
		LABEL_1 : while(true) {
			for(int k = 0; k < limit; k++) {
				cur_r = cur_r + dr[direction];
				cur_c = cur_c + dc[direction];
				if(!canGo(cur_r, cur_c)) {
					break LABEL_1;
				}
				ans[cur_r][cur_c] = cnt;
				cnt++;
			}
			
			direction = (direction + 1) % 4;
			
			if(direction == 2 || direction == 0) {
				limit++;
			}
		}
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				System.out.print(ans[r][c] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}









































































