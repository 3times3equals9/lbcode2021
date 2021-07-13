package type_basic_3_문자열다루기;

import java.util.Scanner;

public class _2_부분문자열위치구하기_1st_BruteForce_main {
	
	static String input_str, target_str;
	
	// input_str의 s_idx1에서 e_idx1 까지의 문자열과
	// output_str의 s_idx2에서 e_idx2 까지의 문자열과 일치하는지를 비교합니다.
	public static boolean IsMatch(int s_idx1, int e_idx1, int s_idx2, int e_idx2) {
		for (int i = s_idx1, j = s_idx2; i <= e_idx1 && j <= e_idx2; i++, j++) {
			if (input_str.charAt(i) != target_str.charAt(j))
				return false;
		}

		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		input_str = sc.next();
		target_str = sc.next();

	    int input_len = input_str.length();
	    int target_len = target_str.length();

	    // 입력 문자열의 각 문자를 시작점으로 하여 목적 문자열을 만들 수 있는지 확인합니다.
	    for(int i = 0; i < input_len; i++) {
	        // input_str의 i 부터 i + target_len - 1까지의 원소가
	        // target_len의 0부터 target_len - 1 까지의 원소와
			// 정확히 일치하는지 확인합니다.
	        
	        // 만약 input_str의 끝 원소인 i + target_len - 1 번째가
			// 존재하지 않는다면 비교를 하지 않습니다.
	        if(i + target_len - 1 >= input_len)
	            continue;
	        
	        if(IsMatch(i, i + target_len - 1, 0, target_len - 1)) {
	            // 모든 문자에 대하여 매칭이 된 경우:
	            System.out.println(i);
	            System.exit(0);
	        }
	    }

	    // 매칭이 되지 않는 경우:
	    System.out.println(-1);
		
		sc.close();
	}
}

/*
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		String pcs = sc.nextLine();
		int k = tmp.indexOf(pcs);
		System.out.println(k);
		sc.close();
	}
}
*/






































































