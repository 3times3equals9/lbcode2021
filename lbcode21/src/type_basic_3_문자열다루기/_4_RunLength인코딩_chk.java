package type_basic_3_문자열다루기;

import java.util.Scanner;

public class _4_RunLength인코딩_chk {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input_str = sc.next();
		int str_len = input_str.length();
		
		int ans_len = 0;
		String ans_str = "";
		
		int cnt = 1;
		char curr = input_str.charAt(0);
		for(int i=1; i<str_len; i++) {
			if(curr == input_str.charAt(i)) {
				cnt++;
			} else {
				//세던거랑 다르면
				//답 문자열에 추가
				ans_str = ans_str + curr + cnt;
				//갱신
				curr = input_str.charAt(i);
				cnt = 1;
			}
		}
		
		//맨 마지막에 센거 추가해줘야함
		ans_str = ans_str + curr + cnt;
		ans_len = ans_str.length();
		
		System.out.println(ans_len);
		System.out.println(ans_str);
		sc.close();
	}
}









































































