package type_basic_2_최대최소;

import java.util.Scanner;

public class _5_자동차단일거래이익최대화하기_2nd_Observation {
	
	static final int MAX_NUM = 1000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 변수 선언:
	    int n;
	    int[] price = new int[MAX_NUM];

	    // 입력:
	    n = sc.nextInt();
	    for(int i = 0; i < n; i++)
	        price[i] = sc.nextInt();
		
		
	    // 배열을 앞에서부터 순회하며 최소값을 갱신해줍니다.
	    // 각 원소에 대하여 해당 시점의 최소값과의 차이가
	    // 최대가 될 때를 갱신해줍니다.
	    int max_profit = 0;
	    int min_price = price[0];
	    for(int i = 0; i < n; i++) {
	        int profit = price[i] - min_price;
	        
	        // 답을 갱신해줍니다.
	        if(profit > max_profit)
	            max_profit = profit;
	        
	        // 지금까지의 최솟값을 갱신해줍니다.
	        if(min_price > price[i])
	            min_price = price[i];
	    }

	    System.out.println(max_profit);
		sc.close();
	}
}





































































