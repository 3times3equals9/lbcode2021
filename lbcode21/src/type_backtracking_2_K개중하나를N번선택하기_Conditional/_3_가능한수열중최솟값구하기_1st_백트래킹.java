package type_backtracking_2_K개중하나를N번선택하기_Conditional;

import java.util.ArrayList;
import java.util.Scanner;

public class _3_가능한수열중최솟값구하기_1st_백트래킹 {
	
	static final int NUM_LEN = 3;
	
	static int n;
	static ArrayList<Integer> series = new ArrayList<>(); 
	static int[] numbers = {4, 5, 6};
	
	// 시작과 끝 인덱스가 주어진 두 수열이 동일한지 여부를 판별합니다.
	static boolean IsEqual(int start1, int end1, int start2, int end2) {
	    for(int i = 0; i <= end1 - start1; i++) {
	        if(series.get(start1 + i) != series.get(start2 + i))
	            return false;
	    }

	    return true;
	}

	// 가능한 수열인지 여부를 판별합니다.
	static boolean IsPossibleSeries() {
	    // 수열의 가장 앞부터 각 인덱스가 시작점일 때
	    // 인접한 연속 부분 수열이 동일한 경우가 있는지를 탐색합니다.
	    for(int idx = 0; idx < (int) series.size(); idx++) {
	        // 가능한 연속 부분 수열의 길이 범위를 탐색합니다.
	        int len = 1;
	        while(true) {
	            // 연속 부분 수열의 시작과 끝 인덱스를 설정하여 줍니다.
	            int start1 = idx, end1 = idx + len - 1;
	            int start2 = end1 + 1, end2 = start2 + len - 1;

	            // 두번째 연속 부분 수열의 끝 인덱스가 범위를 넘어가면 탐색을 종료합니다.
	            if(end2 >= (int) series.size())
	                break;

	            // 인접한 연속 부분 수열이 같은지 여부를 확인합니다.
	            if(IsEqual(start1, end1, start2, end2))
	                return false;

	            len++;
	        }
	    }

	    return true;
	}
	
	static void FindMinSeries(int cnt) {
	    // n개의 숫자가 선택됐을 때 불가능한 수열인 경우 탐색을 종료합니다.
	    // 가능한 수열인 경우 이를 출력하고 프로그램을 종료합니다.
	    if(cnt == n) {
	        if(!IsPossibleSeries())
	            return;

	        for(int i = 0; i < series.size(); i++)
	            System.out.print(series.get(i));
	        System.exit(0);
	    }

	    // 사용 가능한 각 숫자가 뽑혔을 때의 경우를 탐색합니다.
	    for(int i = 0; i < NUM_LEN; i++) {
	        series.add(numbers[i]);
	        FindMinSeries(cnt + 1);
	        int len = series.size();
	        series.remove(len-1);
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		FindMinSeries(0);
		sc.close();
	}
}

/*Intuition
Backtracking을 활용하여 길이가 n인 수열의 순서쌍을 탐색해줍니다. 사전순으로 앞선 것 부터 순서쌍이 만들어지게 하기 위해 사용 가능한 숫자 중 가장 작은 숫자부터 순회하며, 각 숫자를 해당 순서에 뽑았을 때 만들 수 있는 수열을 탐색합니다. 특정 시점에 뽑힌 숫자의 개수를 인자로 설정하여 n개의 숫자를 모두 뽑았을 때 문제의 조건을 처음으로 만족하는 수열을 출력하고 프로그램을 종료합니다.

Algorithm
문제에서 사용 가능하다고 주어진 4, 5, 6을 순서대로 순회하며 해당 순서에 각 숫자를 뽑았을 때 만들 수 있는 수열을 탐색합니다. 이와 같은 순서로 순회를 하면 사전순으로 앞선 수열부터 만들어지게 되며, 문제에서 사전순으로 가장 앞선 가능한 수열을 출력하라고 하였으므로 가장 처음 조건을 만족하는 수열을 출력한 뒤에 프로그램을 종료해주면 됩니다.

이를 위한 재귀 함수는 ‘특정 시점까지 cnt개의 숫자를 뽑았을 때 그 다음 어떤 숫자를 뽑을 지를 선택’하도록 FindMinSeries(int cnt)를 정의해줍니다. Backtracking을 시작할 때는 아직까지 뽑은 숫자가 없다는 의미로 cnt=0을 인자로 넘겨서 첫 번째 숫자를 선택할 수 있도록 만들어 줍니다.

위와 같이 backtracking을 하는 과정에서 특정 시점에 뽑힌 숫자들을 저장하기 위해서 배열을 활용하며, n개의 숫자를 모두 뽑으면 배열에 저장된 순열이 문제의 조건을 만족하는지 여부를 확인해줍니다. 문제에서 명시한 조건인 인접한 연속 부분 수열이 동일한 경우가 있는지를 확인하기 위해서, 수열의 가장 앞부터 각 인덱스가 시작점일 때를 탐색해주어야 합니다. 이 때 가능한 연속 부분 수열의 길이 범위에 대하여 하나라도 인접한 연속 부분 수열이 동일한 경우, 조건을 충족하지 못한 수열이라고 판별할 수 있습니다. 아래의 그림에서 65454 라는 수열이 조건을 충족하지 못하는 수열임을 판별하는 과정을 확인할 수 있습니다.

*/





































































