package type_basic_5_베열정렬;

import java.util.Arrays;
import java.util.Scanner;

public class _3_순서를바꾸었을때같은단어인지판별하기_1st_Sorting_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1;
		String str2;

	    str1 = sc.next();
	    str2 = sc.next();

	    char[] car1 = str1.toCharArray();
		char[] car2 = str2.toCharArray();
	    
	    // 각 문자열을 정렬합니다. 
		Arrays.sort(car1);
		Arrays.sort(car2);
		
		String str1_neo = new String(car1);
		String str2_neo = new String(car2);;

	    if(str1_neo.equals(str2_neo))
	    	System.out.println("Yes");
    	else
    		System.out.println("No");
		
		sc.close();
	}
}

/*
https://zetawiki.com/wiki/%EC%9E%90%EB%B0%94_char_%EB%B0%B0%EC%97%B4%EC%9D%84_String%EC%9C%BC%EB%A1%9C_%EB%B3%80%ED%99%98

# String 생성자
char[] arr = {'h', 'e', 'l', 'l', 'o'};
String str = new String(arr);
System.out.println(str); // hello
 
# String.valueOf()
char[] arr = {'h', 'e', 'l', 'l', 'o'};
String str = String.valueOf(arr);
System.out.println(str); // hello
        
char[] arr = {'h', 'e', 'l', 'l', 'o'};
String str = String.copyValueOf(arr);
System.out.println(str); // hello   

https://codechacha.com/ko/java-convert-chararray-to-string/
*/






































































