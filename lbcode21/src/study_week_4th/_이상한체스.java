package study_week_4th;

import java.util.ArrayList;
import java.util.Scanner;

public class _이상한체스 {
	
	private static class Cell{
		int r, c, kind;

		public Cell(int r, int c, int kind) {
			super();
			this.r = r;
			this.c = c;
			this.kind = kind;
		}
	}
	
	static final int[] dr = {-1, 0, +1, 0};
	static final int[] dc = {0, +1, 0, -1};
	
	static int ROW, COL, ANS;
	static int[][] map, copy;
	static ArrayList<Cell> list;
	static int[] cctv_dir;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ROW = sc.nextInt();
		COL = sc.nextInt();
		map = new int[ROW][COL];
		list = new ArrayList<>();
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				map[r][c] = sc.nextInt();
				if(1<= map[r][c] && map[r][c] <=5) {
					list.add(new Cell(r,c,map[r][c]));
				}
			}
		}
		cctv_dir = new int[list.size()];
		ANS = Integer.MAX_VALUE;
		go(0,0);
		System.out.println(ANS);
		sc.close();
	}
	
	private static int calc(int[][] map) {
		int result = 0;
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				if(map[r][c] == 0) {
					result++;
				}
			}
		}
		return result;
	}

	private static void copy_map() {
		copy = new int[ROW][COL];
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				copy[r][c] = map[r][c];
			}
		}
	}
	
	private static void fill_copy(int row, int col, int kind, int dir_idx) {
		if(kind == 1) {
			int nr = row+dr[dir_idx];
			int nc = col+dc[dir_idx];
			while(0<=nr && nr<ROW && 0<=nc && nc<COL && copy[nr][nc] != 6) {
				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 9;
				}
				nr += dr[dir_idx];
				nc += dc[dir_idx];
			}
		}else if(kind == 2) {
			int nr = row+dr[dir_idx];
			int nc = col+dc[dir_idx];
			while(0<=nr && nr<ROW && 0<=nc && nc<COL && copy[nr][nc] != 6) {
				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 9;
				}
				nr += dr[dir_idx];
				nc += dc[dir_idx];
			}
			int dir_1 = (dir_idx+2)%4;
			nr = row+dr[dir_1];
			nc = col+dc[dir_1];
			while(0<=nr && nr<ROW && 0<=nc && nc<COL && copy[nr][nc] != 6) {
				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 9;
				}
				nr += dr[dir_1];
				nc += dc[dir_1];
			}
		}else if(kind == 3) {
			int nr = row+dr[dir_idx];
			int nc = col+dc[dir_idx];
			while(0<=nr && nr<ROW && 0<=nc && nc<COL && copy[nr][nc] != 6) {
				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 9;
				}
				nr += dr[dir_idx];
				nc += dc[dir_idx];
			}
			int dir_1 = (dir_idx+1)%4;
			nr = row+dr[dir_1];
			nc = col+dc[dir_1];
			while(0<=nr && nr<ROW && 0<=nc && nc<COL && copy[nr][nc] != 6) {
				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 9;
				}
				nr += dr[dir_1];
				nc += dc[dir_1];
			}
		}else if(kind == 4) {
			int nr = row+dr[dir_idx];
			int nc = col+dc[dir_idx];
			while(0<=nr && nr<ROW && 0<=nc && nc<COL && copy[nr][nc] != 6) {
				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 9;
				}
				nr += dr[dir_idx];
				nc += dc[dir_idx];
			}
			int dir_1 = (dir_idx+1)%4;
			nr = row+dr[dir_1];
			nc = col+dc[dir_1];
			while(0<=nr && nr<ROW && 0<=nc && nc<COL && copy[nr][nc] != 6) {
				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 9;
				}
				nr += dr[dir_1];
				nc += dc[dir_1];
			}
			int dir_2 = (dir_idx+2)%4;
			nr = row+dr[dir_2];
			nc = col+dc[dir_2];
			while(0<=nr && nr<ROW && 0<=nc && nc<COL && copy[nr][nc] != 6) {
				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 9;
				}
				nr += dr[dir_2];
				nc += dc[dir_2];
			}
		}else if(kind == 5) {
			int nr = row+dr[0];
			int nc = col+dc[0];
			while(0<=nr && nr<ROW && 0<=nc && nc<COL && copy[nr][nc] != 6) {
				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 9;
				}
				nr += dr[0];
				nc += dc[0];
			}
			nr = row+dr[1];
			nc = col+dc[1];
			while(0<=nr && nr<ROW && 0<=nc && nc<COL && copy[nr][nc] != 6) {
				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 9;
				}
				nr += dr[1];
				nc += dc[1];
			}
			nr = row+dr[2];
			nc = col+dc[2];
			while(0<=nr && nr<ROW && 0<=nc && nc<COL && copy[nr][nc] != 6) {
				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 9;
				}
				nr += dr[2];
				nc += dc[2];
			}
			nr = row+dr[3];
			nc = col+dc[3];
			while(0<=nr && nr<ROW && 0<=nc && nc<COL && copy[nr][nc] != 6) {
				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 9;
				}
				nr += dr[3];
				nc += dc[3];
			}
		}
	}
	
	private static void go(int index, int count) {
		if(count == list.size()) {
			copy_map();
			for(int k=0; k<list.size(); k++) {
				int row = list.get(k).r;
				int col = list.get(k).c;
				int kind = list.get(k).kind;
				fill_copy(row,col,kind,cctv_dir[k]);
			}
			int result = calc(copy);
			if(result < ANS) {
				ANS = result;
			}
//			System.out.println();
//			System.out.println("result : " + result);
//			System.out.println(Arrays.toString(cctv_dir));
//			for(int r=0; r<ROW; r++) {
//				for(int c=0; c<COL; c++) {
//					System.out.print(copy[r][c] + " ");
//				}
//				System.out.println();
//			}
			return;
		}
		
		int cctv_kind = list.get(index).kind;
		if(cctv_kind == 1) {
			//4방향.
			cctv_dir[index]=0;
			go(index+1, count+1);
			cctv_dir[index]=1;
			go(index+1, count+1);
			cctv_dir[index]=2;
			go(index+1, count+1);
			cctv_dir[index]=3;
			go(index+1, count+1);
		}else if(cctv_kind == 2) {
			//2방향.
			cctv_dir[index]=0;
			go(index+1, count+1);
			cctv_dir[index]=1;
			go(index+1, count+1);
		}else if(cctv_kind == 3) {
			//4방향.
			cctv_dir[index]=0;
			go(index+1, count+1);
			cctv_dir[index]=1;
			go(index+1, count+1);
			cctv_dir[index]=2;
			go(index+1, count+1);
			cctv_dir[index]=3;
			go(index+1, count+1);
		}else if(cctv_kind == 4) {
			//4방향.
			cctv_dir[index]=0;
			go(index+1, count+1);
			cctv_dir[index]=1;
			go(index+1, count+1);
			cctv_dir[index]=2;
			go(index+1, count+1);
			cctv_dir[index]=3;
			go(index+1, count+1);
		}else if(cctv_kind == 5) {
			//1방향.
			cctv_dir[index]=0;
			go(index+1, count+1);
		}
	}
}

