package type_backtracking_1_K개중하나를N번선택하기_Simple;

import java.util.ArrayList;
import java.util.Scanner;

public class _2_아름다운수_1st_백트래킹 {
	
	static int n;
	static int ans;
	static ArrayList<Integer> seq = new ArrayList<>();
	
	static boolean IsBeautiful() {
	    // 연달아 같은 숫자가 나오는 시작 위치를 잡습니다.
		for(int i = 0; i < n; i += seq.get(i)) {
	        // 만약 연속하여 해당 숫자만큼 나올 수 없다면
	        // 아름다운 수가 아닙니다.
			if(i + seq.get(i) - 1 >= n)
	            return false;
	        // 연속하여 해당 숫자만큼 같은 숫자가 있는지 확인합니다.
	        // 하나라도 다른 숫자가 있다면
	        // 아름다운 수가 아닙니다.
	        for(int j = i; j < i + seq.get(i); j++)
	            if(seq.get(j) != seq.get(i))
	                return false;
		}
		return true;
	}
	
	static void CountBeautifulSeq(int cnt) {
		if(cnt == n) {
			if(IsBeautiful())
				ans++;
			return;
		}
		
		for(int i = 1; i <= 4; i++) {
			seq.add(i);
			CountBeautifulSeq(cnt + 1);
			int list_length = seq.size();
			seq.remove(list_length-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		CountBeautifulSeq(0);
		
		System.out.println(ans);
		sc.close();
	}
}

/*
Intuition
한번에 아름다운 수를 만들어 내지 않고, 1-4 사이의 숫자로만 이루어진 모든 숫자를 만들어 낸 뒤 그 중 아름다운 수의 수를 세는 것이 구현상 더 편리합니다.

Algorithm
각 자리에 대해 1~4 사이의 숫자 중 하나를 선택하여 총 N번 선택하는 재귀를 작성하여 가능한 모든 숫자들을 만들어냅니다. 그 중 정확히 해당 숫자만큼 연달아 같은 숫자가 나오는 숫자의 수를 세면 됩니다.
 */







































































