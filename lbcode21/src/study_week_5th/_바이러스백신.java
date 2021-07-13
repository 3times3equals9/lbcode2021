package study_week_5th;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _바이러스백신 {
	
	private static class Cell{
		int r,c,step;

		public Cell(int r, int c, int step) {
			super();
			this.r = r;
			this.c = c;
			this.step = step;
		}
		
	}
	
	static final int[] dr = {-1,0,+1,0};
	static final int[] dc = {0,+1,0,-1};
	
	static int N, M, min = Integer.MAX_VALUE;
	static int[][] map, copy;
	static boolean[][] visit;
	static boolean[] check;
	static Queue<Cell> q;
	static ArrayList<Cell> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		
		//0은 빈 칸, 1은 벽, 2는 바이러스를 놓을 수 있는 위치이다. 
		//2의 개수는 M보다 크거나 같고, 10보다 작거나 같은 자연수이다.
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 2) {
					list.add(new Cell(r,c,0));
					map[r][c] = 0;
				}else if(map[r][c] == 1) {
					map[r][c] = -1;
				}
			}
		}
		
		int zero_finder;
		zero_finder = find_zero(map) * -1;
		if(zero_finder == M || zero_finder == list.size()) {
			System.out.println(0);
			System.exit(0);
			//return;
		}
		
		for(Cell temp : list) {
			map[temp.r][temp.c] = -10;
		}
		
		int[] pick = new int[M];
		permutation(0, 0, pick, list.size());
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		sc.close();
	}

	private static void permutation(int idx, int cnt, int[] pick, int list_size) {
		if(cnt == M) {
			init(pick);
			int temp_bfs = bfs();
			if(temp_bfs >= 0) {
				min = Math.min(min, bfs());
			}
			return;
		}
		
		for(int i=idx; i< list_size; i++) {
			pick[cnt] = i;
			permutation(i+1, cnt+1, pick, list_size);
		}
		
	}
	
	private static int bfs() {
		
		while(!q.isEmpty()) {
			Cell cur = q.poll();
			
			for(int k=0; k<4; k++) {
				int nr = cur.r + dr[k];
				int nc = cur.c + dc[k];
				
				if(0<=nr && nr<N && 0<=nc && nc<N) {
					if(!visit[nr][nc]) {
						visit[nr][nc] = true;
						if(copy[nr][nc] == 0) {
							q.add(new Cell(nr,nc,cur.step+1));
							copy[nr][nc] = cur.step+1;
						}else if(copy[nr][nc] == -10) {
							q.add(new Cell(nr,nc,cur.step+1));
						}
					}
						
				}
			}
			
		}
		
		return find_zero(copy);
	}
	
	private static void init(int[] pick) {
		q = new LinkedList<>();
		visit = new boolean[N][N];
		copy_map();
		for(int temp : pick) {
			q.add(list.get(temp));
			visit[list.get(temp).r][list.get(temp).c] = true;
		}
		
	}
	
	private static void copy_map() {
		copy = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				copy[r][c] = map[r][c];
			}
		}
	}
	
	private static int find_zero(int[][] arr) {
		int max = 0;
		int zero = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(arr[r][c] > max) {
					max = arr[r][c];
				}
				if(arr[r][c] == 0) {
					zero--;
				}
			}
		}
		if(zero == 0) {
			return max;
		}else {
			return zero;
		}
	}
}
