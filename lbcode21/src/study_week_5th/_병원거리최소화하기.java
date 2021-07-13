package study_week_5th;

import java.util.ArrayList;
import java.util.Scanner;

public class _병원거리최소화하기 {
	
	private static class Cell{
		int r;
		int c;
		public Cell(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, ANS;
	static int[][] map;
	static ArrayList<Cell> home;
	static ArrayList<Cell> chicken;
	static boolean[] select;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 1) {
					home.add(new Cell(r,c));
				}
				if(map[r][c] == 2) {
					chicken.add(new Cell(r,c));
				}
			}
		}
		//0은 빈 칸, 1은 집, 2는 치킨집이다.
		
		select = new boolean[chicken.size()];
		
		ANS = Integer.MAX_VALUE;
		go(0, 0);
		
		System.out.println(ANS);
		
		sc.close();
	}
	
	private static void go(int index, int count) {
		if(count == M) {
			//치킨거리 계산.
			//System.out.println(Arrays.toString(select));
			int city_distance = 0;
			for(int i=0; i<home.size(); i++) {
				int hr = home.get(i).r;
				int hc = home.get(i).c;
				
				int home_distance = Integer.MAX_VALUE;
				for(int j=0; j<chicken.size(); j++) {
					if(select[j]) {
						int cr = chicken.get(j).r;
						int cc = chicken.get(j).c;
						int temp = Math.abs(hr-cr) + Math.abs(hc-cc);
						home_distance = Math.min(home_distance, temp);
					}
				}
				city_distance = city_distance + home_distance;
			}
			ANS = Math.min(ANS, city_distance);
			return;
		}
		
		for(int k=index; k<chicken.size(); k++) {
			if(!select[k]) {
				select[k] = true;
				go(k+1, count+1);
				select[k] = false;
			}
		}
	}

}