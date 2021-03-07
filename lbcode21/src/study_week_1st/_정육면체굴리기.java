package study_week_1st;

import java.util.Scanner;

public class _정육면체굴리기 {
	
	static class Dice{
		public int top;
		public int down;
		public int left;
		public int right;
		public int front;
		public int back;
		public Dice(int top, int down, int left, int right, int front, int back) {
			super();
			this.top = top;
			this.down = down;
			this.left = left;
			this.right = right;
			this.front = front;
			this.back = back;
		}
		public void roll(int dir) {
			//1동, 2서, 3북, 4남
			if(dir == 1) {
				int tmp = this.right;
				this.right = this.top;
				this.top = this.left;
				this.left = this.down;
				this.down = tmp;
			} else if(dir == 2) {
				int tmp = this.left;
				this.left = this.top;
				this.top = this.right;
				this.right = this.down;
				this.down = tmp;
			}else if ( dir == 3) {
				int tmp = this.back;
				this.back = this.top;
				this.top = this.front;
				this.front = this.down;
				this.down = tmp;
			}else if ( dir == 4) {
				int tmp = this.front;
				this.front = this.top;
				this.top = this.back;
				this.back = this.down;
				this.down = tmp;
			}
		}
	}
	
	static int n, m, str, stc, k;
	static int[][] map;
	static int[] arr;
	static final int[] dr = {0,0,0,-1,+1};
	static final int[] dc = {0,+1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		str = sc.nextInt();
		stc = sc.nextInt(); 
		k = sc.nextInt();
		
		map = new int[n][m];
		arr = new int[k];
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		for(int i=0; i<k; i++) {
			arr[i] = sc.nextInt();
		}

		Dice dice = new Dice(0, 0, 0, 0, 0, 0);
		
		int cr = str;
		int cc = stc;
		
		for(int i=0; i<k; i++) {
			int dd = arr[i];
			int nr = cr + dr[dd];
			int nc = cc + dc[dd];
			
			if(nr<0 || n<=nr || nc<0 || m<=nc) {
				//아무것도 하지 않습니다
			} else {
				dice.roll(dd);
				if(map[nr][nc] == 0) {
					map[nr][nc] = dice.down;
				}else {
					dice.down = map[nr][nc];
					map[nr][nc] = 0;
				}
				System.out.println(dice.top);
				
				cr = nr;
				cc = nc;
			}
		}
		
		sc.close();	
	}
}
































