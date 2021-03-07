package study_week_1st;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
재귀문에서 시작위치 체크 안해줘서 틀리는거같음
그게 기준이 되어서 갯수 세고, 나중꺼 체크해야하는데
 */
public class _방화벽설치하기_수정중_백업_2 {
	
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

		max = Integer.MIN_VALUE;
		SIZE = ROW * COL;
		
		for(int i=0; i<SIZE; i++) {
			int str = i / COL;
			int stc = i % COL;
			if(map[str][stc] == 0) {
				visit = new boolean[ROW][COL];
				walls = new Cell[3];
				for(int k=0; k<3; k++) {
					walls[k] = new Cell();
				}
				walls[0].r = str;
				walls[0].c = stc;
				visit[str][stc] = true;
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
		if(cnt == 3 && idx<SIZE) {
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
			
			System.out.println("ret");
			return;
		}
		
		//왜 여기로 오는거지
		int div = idx / COL;
		int mod = idx % COL;
		//System.out.println("cnt :" + cnt);
		//System.out.println("idx :" + idx);
		//System.out.println();
		if(map[div][mod] == 0 && !visit[div][mod]) {
			System.out.println("cnt :" + cnt);
			//System.out.println("idx :" + idx);
			//System.out.println();
			
			
			//System.out.println("여기여기여");
			walls[cnt].r = div;
			walls[cnt].c = mod;
			visit[div][mod] = true;
			select(cnt++, idx++);
			visit[div][mod] = false;
		}
		
	}
	
}























