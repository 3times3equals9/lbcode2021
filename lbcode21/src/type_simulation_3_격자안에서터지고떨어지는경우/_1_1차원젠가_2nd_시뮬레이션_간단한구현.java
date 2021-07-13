package type_simulation_3_격자안에서터지고떨어지는경우;

import java.util.Scanner;

public class _1_1차원젠가_2nd_시뮬레이션_간단한구현 {
	
	static int n, end_of_array;
	static int[] numbers;
	
	// 입력 배열에서 지우고자 하는 부분 수열을 삭제합니다.
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
		numbers = new int[n];
		for(int i = 0; i < n; i++)
			numbers[i] = sc.nextInt();
	    
	    end_of_array = n;
		
	    // 두 번에 걸쳐 지우는 과정을 반복합니다.
		for(int k = 0; k < 2; k++) {
			int s, e;
			s = sc.nextInt();
			e = sc.nextInt(); 
	    	s--; 
	    	e--;
	        // [s, e] 구간을 삭제합니다.
	        CutArray(s, e);
		}
		
	    // 출력:
		System.out.println(end_of_array);
		for(int i = 0; i < end_of_array; i++)
			System.out.println(numbers[i]);
			
		sc.close();
	}
}









































































