package type_basic_1_단순반복문;

import java.util.Scanner;

public class _2_별그리기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//step1
		for(int i=1; i<=n; i++) {
			for(int j=0; j<n-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i -1; j++) {
				System.out.print("*");
			}
			for(int j=0; j<n-i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		
		//step2
		for(int i=n-1; i>=1; i--) {
			for(int j=0; j<n-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i -1; j++) {
				System.out.print("*");
			}
			for(int j=0; j<n-i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}

/*
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int size = 2 * n - 1;

		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (r <= size / 2) {// 위쪽영역
					if (r + c <= size / 2 - 1) {
						// 왼쪽 위 공백찍기
						System.out.print(" ");
					} else if (c - r >= size / 2 + 1) {
						// 오른쪽 위 공백 찍기
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				} else if (r > size / 2) {// 아래쪽 영역
					if (r - c >= size / 2 + 1) {
						// 왼쪽 밑 공백
						System.out.print(" ");
					} else if (r + c >= size / 2 * 3 + 1) {
						// 오른쪽 밑 공백
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
			}
			// 줄바꿈
			System.out.println();
		}
		sc.close();
	}
}
*/













