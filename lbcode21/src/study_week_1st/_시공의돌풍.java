package study_week_1st;

import java.util.ArrayList;
import java.util.Scanner;

public class _시공의돌풍 {
	
	private static class Cell{
		int r,c;
		public Cell(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static final int[] dr = {-1,0,+1,0};
	static final int[] dc = {0,+1,0,-1};

	static int ROW, COL, TIME;
	static int[][] map, dust_to_merge;
	static ArrayList<Cell> dust_to_spread;
	static ArrayList<Cell> air;
	//위쪽 공기청정기의 바람은 반시계방향으로 순환하고,
	//아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ROW = sc.nextInt();
		COL = sc.nextInt();
		TIME = sc.nextInt();
		map = new int[ROW][COL];
		dust_to_spread = new ArrayList<>();
		air = new ArrayList<>();
		
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == -1) {
					air.add(new Cell(r, c));
					//공기청정기 자리는 -1로 둬야, 먼지 퍼지는 방지.
					//인접한 방향에 공기청정기가 있거나, 
					//칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
				}else if(map[r][c] != 0) {
					dust_to_spread.add(new Cell(r,c));
				}
			}
		}
		
		for(int i=1; i<=TIME; i++) {
			spread_dust();
			air_circulate();
			collect_dust();
			
//			System.out.println();
//			for(int r=0; r<ROW; r++) {
//				for(int c=0; c<COL; c++) {
//					System.out.print(map[r][c] + " ");
//				}
//				System.out.println();
//			}
		}
		
//		System.out.println();
		System.out.println(get_sum());
		
		sc.close();
	}

	private static void spread_dust() {
		dust_to_merge = new int[ROW][COL];
		for(int i=0; i<dust_to_spread.size(); i++) {
			int row = dust_to_spread.get(i).r;
			int col = dust_to_spread.get(i).c;
			///////////////////////////////////			
			//맨 처음의 먼지 량을 가지고 있어야 하네 !!!
			int init_dust = map[row][col];
			///////////////////////////////////			
			for(int k=0; k<4; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];
				if(0<=nr && nr<ROW && 0<=nc && nc<COL) {
					if(map[nr][nc] != -1) {
						dust_to_merge[nr][nc] = dust_to_merge[nr][nc] + (init_dust / 5);
						map[row][col] = map[row][col] - (init_dust / 5);
					}
				}
			}
		}
		//퍼진 먼지 합쳐주기.
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				map[r][c] = map[r][c] + dust_to_merge[r][c];
			}
		}
	}

	private static void air_circulate() {
		//바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
		//공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 
		//공기청정기로 들어간 미세먼지는 모두 정화된다.
		int up_row = air.get(0).r;
//		int up_col = air.get(0).c;
		int down_row = air.get(1).r;
//		int down_col = air.get(1).c;
		
		//위쪽 공기청정기의 바람은 반시계방향으로 순환하고,
		for(int r = up_row-1; r>=1; r--) {
			map[r][0] = map[r-1][0];
		}
		for(int c=0; c<COL-1; c++) {
			map[0][c] = map[0][c+1];
		}
		for(int r=0; r<=up_row-1; r++) {
			map[r][COL-1] = map[r+1][COL-1];
		}
		for(int c=COL-1; c>=2; c--) {
			map[up_row][c] = map[up_row][c-1];
		}
		map[up_row][1] = 0;
		
		//아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
		for(int r = down_row+1; r<ROW-1; r++) {
			map[r][0] = map[r+1][0];
		}
		for(int c=0; c<COL-1; c++) {
			map[ROW-1][c] = map[ROW-1][c+1];
		}
		for(int r=ROW-1; r>=down_row+1; r--) {
			map[r][COL-1] = map[r-1][COL-1];
		}
		for(int c=COL-1; c>=2; c--) {
			map[down_row][c] = map[down_row][c-1];
		}
		map[down_row][1] = 0;
	}
	
	private static void collect_dust() {
		dust_to_spread = new ArrayList<>();
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				if(map[r][c] > 0 ) {
					// -1 : 공기청정기 칸 거름.
					dust_to_spread.add(new Cell(r,c));
				}
			}
		}
	}
	
	private static int get_sum() {
		int sum = 0;
		for(int r=0; r<ROW; r++) {
			for(int c=0; c<COL; c++) {
				if(map[r][c] > 0) {
					// -1 : 공기청정기 칸 거름.
					sum += map[r][c]; 
				}
			}
		}
		return sum;
	}
}


