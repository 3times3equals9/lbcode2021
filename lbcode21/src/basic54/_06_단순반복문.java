package basic54;
/*
import java.util.Scanner;

public class _06_단순반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int st = sc.nextInt();
		int ed = sc.nextInt();
		
		int sum = 0;
		for(int i=st; i<=ed; i++) {
			sum += i;
		}
		
		System.out.println(sum);
		sc.close();
	}
}


import java.util.Scanner;

public class _06_단순반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int st = sc.nextInt();
		int ed = sc.nextInt();
		
		int sum = 0;
		for (int i = (st % 2 == 0 ? st : st + 1); i <= ed; i += 2) {
			sum += i;
		}
		
		System.out.println(sum);
		sc.close();
	}
}

import java.util.Scanner;

public class _06_단순반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int st = sc.nextInt();
		int ed = sc.nextInt();

		for (int k = ed; k >= st; k--) {
			System.out.print(k + " ");
		}
		sc.close();
	}
}

자료형	표현범위
int	-2147483648 ~ 2147483647
long	-9223372036854775808 ~ 9223372036854775807

import java.util.Scanner;

public class _06_단순반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int ret = 1;
		for (int i = 0; i < b; i++) {
			ret = ret * a;
		}
		
		System.out.println(ret);
		sc.close();
	}
}

https://www.acmicpc.net/board/view/37396
갯수가 정해지지 않은 자바 입력에 관한 질문입니다.

https://www.google.com/search?sxsrf=ALeKk02IOO-sl-JpGsDeh8wWuUhxZsSjZg:1614693122459&q=%EA%B0%9C%EC%88%98%EA%B0%80+%EC%A0%95%ED%95%B4%EC%A7%80%EC%A7%80+%EC%95%8A%EC%9D%80+%EC%9E%90%EB%B0%94+%EC%9E%85%EB%A0%A5&spell=1&sa=X&ved=2ahUKEwirz_DP4JHvAhXadXAKHUAtD5cQBSgAegQIBhA0&biw=1192&bih=1027
개수가 정해지지 않은 자바 입력

https://wanna-b.tistory.com/59
백준 10951 : A+B-4 (테스트케이스 개수가 주어지지 않는 경우)

https://www.google.com/search?sxsrf=ALeKk03aMy-8AnmiUp7qQc6J4zRD9uJo-g:1614693124365&q=Java+%EC%9E%85%EB%A0%A5+%EB%81%9D&sa=X&ved=2ahUKEwj__eTQ4JHvAhVCa94KHQ2RCq0Q1QIwDXoECBEQAQ&biw=1324&bih=1027
Java 입력 끝

https://mygumi.tistory.com/236
Java EOF 처리 :: 마이구미

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class _06_단순반복문 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		
		while(true) {
			int ip = sc.nextInt();
			if(ip == 0) {
				break;
			} else {
				q.add(ip);
			}
		}
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		sc.close();
		//시스템 종료 해야만 정답인정...
		System.exit(0);
	}
}


import java.util.Scanner;

public class _06_단순반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int ip = sc.nextInt();
			if(ip == 0) {
				break;
			} else {
				System.out.println(ip);
			}
		}
		sc.close();
		//시스템 종료 해야만 정답인정...
		System.exit(0);
	}
}

import java.util.Scanner;

public class _06_단순반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력 값은 1~100으로 제한
		int ip = sc.nextInt();
		for(int k=1; k<=ip; k++) {
			if(k % 3 == 0) {
				//여기서 숫자 3,6,9 걸러짐
				System.out.print(0 + " ");
			}else if(k % 10 == 3 || k % 10 == 6 || k % 10 == 9) {
				//일의자리가 3,6,9 일 때
				System.out.print(0 + " ");
			}else if(k / 10 == 3 || k / 10 == 6 || k / 10 == 9) {
				//십의자리가 3,6,9 일 때
				System.out.print(0 + " ");
			}else {
				System.out.print(k + " ");
			}
		}
		
		sc.close();
	}
}


import java.util.Scanner;

public class _06_단순반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
//		이거하면 틀리더라
//		double ans = (double)a /(double)b;
//		System.out.printf("%.20f", ans);
//		
//		3 /7 = 0.42857142857142855000
//		이렇게 나오고 끝남
		
		int mod = a/b;
		int remain = (a % b) * 10;
		System.out.print(mod + ".");
		for(int k = 0; k<20; k++) {
			mod = remain / b;
			System.out.print(mod);
			remain = (remain % b) * 10;
		}
		
		sc.close();
	}
}

import java.util.Scanner;

public class _06_단순반복문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int cnt = 0;

		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
			cnt++;
		}

		System.out.println(cnt);
		sc.close();
	}
}

*/



















