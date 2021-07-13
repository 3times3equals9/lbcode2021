package type_basic_4_2차원Array;

import java.util.Scanner;

public class _2_박스굴리기_1st_규칙찾기_main {
	// 입력값 N의 최대값
	static final int MAX_N = 200;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n;
		int[][] array = new int[MAX_N][MAX_N];
		int[][] rotated = new int[MAX_N][MAX_N];
		
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				array[i][j] = sc.nextInt();
		
	    // 90도 회전한 배열 rotated[i][j] == array[n - j - 1][i] 이다.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				rotated[i][j] = array[n - j - 1][i];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				System.out.print(rotated[i][j] + " ");
			System.out.println();
		}
		
		sc.close();
	}
}

/** 
Solution

Intuition
90도 회전을 하면 회전한 배열의 행과 열이, 기존 배열의 어떤 값과 동일해지는지를 찾아내야 합니다.

Algorithm
90도 회전시, 회전한 배열의 i번째 행은 기존 배열의 i번째 열이 되고, j번째 열은 기존 배열의 n - j - 1번째 열이 됩니다.

따라서 회전 이후의 배열은 다음과 같이 구성할 수 있습니다.

rotated[i][j] = array[n - j - 1][i] for all 0 <= i,j < n  
*/

/*
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		int[][] copy = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				copy[r][c] = arr[N-c-1][r];
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				System.out.print(copy[r][c] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
*/






































































