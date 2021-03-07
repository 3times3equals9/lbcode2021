package study_week_1st;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
재귀문에서 시작위치 체크 안해줘서 틀리는거같음
그게 기준이 되어서 갯수 세고, 나중꺼 체크해야하는데
 */
public class _방화벽설치하기_제출용 {
	
	static class Cell{
		public int r;
		public int c;
		
		public Cell() {
		}

		public Cell(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int ROW, COL, SIZE;
	static int[][] map, copy;
	static boolean[][] firechk;
	static Cell[] walls;
	static Queue<Cell> fq;
	static int max;
	
	static final int[] dr = {-1,+1,0,0};
	static final int[] dc = {0,0,-1,+1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ROW = sc.nextInt();	
		COL = sc.nextInt();
		map = new int[ROW][COL];
		
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		walls = new Cell[3];
		for(int k=0; k<3; k++) {
			walls[k] = new Cell();
		}
		
		max = Integer.MIN_VALUE;
		SIZE = ROW * COL;
		
		for(int i=0; i<SIZE; i++) {
			int str = i / COL;
			int stc = i % COL;
			if(map[str][stc] == 0) {
				walls[0].r = str;
				walls[0].c = stc;
				select(1, i+1);
			}
		}
		
		System.out.println(max);
		
		sc.close();
	}
	
	public static void copymap() {
		copy = new int[ROW][COL];
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				copy[r][c] = map[r][c];
			}
		}
	}

	public static void select(int cnt, int idx) {
		if(cnt == 3) {
			//게임 실행
			copymap();
			for(int k=0; k<3; k++) {
				copy[walls[k].r][walls[k].c] = 1;
			}
			
//			System.out.println("cnt : " + cnt);
//			System.out.println("idx : " + idx);
//			for(int r=0; r<ROW; r++) {
//				for(int c=0; c<COL; c++) {
//					System.out.print(copy[r][c] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("=================");
			
			firechk = new boolean[ROW][COL];
			fq = new LinkedList<>();
			
			for(int r=0; r<ROW; r++) {
				for(int c=0; c<COL; c++) {
					if(copy[r][c] == 2) {
						fq.add(new Cell(r,c));
						firechk[r][c] = true;
					}
				}
			}
			
			while(!fq.isEmpty()) {
				Cell cur = fq.poll();
				for(int k=0; k<4; k++) {
					int nr = cur.r + dr[k];
					int nc = cur.c + dc[k];
					if(0<=nr && nr<ROW && 0<=nc && nc<COL) {
						if(copy[nr][nc] == 0 && !firechk[nr][nc]) {
							copy[nr][nc] = 2;
							firechk[nr][nc] = true;
							fq.add(new Cell(nr, nc));
						}
					}
				}
			}
			
			int notfired = 0;
			//불 안붙은 갯수 세기
			for(int r=0; r<ROW; r++) {
				for(int c=0; c<COL; c++) {
					if(copy[r][c] == 0) {
						notfired++;
					}
				}
			}
			
			if(max < notfired) {
				max = notfired;
			}
			
			return;
		}
		
		for(int k=idx; k<SIZE; k++) {
			int div = k / COL;
			int mod = k % COL;
			if(map[div][mod] == 0) {
				walls[cnt].r = div;
				walls[cnt].c = mod;
				select(cnt+1, k+1);
			} 
		}
		
	}
	
}























