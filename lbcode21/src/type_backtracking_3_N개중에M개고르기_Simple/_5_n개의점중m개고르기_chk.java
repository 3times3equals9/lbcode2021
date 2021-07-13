package type_backtracking_3_N개중에M개고르기_Simple;

import java.util.ArrayList;
import java.util.Scanner;

public class _5_n개의점중m개고르기_chk {
	static class Pair{
		int row;
		int col;
		public Pair(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	static int n, m;
	static ArrayList<Pair> list = new ArrayList<>();
	static ArrayList<Pair> selected = new ArrayList<>();
	static int ans = Integer.MAX_VALUE;
	
	static void dfs(int curr, int cnt) {
		if(cnt == m) {
			int idx1 = 0;
			int idx2 = 0;
			int max = Integer.MIN_VALUE;
			for(int k=0; k<m-1; k++) {
				for(int j=k+1; j<m; j++) {
					Pair p1 = selected.get(k);
					Pair p2 = selected.get(j);
					int dist = (p1.row - p2.row)*(p1.row - p2.row) 
							+ (p1.col - p2.col)*(p1.col - p2.col);
					
					if(dist > max) {
						max = dist;
						idx1 = k;
						idx2 = j;
					}
				}
			}
			
			Pair p3 = selected.get(idx1);
			Pair p4 = selected.get(idx2);
			
			int dist_ans = (p3.row - p4.row)*(p3.row - p4.row) 
					+ (p3.col - p4.col)*(p3.col - p4.col);
			
			ans = Math.min(dist_ans, ans);
			return;
		}
		
		for(int idx=curr; idx<n; idx++) {
			int nr = list.get(idx).row;
			int nc = list.get(idx).col;
			
			selected.add(new Pair(nr, nc));
			dfs(idx+1, cnt+1);
			int len = selected.size();
			selected.remove(len-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			list.add(new Pair(r,c));
		}
		
		dfs(0,0);
		System.out.println(ans);
		sc.close();
	}
}









































































