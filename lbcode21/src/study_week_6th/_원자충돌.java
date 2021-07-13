package study_week_6th;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class _원자충돌 {
	
	private static class Ball{
		public int r;
		public int c;
		public int m;
		public int s;
		public int d;
		public Ball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int[] dr = {-1,-1,0,+1,+1,+1,0,-1};
	static int[] dc = {0,+1,+1,+1,0,-1,-1,-1};

	static int n, m, k;
	static ArrayList<Ball> list;
	static LinkedList<Integer> map[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		list = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			int rr = sc.nextInt()-1;
			int cc = sc.nextInt()-1;
			int mm = sc.nextInt();
			int ss = sc.nextInt();
			int dd = sc.nextInt();
			list.add(new Ball(rr,cc,mm,ss,dd));
		}
		
		for(int i=0; i<k; i++) {
			init_map();
			move_ball();
			check_map();
			del_mass_zero();
		}
		
		int ans = 0;
		for(Ball b : list) {
			ans += b.m;
		}
	
		System.out.println(ans);
		sc.close();
	}

	public static void init_map() {
		map = new LinkedList[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = new LinkedList<Integer>();
			}
		}
	}
	
	public static void move_ball() {
		for(int i=0; i<list.size(); i++) {
			int cr = list.get(i).r;
			int cc = list.get(i).c;
			
			int cd = list.get(i).d;
			int cs = list.get(i).s % n;
			
			int nr = ( cr + (dr[cd] * cs) + n ) % n;
			int nc = ( cc + (dc[cd] * cs) + n ) % n;
			
//			if(nr >= n) nr -= n;
//			else if(nr < 0) nr += n;
//			
//			if(nc >= n) nc -= n;
//			else if(nc < 0) nc += n;
			
			map[nr][nc].add(i);
			list.get(i).r = nr;
			list.get(i).c = nc;
		}
	}
	
	public static void check_map() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int cnt = map[i][j].size();
				if(cnt >= 2) {
					int tm = 0;
					int ts = 0;
					for(Integer k : (LinkedList<Integer>) map[i][j]) {
						tm += list.get(k).m;
						ts += list.get(k).s;
					}
					
					int nm = tm/5;
					int ns = ts/cnt;
					
					for(Integer k : (LinkedList<Integer>) map[i][j]) {
						list.get(k).m = 0;
					}
					
					if(nm > 0) {
						if(allodd(map[i][j]) || alleven(map[i][j])) {
							list.add(new Ball(i,j,nm,ns,0));
							list.add(new Ball(i,j,nm,ns,2));
							list.add(new Ball(i,j,nm,ns,4));
							list.add(new Ball(i,j,nm,ns,6));
						}else {
							list.add(new Ball(i,j,nm,ns,1));
							list.add(new Ball(i,j,nm,ns,3));
							list.add(new Ball(i,j,nm,ns,5));
							list.add(new Ball(i,j,nm,ns,7));
						}
					}
				}
			}
		}
	}
	
	public static void del_mass_zero() {
		ArrayList<Ball> tmp = new ArrayList<>();
		
		for(Ball b : list) {
			if(b.m != 0) {
				tmp.add(b);
			}
		}
		
		list = tmp;
	}
	
	public static boolean allodd(LinkedList<Integer> li) {
		for(Integer t : li) {
			if(list.get(t).d % 2 == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean alleven(LinkedList<Integer> li) {
		for(Integer t : li) {
			if(list.get(t).d % 2 == 1) {
				return false;
			}
		}
		return true;
	}
	
}
