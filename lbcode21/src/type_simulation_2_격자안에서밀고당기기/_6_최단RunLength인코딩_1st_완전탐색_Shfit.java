package type_simulation_2_격자안에서밀고당기기;

import java.util.Scanner;

public class _6_최단RunLength인코딩_1st_완전탐색_Shfit {
	
	static String RunLengthEncoding(String input){
	    // 이 함수는 input 문자열을 Run-Length-Encoding한 결과를 반환합니다.
		String encoded = "";

	    // 입력의 첫번째 값을 읽고 초기화합니다.
	    char curr_char = input.charAt(0);
	    int num_char = 1;
	    for(int i = 1; i < input.length(); i++){
	        if(input.charAt(i) == curr_char)
	            num_char++;
	        else {
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
		
		int min_length = RunLengthEncoding(A).length(); // 초기값은 shift안했을 때의 값
	    int n = A.length();
	    int num_shift = n - 1; // 0부터 length - 1
	    
	    while(num_shift-- > 0){
	    	char[] ch_arr = A.toCharArray();
	        // 문자열 A를 오른쪽으로 1번 shift합니다.
	        // 오른쪽부터 채워넣어야하며, 마지막 값은 temp에 저장된 값을 사용해야함을 유의합니다.
	        char temp = ch_arr[n - 1];
	        for(int i = n - 1; i >= 1; i--){
	        	ch_arr[i] = ch_arr[i - 1];
	        }
	        ch_arr[0] = temp;
	        
	        A = new String(ch_arr);
	        int length = RunLengthEncoding(A).length();
	        if(min_length > length)
	            min_length = length;
	    }
	    
	    System.out.println(min_length);
		sc.close();
	}
}









































































