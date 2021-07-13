package _lb_mark;

import java.util.ArrayList;
import java.util.Scanner;

public class _3_가능한수열중최솟값구하기_2ndt_백트래킹_커팅_main {
	
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
	    int len = 1;
	    while(true) {
	        // 연속 부분 수열의 시작과 끝 인덱스를 설정하여 줍니다.
	        int end1 = (int) series.size() - 1, start1 = end1 - len + 1;
	        int end2 = start1 - 1, start2 = end2 - len + 1;

	        if(start2 < 0)
	            break;

	        // 인접한 연속 부분 수열이 같은지 여부를 확인합니다.
	        if(IsEqual(start1, end1, start2, end2))
	            return false;

	        len++;
	    }

	    return true;
	}
	
	static void FindMinSeries(int cnt) {
		// n개의 숫자가 선택됐을 때 불가능한 수열인 경우 탐색을 종료합니다.
	    // 가능한 수열인 경우 이를 출력하고 프로그램을 종료합니다.
	    if(cnt == n) {
	        for(int i = 0; i < series.size(); i++)
	            System.out.print(series.get(i));
	        System.exit(0);
	    }

	    // 사용 가능한 각 숫자가 뽑혔을 때의 경우를 탐색합니다.
	    for(int i = 0; i < NUM_LEN; i++) {
	        series.add(numbers[i]);
	        // 해당 시점까지 만들 수열이 조건을 만족하는 경우에만
	        // 탐색을 진행합니다.
	        if(IsPossibleSeries())
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

/*
Intuition
Solution1에서는 n개의 숫자가 모두 선택됐을 때 비로소 해당 수열이 조건을 만족하는지 여부를 확인하였습니다. 인접한 연속 부분 수열이 동일한 경우가 있을 때, 그 뒤에 어떤 수열을 추가하여도 해당 수열은 조건을 만족할 수 없습니다. 이러한 성질을 이용하여 탐색을 하는 과정에서 조건을 만족하지 않는 경우 더 이상 탐색하지 않는 방식으로 불필요한 탐색을 줄일 수 있습니다. 비록 시간 복잡도가 바뀌지는 않지만 실제로는 훨씬 더 빠르게 답을 구할 수 있습니다.

Algorithm
Solution1과 함수의 정의와 대부분의 코드는 동일합니다. 다른 점이 있다면, n개의 숫자가 모두 선택 됐을 때 해당 수열이 조건을 만족하는지 여부를 확인하는 것이 아니라, 탐색하는 과정에서 만들어지는 모든 부분 수열에 대하여 조건을 만족하는지 여부를 확인한 뒤 만족하지 않는 경우 탐색을 종료한다는 점입니다. 예를 들어 아래의 그림과 같은 65454라는 수열의 경우 54가 연속하여 존재하므로 문제의 조건을 만족하지 않습니다. 해당 수열의 뒤에 어떤 수열을 추가하더라도 조건을 만족하도록 할 수 없으므로 추가적인 탐색은 의미가 없습니다.



이와 같은 방식으로 탐색을 하게 되면 길이가 L인 수열을 만들었을 때 1~L-1까지에 해당하는 숫자는 문제의 조건을 만족함을 보장할 수 있게 됩니다. 따라서 가능한 수열인지 여부를 판단하는 과정에서도 전체 수열을 앞에서부터 탐색할 필요없이 제일 마지막 숫자를 포함한 수열이 조건을 만족하는지 여부만 탐색해주면 됩니다.
*/





































































