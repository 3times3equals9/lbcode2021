package type_basic_5_베열정렬;

import java.util.Arrays;
import java.util.Scanner;

public class _2_2개씩그룹짓기_1st_Sorting_Observation_main {
	
	//static final int MAX_N = 1000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n;
		n = sc.nextInt();
		
		int[] nums = new int[2*n];
		
		for(int i = 0; i < 2 * n; i++)
	        nums[i] = sc.nextInt();
		
		// nums[0]부터 nums[2n - 1]까지를 정렬함
		Arrays.sort(nums);
		
		int group_max = 0;
		for(int i = 0; i < n; i++) {
	        // i번째와 2n - 1 - i번째 원소를 매칭
	        int group_sum = nums[i] + nums[2*n - 1 - i];
	        if(group_sum > group_max)
	            // 최댓값 갱신
	            group_max = group_sum;
	    }
		
		System.out.println(group_max);
		sc.close();
	}
}


/*
Intuition
관찰을 통해 최댓값은 최솟값과 묶는 것이 항상 최선임을 알 수 있습니다.

Algorithm
주어진 배열의 최댓값(=M)을 어떤 값과 그룹으로 묶어주는 것이 가장 좋을까요? 아마도 최솟값(=m)이라고 추측할 수 있을 것 입니다. 왜냐하면 만약 최댓값과 최솟값이 각각 다른 그룹에 배치된다고 생각해보면 [M, a], [m, b] 이렇게 그룹으로 만들어집니다. 이 때, M+a >= m+b 입니다 (M >= b, a >= m 이므로) 이 그룹들의 a와 m을 서로 바꿔서 [M, m], [a, b]로 만들면 M+m과 a+b라는 값이 최댓값이 될 수 있습니다. 하지만 두 값 모두 M+a보다는 작습니다.

따라서 배열의 최댓값은 최솟값과 그룹으로 묶어주는 것이 좋습니다. 이제 남은 배열의 값들도 마찬가지 논리로 남은 배열의 최대와 최소를 그룹으로 묶는게 좋습니다. 이러한 방식으로 모든 그룹을 만들었을 때가 최댓값이 최소가 될 것 입니다.
*/





































































