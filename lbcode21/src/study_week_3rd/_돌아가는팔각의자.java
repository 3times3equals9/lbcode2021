package study_week_3rd;

import java.util.Scanner;

public class _돌아가는팔각의자 {

	static final int N = 8;
	static int[][] tooth;
	static int K;
	static int[][] command;
	static int[] turn;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//상태는 8개의 정수로 이루어져 있고, 
		//12시방향부터 시계방향 순서대로 주어진다. 
		//	>> 12시방향부터 인덱스 0,1,2,...,7
		//N극은 0, S극은 1로 나타나있다.
		tooth = new int[5][8];
		for(int r=1; r<=4; r++) {
			String temp = sc.next();
			for(int c=0; c<8; c++) {
				tooth[r][c] = temp.charAt(c)-'0';
			}
		}
		K = sc.nextInt();
		// 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.
		command = new int[K][2];
		for(int r=0; r<K; r++) {
			for(int c=0; c<2; c++) {
				command[r][c] = sc.nextInt();
			}
		}
		
		for(int r=0; r<K; r++) {
			turn = new int[5];
			
			int num = command[r][0];
			int dir = command[r][1];
			
			turn[num] = dir;
			
			if(num == 1) {
				if(tooth[1][2] != tooth[2][6]) {
					turn[2] = -1 * turn[1];
					if(tooth[2][2] != tooth[3][6]) {
						turn[3] = -1 * turn[2];
						if(tooth[3][2] != tooth[4][6]) {
							turn[4] = -1 * turn[3];
						}
					}
				}
			}else if(num ==2) {
				if(tooth[1][2] != tooth[2][6]) {
					turn[1] = -1 * turn[2];
				}
				if(tooth[2][2] != tooth[3][6]) {
					turn[3] = -1 * turn[2];
					if(tooth[3][2] != tooth[4][6]) {
						turn[4] = -1 * turn[3];
					}
				}
			}else if(num ==3) {
				if(tooth[3][2] != tooth[4][6]) {
					turn[4] = -1 * turn[3];
				}
				if(tooth[2][2] != tooth[3][6]) {
					turn[2] = -1 * turn[3];
					if(tooth[1][2] != tooth[2][6]) {
						turn[1] = -1 * turn[2];
					}
				}
			}else if(num == 4) {
				if(tooth[3][2] != tooth[4][6]) {
					turn[3] = -1 * turn[4];
					if(tooth[2][2] != tooth[3][6]) {
						turn[2] = -1 * turn[3];
						if(tooth[1][2] != tooth[2][6]) {
							turn[1] = -1 * turn[2];
						}
					}
				}
			}
			
			
//			System.out.println(Arrays.toString(turn));
			
			for(int c=1; c<=4; c++) {
				rotate(tooth[c], turn[c]);
			}
			
//			for(int k=1; k<=4; k++) {
//				System.out.println(Arrays.toString(tooth[k]));
//			}
//			
//			System.out.println();
			
		}
		
		int sum = 0;
		if(tooth[1][0] == 1) {
			sum += 1;
		}
		if(tooth[2][0] == 1) {
			sum += 2;
		}
		if(tooth[3][0] == 1) {
			sum += 4;
		}
		if(tooth[4][0] == 1) {
			sum += 8;
		}
		
		System.out.println(sum);
		sc.close();
	}

	private static void rotate(int[] arr, int dir) {
		if(dir == -1) {
			//1인 경우는 톱니 시계 방향.
			//	>> 숫자 교환 방향은 바뀌는건 반대... 시팔...
			int temp = arr[0];
			for(int i=0; i<7; i++) {
				arr[i] = arr[i+1];
			}
			arr[7] = temp;
		}else if(dir == 1) {
			//-1인 경우는 반시계 방향.
			//	>> 숫자 교환 방향은 바뀌는건 반대... 시팔...
			int temp = arr[7];
			for(int i=6; i>=0; i--) {
				arr[i+1] = arr[i];
			}
			arr[0] = temp;
		}else if(dir == 0) {
			return;
		}
	}

}
