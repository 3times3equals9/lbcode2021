package _lb_mark;

import java.util.Scanner;

public class _3_1차원폭발게임_3rd_시뮬레이션_Mem_Time_최적화 {
	
	static int n, m, end_of_array;
	static int[] numbers;
	
	static int GetEndIdxOfExplosion(int start_idx, int curr_num) {
	    int end_idx = start_idx + 1;
	    while(end_idx < end_of_array) {
	        if(numbers[end_idx] == curr_num)
	            end_idx++;
	        else{
	            break;
	        }
	    }

	    return end_idx - 1;
	}
	
	static void CutArray(int start_idx, int end_idx) {
	    int cut_len = end_idx - start_idx + 1;
	    for(int i = end_idx + 1; i < end_of_array; i++) {
	        numbers[i - cut_len] = numbers[i];
	    }
	    
	    end_of_array -= cut_len;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력:
		n = sc.nextInt();
		m = sc.nextInt();
		
		numbers = new int[n];
		for(int i = 0; i < n; i++)
	        numbers[i] = sc.nextInt();
	    
		end_of_array = n;

		boolean did_explode;
	    int curr_idx;
	    
	    do {
	        did_explode = false;
	        curr_idx = 0;

	        while(curr_idx < end_of_array) {
	            int end_idx = GetEndIdxOfExplosion(curr_idx, numbers[curr_idx]);

	            if(end_idx - curr_idx + 1 >=  m) {
	                // 연속한 숫자의 개수가 m개 이상이면
	                // 폭탄이 터질 수 있는 경우 해당 부분 수열을 잘라내고
	                // 폭탄이 터졌음을 기록해줍니다.
	                CutArray(curr_idx, end_idx);
	                did_explode = true;
	            }
	            else {
	                // 폭탄이 터질 수 없는 경우 
	                // 순회할 필요가 없는 원소에 대한 탐색을 생략해줍니다.
	                curr_idx = end_idx + 1;
	            }
	        }
	    }
	    while(did_explode); 
		
		System.out.println(end_of_array);

		for (int i = 0; i < end_of_array; i++)
			System.out.println(numbers[i]);
		
		sc.close();
	}
}









































































