package type_basic_5_베열정렬;

import java.util.Arrays;
import java.util.Scanner;

public class _3_순서를바꾸었을때같은단어인지판별하기_chk {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String in_str_1 = sc.next();
		String in_str_2 = sc.next();
		
		int str_len_1 = in_str_1.length();
		int str_len_2 = in_str_2.length();
		
		if(str_len_1 != str_len_2) {
			System.out.println("No");
			System.exit(0);
		}
		
		char[] car_1 = in_str_1.toCharArray();
		char[] car_2 = in_str_2.toCharArray();
		
		Arrays.sort(car_1);
		Arrays.sort(car_2);
		
		boolean isSame = true;
		for(int i=0; i<str_len_1; i++) {
			if(car_1[i] != car_2[i]) {
				isSame = false;
				break;
			}
		}
		
		if(isSame) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		
		sc.close();
	}
}









































































