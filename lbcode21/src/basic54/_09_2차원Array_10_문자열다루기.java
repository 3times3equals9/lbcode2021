package basic54;
/*
import java.util.Scanner;

public class _09_2차원Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		
		int m = sc.nextInt();
		
		for(int i=0; i<m; i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			arr[r][c] = i+1;
		}
		
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
import java.util.Scanner;

public class _09_2차원Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		
		int k = 0;
		for(int c=0; c<m; c++) {
			if(c%2 == 0) {
				for(int r=0; r<n; r++) {
					arr[r][c] = k;
					k++;
				}
			}else{
				for(int r=n-1; r>=0; r--) {
					arr[r][c] = k;
					k++;
				}
			}
		}
		
		for(int r = 0; r<n; r++) {
			for(int c=0; c<m; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}

import java.util.Scanner;

public class _09_2차원Array_10_문자열다루기 {
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
import java.util.Scanner;

public class _09_2차원Array_10_문자열다루기 {
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




























