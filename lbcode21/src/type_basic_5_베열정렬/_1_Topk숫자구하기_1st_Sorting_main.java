package type_basic_5_베열정렬;

import java.util.Arrays;
import java.util.Scanner;

public class _1_Topk숫자구하기_1st_Sorting_main {
	
	//static final int MAX_N = 1000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 변수 선언 및 입력:
	    int n, k;
	    n = sc.nextInt();
	    k = sc.nextInt();
	    
	    int[] nums = new int[n];
		
	    for(int i=0; i < n; i++){
	        nums[i] = sc.nextInt();
	    }
	    
	    // nums[0]부터 nums[n - 1]까지를 정렬함
	    Arrays.sort(nums);
	    
	    // k번째 원소를 출력 (원소 k-1)
	    System.out.println(nums[k-1]);
	    
		sc.close();
	}
}









































































