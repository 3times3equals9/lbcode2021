package study_week_2nd;

import java.util.Scanner;

public class _보도블럭 {

	static int N, L, ANS;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		ANS=0;
		
		boolean[] check;
		for(int r=0; r<N; r++) {
			 check = new boolean[N];
			 go_right(r,0,check);
		}
		for(int c=0; c<N; c++) {
			 check = new boolean[N];
			 go_down(0,c,check);
		}
		
		System.out.println(ANS);
		sc.close();
	}
	
	private static void go_right(int r, int c, boolean[] ch) {
		if(c == N-1) {
			ANS++;
			return;
		}
		if(c < N-1) {
			if(map[r][c] == map[r][c+1]) {
				go_right(r,c+1,ch);
			}else {
				int diff = map[r][c] - map[r][c+1];
				if(diff == 1 && (c+L <= N-1)) {
					//낮아지는길. 다음 칸 부터 오른쪽으로 경사 시작.
					int height = map[r][c]-1;
					for(int pc = c+1; pc<=c+L; pc++) {
						if(height == map[r][pc] && !ch[pc]) {
							ch[pc] = true;
						} else {
							return;
						}
					}
					go_right(r, c+L, ch);
						
				}else if(diff == -1 && (0 <= c-L+1)) {
					//높아지는길. 왼쪽에서부터 경사 시작해서, 현재칸까지 경사 생김.
					int height = map[r][c];
					for(int pc = c; pc > c-L; pc--) {
						if(height == map[r][pc] && !ch[pc]) {
							ch[pc] = true;
						} else {
							return;
						}
					}
					go_right(r, c+1, ch);
				}
			}
		}
	}
	
	private static void go_down(int r, int c, boolean[] ch) {
		if(r == N-1) {
			ANS++;
			return;
		}
		if(r < N-1) {
			if(map[r][c] == map[r+1][c]) {
				go_down(r+1,c,ch);
			}else {
				int diff = map[r][c] - map[r+1][c];
				if(diff == 1 && (r+L <= N-1)) {
					//낮아지는길. 다음 칸 부터 아래로 경사 시작.
					int height = map[r][c]-1;
					for(int pr = r+1; pr<=r+L; pr++) {
						if(height == map[pr][c] && !ch[pr]) {
							ch[pr] = true;
						} else {
							return;
						}
					}
					go_down(r+L, c, ch);
					
				}else if(diff == -1 && (0 <= r-L+1)) {
					//높아지는길. ㅇ위쪽에서부터 경사 시작, 현재칸까지 경사 생김.
					int height = map[r][c];
					for(int pr = r; pr > r-L; pr--) {
						if(height == map[pr][c] && !ch[pr]) {
							ch[pr] = true;
						} else {
							return;
						}
					}
					go_down(r+1, c, ch);
				}
			}
		}
	}

}
