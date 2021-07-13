package type_basic_1_단순반복문;

import java.util.Scanner;

public class _3_약수의개수가3개인수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start, end;
		int answer_cnt = 0;
		
		start = sc.nextInt();
		end = sc.nextInt();
		
		for(int curr_num = start; curr_num <= end; curr_num++) {
			//step1
			int divisor_cnt = 0;
			for(int divisor = 1; divisor <= curr_num; divisor++) {
				if(curr_num % divisor == 0) {
					divisor_cnt++;
				}
			}
			
			//case1
			if(divisor_cnt == 3) {
				answer_cnt++;
			}
		}
		
		System.out.println(answer_cnt);
		sc.close();
	}
}

























