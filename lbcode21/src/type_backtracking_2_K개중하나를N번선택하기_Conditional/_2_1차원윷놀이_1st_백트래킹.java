package type_backtracking_2_K개중하나를N번선택하기_Conditional;

import java.util.Scanner;

public class _2_1차원윷놀이_1st_백트래킹 {
	
	static final int MAX_N = 12;
	static final int MAX_K = 4;
	
	static int n, m, k;
	static int[] nums, pieces;
	static int ans;
	
	// 점수를 계산합니다.
	static int Calc() {
		int score = 0;
		for(int i = 0; i < k; i++)
			//score += (pieces[i] >= m);
			score += (pieces[i] >= m ? 1 : 0);
	    
		return score;
	}
	
	static void FindMax(int cnt) {
	    // 말을 직접 n번 움직이지 않아도
	    // 최대가 될 수 있으므로 항상 답을 갱신합니다.
	    ans = Math.max(ans, Calc());
	    
	    // 더 이상 움직일 수 없으면 종료합니다.
		if(cnt == n) 
			return;
		
		for(int i = 0; i < k; i++) {
	        // 움직여서 더 이득이 되지 않는
	        // 말은 더 이상 움직이지 않습니다.
	        if(pieces[i] >= m)
	            continue;
	        
			pieces[i] += nums[cnt];
			FindMax(cnt + 1);
			pieces[i] -= nums[cnt];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int nums[MAX_N], pieces[MAX_K];
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		nums = new int[n];
		pieces = new int[k];
		
		for(int i = 0; i < n; i++)
			nums[i] = sc.nextInt();
		
		for(int i = 0; i < k; i++)
			pieces[i] = 1;
		
		FindMax(0);
		System.out.println(ans);
		sc.close();
	}
}

/*
Intuition
N번의 턴에 대해 각 턴마다 K개 중 어떤 말을 움직일 것인지를 선택하는 재귀함수를 작성합니다. 이때, 이미 점수를 획득한 말을 움직이지 않으면 총 탐색 시간을 줄일 수 있습니다.

Algorithm
Backtracking을 이용하면 각 턴마다 어떤 말을 움직일지에 대해 모든 조합을 만들어볼 수 있습니다. 이 각각의 조합에 대해 점수를 계산한 후 그 중 최대를 출력하면 됩니다.

다만, 이미 점수를 획득한 말의 경우에는 굳이 다시끔 선택해줘야 할 필요가 없으므로 말 선택시 이를 제외시켜주는 것이 좋습니다. 하지만 이렇게 진행하게 되면 n번의 턴을 다 끝마치지 못하고 최대 점수를 얻는 경우도 생기게 되므로 꼭 모든 턴에 대해 점수를 계산하여 그 중 최댓값을 계산해야만 함에 유의합니다.
*
*
*/





































































