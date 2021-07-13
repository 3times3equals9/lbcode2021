package type_basic_3_문자열다루기;

import java.util.Scanner;

public class _3_문자열계속지우기_1st_String_main {
	
	public static int find(String source, String target) {
	    // source문자열에서 target문자열이 처음 등장하는 위치를 반환합니다.

	    // Tip1: 우리는 i, i+1, ..., i+target.length()-1을 비교할 것입니다.
	    // 이 때 마지막 위치는 i+target.length()-1 < source.length()를 만족해야
	    // 하므로 i < source.length() - target.length() + 1을 구할 수 있습니다.

	    // Tip2: length는 size_t형이므로 int로 변환해야 음수 값을 처리할 수 있습니다.
	    int candidates = source.length() - target.length() + 1;
	    for(int i = 0; i < candidates; i++) {
	        // i부터 target길이만큼 비교해서 target과 같은지 체크합니다.
	        boolean is_same = true;
	        for(int j = 0; j < target.length(); j++) {
	            if(source.charAt(i + j) != target.charAt(j)) {
	                is_same = false;
	                break;
	            }
	        }
	        if(is_same) {
	            // 문자열을 찾았으므로 i 반환
	            return i;
	        }
	    }
	    return -1; // 찾지 못한 경우
	}
	
	public static String erase(String source, int pos, int count) {
	    // source문자열에서 pos위치에서 count개수만큼의 문자를 지운 문자열을 반환합니다.
		String erased_source = "";
	    // 원래길이 - count만큼의 공간을 사용합니다.
	    int output_length = source.length() - count;
	    
	    //아래는 C++ 함수, 자바는 안해도 됨
	    //erased_source.reserve(output_length);
	    
	    for(int i = 0; i < output_length; i++) {
	        if(i < pos) {
	            // pos 이전이므로 그대로 사용합니다.
	            erased_source += source.charAt(i);
	        } else{
	            // count만큼 건너뛴 위치를 사용해줍니다.
	            erased_source += source.charAt(i+count);
	        }
	    }
	    return erased_source;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A, B;
		A = sc.next();
		B = sc.next();
		
		while(find(A, B) != -1) {
			A = erase(A, find(A, B), B.length());
		}
		
		System.out.println(A);
		sc.close();
	}
}









































































