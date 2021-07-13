package _lb_mark;

import java.util.ArrayList;
import java.util.Scanner;

public class _5_n개의점중m개고르기_1st_백트래킹 {
	
	static final int MAX_N = 20;
	
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
	static Pair[] points;
	static ArrayList<Pair> selected_points = new ArrayList<>();
	
	static int ans = Integer.MAX_VALUE;
	
	static int Dist(Pair p1, Pair p2) {
	    int x1, y1;
	    //tie(x1, y1) = p1;
	    x1 = p1.row;
	    y1 = p1.col;
	    
	    int x2, y2;
	    //tie(x2, y2) = p2;
	    x2 = p2.row;
	    y2 = p2.col;
	    
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
	
	static int Calc() {
		int max_dist = 0;
	    
	    // 가장 먼 거리를 반환합니다.
		for(int i = 0; i < m; i++) 
			for(int j = i + 1; j < m; j++) 
				max_dist = Math.max(max_dist, 
	                           Dist(selected_points.get(i), selected_points.get(j)));
			
		return max_dist;
	}
	
	static void FindMin(int idx, int cnt) {
	    if(cnt == m) {
	        // 가장 먼 거리 중 최솟값을 선택합니다.
			ans = Math.min(ans, Calc());
	        return;
	    }
	    
		if(idx == n) 
			return;
		
	    // 점을 선택하는 경우입니다.
		selected_points.add(points[idx]);
		FindMin(idx + 1, cnt + 1);
		int len = selected_points.size();
		selected_points.remove(len-1);
	    
	    // 점을 선택하지 않는 경우입니다.
		FindMin(idx + 1, cnt);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//pair<int, int> points[MAX_N];
		n = sc.nextInt();
		m = sc.nextInt();
		
		points = new Pair[n];
		for(int i = 0; i < n; i++) {
			int x, y;
	        x = sc.nextInt();
	        y = sc.nextInt();
	        points[i] = new Pair(x, y);
	    }
		
		FindMin(0, 0);
		
		System.out.println(ans);
		sc.close();
	}
}









































































