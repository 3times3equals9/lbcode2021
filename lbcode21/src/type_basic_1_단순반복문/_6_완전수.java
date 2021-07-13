package type_basic_1_단순반복문;

import java.util.Scanner;

public class _6_완전수 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start, end;
	    int answer_cnt = 0;
	    start = sc.nextInt();
	    end = sc.nextInt();
	    
	    for(int curr_num = start; curr_num <= end; curr_num++) {
	        // Step 1:
	        int divisor_sum = 0;
	        for(int divisor = 1; divisor <= curr_num-1; divisor++){
	            if(curr_num % divisor == 0){
	                divisor_sum += divisor;
	            }
	        }
	        // Case 1:
	        if(divisor_sum == curr_num){
	            answer_cnt++;
	        }
	    }
		
	    System.out.println(answer_cnt);
		sc.close();
	}
}

























