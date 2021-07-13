package type_basic_1_단순반복문;

import java.util.Scanner;

public class _6_완전수_chk {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int ans = 0;
		for(int cur = start; cur <= end; cur++) {
			int sum = 0;
			for(int div = 1; div<=(cur/2); div++) {
				if(cur % div == 0) {
					sum += div;
				}
			}
			
			//완전수 인지 판별
			if(cur == sum) {
				ans++;
			}
		}

		System.out.println(ans);
		sc.close();
	}
}

























