package type_basic_3_문자열다루기;

import java.util.Scanner;

public class _4_RunLength인코딩_1st_String_main {
	
	public static String RunLengthEncoding(String input){
	    // 이 함수는 input 문자열을 Run-Length-Encoding한 결과를 반환합니다.
		String encoded = "";

	    // 입력의 첫번째 값을 읽고 초기화합니다.
	    char curr_char = input.charAt(0);
	    int num_char = 1;
	    for(int i = 1; i < input.length(); i++){
	        if(input.charAt(i) == curr_char){
	            num_char++;
	        } else {
	            // 지금까지 세어온 curr_char와 num_char를 기록합니다.
	            encoded += curr_char;
	            encoded += num_char;
	            // curr_char와 num_char를 현재 값으로 초기화합니다.
	            curr_char = input.charAt(i);
	            num_char = 1;
	        }
	    }
	    // 마지막 덩어리에 해당하는 curr_char와 num_char를 기록합니다.
	    encoded += curr_char;
	    encoded += num_char;
	    return encoded;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		
		//변환
		String encoded = RunLengthEncoding(A);
		
		System.out.println(encoded.length());
		System.out.println(encoded);
		
		sc.close();
	}
}









































































