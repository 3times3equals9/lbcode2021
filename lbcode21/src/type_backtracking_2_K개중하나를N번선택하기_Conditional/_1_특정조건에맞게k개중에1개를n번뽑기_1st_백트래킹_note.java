package type_backtracking_2_K개중하나를N번선택하기_Conditional;

import java.util.ArrayList;
import java.util.Scanner;

public class _1_특정조건에맞게k개중에1개를n번뽑기_1st_백트래킹_note {
	
	static int n, k;
	static ArrayList<Integer> selected_nums = new ArrayList<>();
	
	// 선택된 원소들을 출력해줍니다.
	static void PrintPermutation() {
	    for(int i = 0; i < (int) selected_nums.size(); i++)
	    	System.out.print(selected_nums.get(i) + " ");
	    System.out.println();
	}
	
	static void FindConditionalPermutation(int cnt) {
	    // n개를 모두 뽑은 경우 답을 출력해줍니다.
	    if(cnt == n) {
	        PrintPermutation();
	        return;
	    }

	    for(int i = 1; i <= k; i++) {
	        if(cnt >= 2 && i == selected_nums.get(cnt - 1) &&
	                i == selected_nums.get(cnt - 2)) 
	            continue;
	        else {
	            selected_nums.add(i);
	            FindConditionalPermutation(cnt + 1);
	            int tmp_len = selected_nums.size();
	            selected_nums.remove(tmp_len-1);
	        }
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();
		
		FindConditionalPermutation(0);
		sc.close();
	}
}

/*
Intuition
Backtracking을 활용하여 가능한 모든 순서쌍을 탐색합니다. 특정 시점에 뽑힌 숫자의 개수를 인자로 설정하여 m개의 숫자를 모두 뽑았을 때마다 출력해줍니다. 또한 사전순으로 앞선 것 부터 순서쌍이 만들어지게 하기 위해 사용 가능한 숫자 중 가장 작은 숫자부터 순회하며, 각 숫자를 해당 순서에 뽑았을 때 만들 수 있는 순열을 탐색합니다. 단, 문제에서 주어진 조건을 만족하지 않는 경우 탐색하는 과정에서 제외해주는 방식으로 원하는 답만 출력할 수 있도록 합니다.

Algorithm
1부터 K 사이의 숫자들을 순서대로 순회하며 해당 순서에 각 숫자를 뽑았을 때 만들 수 있는 순열을 탐색합니다. 이를 위한 재귀 함수는 ‘특정 시점까지 cnt개의 숫자를 뽑았을 때 그 다음 어떤 숫자를 뽑을 지를 선택’하도록 FindConditionalPermutation(int cnt)를 정의해줍니다. Backtracking을 시작할 때는 아직까지 뽑은 숫자가 없다는 의미로 cnt=0을 인자로 넘겨서 첫 번째 숫자를 선택할 수 있도록 만들어 줍니다.

위와 같이 backtracking을 하는 과정에서 특정 시점에 뽑힌 숫자들을 저장하기 위해서 배열을 활용할 수 있습니다. 특정 숫자를 뽑으려고 할 때 배열의 끝에 위치한 두 원소와 해당 숫자가 동일한 지를 판별하면 연속하여 같은 숫자가 3번 이상 나오는지를 알아낼 수 있습니다. 이러한 경우를 탐색하는 과정에서 제외 해주면 문제의 조건을 만족하는 답을 출력할 수 있습니다.
*/

/**
아래의 함수에서 cnt >= 2라는 조건이 빠지면 안되나요?

만약 cnt >= 2라는 조건이 빠지게 되면 해당 시점에 뽑힌 숫자가 두 개 미만인 경우 존재하지 않은 인덱스에 접근하게 되기 때문에 런타임 에러가 발생하게 됩니다. 이러한 에러를 방지하기 위해서 필수적으로 해당 조건을 적어주어야 합니다.

void FindConditionalPermutation(int cnt) {
    ...

    for(int i = 1; i <= k; i++) {
        if(cnt >= 2 && i == selected_nums[cnt - 1] &&
                i == selected_nums[cnt - 2]) 
            continue;
        ...
        }
    }
}
*/






























































