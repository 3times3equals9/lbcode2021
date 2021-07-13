package type_backtracking_3_N개중에M개고르기_Simple;

import java.util.ArrayList;
import java.util.Scanner;

public class _1_n개중에m개뽑기_백트래킹_방법2_main {
	
	static final int MAX_NUM = 10;
	static int n, m;
	static ArrayList<Integer> combination = new ArrayList<>();
	
	// 방문한 원소들을 출력해줍니다.
	static void PrintCombination() {
	    for(int i = 0; i < combination.size(); i++)
	    	System.out.print(combination.get(i) + " ");
	    System.out.println();
	}
	
	// 지금까지 뽑은 갯수와 뽑을지 말지를 결정할 숫자를 인자로 받습니다. 
	static void FindCombination(int curr_num, int cnt) {

	    // n개의 숫자를 모두 탐색했으면 더 이상 탐색하지 않습니다.
	    if(curr_num == n+1) {
	        // 탐색하는 과정에서 m개의 숫자를 뽑은 경우 답을 출력해줍니다.
	        if(cnt == m)
	            PrintCombination();
	        return;
	    }

	    // curr_num에 해당하는 숫자를 사용했을 때의 경우를 탐색합니다.
	    combination.add(curr_num);
	    FindCombination(curr_num + 1, cnt + 1);
	    int len = combination.size();
	    combination.remove(len-1);

	    // curr_num에 해당하는 숫자를 사용하지 않았을 때의 경우를 탐색합니다.
	    FindCombination(curr_num + 1, cnt);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		n = sc.nextInt();
		m = sc.nextInt();
		
		FindCombination(1, 0);
		sc.close();
	}
}


/*
1. Solution1의 main함수에서 for문 없이 재귀함수를 한 번만 호출하여 해결할 수는 없나요?

가능합니다. for문을 사용하지 않고 FindCombination(0, 0)만 호출해줘도 동일한 결과를 얻을 수 있습니다. 함수의 정의상 다소 이상하게 느껴질 수도 있지만, 아직 선택된 원소가 없고, 0 다음부터 선택을 시작하면 된다는 의미로 받아들일 수 있습니다.

int main() {
    cin >> n >> m;

    // 아직 선택된 원소가 없고, 
    // 0 보다 큰 숫자부터 선택을 시작하면 된다.
    FindCombination(0, 0);

    return 0;
}
2. Solution2에서 m개가 만들어졌을 때 바로 종료하는 식으로 작성할 수는 없나요?

가능합니다. FindCombination의 조건문을 아래와 같이 바꿔주면 동일한 결과를 얻을 수 있습니다.

 void FindCombination(int curr_num, int cnt) {
    if(cnt == m)
        PrintCombination();

    if(curr_num == n+1)
        return;
    ...
}
이 때 유의해야할 점은, 두 if문의 위치가 뒤바뀌게 되면 제일 마지막 원소를 골랐을 때에 대한 조합을 출력할 수 없어 틀린 답을 얻게 됩니다.

이렇게 재귀함수에서 if 문을 여러 개를 적게 되는 경우, 논리적으로 if 문의 순서를 어떻게 배치해야 할 지를 유의해야 합니다.
*/






































































