package type_basic_3_문자열다루기;

import java.util.Scanner;

public class _1_문자열한칸씩밀어내며뒤집기_In_Place_Operation_main_메모리초과 {
	
	static String input_str;
	static int str_size;
	
	public static void shiftFront() {
		// step1: 가장 앞의 문자를 저장한 뒤,
	    // step2: 문자열을 앞부터 순회하며 문자를 한 칸씩 앞으로 당기고
	    // step3: 문자열의 제일 뒤에 가장 앞에 있던 문자를 넣어줍니다. 
		//자바는 문자열 불변 (String immutable)
		String tmp = "";
	    char front = input_str.charAt(0);             // step1
	    for(int i = 1; i < str_size; i++) {      // step2
	        //input_str[i - 1] = input_str[i];
	    	tmp = tmp + input_str.charAt(i);
	    }
	    
	    //input_str[str_size - 1] = front;       // step3
	    tmp = tmp + front;
	    input_str = tmp;
	    
	    System.out.println(input_str);
	    return;
	}
	
	public static void shiftBack() {
		// step1: 가장 뒤의 문자를 저장한 뒤,
	    // step2: 문자열의 뒤부터 순회하며 문자를 한 칸씩 뒤로 밀어주고
	    // step3: 문자열의 제일 앞에 가장 뒤에 있던 문자를 넣어줍니다.
		//자바는 문자열 불변 (String immutable)
		String tmp = "";
	    char back = input_str.charAt(str_size-1);    // step1
	    for(int i = str_size - 1; i >= 1; i--) { // step2
	        //input_str[i] = input_str[i - 1];
	    	tmp = input_str.charAt(i-1) + tmp;
	    }
	   
	    //input_str[0] = back;					// step3
	    tmp = back + tmp;
	    input_str = tmp;
	    
	    System.out.println(input_str);
	    return;
	}
	
	public static void reverse() {
		// 문자열의 앞부터 순회하며 좌우 대칭 위치에 있는 문자와 swap해줍니다. 
	    // 단, 문자열의 절반만 순회해줍니다.
		//자바는 문자열 불변 (String immutable)
		String tmp_string = "";
		//문자열 길이 홀수일때 중심글자
		if(str_size % 2 == 1) {
			tmp_string = input_str.charAt(str_size/2) + "";
		}
	    char temp_char;
	    //for(int i = 0; i < str_size / 2; i++) {
//	        temp = input_str[i];
//	        input_str[i] = input_str[str_size - i - 1];
//	        input_str[str_size - i - 1] = temp;
	    for(int i = (str_size / 2) - 1; i >= 0; i--) {
	    	tmp_string = 
	    			input_str.charAt(str_size - 1 - i)
	    			+ tmp_string
	    			+ input_str.charAt(0 + i);
	    }

	    input_str = tmp_string;
	    System.out.println(input_str);
	    return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int q_num;
		input_str = sc.next();
		q_num = sc.nextInt();

	    str_size = input_str.length();

	    int q_type;
	    for(int i = 0; i < q_num; i++) {
	        q_type = sc.nextInt();
	        if(q_type == 1)
	            shiftFront();
	        else if(q_type == 2)
	            shiftBack();
	        else if(q_type == 3)
	            reverse();
	    }
		
		sc.close();
	}
}

/*
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char[] ca  = str.toCharArray();
		int len = str.length();
		
		int q = sc.nextInt();
		int[] arr = new int[q];
		for(int i=0; i<q; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<q; i++) {
			if(arr[i] == 1) {
				char tmp = ca[0];
				for(int k=1; k<len; k++) {
					ca[k-1] = ca[k];
				}
				ca[len-1] = tmp;
				
				String prt  = new String(ca);
				System.out.println(prt);
			}else if(arr[i] == 2) {
				char tmp = ca[len-1];
				for(int k=len-1-1; k>=0; k--) {
					ca[k+1] = ca[k];
				}
				ca[0] = tmp;
				
				String prt  = new String(ca);
				System.out.println(prt);
			}else if( arr[i] == 3) {
				for(int k=0; k<(len/2); k++) {
					char tmp = ca[k];
					ca[k] = ca[len-1-k];
					ca[len-1-k] = tmp;
				}
				
				String prt  = new String(ca);
				System.out.println(prt);
			}
		}
	
		sc.close();
	}
	
}
*/







































































