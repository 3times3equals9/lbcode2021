package study_week_1st;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _방화벽설치하기_맨처음시도_틀린거복사 {
	
	static class Cell{
		int r;
		int c;
		
		public Cell() {
		}

		public Cell(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int ROW, COL;
	static int[][] map, copy;
	static boolean[][] visit, firechk;
	static Cell[] walls;
	static Queue<Cell> fires;
	static Queue<Cell> fq;
	static int max;
	
	static final int[] dr = {-1,+1,0,0};
	static final int[] dc = {0,0,-1,+1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ROW = sc.nextInt();	
		COL = sc.nextInt();
		map = new int[ROW][COL];
		fires = new LinkedList<>();
		
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 2) {
					fires.add(new Cell(r,c));
				}
			}
		}

		visit = new boolean[ROW][COL];
		walls = new Cell[3];
		for(int k=0; k<3; k++) {
			walls[k] = new Cell();
		}
		max = Integer.MIN_VALUE;
		
		select(0);
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

	public static void select(int cnt) {
		if(cnt == 3) {
			//게임 실행
			copymap();
			for(int k=0; k<3; k++) {
				copy[walls[k].r][walls[k].c] = 1;
			}
			
			firechk = new boolean[ROW][COL];
			fq = new LinkedList<>();
			
			while(!fires.isEmpty()) {
				Cell tmpfire = fires.poll();
				fq.add(new Cell(tmpfire.r, tmpfire.c));
				copy[tmpfire.r][tmpfire.c] = 2;
				firechk[tmpfire.r][tmpfire.c] = true;
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
			
//			for(int rr=0; rr<ROW; rr++) {
//				for(int cc=0; cc<COL; cc++) {
//					System.out.print(copy[rr][cc] + " ");
//				}
//				System.out.println();
//			}
////			System.out.println("r : " + r);
////			System.out.println("c : " + c);
//			System.out.println("cnt : " + (cnt+1));
//			System.out.println();
////			
////			System.out.println("ret");
			return;
		}
		
		//왜 여기로 오는거지
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				if(map[r][c] == 0 && !visit[r][c]) {
					
					copymap();
					for(int k=0; k<3; k++) {
						copy[walls[k].r][walls[k].c] = 1;
					}
					for(int rr=0; rr<ROW; rr++) {
						for(int cc=0; cc<COL; cc++) {
							System.out.print(copy[rr][cc] + " ");
						}
						System.out.println();
					}
//					System.out.println("r : " + r);
//					System.out.println("c : " + c);
					System.out.println("cnt : " + (cnt+1));
					System.out.println();
					walls[cnt].r = r;
					walls[cnt].c = c;
					visit[r][c] = true;
					select(cnt++);
					visit[r][c] = false;
				}
			}
		}
	}
	
}























