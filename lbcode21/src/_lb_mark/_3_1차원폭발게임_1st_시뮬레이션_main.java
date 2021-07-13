package _lb_mark;

import java.util.Scanner;

public class _3_1차원폭발게임_1st_시뮬레이션_main {
	
	static int n, m, end_of_array, end_of_temp;
	static int[] numbers;
	static int[] temp;
	
	// 주어진 시작점에 대하여 
	// 부분 수열의 끝 위치를 반환합니다.
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
	
	// 터져야 할 폭탄들에 대해 터졌다는 의미로 0을 채워줍니다.
	static void FillZero(int start_idx, int end_idx) {
	    for(int i = start_idx; i <= end_idx; i++) {
	        numbers[i] = 0;
	    }
	}
	
	// Arr에서 폭탄이 터진 이후의 결과를 Temp에 임시로 저장합니다. 
	static void MoveToTemp() {
		temp = new int[n];
	    end_of_temp = 0;
	    
	    for(int i = 0; i < end_of_array; i++) {
	        if(numbers[i] != 0) {
	        	temp[end_of_temp++] = numbers[i];
	        }
	    }
	}
	
	// Temp배열을 그대로 Copy하여 Arr에 저장합니다.
	static void Copy() {
	    end_of_array = end_of_temp;
	    for(int i = 0; i < end_of_array; i++) {
	        numbers[i] = temp[i];
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력: 
		/**
		static 변수인데... 여기서 이상하게 해가지고 오류남
		같은 이름으로 선언해서 새로 초기화 하면 안됨여
		static 변수 주의!!!
		 * */
//		int n = sc.nextInt();
//		int m = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();		
		
		numbers = new int[n];
		for(int i = 0; i < n; i++)
			numbers[i] = sc.nextInt();
		
		end_of_array = n;
		
		boolean did_explode;
		do {
	        did_explode = false;
	        for(int curr_idx = 0; curr_idx < end_of_array; curr_idx++) {  
				// 각 위치마다 그 뒤로 폭탄이 m개 이상 있는지 확인합니다.
				
				// 이미 터지기로 예정되어있는 폭탄은 패스합니다.
	            if(numbers[curr_idx] == 0) { 
	                continue;
	            }
	            // curr_idx로부터 연속하여 같은 숫자를 갖는 폭탄 중 
				// 가장 마지막 위치를 찾아 반환합니다.
	            int end_idx = GetEndIdxOfExplosion(curr_idx, numbers[curr_idx]);

	            if(end_idx - curr_idx + 1 >=  m) {
	                // 연속한 숫자의 개수가 m개 이상인 경우 폭탄이 터졌음을 기록해줍니다.
	                FillZero(curr_idx, end_idx);
	                did_explode = true;
	            }
	        }
			// Arr에서 폭탄이 터진 이후의 결과를 Temp에 임시로 저장합니다. 
	        MoveToTemp();
			// Temp배열을 그대로 Copy하여 Arr에 저장합니다.
	        Copy();       
	    }
	    while(did_explode); // 더 이상 폭탄이 터질 수 없을 때까지 반복합니다.
		
		System.out.println(end_of_array);
		
		for(int i = 0; i < end_of_array; i++)
			System.out.println(numbers[i]);
			
		sc.close();
	}
}









































































