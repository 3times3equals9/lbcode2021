package type_basic_1_단순반복문;

import java.util.Scanner;

public class _4_숫자뒤집기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int answer=0;
		//입력의 일의 자리부터 분리하여 새로운 수의 뒤에 붙여줍니다
		while(num > 0) {
			//일의 자리 숫자를 결과의 뒤에 붙입니다.
			answer = answer * 10 + num % 10;
			//사용한 일의 자리 숫자를 제거합니다.
			num /= 10;
		}
		
		System.out.println(answer);
		sc.close();
	}
}



/*
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		while(input != 0) {
			int mod = input % 10;
			list.add(mod);
			input = input / 10;
		}
		
		int ans = 0;
		boolean isNotZero = false;
		for(int tmp : list) {
			if(!isNotZero && tmp == 0) {
				continue;
			}else if(tmp > 0){
				isNotZero = true;
				ans = (ans*10) + tmp;
			}else if(isNotZero && tmp == 0) {
				ans = (ans*10) + tmp;
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
} 
 */





















