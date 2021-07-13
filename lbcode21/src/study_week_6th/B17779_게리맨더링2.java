package study_week_6th;

import java.util.Arrays;
import java.util.Scanner;

public class B17779_게리맨더링2 {
	private static class Cell{
		int row,col;
		public Cell() {
			super();
		}
		@Override
		public String toString() {
			return "Cell [row=" + row + ", col=" + col + "]";
		}
	}
	
	static final int[] dr = {+1,+1};
	static final int[] dc = {-1,+1};
	
	static Cell UP, DOWN, LEFT, RIGHT;
	
	static int N, allSum, MIN;
	static int[] numbers;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		allSum = 0;
		
		for(int r = 0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = sc.nextInt();
				allSum += map[r][c];
			}
		}
		
		MIN = Integer.MAX_VALUE;
		
		
		for (int r = 0; r <= N - 3; r++) {
			for (int c = 1; c <= N - 2; c++) {
				
				UP = new Cell();
				UP.row = r;
				UP.col = c;
				
				LEFT = new Cell();
				LEFT.row = r;
				LEFT.col = c;

				for (int k = c - 1; k >= 0; k--) {
					
					LEFT.row += dr[0];
					LEFT.col += dc[0];
					
					RIGHT = new Cell();
					RIGHT.row = r;
					RIGHT.col = c;
					
					for (int m = c + 1; m <= N - 1; m++) {
						
						RIGHT.row += dr[1];
						RIGHT.col += dc[1];
						// U,L,R 점 다찍음.
						
						// D 점 계산.
						DOWN = new Cell();
						DOWN.row = LEFT.row + RIGHT.row - UP.row;
						DOWN.col = LEFT.col + RIGHT.col - UP.col;
						
						if(isOut(UP.row,UP.col)) continue;
						if(isOut(LEFT.row,LEFT.col)) continue;
						if(isOut(RIGHT.row,RIGHT.col)) continue;
						if(isOut(DOWN.row,DOWN.col)) continue;
						
//						System.out.println("UP : " + UP.toString());
//						System.out.println("LEFT : " + LEFT.toString());
//						System.out.println("RIGHT : " + RIGHT.toString());
//						System.out.println("DOWN : " + DOWN.toString());
						
						int sum1 = getSum1();
						int sum2 = getSum2();
						int sum3 = getSum3();
						int sum4 = getSum4();
						int sum5 = allSum - sum1 - sum2 - sum3 - sum4;
						
//						System.out.println("SUM1 : " + sum1);
//						System.out.println("SUM2 : " + sum2);
//						System.out.println("SUM3 : " + sum3);
//						System.out.println("SUM4 : " + sum4);
//						System.out.println("SUM5 : " + sum5);
						
						numbers = new int[5];
						numbers[0] = sum1;
						numbers[1] = sum2;
						numbers[2] = sum3;
						numbers[3] = sum4;
						numbers[4] = sum5;
						
						Arrays.sort(numbers);
						
						MIN = Math.min(numbers[4] - numbers[0], MIN);
					}
				}

			}
		}
		
		System.out.println(MIN);
		sc.close();
	}
	
	
	private static int getSum1() {
		int sum = 0;
		int cLimit = UP.col;
		for(int r=0; r<=LEFT.row-1; r++) {
			if(UP.row <= r && r<=LEFT.row-1) {
				cLimit--;
			}
			for(int c=0; c<=cLimit; c++) {
				sum += map[r][c];
			}
		}
		return sum;
	}
	
	private static int getSum2() {
		int sum = 0;
		int rLimit = RIGHT.row;
		for(int c=N-1; c>=UP.col+1; c--) {
			if(UP.col+1 <= c && c <= RIGHT.col) {
				rLimit--;
			}
			for(int r=0; r<=rLimit; r++) {
				sum += map[r][c];
			}
		}
		return sum;
	}
	
	private static int getSum3() {
		int sum = 0;
		int rLimit = LEFT.row;
		
		for(int c=0; c<=DOWN.col-1; c++) {
//			System.out.println("(1)c : " + c);
			if(LEFT.col <= c && c <= DOWN.col-1) {
//				System.out.println("(2)LEFT.col : " + LEFT.col);
//				System.out.println("(2)c : " + c);
//				System.out.println("(2)DOWN.col-1 : " + (DOWN.col-1));
				rLimit++;
//				System.out.println("(2)rLimit : " + rLimit);
			}
			
//			System.out.println("(3)c : " + c);
			for(int r=N-1; r>=rLimit; r--) {
				sum += map[r][c];
//				System.out.println("c : " + c + " / r : " + r);
			}
//			System.out.println(); 
			
		}
		
		return sum;
	}
	
	private static int getSum4() {
		int sum = 0;
		int cLimit = DOWN.col;
		for(int r=N-1; r>=RIGHT.row+1; r--) {
			if(RIGHT.row+1 <= r && r<=DOWN.row) {
				cLimit++;
			}
			for(int c=N-1; c>=cLimit; c--) {
				sum += map[r][c];
			}
		}
		return sum;
	}

	private static boolean isOut(int row, int col) {
		if(row < 0 || N<=row || col<0 || N<=col) {
			return true;
		}
		return false;
	}
	
}
