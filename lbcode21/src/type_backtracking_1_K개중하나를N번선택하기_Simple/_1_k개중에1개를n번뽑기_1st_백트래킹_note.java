package type_backtracking_1_K개중하나를N번선택하기_Simple;

import java.util.ArrayList;
import java.util.Scanner;

public class _1_k개중에1개를n번뽑기_1st_백트래킹_note {
	
	static int k, n;
	static ArrayList<Integer> selected_nums = new ArrayList<>();
	
	// 선택된 원소들을 출력해줍니다.
	static void PrintPermutation() {
	    for(int i = 0; i < (int) selected_nums.size(); i++)
	    	System.out.print(selected_nums.get(i) + " ");
    	System.out.println();
	}
	
	static void FindDuplicatedPermutations(int cnt) {
	    // n개를 모두 뽑은 경우 답을 출력해줍니다.
	    if(cnt == n) {
	        PrintPermutation();
	        return;
	    }

	    // 1부터 k까지의 각 숫자가 뽑혔을 때의 경우를 탐색합니다.
	    for(int i = 1; i <= k; i++) {
	        selected_nums.add(i);
	        FindDuplicatedPermutations(cnt + 1);
	        int list_length = selected_nums.size();
	        selected_nums.remove(list_length-1);
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();
		
		FindDuplicatedPermutations(0);
		sc.close();
	}
}

/*
1. 아래의 함수에서 return이 없으면 어떻게 될까요?

문제에서 주어진 n개 이상의 숫자를 뽑더라도 계속해서 backtracking을 하게 되어 함수가 종료하지 않게 됩니다. (메모리 부족으로 프로그램이 종료되기 전까지 계속해서 탐색합니다.)

void FindDuplicatedPermutations(int cnt) {
    // n개를 모두 뽑은 경우 답을 출력해줍니다.
    if(cnt == n) {
        PrintPermutation();
        return;
    }   

    // 1부터 k까지의 각 숫자가 뽑혔을 때의 경우를 탐색합니다.
    for(int i = 1; i <= k; i++) {
        selected_nums.push_back(i);
        FindDuplicatedPermutations(cnt + 1); 
        selected_nums.pop_back();
    }   
}

*/




































































