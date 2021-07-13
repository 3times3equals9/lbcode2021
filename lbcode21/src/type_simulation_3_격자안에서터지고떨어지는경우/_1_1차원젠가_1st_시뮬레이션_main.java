package type_simulation_3_격자안에서터지고떨어지는경우;

import java.util.Scanner;

public class _1_1차원젠가_1st_시뮬레이션_main {
	
	static int n, end_of_array;
	static int[] numbers;
	
	// 입력 배열에서 지우고자 하는 부분 수열을 삭제합니다.
	static void CutArray(int start_idx, int end_idx) {
	    int[] temp_arr = new int[n];
	    int end_of_temp_array = 0;
	    
	    // 구간 외의 부분만 temp 배열에 순서대로 저장합니다.
	    for(int i = 0; i < end_of_array; i++)
	        if(i < start_idx || i > end_idx)
	            temp_arr[end_of_temp_array++] = numbers[i];
	    
	    // temp 배열을 다시 numbers 배열로 옮겨줍니다.
	    for(int i = 0; i < end_of_temp_array; i++)
	        numbers[i] = temp_arr[i];
	    
	    end_of_array = end_of_temp_array;
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









































































