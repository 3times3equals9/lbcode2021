package type_basic_6_Object정렬;

import java.util.Arrays;
import java.util.Scanner;

public class _3_원점으로부터의거리_chk {
	
	static class Dot implements Comparable<Dot>{
		public int x;
		public int y;
		public int idx;
		public Dot(int x, int y, int idx) {
			super();
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
		@Override
		public int compareTo(Dot o) {
			int dist_this = Math.abs(this.x) + Math.abs(this.y);
			int dist_o = Math.abs(o.x) + Math.abs(o.y);
			if(dist_this != dist_o) {
				return dist_this - dist_o;
			}else {
				return this.idx - o.idx;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Dot[] dots = new Dot[n];
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			dots[i] = new Dot(x, y, i+1);
		}
		
		Arrays.sort(dots);
		
		for(int i=0; i<n; i++) {
			System.out.println(dots[i].idx);
		}
		
		sc.close();
	}
}









































































