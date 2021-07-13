package study_week_4th;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _격자숫자놀이 {
	
	private static class Cell implements Comparable<Cell>{
		int num, count;

		public Cell(int num, int count) {
			super();
			this.num = num;
			this.count = count;
		}

		@Override
		public int compareTo(Cell o) {
			if(this.count != o.count) {
				return Integer.compare(this.count, o.count);
			}
			return Integer.compare(this.num, o.num);
		}
		//수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬한다.
	}
	
	static int R,C,K, ROW, COL;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		arr = new int[101][101];
		for(int r=1; r<=3; r++) {
			for(int c=1; c<=3; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		sc.close();
		
		ROW = 3;
		COL = 3;
		PriorityQueue<Cell> q;
		int count = 0;
		while(true) {
			if(count > 100) {
				System.out.println(-1);
				System.exit(0);
			}
			if(arr[R][C] == K) {
				System.out.println(count);
				System.exit(0);
			}
			
			if(ROW >= COL) {
				int max_size = 0;
				for(int r=1; r<=ROW; r++) {
					q = new PriorityQueue<>();
					int[] temp = new int[101];
					for(int c=1; c<=COL; c++) {
						temp[arr[r][c]]++;
					}
					for(int num=1; num<=100; num++) {
						if(temp[num] != 0) {
							q.add(new Cell(num, temp[num]));
						}
					}
					if((q.size() * 2) > max_size) {
						max_size = q.size() * 2;
						if(max_size > 100) {
							max_size = 100;
						}
					}
					int idx = 0;
					while(idx < 100 && !q.isEmpty()) {
						Cell cur = q.poll();
//						System.out.println("r : " + r);
//						System.out.println("idx : " + idx);
//						System.out.println("q.size : " + q.size());
//						System.out.println("cur.num : " + cur.num);
//						System.out.println("cur.count : " + cur.count);
						arr[r][idx+1] = cur.num;
						arr[r][idx+2] = cur.count;
						idx += 2;
					}
					for(int c=idx+1; c<=100; c++) {
						arr[r][c] = 0;
					}
				}
				COL = max_size;
			}else {
				int max_size = 0;
				for(int c=1; c<=COL; c++) {
					q = new PriorityQueue<>();
					int[] temp = new int[101];
					for(int r=1; r<=ROW; r++) {
						temp[arr[r][c]]++;
					}
					for(int num=1; num<=100; num++) {
						if(temp[num] != 0) {
							q.add(new Cell(num, temp[num]));
						}
					}
					if((q.size() * 2) > max_size) {
						max_size = q.size() * 2;
						if(max_size > 100) {
							max_size = 100;
						}
					}
					int idx = 0;
					while(idx < 100 && !q.isEmpty()) {
						Cell cur = q.poll();
						arr[idx+1][c] = cur.num;
						arr[idx+2][c] = cur.count;
						idx += 2;
					}
					for(int r=idx+1; r<=100; r++) {
						arr[r][c] = 0;
					}
				}
				ROW = max_size;
			}
			count++;
		}

	}

}
