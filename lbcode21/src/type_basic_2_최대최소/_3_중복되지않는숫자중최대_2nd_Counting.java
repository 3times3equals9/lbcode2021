package type_basic_2_최대최소;

import java.util.Scanner;

public class _3_중복되지않는숫자중최대_2nd_Counting {
	
	static final int MAX_N = 1000; // 입력값 N의 최댓값
	static final int MAX_NUM = 1000; // 원소의 최댓값
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n;
		int[] nums = new int[MAX_N];
	    // count 배열을 0으로 초기화
	    // 편의상 배열의 index가 실제 숫자를 나타내도록 하기 위해
	    // MAX_NUM+1개의 공간을 갖는 배열로 선언합니다.
	    int[] count = new int[MAX_NUM + 1];

	    // 입력
	    n = sc.nextInt();
	    for(int i = 0; i < n; i++)
	        nums[i] = sc.nextInt();

	    // step1. count 배열에 수의 등장 빈도를 셉니다.
	    for(int i = 0; i < n; i++)
	        count[nums[i]]++;

	    // step2. 큰 수부터 체크하며 한 번 등장한 최대의 값을 찾습니다.
	    int answer = -1;
	    for(int max_candidate = MAX_NUM; max_candidate >= 0; max_candidate--) {
	        if(count[max_candidate] == 1) {
	            answer = max_candidate;
	            break;
	        }
	    }

	    System.out.println(answer);
		
		sc.close();
	}
}
