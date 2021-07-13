package type_simulation_2_격자안에서밀고당기기;

import java.util.Scanner;

public class _6_최단RunLength인코딩_chk {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input_str = sc.next();
		int limit = input_str.length();
		int len = input_str.length();
		
		int min = Integer.MAX_VALUE;
		
		char[] car = input_str.toCharArray();
		
		while(limit-- > 0) {
			//오른쪽 shift
			char tmp = car[len-1];
			for(int i = len-1; i>=1; i--) {
				car[i] = car[i-1];
			}
			car[0] = tmp;
			
			//run-length-encoding
			String ans_str = "";
			int cnt = 1;
			char curr = car[0];
			for(int i=1; i<len; i++) {
				if(curr == car[i]) {
					cnt++;
				} else {
					//세던거랑 다르면
					//답 문자열에 추가
					ans_str = ans_str + curr + cnt;
					//갱신
					curr = car[i];
					cnt = 1;
				}
			}
			//맨 마지막에 센거 추가해줘야함
			ans_str = ans_str + curr + cnt;
			int ans_len = ans_str.length();
			
			min = Math.min(min, ans_len);
		}
		
		System.out.println(min);
		sc.close();
	}
}









































































