package _lb_mark;

import java.util.ArrayList;
import java.util.Scanner;

public class _4_겹치지않게선분고르기_1st_백트래킹 {
	
	static class Pair {
		int row;
		int col;
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static final int MAX_N = 15;
	static int n, ans;
	static Pair[] segments = new Pair[MAX_N];
	static ArrayList<Pair> selected_segs = new ArrayList<>();
	
	static boolean Overlapped(Pair seg1, Pair seg2) {
	    int ax1, ax2;
	    //tie(ax1, ax2) = seg1;
	    ax1 = seg1.row;
	    ax2 = seg1.col;
	    
	    int bx1, bx2;
	    //tie(bx1, bx2) = seg2;
	    bx1 = seg2.row;
	    bx2 = seg2.col;
	    
	    // 두 선분이 겹치는지 여부는
	    // 한 점이 다른 선분에 포함되는 경우로 판단 가능합니다. 
	    return (ax1 <= bx1 && bx1 <= ax2) || (ax1 <= bx2 && bx2 <= ax2) ||
	           (bx1 <= ax1 && ax1 <= bx2) || (bx1 <= ax2 && ax2 <= bx2);
	}
	
	static boolean Possible() {
	    // 단 한쌍이라도 선분끼리 겹치면 안됩니다.
		for(int i = 0; i < (int)selected_segs.size(); i++)
			for(int j = i + 1; j < (int)selected_segs.size(); j++)
	            if(Overlapped(selected_segs.get(i), selected_segs.get(j)))
	                return false;

		return true;
	}
	
	static void FindMaxSegments(int cnt) {
		if(cnt == n) {
			if(Possible())
				ans = Math.max(ans, (int) selected_segs.size());
			return;
		}
	    
		selected_segs.add(segments[cnt]);
		FindMaxSegments(cnt + 1);
		int tmp_len = selected_segs.size();
		selected_segs.remove(tmp_len-1);
	    
		FindMaxSegments(cnt + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 0; i < n; i++) {
	        int x1, x2;
	        x1 = sc.nextInt();
	        x2 = sc.nextInt();
	        
	        segments[i] = new Pair(x1, x2);
	    }
		
		FindMaxSegments(0);
		System.out.println(ans);
		sc.close();
	}
}

/*
Intuition
모든 선분을 선택하는 조합을 만들어본 다음, 그 중 선분끼리 전혀 겹치지 않는 경우들 중 최대 선분의 수를 구하면 됩니다. 두 선분이 겹치는지 여부는 한 점이 다른 선분에 속하는지 여부로 쉽게 판단이 가능합니다.

Algorithm
각 선분을 선택하는 가능한 모든 조합을 만든 후, 그 중 전혀 겹치지 않는 경우에 해당하는 조합에 대해서만 최대 선분의 수를 갱신해주면 됩니다.

두 선분이 겹치는지에 대한 여부는, 특정 점이 다른 선분과 겹치는 부분이 단 한 곳이라도 있는지를 확인하면 알 수 있습니다. 따라서 2개의 선분 중 각 선분을 이루는 총 4개의 점에 대해 각각 다른 선분 내에 속하는지를 확인하여, 그 중 단 하나라도 속한다면 두 선분이 겹치는 경우라 볼 수 있습니다.
*/




































































