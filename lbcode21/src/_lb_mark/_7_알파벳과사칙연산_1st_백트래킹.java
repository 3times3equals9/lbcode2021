package _lb_mark;

import java.util.Scanner;

public class _7_알파벳과사칙연산_1st_백트래킹 {
	
	static final int MAX_N = 6;
	static int n = 6;
	//static String expression;
	static char[] expression;
	static int car_len;
	static int ans = Integer.MIN_VALUE;
	static int[] num = new int[MAX_N];
	
	static int Conv(int idx) {
		return num[expression[idx] - 'a'];
	}
	
	static int Calc() {
		int length = (int) car_len;
		int value = Conv(0);
		for(int i = 2; i < length; i += 2) {
			if(expression[i - 1] == '+')
				value += Conv(i);
			else if(expression[i - 1] == '-')
				value -= Conv(i);
			else
				value *= Conv(i);
		}
		return value;
	}
	
	// 'a'부터 'f'까지 순서대로
	// 0부터 5번째 index까지의 값을 
	// 1~4 중에 하나로 채웁니다.
	static void FindMax(int cnt) {
		if(cnt == n) {
			ans = Math.max(ans, Calc());
			return;
		}
		
		for(int i = 1; i <= 4; i++) {
			num[cnt] = i;
			FindMax(cnt + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input_str = sc.next();
		expression = input_str.toCharArray();
		car_len = input_str.length();
		
		FindMax(0);
		
		System.out.println(ans);
		sc.close();
	}
}









































































