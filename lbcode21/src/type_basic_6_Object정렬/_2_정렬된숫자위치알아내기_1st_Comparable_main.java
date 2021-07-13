package type_basic_6_Object정렬;

import java.util.Arrays;
import java.util.Scanner;

public class _2_정렬된숫자위치알아내기_1st_Comparable_main {
	
	static class Number implements Comparable<Number>{
		public int number;
		public int index;
		public Number(int number, int index) {
			this.number = number;
			this.index = index;
		}
		@Override
		public int compareTo(Number o) {
			if(this.number != o.number) {
				return this.number - o.number;
			} else {
				return this.index - o.index;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 변수 선언:
		int n, num_cache;
		n = sc.nextInt();
		
	    int[] answer = new int[n];
	    Number[] numbers = new Number[n];
	    
	    // 입력:
	    for(int i=0; i<n; i++) {
	    	num_cache = sc.nextInt();
	    	numbers[i] = new Number(num_cache, i);
	    }
	    
	    // Comparable, Arrays.sort 를 활용한 정렬:
	    Arrays.sort(numbers);
	    
	    // 정렬된 숫자들의 원래 인덱스를 활용한 정답 배열 저장:
	    for(int i = 0; i < n; i++) 
	        answer[numbers[i].index] = i + 1; // 인덱스 보정
	    
	    // 출력:
	    for(int i = 0; i < n; i++){
	    	System.out.print(answer[i] + " ");
	    }
		sc.close();
	}
}









































































