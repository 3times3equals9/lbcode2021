package basic54;
/*
import java.util.Scanner;

public class _07_중첩반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				System.out.print((r * n + c + 1) + " ");
			}
			System.out.println();
		}

		sc.close();
	}
}

import java.util.Scanner;

public class _07_중첩반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = 1;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				System.out.print(k + " ");
				k++;
			}
			System.out.println();
		}

		sc.close();
	}
}

import java.util.Scanner;

public class _07_중첩반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int r = 0; r < n; r++) {
			if(r % 2 == 0) {
				for (int c = 0; c < n; c++) {
					System.out.print((r * n + c + 1) + " ");
				}
				System.out.println();
			} else {
				for (int c = n; c > 0; c--) {
					System.out.print((r * n + c) + " ");
				}
				System.out.println();
			}
		}

		sc.close();
	}
}

public class _07_중첩반복문 {
	public static void main(String[] args) {
		for (int r = 1; r <= 19; r++) {
			for (int c = 1; c <= 19; c++) {
				System.out.print(r + " * " + c + " = " + (r*c));
				if(c % 2 == 1 && c != 19) {
					System.out.print(" / ");
				}else if(c % 2 == 0 || c == 19) {
					System.out.println();
				}
			}
		}
	}
}

https://coding-factory.tistory.com/68
[Java] 별찍기 예제 (For문 연습)

이거는 5x5 배열해서 r,c 매기면 규칙이 보이네
import java.util.Scanner;

public class _07_중첩반복문 {
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

import java.util.Scanner;

public class _07_중첩반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		for(int i=0; i<m; i++) {
			int cnt = 0;
			int n = sc.nextInt();
			while(n != 1) {
				if(n%2 == 0) {
					n = n/2;
				}else {
					n = 3*n+1;
				}
				cnt++;
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
*/
import java.util.Scanner;

public class _07_중첩반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] arr = new boolean[n+1];
		for(int i=2; i*i<=n; i++) {
			for(int k=i+i; k<=n; k+=i) {
				if(!arr[k]) {
					arr[k] = true;
				}
			}
		}
		
		for(int i=2; i<=n; i++) {
			if(!arr[i]) {
				System.out.print(i+" ");
			}
		}
		sc.close();
	}
}


















