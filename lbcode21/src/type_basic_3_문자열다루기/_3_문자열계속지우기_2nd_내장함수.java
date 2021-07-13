package type_basic_3_문자열다루기;

import java.util.Scanner;

public class _3_문자열계속지우기_2nd_내장함수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A, B;
		A = sc.next();
		B = sc.next();
		
		// A에서 B를 찾습니다, 찾을 수 없을 때까지 반복합니다.
	    while(A.indexOf(B) != -1){
	        int start_pos = A.indexOf(B);
	        // start_pos부터 B.length()개의 문자를 지웁니다.
	        String tmp1 = A.substring(0, start_pos);
	        int tmp_len = A.length();
	        String tmp2 = A.substring(start_pos + B.length(), tmp_len);
	        //A.erase(start_pos, B.length());
	        A = tmp1 + tmp2;
	    }
		
	    System.out.println(A);
		sc.close();
	}
}









































































