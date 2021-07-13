package study_week_6th;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B20058_마법사상어와파이어스톰 {
	
	static int n, q, map[][], lv[], size, big;
	static int[] dr = {-1,0,+1,0};
	static int[] dc = {0,+1,0,-1};
	static boolean[][] ismelt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		q = sc.nextInt();
		
		size = 1;
		for(int i=0; i<n; i++) {
			size *= 2;
		}
		
		map = new int[size+2][size+2];
		
		for(int r=1; r<=size; r++) {
			for(int c=1; c<=size; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		lv = new int[q];
		for(int k=0; k<q; k++) {
			lv[k] = sc.nextInt();
		}
		
		for(int k=0; k<q; k++) {
			int dist = pow(lv[k]);
			
			for(int r=1; r<=size; r = r+dist) {
				for(int c=1; c<=size; c = c+dist) {
					clock(r,c,dist);
				}
			}
			
			melt();
		}
		
		bfs();
		
		int ans1 = 0;
		for(int r=1; r<=size; r++) {
			for(int c=1; c<=size; c++) {
				if(map[r][c] > 0) {
					ans1 = ans1 + map[r][c];
				}
			}
		}
		
		System.out.println(ans1);
		System.out.println(big);
		
		sc.close();
	}
	
	public static void clock(int sr, int sc, int len) {
		int[][] copy = new int[len][len];
		for(int r=0; r<len; r++) {
			for(int c=0; c<len; c++) {
				copy[r][c] = map[sr+r][sc+c];
			}
		}
		
		int[][] arr = new int[len][len];
		for(int r=0; r<len; r++) {
			for(int c=0; c<len; c++) {
				arr[r][c] = copy[len-1-c][r];
			}
		}
		
		for(int r=0; r<len; r++) {
			for(int c=0; c<len; c++) {
				map[sr+r][sc+c] = arr[r][c];
			}
		}
	}
	
	public static int pow(int ex) {
		int res = 1;
		for(int i=0; i<ex; i++) {
			res *= 2;
		}
		return res;
	}
	
	public static void melt() {
		ismelt = new boolean[size+2][size+2];
		
		for(int cr = 1; cr<=size; cr++) {
			for(int cc=1; cc<=size; cc++) {
				if(map[cr][cc] > 0) {
					int cnt = 0;
					int nr, nc;
					for(int k=0; k<4; k++) {
						nr = cr + dr[k];
						nc = cc + dc[k];
						if(map[nr][nc] == 0 ) {
							cnt++;
						}
						if(cnt >=2) {
							ismelt[cr][cc] = true;
							break;
						}
					}
				}
			}
		}
		
		for(int r=1; r<=size; r++) {
			for(int c=1; c<=size; c++) {
				if(ismelt[r][c]) {
					map[r][c]--;
					if(map[r][c] < 0) {
						map[r][c] = 0;
					}
				}
			}
		}
	}
	
	public static void bfs() {
		big = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[size+2][size+2];
		
		for(int r=1; r<=size; r++) {
			for(int c=1; c<=size; c++) {
				if(!visit[r][c] && map[r][c] != 0) {
					int[] pos = new int[2];
					pos[0] = r;
					pos[1] = c;
					
					q.offer(pos);
					visit[r][c] = true;
					
					int cnt = 0;
					
					while(!q.isEmpty()) {
						int[] cur = new int[2];
						cur = q.poll();
						cnt++;
						
						for(int k=0; k<4; k++) {
							int nr = cur[0] + dr[k];
							int nc = cur[1] + dc[k];
							
							if(1<=nr && nr<=size && 1<=nc && nc<=size && !visit[nr][nc] && map[nr][nc] > 0) {
								int[] next = new int[2];
								next[0] = nr;
								next[1] = nc;
								visit[nr][nc] = true;
								q.offer(next);
							}
						}
					}
					
					if(big<cnt) {
						big = cnt;
					}
				}
			}
		}
	}
}


