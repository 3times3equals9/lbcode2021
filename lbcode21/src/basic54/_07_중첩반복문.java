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

*/
import java.util.Scanner;

public class _07_중첩반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int size = 2*n+1;

		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				
				System.out.print("*" + " ");
				
			}
			System.out.println();
		}

		sc.close();
	}
}





















